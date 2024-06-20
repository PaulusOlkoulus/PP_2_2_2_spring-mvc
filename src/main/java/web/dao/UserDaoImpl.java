package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {
    private List<User> users;
    private static int usersCount;
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public List<User> getUsers(int count) {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList()
                .stream().limit(count).toList();
    }

    public List<User> getUsers() {
        return entityManager.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Transactional
    @Override
    public User getUserDetail(int id) {
        return entityManager.find(User.class, id);
    }

    @Transactional
    @Override
    public void addUser(User user) {
//        user.setId(++usersCount);
//        users.add(user);
        entityManager.persist(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
//        users.removeIf(user -> user.getId() == id);
        entityManager.remove(user);
    }


}

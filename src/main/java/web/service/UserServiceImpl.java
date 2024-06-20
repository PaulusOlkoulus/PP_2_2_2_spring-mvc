package web.service;

import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.models.User;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getUsers(int count) {
        return userDao.getUsers(count);
    }
    public  List<User> getUsers(){
        return userDao.getUsers();
    }

    @Override
    public User getUserDetail(int id) {
        return userDao.getUserDetail(id);
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }


}

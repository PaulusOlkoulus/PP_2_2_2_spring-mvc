package web.dao;

import web.models.User;

import java.util.List;

public interface UserDao {
     List<User> getUsers(int count);
     List<User> getUsers();

     User getUserDetail(int id);

     void addUser(User user);
     void update(User user);
     void deleteUser(User user);
}

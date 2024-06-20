package web.service;



import web.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers(int count);
    List<User> getUsers();
    User getUserDetail(int id);
    void addUser(User user);

    void update(User user);

    void deleteUser(User user);
}

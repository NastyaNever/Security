package web.service;

import web.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    void updateUser(User user, int id);
    User show(int id);
    void removeUserById(int id);
    List<User> getAllUsers();
}

package web.service;

import web.entity.Role;
import web.entity.User;

import java.util.List;


public interface UserService {
    void saveUser(User user);

    void updateUser(User user);

    User show(long id);

    void removeUserById(long id);

    List<User> getAllUsers();

}

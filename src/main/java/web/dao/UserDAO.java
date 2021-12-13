package web.dao;


import web.entity.User;
import java.util.List;

public interface UserDAO {

    void saveUser(User user);

    void updateUser(User user);

    User show(long id);

    void removeUserById(long id);

    List<User> getAllUsers();

    User findByUserName(String name);

}

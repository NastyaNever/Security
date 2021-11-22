package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDAOImpl;
import web.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDAOImpl userDAOImpl;

    @Autowired
    public UserServiceImpl(UserDAOImpl userDAOImpl) {
        this.userDAOImpl = userDAOImpl;
    }

    @Override
    public void saveUser(User user) {
        userDAOImpl.saveUser(user);
    }

    @Override
    public void updateUser(User user, int id) {
        userDAOImpl.updateUser(user, id);
    }

    @Override
    public User show(int id) {
        return userDAOImpl.show(id);
    }

    @Override
    public void removeUserById(int id) {
        userDAOImpl.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAOImpl.getAllUsers();
    }
}

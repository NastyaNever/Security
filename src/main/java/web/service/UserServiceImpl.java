package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.RoleDaoImpl;
import web.dao.UserDAOImpl;
import web.entity.Role;
import web.entity.User;

import java.util.List;
import java.util.Set;

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
    public void updateUser(User user) {
        userDAOImpl.updateUser(user);
    }

    @Override
    public User show(long id) {
        return userDAOImpl.show(id);
    }

    @Override
    public void removeUserById(long id) {
        userDAOImpl.removeUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDAOImpl.getAllUsers();
    }

}
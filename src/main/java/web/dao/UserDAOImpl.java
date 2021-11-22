package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        entityManager.persist(user);

    }

    public User show(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Transactional
    @Override
    public void updateUser(User updateUser, int id) {
        User userToBeUpdated = show(id);
        userToBeUpdated.setName(updateUser.getName());
        userToBeUpdated.setlastName(updateUser.getlastName());
        userToBeUpdated.setAge(updateUser.getAge());
        userToBeUpdated.setPhoneNumber(updateUser.getPhoneNumber());
        entityManager.merge(updateUser);

    }

    @Transactional
    @Override
    public void removeUserById(int id) {
        entityManager.remove(show(id));
    }
}

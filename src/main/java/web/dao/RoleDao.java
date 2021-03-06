package web.dao;

import web.entity.Role;
import web.entity.User;

import java.util.List;


public interface RoleDao {

    List<User> getListRole();

    void add(Role role);

    void update(Role role);

    Role getById(int id);

    Role getByName(String roleName);
}

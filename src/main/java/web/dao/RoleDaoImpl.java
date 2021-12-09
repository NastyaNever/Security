package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Repository
@Transactional(readOnly = true)
public class RoleDaoImpl implements  RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleByName(String name) {
        Role role = null;
        try {
            role = entityManager
                    .createQuery("SELECT r FROM Role r WHERE r.role=:name", Role.class)
                    .setParameter("name", name)
                    .getSingleResult();
        } catch (Exception e) {
            System.out.println("Роли с таким именем не существует!");
        }
        return role;
    }

    @Override
    public Role getRoleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager
                .createQuery("select r from Role r", Role.class)
                .getResultList();
    }

    @Override
    public Role getDefaultRole() {
        return getRoleByName("ROLE_USER");
    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void removeRole(long id) {
        entityManager.remove(getRoleById(id));
    }


    public HashSet<Role> getSetOfRoles(String[] rolesNames) {
        Set<Role> roleSet = new HashSet<>();
        for (String role : rolesNames) {
            roleSet.add(getRoleByName(role));
        }
        return (HashSet) roleSet;
    }


    public Set<Role> setRoleByName(String name) {
        Set<Role> roleSet = new HashSet<>();
        if (name != null) {
            roleSet.add(getRoleByName(name));
        }
        return roleSet;
    }
}

package ir.service;

import ir.model.entity.Role;
import ir.model.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    void update(User user);
    void delete(String username);
    User findByUsername(String username);
    boolean existsByUsername(String username);
    List<User> findAll();
    List<User> findByRole(Role role);
    List<User> findByRoleName(String roleName);
    User findByUsernameAndPassword(String username, String password);
}

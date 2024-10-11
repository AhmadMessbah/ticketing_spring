package ir.service;

import ir.model.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);
    void update(Role role);
    void delete(String roleName);
    Role findByRoleName(String roleName);
    List<Role> findAll();
}

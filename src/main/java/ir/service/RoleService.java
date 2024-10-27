package ir.service;

import ir.model.entity.Role;

import java.util.List;

public interface RoleService {
    void save(Role role);
    void update(Role role);
    void delete(String roleName);
    Role findByRoleName(Role.RoleName roleName);
    List<Role> findAll();
}

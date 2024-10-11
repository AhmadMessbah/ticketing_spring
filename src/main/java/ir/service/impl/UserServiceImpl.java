package ir.service.impl;

import ir.model.Role;
import ir.model.User;
import ir.repository.UserRepository;
import ir.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        if(! userRepository.existsUserByUsername(user.getUsername())) {
            userRepository.save(user);
        }
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(String username) {
        userRepository.deleteById(username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findById(username).orElse(null);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsById(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByRole(Role role) {
        return userRepository.findByRole(role);
    }

    @Override
    public List<User> findByRoleName(String roleName) {
        return userRepository.findByRoleRoleName(roleName);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }
}

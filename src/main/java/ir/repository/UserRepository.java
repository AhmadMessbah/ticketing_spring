package ir.repository;

import ir.model.Role;
import ir.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    boolean existsUserByUsername(String username);
    List<User> findByFirstNameIsLikeAndLastNameIsLike(String firstName, String lastName);
    User findByUsername(String username);
    Optional<User> findByUsernameAndPassword(String username, String password);
    List<User> findByRole(Role role);
    List<User> findByRoleRoleName(String roleName);
}

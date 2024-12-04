package ir.controller.api;


import ir.model.entity.Role;
import ir.model.entity.User;
import ir.service.RoleService;
import ir.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest/users")
public class UserApi {
    private final UserService userService;
    private final RoleService roleService;

    public UserApi(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok()
                .header("Message", "Find All Users")
                .body(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        System.out.println(user);
//        Role role = roleService.findByName(roleName);

        Role role = Role.builder().name("ROLE_ADMIN").build();
        user.addRole(role);
        userService.save(user);
        return ResponseEntity.ok()
                .header("Message", "User Saved Successfully")
                .body(userService.findAll());
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username) {
        userService.delete(username);
        return ResponseEntity.ok()
                .header("Message", "User Removed Successfully")
                .body(userService.findAll());
    }

    @PutMapping("/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody User user) {
        System.out.println(user);
        user.setUsername(username); // Ensure the username is updated
        userService.update(user);
        return ResponseEntity.ok()
                .header("Message", "User Updated Successfully")
                .body(userService.findAll());
    }

}

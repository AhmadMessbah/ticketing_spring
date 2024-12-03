package ir.controller.api;


import ir.model.entity.Role;
import ir.model.entity.User;
import ir.service.RoleService;
import ir.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserApi {
    private final UserService userService;
    private final RoleService roleService;

    public UserApi(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(path = "/rest/users")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok()
                .header("Message", "Find All Users")
                .body(userService.findAll());
    }

    @PostMapping(path = "/rest/users")
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
}

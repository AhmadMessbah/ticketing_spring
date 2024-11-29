package ir.controller.api;

import ir.model.entity.User;
import ir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserApi {
    private final UserService userService;

    public UserApi(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/rest/users")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }
}

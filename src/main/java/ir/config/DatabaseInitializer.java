package ir.config;

//import ir.model.entity.Role;
//import ir.model.entity.User;
//import ir.repository.RoleRepository;
//import ir.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
public class DatabaseInitializer {

//    @Bean
//    public CommandLineRunner initRoles(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        return args -> {
//            if (roleRepository.findByName("ADMIN") == null) {
//                Role role =
//                        Role
//                                .builder()
//                                .name("ADMIN")
//                                .build();
//                roleRepository.save(role);
//            }
//            if (roleRepository.findByName("CUSTOMER") == null) {
//                Role role1 =
//                        Role
//                                .builder()
//                                .name("CUSTOMER")
//                                .build();
//                roleRepository.save(role1);
//            }
//
//            User user =
//                    User
//                            .builder()
//                            .username("admin")
//                            .password("admin")
//                            .build();
//
//            user.addRole(roleRepository.findByName("ADMIN"));
//
//            userRepository.save(user);
//        };
//
//    }
}

package ir.config;


import ir.model.entity.User;
import ir.repository.UserRepository;
import ir.service.CustomUserDetailsService;
import ir.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Set;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    private final CustomUserDetailsService customUserDetailsService;

    public WebSecurityConfig(CustomUserDetailsService customUserDetailsService) {
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf-> csrf.disable())
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/","/register", "/panel", "/login", "/logout","/h2-console/**","/favicon.ico").permitAll()
                        .requestMatchers("/admins/**","/users/**", "/roles/**").hasRole("ADMIN")
                        .requestMatchers("/customers/**").hasRole("CUSTOMER")
                        .requestMatchers("/tickets/**", "/messages/**").hasAnyRole("ADMIN", "CUSTOMER")
                        .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")
                                .defaultSuccessUrl("/panel",true)
//                                .failureForwardUrl("/login?error")
                                .permitAll()
                )
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager inMemoryUserDetailsManager =
//                new InMemoryUserDetailsManager();
//
//        UserDetails user1 =
//                User.withDefaultPasswordEncoder()
//                        .username("customer")
//                        .password("customer123")
//                        .roles("CUSTOMER")
//                        .build();
//
//        UserDetails user2 =
//                User.withDefaultPasswordEncoder()
//                        .username("admin")
//                        .password("admin123")
//                        .roles("ADMIN")
//                        .build();
//
//        inMemoryUserDetailsManager.createUser(user1);
//        inMemoryUserDetailsManager.createUser(user2);
//
//        return inMemoryUserDetailsManager;
//    }



//        @Bean
//        public UserDetailsService userDetailsService(UserRepository userRepository) {
//            return username -> {
//                User user = userRepository.findByUsername(username);
//                if (user == null) {
//                    throw new UsernameNotFoundException("User not found");
//                }
//
//                Set<SimpleGrantedAuthority> authorities = user.getRoleSet().stream()
//                        .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
//                        .collect(Collectors.toSet());
//
//                return new org.springframework.security.core.userdetails.User(
//                        user.getUsername(), user.getPassword(), authorities);
//            };
//        }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/h2-console/**", "/");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

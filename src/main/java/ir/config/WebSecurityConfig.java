package ir.config;



import ir.service.CustomUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import org.springframework.security.web.SecurityFilterChain;



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
                        .requestMatchers("/","/register", "/panel", "/login", "/logout","/h2-console/**","/favicon.ico","/monitoring/**").permitAll()
                        .requestMatchers("/admins/**","/users/**", "/roles/**").hasAnyAuthority ("ROLE_ADMIN")
                        .requestMatchers("/customers/**").hasRole("CUSTOMER")
                        .requestMatchers("/tickets/**", "/messages/**").hasAnyAuthority("ROLE_ADMIN", "ROLE_CUSTOMER")
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

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }


}

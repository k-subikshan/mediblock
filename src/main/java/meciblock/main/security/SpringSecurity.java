package meciblock.main.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import meciblock.main.Service.UserService;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
    SuccessHandelr successHandler = new SuccessHandelr();
    private final UserService customUserDetailsService;
    SpringSecurity(SuccessHandelr successHandler, UserService customUserDetailsService) {
        this.successHandler = successHandler;
        this.customUserDetailsService = customUserDetailsService;
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder.encode("password"))
            .roles("USER")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
    @Bean
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        

        return http
        .formLogin(httpform->{
            httpform
            .loginPage("/login")
            .loginProcessingUrl("/login")
            .failureUrl("/login?error=true")
            .successHandler(successHandler)
            .permitAll();
        })
        .authorizeHttpRequests(auth->{
            auth
            .requestMatchers("/register").permitAll()
            .requestMatchers("/css/**").permitAll()
            .requestMatchers("/js/**").permitAll()
            .requestMatchers("/images/**").permitAll()
            .anyRequest().authenticated();
        })
        .build();
        
        
    }
    
}

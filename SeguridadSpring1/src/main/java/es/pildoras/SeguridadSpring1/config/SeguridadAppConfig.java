package es.pildoras.SeguridadSpring1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SeguridadAppConfig  {

    @SuppressWarnings("deprecation")
	@Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("user")
                .build());
        manager.createUser(User.withDefaultPasswordEncoder().username("Jean Franco").password("jeansama").roles("admin").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("Juan").password("123").roles("admin").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("Antonio").password("456").roles("user").build());
        manager.createUser(User.withDefaultPasswordEncoder().username("Laura").password("123").roles("ayudante").build());
        return manager;
    }
}

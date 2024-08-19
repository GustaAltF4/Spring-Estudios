package ar.practicas.SeguritySpring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SeguridadAppConfig{ //extends WebSecurityConfigurerAdapter {

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		
//		UserBuilder usuarios= User.withDefaultPasswordEncoder();
//		
//		auth.inMemoryAuthentication().withUser(usuarios.username("Juan").password("123").roles("administrador"));
//		auth.inMemoryAuthentication().withUser(usuarios.username("Antonio").password("456").roles("usuario"));
//		auth.inMemoryAuthentication().withUser(usuarios.username("Ana").password("789").roles("ayudante"));
//		auth.inMemoryAuthentication().withUser(usuarios.username("Laura").password("321").roles("administrador"));
//	}
	

    @Bean
    public UserDetailsService userDetailsService() {
        User.UserBuilder users = User.withDefaultPasswordEncoder();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(users.username("Juan").password("123").roles("administrador").build());
        manager.createUser(users.username("Antonio").password("456").roles("usuario").build());
        manager.createUser(users.username("Ana").password("789").roles("ayudante").build());
        manager.createUser(users.username("Laura").password("321").roles("administrador").build());
        return manager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .permitAll()
                .and()
            .httpBasic();
        return http.build();
    }


}

package com.ragbecca.ITVitaeManagement.util;

import com.ragbecca.ITVitaeManagement.entity.User;
import com.ragbecca.ITVitaeManagement.repository.UserRepository;
import com.ragbecca.ITVitaeManagement.service.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    AuthUserService authUserService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.httpBasic().authenticationEntryPoint(new BasicAuthenticationEntryPoint());

        http
                .authorizeRequests().antMatchers(HttpMethod.POST, "/login").authenticated()
                .antMatchers(HttpMethod.PUT, "/users/{id:[0-9]+}").authenticated()
                .and().authorizeRequests().anyRequest().permitAll();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        if (userRepository.findByUsername("rebeccadj2003@gmail.com") == null) {
            User user = new User();
            user.setUsername("Rebeccadj2003@gmail.com");
            user.setMaster(true);
            user.setDisplayName("Rebecca de Jong");
            user.setPassword(passwordEncoder().encode("Welkom123!"));
            user.setRole("MANAGER");
            userRepository.save(user);
        }
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authUserService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

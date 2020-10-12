package com.example.springBootdemo.config;

import com.example.springBootdemo.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Override
    public void configure(HttpSecurity http) throws Exception{
    http
            .csrf().disable()
            .authorizeRequests()
            .antMatchers("/").permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
}

@Bean
    @Override
    protected UserDetailsService userDetailsService(){
    return  new InMemoryUserDetailsManager(
    User.builder()
        .username("librarian")
        .password(passwordEncoder().encode("librarian"))
        .authorities(Role.LIBRARIAN.getAuthorities())
        .build(),

    User.builder()
            .username("reader")
            .password(passwordEncoder().encode("reader"))
            .authorities(Role.READER.getAuthorities())
            .build()
    );
}
@Bean
    protected PasswordEncoder passwordEncoder()
{
    return new BCryptPasswordEncoder(12);
}
}

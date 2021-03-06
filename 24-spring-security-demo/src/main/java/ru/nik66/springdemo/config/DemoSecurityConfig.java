package ru.nik66.springdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder builder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(builder.username("john").password("123").roles("EMPLOYEE"))
                .withUser(builder.username("mary").password("123").roles("MANAGER"))
                .withUser(builder.username("susan").password("123").roles("ADMIN"));
    }
}

package org.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE","HR","MANAGER")
                .antMatchers("/employee/**").hasRole("HR")
                .antMatchers("/position/**").hasRole("HR")
                .antMatchers("/order/**").hasRole("MANAGER")
                .antMatchers("/tour-tasks/**").hasRole("MANAGER")
                .antMatchers("/country/**").hasRole("MANAGER")
                .antMatchers("/tour-type/**").hasRole("MANAGER")
                .antMatchers("/program/**").hasRole("MANAGER")
                .antMatchers("/tour/**").hasRole("MANAGER")
                .antMatchers("/agreement/**").hasRole("EMPLOYEE")
                .antMatchers("/trip/**").hasRole("EMPLOYEE")
                .antMatchers("/trip-ticket/**").hasRole("EMPLOYEE")
                .antMatchers("/event/**").hasRole("MANAGER")
                .antMatchers("/event-ticket/**").hasRole("MANAGER")
                .antMatchers("/hotel/**").hasRole("MANAGER")
                .antMatchers("/rooms/**").hasAnyRole("MANAGER", "EMPLOYEE")
                .antMatchers("/hotel-klass/**").hasRole("MANAGER")
                .antMatchers("/category/**").hasRole("MANAGER")
                .antMatchers("/trip-numbers/**").hasRole("EMPLOYEE")
                .antMatchers("/tour-flights/**").hasRole("MANAGER")
                .antMatchers("/air-klass/**").hasRole("MANAGER")
                .antMatchers("/air-tickets/**").hasAnyRole("MANAGER", "EMPLOYEE")
                .antMatchers("/air-ticket-trips/**").hasRole("EMPLOYEE")
                .and().formLogin().permitAll();
    }
}

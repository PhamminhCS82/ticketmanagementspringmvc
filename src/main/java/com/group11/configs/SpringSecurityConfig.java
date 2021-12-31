/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group11.configs;

import com.configs.handlers.LoginSuccessHandler;
import com.configs.handlers.LogoutHandler;
import com.configs.handlers.MyAccessDeniedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 *
 * @author pminh
 */
@Configuration
@EnableWebSecurity
@EnableTransactionManagement
@ComponentScan(basePackages = {
    "com.group11.repository",
    "com.group11.services"
})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private AuthenticationSuccessHandler loginSuccessHandler;
    @Autowired
    private LogoutSuccessHandler logoutHandler;
    @Autowired
    private MyAccessDeniedHandler accessDenied;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public AuthenticationSuccessHandler loginSuccessHandler() {
        return new LoginSuccessHandler();
    }

    @Bean
    public LogoutSuccessHandler logoutHandler() {
        return new LogoutHandler();
    }

    @Bean
    public MyAccessDeniedHandler accessDenied() {
        return new MyAccessDeniedHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/signin")
                .usernameParameter("username")
                .passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/").failureUrl("/signin?error");
        http.formLogin().successHandler(this.loginSuccessHandler);
        http.logout().logoutSuccessHandler(this.logoutHandler);
        http.exceptionHandling().accessDeniedPage("/signin?accessDenied");

        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/order-history").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
                .antMatchers("/order-history-detail").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
        http.csrf().disable();

    }
}

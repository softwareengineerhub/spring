package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                		.usersByUsernameQuery("SELECT username, password, active FROM user_role where username=?")
                .authoritiesByUsernameQuery("SELECT username, role FROM user_role where username=?")

                .dataSource(dataSource);
                /*.withUser("denis").password("1")
                .authorities("ADMIN");
        auth.inMemoryAuthentication()
                .withUser("piter").password("2")
                .authorities("USER");
        auth.inMemoryAuthentication()
                .withUser("boris").password("3").authorities("USER", "ADMIN");*/
    }


    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("denis").password("1")
                .authorities("ADMIN");
        auth.inMemoryAuthentication()
                .withUser("piter").password("2")
                .authorities("USER");
        auth.inMemoryAuthentication()
                .withUser("boris").password("3").authorities("USER", "ADMIN");
    }*/

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/all").permitAll()
                .antMatchers("/api/admin").hasAuthority("ADMIN")
                .antMatchers("/api/user").hasAuthority("USER")
                .antMatchers("/api/user-admin").hasAnyAuthority("USER", "ADMIN")
                .anyRequest()
                .authenticated().and().csrf().disable().httpBasic();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/all").permitAll()
                .antMatchers("/api/admin").hasAuthority("ADMIN")
                .antMatchers("/api/user").hasAuthority("USER")
                .antMatchers("/api/user-admin").hasAnyAuthority("USER", "ADMIN")
                .anyRequest()
                .authenticated().and().csrf().disable().formLogin();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/open");
    }
}

package com.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("denis").password("{noop}1")
                .authorities("ADMIN");
        auth.inMemoryAuthentication()
                .withUser("piter").password("{noop}2")
                .authorities("USER");
        auth.inMemoryAuthentication()
                .withUser("boris").password("{noop}3")
                .authorities("USER", "ADMIN");
    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        String rootPath = "/api/v1";
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, rootPath+"/person").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, rootPath+"/person").hasAnyAuthority( "ADMIN")
                .anyRequest()
                .authenticated().and().csrf().disable().httpBasic();
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String rootPath = "/api/v1";
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, rootPath+"/person").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, rootPath+"/person").hasAnyAuthority( "ADMIN")
                //.antMatchers(rootPath+"/person/id/*").hasAnyAuthority("USER", "ADMIN")
                .anyRequest()
                .authenticated().and().csrf().disable().formLogin();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring().antMatchers("/**");
        web.ignoring().antMatchers("/api/v1/person/info");
    }

}

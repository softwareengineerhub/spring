package com.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import javax.sql.DataSource;


@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT username, password, active FROM user_role where username=?")
                .authoritiesByUsernameQuery("SELECT username, role FROM user_role where username=?")
                .dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String rootPath = "/api/v1";
        String rootPath2 = "/api/v2";
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, rootPath+"/person").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, rootPath+"/person").hasAnyAuthority( "ADMIN")

                .antMatchers( rootPath2+"/admin").hasAnyAuthority("ADMIN")
                .antMatchers( rootPath2+"/user").hasAnyAuthority( "USER")
                .antMatchers( rootPath2+"/user-admin").hasAnyAuthority( "USER","ADMIN")

                .anyRequest()
                .authenticated().and().csrf().disable().httpBasic();



    }

    /*@Override
    protected void configure(HttpSecurity http) throws Exception {
        String rootPath = "/api/v1";
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, rootPath+"/person").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, rootPath+"/person").hasAnyAuthority( "ADMIN")
                //.antMatchers(rootPath+"/person/id/*").hasAnyAuthority("USER", "ADMIN")
                .anyRequest()
                .authenticated().and().csrf().disable().formLogin();
    }*/

    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring().antMatchers("/**");
        web.ignoring().antMatchers("/api/v1/person/info");
    }

}

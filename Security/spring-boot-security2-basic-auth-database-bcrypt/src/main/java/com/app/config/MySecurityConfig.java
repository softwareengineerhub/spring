package com.app.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(){
            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                System.out.println("matcher.rawPassword="+rawPassword);
                System.out.println("matcher.encodedPassword="+encodedPassword);
                return super.matches(rawPassword, encodedPassword); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public String encode(CharSequence rawPassword) {
                System.out.println("encode.rawPassword="+rawPassword);
                return super.encode(rawPassword); //To change body of generated methods, choose Tools | Templates.
            }
            
        };
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .usersByUsernameQuery("SELECT username, password, active FROM user_role where username=?")
                .authoritiesByUsernameQuery("SELECT username, role FROM user_role where username=?")
                .dataSource(dataSource).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/api/all").permitAll()
                .antMatchers("/api/admin").hasAuthority("ADMIN")
                .antMatchers("/api/user").hasAuthority("USER")
                .antMatchers("/api/user-admin").hasAnyAuthority("USER", "ADMIN")
                .anyRequest()
                .authenticated().and().csrf().disable().httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/api/open");
    }

}

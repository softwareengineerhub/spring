package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @SuppressWarnings("deprecation")
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("denis").password("1")
                .authorities("ADMIN");
        auth.inMemoryAuthentication()
                .withUser("piter").password("2")
                .authorities("USER");
        auth.inMemoryAuthentication()
                .withUser("boris").password("3")
                .authorities("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String rootPath = "/api";
        http.authorizeRequests()
        //        .antMatchers(HttpMethod.GET, rootPath+"/get").hasAnyAuthority("USER", "ADMIN")
                .antMatchers(HttpMethod.POST, rootPath+"/get2").hasAnyAuthority( "ADMIN")
                .anyRequest()
                .authenticated().and().csrf().disable().httpBasic();
        //http.authorizeRequests()
          //      .antMatchers(HttpMethod.GET, rootPath+"/get3").permitAll();
    }
}

package com.app.configuration;

import com.app.security.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@Configuration
public class MySecurityConfiguration2 {
    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/my").permitAll()
                .antMatchers("/home","/student","/professor").authenticated()
                .and()
                .csrf().disable()
                .formLogin().defaultSuccessUrl("/home")
                .and()
                .exceptionHandling().accessDeniedPage("/access-denied")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
        return http.build();
    }

    @Bean
    AuthenticationSuccessHandler successHandler(){
        return new SavedRequestAwareAuthenticationSuccessHandler();
    }

    @Bean
    AuthenticationFailureHandler failureHandler(){
        return new SimpleUrlAuthenticationFailureHandler("/login?error");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}

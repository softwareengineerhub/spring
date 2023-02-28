package org.example.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AuthorizationComponent {


    public boolean mayCallGet(UserDetails principal, String name) {
        System.out.println("mayCallGet:");
        return true;
    }


    public boolean mayCallGet() {
        System.out.println("mayCallGet -simple:");
        return true;
    }

    public boolean mayCallGet(String name) {
        System.out.println("mayCallGet -simple: name="+name);
        return false;
    }

    public boolean mayCallGet2(String name) {
        System.out.println("mayCallGet2 -simple: name="+name);
        return true;
    }

    public boolean mayCallGet2(UserDetails principal, String name) {
        System.out.println("mayCallGet2: principal="+principal+"; name="+name);
        System.out.println(Arrays.toString(principal.getAuthorities().toArray()));
        return true;
    }

    public boolean mayCallPost(int age) {
        System.out.println("mayCallPost();age="+age);
        return age>10;
    }
}

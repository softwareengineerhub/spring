package org.example.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    @GetMapping("/get")
    //@PreAuthorize("@A.mayCallGet(principal, #name)")
    //@PreAuthorize("@authorizationComponent.mayCallGet()")
    @PreAuthorize("@authorizationComponent.mayCallGet(#name)")
    public String get(@P("name") String name){
        String text = "get(); name="+name;
        System.out.println(text);
        return text;
    }

    @GetMapping("/get2")
    @PreAuthorize("@authorizationComponent.mayCallGet2(principal, #name)")
    public String get2(@P("name") String name){
        String text = "get2(); name="+name;
        System.out.println(text);
        return text;
    }

    @PostMapping("/post")
    @PreAuthorize("@authorizationComponent.mayCallPost(#person.age)")
    public String post(@RequestBody Person person){
        String text = "get3(); person="+person;
        System.out.println(text);
        return text;
    }

}

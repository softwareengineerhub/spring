package com.app.controller;

import com.app.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/books-another")
@RestController
//switching to false --> 404 in Runtime
@ConditionalOnProperty(name = "feature-flags.is-new-books-service-enabled", havingValue = "true")
@RequiredArgsConstructor
public class BooksControllerThatCouldbeDisabled {

    private final BooksService booksService;

    @GetMapping("/info")
    public String getInfo(){
        return booksService.getBooksResult();
    }

}

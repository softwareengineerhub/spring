package com.app.controller;

import com.app.service.BooksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/books")
@RestController
@RequiredArgsConstructor
public class BooksController {

    private final BooksService booksService;

    @GetMapping("/info")
    public String getInfo(){
        return booksService.getBooksResult();
    }

}

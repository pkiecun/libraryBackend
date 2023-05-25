package com.revature.project.service;

import com.revature.project.doa.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepository br;
    @Autowired
    public BookService(BookRepository br){
        this.br = br;
    }
}

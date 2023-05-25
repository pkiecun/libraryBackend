package com.revature.project.service;

import com.revature.project.doa.LibraryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService {
    private final LibraryRepository lr;
    @Autowired
    public LibraryService(LibraryRepository lr){
        this.lr = lr;
    }
}

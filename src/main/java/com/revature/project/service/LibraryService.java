package com.revature.project.service;

import com.revature.project.doa.LibraryRepository;
import com.revature.project.models.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryService {
    private final LibraryRepository lr;
    @Autowired
    public LibraryService(LibraryRepository lr){
        this.lr = lr;
    }

    public Library openLibrary(Library opening){
        return  lr.save(opening);
    }

    public Optional<Library> search(Long code){
        return lr.findById(code);
    }
}

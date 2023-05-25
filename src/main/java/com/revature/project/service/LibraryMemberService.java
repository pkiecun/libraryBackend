package com.revature.project.service;

import com.revature.project.doa.LibraryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryMemberService {

    private final LibraryMemberRepository lmr;

    @Autowired
    public LibraryMemberService(LibraryMemberRepository lmr){
        this.lmr = lmr;
    }
}

package com.revature.project.service;

import com.revature.project.doa.LibraryRepository;
import com.revature.project.models.Book;
import com.revature.project.models.Library;
import com.revature.project.models.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

//@Service
public class LibraryService {
//    private final LibraryRepository lr;
//    @Autowired
//    public LibraryService(LibraryRepository lr){
//        this.lr = lr;
//    }
//
//    public Library openLibrary(Library opening){
//        return  lr.save(opening);
//    }
//
//    public Optional<Library> search(Long code){
//        return lr.findById(code);
//    }


    public LibraryService() {
    }
//    public Optional<Member> checkRegistry(Library location,Member guest){
//        Optional<Member> actual = Optional.of(new Member());
//        for (Member verified: location.getMemberList()) {
//            if(verified.getId() == guest.getId()){
//                actual = Optional.of(verified);
//            }
//        }
//        return actual;
//    }
public boolean checkRegistry(Library location,Member guest){
    for (Member visit: location.getMemberList()) {
        if(guest.getId() == visit.getId()){return true;}
    }
    return false;
    }

    public Library extendCatalog(Library location, Book edition){
        if(!location.getCatalog().contains(edition)) {
            ArrayList<Book> current = location.getCatalog();
            current.add(edition);
            location.setCatalog(current);
        }
        return location;
    }

    public Library burnBook(Library location, Book edition){
        if(location.getCatalog().contains(edition)) {
        ArrayList<Book> current = location.getCatalog();
        current.remove(edition);
        location.setCatalog(current);
    }
        return location;}

    public Library extendRegistry(Library location, Member guest){
        ArrayList<Member> registry = location.getMemberList();
        registry.add(guest);
        location.setMemberList(registry);
        return location;
    }

    public Library borrow(Library location, Member guest, Book edition){
        if(checkRegistry(location, guest)) {
            if (location.getCatalog().contains(edition)) {
                location.getCatalog().get(location.getCatalog().indexOf(edition)).setAvailable(false);
                ArrayList<Long> ledger = location.getMemberList().get(location.getMemberList().indexOf(guest)).getBorrowed();
                ledger.add(location.getCatalog().get(location.getCatalog().indexOf(edition)).getId());
                location.getMemberList().get(location.getMemberList().indexOf(guest)).setBorrowed(ledger);
                    }
            }
        return location;
    }

    public Library bookReturn(Library location, Member guest, Book edition){
        if(checkRegistry(location, guest)) {
            if (location.getCatalog().contains(edition)) {
                int place = location.getCatalog().indexOf(edition);
                ArrayList<Long> ledger = location.getMemberList().get(location.getMemberList().indexOf(guest)).getBorrowed();
                if (ledger.contains(edition.getId())) {
                    location.getCatalog().get(place).setAvailable(true);
                    ledger.remove(edition.getId());
                    location.getMemberList().get(location.getMemberList().indexOf(guest)).setBorrowed(ledger);
                }
            }
        }
        return location;
    }

    public ArrayList<Book> ledger(Library location, Member guest){
        ArrayList<Book> result = new ArrayList<>();
        for (Long id:location.getMemberList().get(location.getMemberList().indexOf(guest)).getBorrowed()) {
            for (Book item: location.getCatalog()) {
                if(id == item.getId()){
                    result.add(item);
                }
            }
        }
        return result;
    }
}

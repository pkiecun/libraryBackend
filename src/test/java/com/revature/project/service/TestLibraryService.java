package com.revature.project.service;

import com.revature.project.models.Book;
import com.revature.project.models.Library;
import com.revature.project.models.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLibraryService {
    //@Mock
    static LibraryService ls = new LibraryService();

//    @BeforeEach
//    public void registrationBeforeTest() {
//        MockitoAnnotations.openMocks(this);
//    }

    @Test
    public void passingTestCheckRegistry(){
        ArrayList<Book> offering = new ArrayList<>();
        ArrayList<Member> guests = new ArrayList<>();
        Member person = new Member(1L,"none", "utopia","nowhere");
        guests.add(person);
        Library local = new Library(1L, offering,guests);
        //local.setMemberList(guests);
        boolean visit = ls.checkRegistry(local,person);
        assertTrue(visit);
    }
    @Test
    public void failingTestCheckRegistry(){
        ArrayList<Book> offering = new ArrayList<>();
        ArrayList<Member> guests = new ArrayList<>();
        Library local = new Library(1L, offering, guests);
        Member person = new Member(1L,"none", "utopia","nowhere");
        boolean visit = ls.checkRegistry(local,person);
        assertEquals(false, visit);
    }

    @Test
    public void passingExtendCatalog(){
        ArrayList<Book> offering = new ArrayList<>();
        ArrayList<Member> guests = new ArrayList<>();
        Library local = new Library(1L, offering, guests);
        Book story = new Book(1L, "title","somebody",local,true);
        //local.getCatalog().add(story);
        Library result = ls.extendCatalog(local, story);
        assertTrue(result.getCatalog().contains(story));
    }

    @Test
    public void passingBurnBook(){
        ArrayList<Book> offering = new ArrayList<>();
        ArrayList<Member> guests = new ArrayList<>();
        Library local = new Library(1L, offering, guests);
        Book story = new Book(1L, "title","somebody",local,true);
        local.getCatalog().add(story);
        Library result = ls.burnBook(local,story);
        assertEquals(false, result.getCatalog().contains(story));
    }

    @Test
    public void passingExtendRegistry(){
        ArrayList<Book> offering = new ArrayList<>();
        ArrayList<Member> guests = new ArrayList<>();
        Member person = new Member(1L,"none", "utopia","nowhere");
        Library local = new Library(1L, offering,guests);
        Library visit = ls.extendRegistry(local,person);
        assertTrue(visit.getMemberList().contains(person));
    }

    @Test
    public void passingBorrow(){
        ArrayList<Book> offering = new ArrayList<>();
        ArrayList<Member> guests = new ArrayList<>();
        ArrayList<Long> ledger = new ArrayList<>();
        Member person = new Member(1L,"none", "utopia","nowhere",ledger);
        guests.add(person);
        Library local = new Library(1L, offering,guests);
        Book story = new Book(1L, "title","somebody",local,true);
        offering.add(story);
        local.setCatalog(offering);
        person.getBorrowed().add(story.getId());
        Library visit = ls.borrow(local,person,story);
        assertEquals(false, visit.getCatalog().get(visit.getCatalog().indexOf(story)).isAvailable());
    }
    @Test
    public void passingBookReturn(){
        ArrayList<Book> offering = new ArrayList<>();
        ArrayList<Member> guests = new ArrayList<>();
        ArrayList<Long> ledger = new ArrayList<>();
        Member person = new Member(1L,"none", "utopia","nowhere",ledger);
        guests.add(person);
        Library local = new Library(1L, offering,guests);
        Book story = new Book(1L, "title","somebody",local,false);
        offering.add(story);
        local.setCatalog(offering);
        person.getBorrowed().add(story.getId());
        guests.set(0,person);
        local.setMemberList(guests);
        Library visit = ls.bookReturn(local,person,story);
        System.out.println(visit.getCatalog().isEmpty());
        assertTrue(visit.getCatalog().get(0).isAvailable());
    }

    @Test
    public void passingLedger(){
        ArrayList<Book> offering = new ArrayList<>();
        ArrayList<Member> guests = new ArrayList<>();
        ArrayList<Long> ledger = new ArrayList<>();
        Member person = new Member(1L,"none", "utopia","nowhere",ledger);
        guests.add(person);
        Library local = new Library(1L, offering,guests);
        Book story = new Book(1L, "title","somebody",local,false);
        offering.add(story);
        local.setCatalog(offering);
        person.getBorrowed().add(story.getId());
        guests.set(0,person);
        local.setMemberList(guests);
        ArrayList<Book> check = ls.ledger(local,person);
        assertTrue(check.contains(story));
    }
}

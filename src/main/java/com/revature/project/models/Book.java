package com.revature.project.models;

import jakarta.persistence.*;
import lombok.*;

//@Entity
//@Table(name = "books")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
public class Book {

//    @Id
//    @GeneratedValue(generator = "book_id_seq", strategy = GenerationType.AUTO)
//    @SequenceGenerator(allocationSize = 1, name = "book_id_seq")
    private Long id;
//    @Column
    private String title;
//    @Column
    private String author;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "library_id")
    private Library branch;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "member_id")
    private Member customer;

    private boolean available;

    public Book() {
    }

    public Book(Long id, String title, String author, Library branch, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.branch = branch;
        this.available = available;
    }

    public Book(Long id, String title, String author, Library branch, Member customer, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.branch = branch;
        this.customer = customer;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Library getBranch() {
        return branch;
    }

    public void setBranch(Library branch) {
        this.branch = branch;
    }

    public Member getCustomer() {
        return customer;
    }

    public void setCustomer(Member customer) {
        this.customer = customer;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

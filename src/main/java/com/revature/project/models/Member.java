package com.revature.project.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;

//@Entity
//@Table(name = "members")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
public class Member {

//    @Id
//    @GeneratedValue(generator = "member_id_seq", strategy = GenerationType.AUTO)
//    @SequenceGenerator(allocationSize = 1, name = "member_id_seq")
    private Long id;
//    @Column
    private String name;
//    @Column
    private String address;
//    @Column
    private String email;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "library_id")
    private Library branch;
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "book_id")
    private ArrayList<Book> borrowed;

    public Member() {
    }

    public Member(Long id, String name, String address, String email, Library branch) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.branch = branch;
    }

    public Member(Long id, String name, String address, String email, Library branch, ArrayList<Book> borrowed) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.branch = branch;
        this.borrowed = borrowed;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Library getBranch() {
        return branch;
    }

    public void setBranch(Library branch) {
        this.branch = branch;
    }

    public ArrayList<Book> getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(ArrayList<Book> borrowed) {
        this.borrowed = borrowed;
    }
}

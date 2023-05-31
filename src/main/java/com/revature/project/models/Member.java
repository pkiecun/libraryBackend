package com.revature.project.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Objects;

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
//    private Library branch;
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "book_id")
    private ArrayList<Long> borrowed;

    public Member() {
    }

    public Member(Long id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public Member(Long id, String name, String address, String email, ArrayList<Long> borrowed) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
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


    public ArrayList<Long> getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(ArrayList<Long> borrowed) {
        this.borrowed = borrowed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return getId().equals(member.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

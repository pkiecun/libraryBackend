package com.revature.project.models;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Set;

//@Entity
//@Table(name = "libraries")
//@NoArgsConstructor
//@AllArgsConstructor
//@Getter
//@Setter
//@EqualsAndHashCode
public class Library {
//    @Id
//    @GeneratedValue(generator = "library_id_seq", strategy = GenerationType.AUTO)
//    @SequenceGenerator(allocationSize = 1, name = "library_id_seq")
    private Long id;
//    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ArrayList<Book> catalog;
//    @OneToMany(mappedBy = "library", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ArrayList<Member> memberList;

    public Library() {
    }

    public Library(Long id, ArrayList<Book> catalog, ArrayList<Member> memberList) {
        this.id = id;
        this.catalog = catalog;
        this.memberList = memberList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ArrayList<Book> getCatalog() {
        return catalog;
    }

    public void setCatalog(ArrayList<Book> catalog) {
        this.catalog = catalog;
    }

    public ArrayList<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<Member> memberList) {
        this.memberList = memberList;
    }
}

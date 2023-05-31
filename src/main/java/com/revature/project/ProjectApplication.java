package com.revature.project;

import com.revature.project.models.Book;
import com.revature.project.models.Library;
import com.revature.project.models.Member;
import com.revature.project.service.LibraryService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Scanner;

//@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ProjectApplication.class, args);
		LibraryService ls = new LibraryService();
		boolean ending = false;
		ArrayList<Book> onOffer = new ArrayList<>();
		ArrayList<Member> clean = new ArrayList<>();
		ArrayList<Long> ledger = new ArrayList<>();
		Library local = new Library(1L,onOffer,clean);
		Member user = new Member(1L,"John Doe", "nowhere", "nothing", ledger);
		Book story = new Book(1L,"Cryptonomicon","Neal Stephenson",local,true);
		Scanner scanner = new Scanner(System.in);
		while(!ending) {
			System.out.println("numeric choice 1 registration, 2 add book, 3 burn Book");
			System.out.println("4 display catalog, 5 display members, 6 borrow book");
			System.out.println("7 return book, 8 Display currently held books");
			System.out.println("all actions will be done by john doe for this update");
			System.out.println("0 ends the session");
		int choice = scanner.nextInt();
		switch (choice){
			case 0:
				ending = true;
				break;
			case 1:
				if(local.getMemberList().isEmpty()){
					local = ls.extendRegistry(local,user);
					System.out.println("John Doe has registered");
					continue;
				}else{
					System.out.println("John Doe already exists");
					continue;
				}
			case 2:
				if(local.getCatalog().isEmpty()){
					local = ls.extendCatalog(local,story);
					continue;
				}else{
					System.out.println("Book already exists");
					continue;
				}
			case 3:
				if(local.getCatalog().isEmpty()){
					System.out.println("no books to burn.");
					continue;
				}else{
					local = ls.burnBook(local, story);
					System.out.println("What kind of monster burns a defenseless book, well its done now.");
					continue;
				}
			case 4:
				if(local.getCatalog().isEmpty()){
					System.out.println("no books available.");
					continue;
				}else{
					System.out.println("Available Titles.");
					for (Book item: local.getCatalog()) {
						System.out.println(item.getTitle());
					}
					continue;
				}
			case 5:
				if(local.getMemberList().isEmpty()){
					System.out.println("no registered members.");
					continue;
				}else{
					System.out.println("Current Members.");
					for (Member item: local.getMemberList()) {
						System.out.println(item.getName());
					}
					continue;
				}
			case 6:
				if(local.getMemberList().isEmpty() && local.getCatalog().isEmpty()){
					System.out.println("no members and no books available.");
					continue;
				}else if(local.getMemberList().isEmpty() || local.getCatalog().isEmpty()){
					System.out.println("might be no books available or members registered.");
					continue;
				}else{
					local = ls.borrow(local,user,story);
					System.out.println("John Doe checked out Cryptonomicon.");
					continue;
				}
			case 7:
				if(local.getMemberList().isEmpty() && local.getCatalog().isEmpty()){
					System.out.println("no members and no books available.");
					continue;
				}else if(local.getMemberList().isEmpty() || local.getCatalog().isEmpty()){
					System.out.println("might be no books available or members registered.");
					continue;
				}else{
					local = ls.bookReturn(local,user,story);
					System.out.println("John Doe return out Cryptonomicon.");
					continue;
				}
			case 8:
				if(local.getMemberList().isEmpty()){
					System.out.println("no registered members.");
					continue;
				}else{
					System.out.println("John Doe has not yet returned the following");
					for (Book item: ls.ledger(local,user)
						 ) {
						System.out.println(item.getTitle());
					}
					continue;
				}
			default:
				System.out.println("Why do you need to be difficult? just follow instructions.");
		}

		}
		scanner.close();
	}

}

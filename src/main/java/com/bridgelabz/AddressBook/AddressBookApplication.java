package com.bridgelabz.AddressBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookApplication {

	public static void main(String[] args) {
		System.out.println("Welcome to address book system");
		SpringApplication.run(AddressBookApplication.class, args);
	}
}

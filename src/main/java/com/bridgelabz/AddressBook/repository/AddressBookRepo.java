package com.bridgelabz.AddressBook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.AddressBook.model.AddressBookModel;

public interface AddressBookRepo extends JpaRepository<AddressBookModel, Integer> {

}

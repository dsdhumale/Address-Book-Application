package com.bridgelabz.AddressBook.service;

import java.util.List;

import com.bridgelabz.AddressBook.dto.AddressBookDTO;
import com.bridgelabz.AddressBook.model.AddressBookModel;

public interface IAddressBookService {
    
    public AddressBookModel create(AddressBookDTO addressBookDTO);

    public AddressBookModel getById(int id);

    public List<AddressBookModel> getAll();

    public AddressBookModel update(int id,AddressBookDTO addressBookDTO);

    public AddressBookModel delete(int id);

    public List<AddressBookModel> getByname(String name);

    public List<AddressBookModel> getByCity(String city);


}

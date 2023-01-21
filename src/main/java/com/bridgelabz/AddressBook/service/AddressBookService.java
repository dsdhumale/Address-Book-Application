package com.bridgelabz.AddressBook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.AddressBook.dto.AddressBookDTO;
import com.bridgelabz.AddressBook.model.AddressBookModel;
import com.bridgelabz.AddressBook.repository.AddressBookRepo;

@Service
public class AddressBookService implements IAddressBookService{

    @Autowired
    AddressBookRepo addressBookRepo;

    @Override
    public AddressBookModel create(AddressBookDTO addressBookDTO) {
        AddressBookModel addressBookData = new AddressBookModel(addressBookDTO.getName(), 
        addressBookDTO.getPhoneNumber(),addressBookDTO.getEmail(), 
        addressBookDTO.getAddress(), addressBookDTO.getCity(), 
        addressBookDTO.getState(), addressBookDTO.getZipcode());
        return addressBookRepo.save(addressBookData);
    }

    @Override
    public AddressBookModel getById(int id) {
        AddressBookModel addressBookData = addressBookRepo.findById(id).get();
        return addressBookData;
    }

    @Override
    public List<AddressBookModel> getAll() {
        return addressBookRepo.findAll();
    }

    @Override
    public AddressBookModel update(int id, AddressBookDTO addressBookDTO) {
        AddressBookModel addressBookData = addressBookRepo.findById(id).get();
        addressBookData.setName(addressBookDTO.getName());
        addressBookData.setPhoneNumber(addressBookDTO.getPhoneNumber());
        addressBookData.setEmail(addressBookDTO.getEmail());
        addressBookData.setAddress(addressBookDTO.getAddress());
        addressBookData.setCity(addressBookDTO.getCity());
        addressBookData.setState(addressBookDTO.getState());
        addressBookData.setZipcode(addressBookDTO.getZipcode());
        return addressBookData ;
    }

    @Override
    public AddressBookModel deleteById(int id) {
        AddressBookModel addressBookData = addressBookRepo.findById(id).get();
        addressBookRepo.deleteById(id);
        return addressBookData;
    } 
    
}

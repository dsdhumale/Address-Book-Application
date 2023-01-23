package com.bridgelabz.AddressBook.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.AddressBook.dto.AddressBookDTO;
import com.bridgelabz.AddressBook.exception.AddressBookException;
import com.bridgelabz.AddressBook.model.AddressBookModel;
import com.bridgelabz.AddressBook.repository.AddressBookRepo;

@Service
public class AddressBookService implements IAddressBookService {

    @Autowired
    AddressBookRepo addressBookRepo;

    @Override
    public AddressBookModel create(AddressBookDTO addressBookDTO) {
        AddressBookModel addressBookData = new AddressBookModel(addressBookDTO.getName(),
                addressBookDTO.getPhoneNumber(), addressBookDTO.getEmail(),
                addressBookDTO.getAddress(), addressBookDTO.getCity(),
                addressBookDTO.getState(), addressBookDTO.getZipcode());
        return addressBookRepo.save(addressBookData);
    }

    @Override
    public AddressBookModel getById(int id) throws AddressBookException {
        AddressBookModel addressBookData = addressBookRepo.findById(id)
                .orElseThrow(() -> new AddressBookException("Address Book data not found for id " + id));
        return addressBookData;
    }

    @Override
    public List<AddressBookModel> getAll() {
        List<AddressBookModel> addressBookData = addressBookRepo.findAll();
        if (addressBookData.isEmpty()) {
            throw new AddressBookException("Address Book data is Empty ");
        } else {
            return addressBookData;
        }

    }

    @Override
    public AddressBookModel update(int id, AddressBookDTO addressBookDTO) throws AddressBookException {
        AddressBookModel addressBookData = addressBookRepo.findById(id)
                .orElseThrow(() -> new AddressBookException("Address Book data not found for id " + id));
        addressBookData.setName(addressBookDTO.getName());
        addressBookData.setPhoneNumber(addressBookDTO.getPhoneNumber());
        addressBookData.setEmail(addressBookDTO.getEmail());
        addressBookData.setAddress(addressBookDTO.getAddress());
        addressBookData.setCity(addressBookDTO.getCity());
        addressBookData.setState(addressBookDTO.getState());
        addressBookData.setZipcode(addressBookDTO.getZipcode());
        return addressBookData;
    }

    @Override
    public AddressBookModel delete(int id) {
        if (addressBookRepo.findById(id).isPresent()) {
            AddressBookModel addressBookData = addressBookRepo.findById(id).get();
            addressBookRepo.deleteById(id);
            return addressBookData;
        } else {
            throw new AddressBookException("Address book data not found for id "+id);
        }    

    }

    @Override
    public List<AddressBookModel> getByname(String name) {
        List<AddressBookModel> addressBookModels = addressBookRepo.findByName(name);
        if(addressBookModels.isEmpty()){
            throw new AddressBookException("Address book data not found for name "+name);
        }
        else{
            return addressBookModels;
        }
    }

    @Override
    public List<AddressBookModel> getByCity(String city) {
        List<AddressBookModel> addressBookModels = addressBookRepo.findByCity(city);
        if(addressBookModels.isEmpty()){
            throw new AddressBookException("Address book data not found for city "+city);
        }
        else{
            return addressBookModels;
        }
    }

}

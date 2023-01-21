package com.bridgelabz.AddressBook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.AddressBook.dto.AddressBookDTO;
import com.bridgelabz.AddressBook.dto.ResponseDTO;
import com.bridgelabz.AddressBook.service.IAddressBookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/addressbookservice")
public class AddressBookController {

    @Autowired
    IAddressBookService addressBookService;

    // API for creating address book data
    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@Valid @RequestBody AddressBookDTO addressBookDTO) {
        ResponseDTO response = new ResponseDTO("Address Book Data Created Successfully",
        addressBookService.create(addressBookDTO));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // API for fetching particular address book data by id
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getDetailById(@PathVariable int id) {
        ResponseDTO response = new ResponseDTO("Address Book Data fetched Successfully ",
        addressBookService.getById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // API for fetching all address book data
    @GetMapping("/getall")
    public ResponseEntity<ResponseDTO> getAllDetails() {
        ResponseDTO response = new ResponseDTO("All Address Book Data fetched Successfully ",
        addressBookService.getAll());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    // API for Update particular address book data data by id
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable int id,
            @Valid @RequestBody AddressBookDTO addressBookDTO) {
                ResponseDTO response = new ResponseDTO("Address Book Data Updated Successfully",
                addressBookService.update(id, addressBookDTO));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }    

     // API for delete particular address book data by id
     @DeleteMapping("delete/{id}")
     public ResponseEntity<ResponseDTO> deleteDetailById(@PathVariable int id) {
         addressBookService.deleteById(id);
         ResponseDTO response = new ResponseDTO("Address Book Data Deleted Successfully ",
                addressBookService.deleteById(id));
         return new ResponseEntity<>(response, HttpStatus.OK);
     }
    
}

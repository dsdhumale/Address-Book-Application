package com.bridgelabz.AddressBook.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address_book")
@Data
@NoArgsConstructor
public class AddressBookModel {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    private long zipcode;
    
}

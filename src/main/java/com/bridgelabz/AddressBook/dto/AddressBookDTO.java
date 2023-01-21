package com.bridgelabz.AddressBook.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private String city;
    private String state;
    private long zipcode;
}

package com.spring.entities;

import com.spring.DTO.AddressBookDTO;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String firstName;
    public String lastName;
    public long mobileNumber;
    public String street;
    public String village;
    public String city;
    public int zipCode;


    public AddressBook(AddressBookDTO addressBookDTO) {
        this.changeToEntity(addressBookDTO);

    }

    public AddressBook() {

    }

    public void changeToEntity(AddressBookDTO addressBookDTO){
        this.id =addressBookDTO.id;
        this.firstName = addressBookDTO.firstName;
        this.lastName = addressBookDTO.lastName;
        this.mobileNumber = addressBookDTO.mobileNumber;
        this.street = addressBookDTO.street;
        this.village = addressBookDTO.village;
        this.city = addressBookDTO.city;
        this.zipCode = addressBookDTO.zipCode;

    }

}

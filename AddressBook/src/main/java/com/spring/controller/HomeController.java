package com.spring.controller;

import com.spring.DTO.AddressBookDTO;
import com.spring.entities.AddressBook;
import com.spring.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressBook")
public class HomeController {

        final AddressBookService addressBookService;

        /**
         *  constructor user for dependency injection
         * @param addressBookService
         */
        @Autowired
        public HomeController(AddressBookService addressBookService) {
            this.addressBookService = addressBookService;
        }

        /**
         *
         * @return all contacts in the repository
         */
        @GetMapping("/getAllContacts")
        public List<AddressBook> getAllContacts(){
            return addressBookService.getAllContacts();
        }

        /**
         *
         * @param id
         * @return give contact person details using given id
         */
        @GetMapping("/getSinglePerson/{id}")
        public AddressBook getSinglePersonById(@PathVariable("id") int id){

            return addressBookService.getSinglePerson(id);
        }

        /**
         *
         * @param addressBookDTO
         * @return saved contact in repo provided by user
         */
        @PostMapping("/saveContact")
        public AddressBook saveContact(@RequestBody AddressBookDTO addressBookDTO){
            return addressBookService.savePerson(addressBookDTO);
        }

        /**
         *
         * @param addressBookDTO
         * @param id
         * @return edit existing contact in repository
         */

        @PutMapping("/editContact/{id}")
        public AddressBook editContact(@RequestBody AddressBookDTO addressBookDTO , @PathVariable("id") int id){
            return addressBookService.editPerson(addressBookDTO,id);
        }

        /**
         * delete the contact from repository by using provided id
         * @param id
         */
        @DeleteMapping("/deleteContact/{id}")
        public void deleteContact(@PathVariable("id") int id){
            addressBookService.deletePerson(id);
        }

}



package com.spring.controller;

import com.spring.DTO.AddressBookDTO;
import com.spring.entities.AddressBook;
import com.spring.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        public ResponseEntity<List<AddressBook>> getAllContacts(){
                List<AddressBook> list = null;
                list = addressBookService.getAllContacts();
                return  new ResponseEntity<>(list, HttpStatus.OK);
        }

        /**
         *
         * @param id
         * @return give contact person details using given id
         */
        @GetMapping("/getSinglePerson/{id}")
        public ResponseEntity<AddressBook> getSinglePersonById(@PathVariable("id") int id){
                AddressBook contact = null;
                contact = addressBookService.getSinglePerson(id);
                return new ResponseEntity<>(contact, HttpStatus.FOUND);
        }

        /**
         *
         * @param addressBookDTO
         * @return saved contact in repo provided by user
         */
        @PostMapping("/saveContact")
        public ResponseEntity<AddressBook> saveContact(@RequestBody AddressBookDTO addressBookDTO){
                AddressBook savedContact = null;
                savedContact = addressBookService.savePerson(addressBookDTO);
                return  new ResponseEntity<>(savedContact, HttpStatus.ACCEPTED);
        }

        /**
         *
         * @param addressBookDTO
         * @param id
         * @return edit existing contact in repository
         */

        @PutMapping("/editContact/{id}")
        public ResponseEntity<AddressBook> editContact(@RequestBody AddressBookDTO addressBookDTO , @PathVariable("id") int id){
                AddressBook updatedContact = null;
                updatedContact = addressBookService.editPerson(addressBookDTO , id);
                return  new ResponseEntity<>(updatedContact , HttpStatus.OK);
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



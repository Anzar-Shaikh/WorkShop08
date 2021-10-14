package com.spring.controller;

import com.spring.DTO.AddressBookDTO;
import com.spring.DTO.ResponseDTO;
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
        public ResponseEntity<ResponseDTO> getAllContacts(){
                List<AddressBook> employeeList = null;
                employeeList = addressBookService.getAllContacts();
                ResponseDTO responseDTO = new ResponseDTO("Get mapping succeeded" , employeeList);
                return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }

        /**
         *
         * @param id
         * @return give contact person details using given id
         */
        @GetMapping("/getSinglePerson/{id}")
        public ResponseEntity<ResponseDTO> getSinglePersonById(@PathVariable("id") int id){
                AddressBook contact = null;
                contact = addressBookService.getSinglePerson(id);
                ResponseDTO responseDTO = new ResponseDTO("Get mapping succeeded", contact);
                return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.FOUND);
        }

        /**
         *
         * @param addressBookDTO
         * @return saved contact in repo provided by user
         */
        @PostMapping("/saveContact")
        public ResponseEntity<ResponseDTO> saveContact(@RequestBody AddressBookDTO addressBookDTO){
                AddressBook savedContact = null;
                savedContact = addressBookService.savePerson(addressBookDTO);
                ResponseDTO responseDTO = new ResponseDTO("Get mapping succeeded", savedContact);
                return  new ResponseEntity<>(responseDTO, HttpStatus.ACCEPTED);

        }

        /**
         *
         * @param addressBookDTO
         * @param id
         * @return edit existing contact in repository
         */

        @PutMapping("/editContact/{id}")
        public ResponseEntity<ResponseDTO> editContact(@RequestBody AddressBookDTO addressBookDTO , @PathVariable("id") int id){
                AddressBook updatedContact = null;
                updatedContact = addressBookService.editPerson(addressBookDTO , id);
                ResponseDTO responseDTO = new ResponseDTO("Put mapping succeeded", updatedContact);
                return  new ResponseEntity<>(responseDTO , HttpStatus.OK);
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



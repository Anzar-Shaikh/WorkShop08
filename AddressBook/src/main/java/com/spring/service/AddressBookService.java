package com.spring.service;

import com.spring.DTO.AddressBookDTO;
import com.spring.entities.AddressBook;
import com.spring.repo.AddressBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBookService {

    final AddressBookRepo addressBookRepo;
    final AddressBook person = new AddressBook();

    /**
     *
     * @param addressBookRepo
     */
    @Autowired
    public AddressBookService(AddressBookRepo addressBookRepo) {
        this.addressBookRepo = addressBookRepo;

    }

    /**
     *
     * @return all contacts from repo
     */
    public List<AddressBook> getAllContacts(){
        return (List<AddressBook>) addressBookRepo.findAll();
    }

    /**
     *
     * @param id
     * @return  single person from repository
     */

    public AddressBook getSinglePerson(int id){
        return addressBookRepo.findById(id);
    }

    /**
     *
     * @param personDTO
     * @return  saved person in repository
     */
    public AddressBook savePerson(AddressBookDTO personDTO){
        person.changeToEntity(personDTO);
        return addressBookRepo.save(person);
    }

    /**
     *
     * @param personDTO
     * @param id
     * @return person edited in repository
     */
    public AddressBook editPerson(AddressBookDTO personDTO , int id){
        person.changeToEntity(personDTO);
        return  addressBookRepo.save(person);
    }

    /**
     *  delete person provided by user
     * @param id
     */
    public void deletePerson(int id){
         addressBookRepo.deleteById(id);
    }


}

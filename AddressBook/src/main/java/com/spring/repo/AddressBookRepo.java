package com.spring.repo;

import com.spring.entities.AddressBook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface AddressBookRepo extends CrudRepository<AddressBook , Integer> {

    AddressBook findById(int id);

    @Override
    <S extends AddressBook> S save(S entity);

    @Override
    <S extends AddressBook> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<AddressBook> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<AddressBook> findAll();

    @Override
    Iterable<AddressBook> findAllById(Iterable<Integer> integers);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(AddressBook entity);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends AddressBook> entities);

    @Override
    void deleteAll();
}

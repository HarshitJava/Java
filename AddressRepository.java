package com.survey.repository;

import org.springframework.data.repository.CrudRepository;

import com.survey.model.Address;

public interface AddressRepository extends CrudRepository<Address, Long> {

}

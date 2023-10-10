package com.survey.controller;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.survey.model.Address;
import com.survey.services.IAddressService;

@RestController
@RequestMapping("/api")
@Validated
public class AddressController {
	
	@Autowired
	private IAddressService addressService;
	
	@PostMapping(value="/address", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> create(@RequestBody @Valid Address address) throws MethodArgumentNotValidException , ConstraintViolationException
	{
			Address address1 = addressService.save(address);
			return new ResponseEntity<>(address1, HttpStatus.CREATED);
	}
	
	@PutMapping("/address/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable("id") long id,
			@RequestBody Address address) {

		address.setId(id);
		Address updateAddress = addressService.save(address);
		if (updateAddress != null) {
			return new ResponseEntity<>(addressService.save(address), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/address/{id}")
	public ResponseEntity<Address> getAddressById(@PathVariable("id") long id) {
		Address addressData = addressService.get(id);

		if (addressData != null) {
			return new ResponseEntity<>(addressData, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/address/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") long id) {
		try {
			addressService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/address")
	public ResponseEntity<HttpStatus> deletes() {
		try {
			addressService.delete();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@GetMapping("/address")
	public ResponseEntity<List<Address>> get() {
		try {
			List<Address> address = addressService.get();

			if (address.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(address, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}


}

package com.survey.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.survey.model.Address;
import com.survey.repository.AddressRepository;

@Service("addressService")
public class AddressService implements IAddressService   {
	
	@Autowired
	private AddressRepository addressRepository;


	@Override
	public Address save(Address address) {
		// TODO Auto-generated method stub
		Address returnAddress = addressRepository.save(address);
		return returnAddress;
	}

	@Override
	public Address get(Long id) {
		// TODO Auto-generated method stub
		Optional<Address> returnAddress = addressRepository.findById(id);
		return  returnAddress.get();
	}

	@Override
	public List<Address> get() {
		// TODO Auto-generated method stub
		List<Address> returnAddress = (List<Address>) addressRepository.findAll();
		return returnAddress;
	}

	@Override
	public Address update(Address address) {
		// TODO Auto-generated method stub
		Address returnAddress = addressRepository.save(address);
		return returnAddress;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		addressRepository.deleteById(id);
		
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
		addressRepository.deleteAll();
		
	}
	
	

}

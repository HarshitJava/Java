package com.survey.services;

import java.util.List;

import com.survey.model.Address;

public interface IAddressService  {
	
	public Address save(Address address);
	
	public Address get(Long id);
	
	public List<Address> get();
	
	public Address update(Address address);
	
	public void delete(Long id);
	
    public void delete();

}

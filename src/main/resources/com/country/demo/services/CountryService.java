package com.country.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.country.demo.beans.AddResponse;
import com.country.demo.beans.Country;
import com.country.demo.repositories.CountryRepository;

@Component
@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepo;
	
	public List<Country> getCountries()
	{	
		return countryRepo.findAll();
	}
	
	public Country getCountryById(int id)
	{
		return countryRepo.findById(id).get();
	}
	
	public Country getCountryByName(String countryName)
	{
		List<Country> countries=countryRepo.findAll();
		Country country=null;
		for(Country i:countries) {
			if(i.getCountryName().equalsIgnoreCase(countryName))
				country=i;
		}
		return country;
	}
	
	public Country addCountry(Country country)
	{
		country.setId(getMaxId());
		countryRepo.save(country);
		return country;
	}
	
	public int getMaxId() 
	{
		return countryRepo.findAll().size()+1;
	}
	
	public Country updateCountry(Country country)
	{
		countryRepo.save(country);
		return country;
	}
	
	public void deleteCountry(Country country)
	{
		countryRepo.delete(country);
//		AddResponse res = new AddResponse();
//		res.setId(id);
//		res.setmsg("Deleted...");
//		return res;
	}
	

}

package com.countryservice.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;


@Component
public class CountryService {

	static HashMap<Integer, Country> cs;

	public CountryService() {

		cs = new HashMap<>();

		Country ind = new Country(1,"India","Delhi");
		Country us = new Country(2,"US","Washington");
		Country uk = new Country(3,"UK","London");

		cs.put(1, ind);
		cs.put(2, us);
		cs.put(3, uk);

	}

	public List getcountries() 
	{
		List country = new ArrayList(cs.values());
		return country;
	}

	public Country getCountryById(int id)
	{
		Country country=cs.get(id);
		return country;
	}

	public Country getCountryByName(String countryName)
	{
		Country country = null;
		for(int i:cs.keySet()) {
			if(cs.get(i).getCountryName().equals(countryName))
				country=cs.get(i);
		}
		return country;
	}


	public Country addCountry(Country country) {
		country.setId(getMaxId());
		cs.put(country.getId(), country);
		return country;

	}

	public int getMaxId() {
		int max=0;
		for(int id:cs.keySet()) {
			if(max<=id)
				max=id;
		}
		return max+1;

	}

	public Country updateCountry(Country country) {
		if(country.getId()>0) {
			cs.put(country.getId(), country);
		}
		return country;
	}
	
	public AddResponse deleteCountry(int id) {
		cs.remove(id);
		AddResponse rs = new AddResponse();
		rs.setId(id);
		rs.setMsg("Deleted...");
		return rs;

	}


}

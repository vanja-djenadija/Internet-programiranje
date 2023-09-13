package org.unibl.etf.ip.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.models.entities.Country;
import org.unibl.etf.ip.repositories.CountryRepository;

@Service
public class CountryService {

	@Autowired
	private CountryRepository repository;
	
	public List<Country> getAllByRegion(Integer regionId){
		return repository.findByRegionId(regionId);
	}
}

package org.unibl.etf.ip.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.unibl.etf.ip.models.entities.Country;
import org.unibl.etf.ip.services.CountryService;

@Controller
@RequestMapping("/countries")
public class CountryController {

	@Autowired
	private CountryService service;
	
	// c
	@GetMapping("/{regionId}")
	public @ResponseBody List<Country> getAllByRegion(@PathVariable Integer regionId){
		return service.getAllByRegion(regionId);
	}
}

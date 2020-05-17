package com.onlinemovie.city.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.onlinemovie.city.exception.CityException;
import com.onlinemovie.city.model.*;
import com.onlinemovie.city.service.ICityService;



@RestController
@RequestMapping("/api/v1/city")
@CrossOrigin(origins="http://localhost:4200")
public class CityController {

	@Autowired
	public ICityService cityService;
	
//	API to find all cities

	@GetMapping("/findallcity")
	public ResponseEntity<List<City>> findAll() {
		return new ResponseEntity<List<City>>(cityService.findAll(), HttpStatus.OK);
	}

//	API to find city by Id
	@GetMapping("/findbycityid/{cityId}")
	public ResponseEntity<City> getCities(@PathVariable(name = "cityId") String cityId) throws CityException {
		return new ResponseEntity<City>(cityService.getCities(cityId), HttpStatus.OK);
	}
//	API to add City
	@PostMapping("/admin/add")
	public ResponseEntity<City> addCity(@RequestBody City city)  {
		cityService.addCity(city);
		return new ResponseEntity<>(city, HttpStatus.CREATED);
	}
	
// API to delete City	
	@DeleteMapping("/deletecitybycityid/{cityId}")
	public ResponseEntity<Void> deleteCity(@PathVariable("cityId") String cityId) {

		ResponseEntity<Void> response = null;

		City city = cityService.findById(cityId);

		if (city == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			cityService.deleteById(cityId);
			response = new ResponseEntity<>(HttpStatus.OK);
		}

		return response;
	}

}



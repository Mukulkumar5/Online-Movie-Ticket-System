package com.onlinemovie.city.service;

import java.util.List;

import com.onlinemovie.city.exception.AllException;
import com.onlinemovie.city.exception.CityException;
import com.onlinemovie.city.model.City;


public interface ICityService {
	
	
	
	// Service to get all city
	List<City> findAll();
	
	// Service to add city
	void addCity(City city);



	City getCities(String cityId);

	City findById(String cityId);

	void deleteById(String cityId);
	
}

package com.onlinemovie.city.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.onlinemovie.city.exception.AllException;
import com.onlinemovie.city.exception.CityException;
import com.onlinemovie.city.model.City;
import com.onlinemovie.city.repository.ICityRepository;


@Service
public class CityServiceImpl implements ICityService {

	@Autowired
	public ICityRepository cityRepository;

// 	 service to  findall city
	@Override
	public List<City> findAll() {
		

		List<City> list = cityRepository.findAll();

		return list;
	}
	
//	service for admin to add cities
	@Override
	public void addCity(City city) {
		
		cityRepository.save(city);
	}
	
//  service to get city findbyId
	public City getCities(String cityId)  {
	
		City c = null;
		Optional<City> city = cityRepository.findById(cityId);
		if (city.isPresent()) {
			c = new City();
			c = city.get();
		}
		return c;
	}

	@Override
	public City findById(String cityId) {
		
		return cityRepository.findById(cityId).orElse(null);
	}

	@Override
	public void deleteById(String cityId) {
		cityRepository.deleteById(cityId);
		
	}
}

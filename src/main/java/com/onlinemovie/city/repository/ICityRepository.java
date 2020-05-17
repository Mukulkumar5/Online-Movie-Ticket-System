package com.onlinemovie.city.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinemovie.city.model.City;



@Repository
public interface ICityRepository extends JpaRepository<City,String> {


	//Object addCity(City city);

}

package com.devsuperior.demo.service;


import com.devsuperior.demo.dto.CityDTO;
import com.devsuperior.demo.entities.City;

import com.devsuperior.demo.repositories.CityRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<CityDTO> findAll() {
        List<City>cities = cityRepository.findAll(Sort.by("name"));

        return cities.stream().map(x -> new CityDTO(x)).collect(Collectors.toList());
    }


    public CityDTO insert(CityDTO cityDTO) {
        City city = new City();
        city.setName(cityDTO.getName());
        cityRepository.save(city);
        return new CityDTO(city);
    }



    public void delete(Long id) {
       cityRepository.deleteById(id);

        }



}

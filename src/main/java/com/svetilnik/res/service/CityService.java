package com.svetilnik.res.service;

import com.svetilnik.res.entity.City;
import com.svetilnik.res.repository.CityRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CityService {

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> listAll() {
        return (List<City>) cityRepository.findAll();
    }

    public void save(City city) {
        cityRepository.save(city);
    }

    public City get(long id) {
        return cityRepository.findById(id).get();
    }

    public void delete(long id) {
        cityRepository.deleteById(id);
    }

    public List<City> findByName(String name) {
        return cityRepository.findByName(name);
    }
}

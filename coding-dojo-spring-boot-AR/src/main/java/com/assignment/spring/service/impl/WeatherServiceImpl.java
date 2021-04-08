package com.assignment.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.assignment.spring.DTO.WeatherResponse;
import com.assignment.spring.config.ApplicationProperties;
import com.assignment.spring.model.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;
import com.assignment.spring.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService{
	
	@Autowired
    private RestTemplate restTemplate;
	
	@Autowired
	private WeatherRepository weatherRepository;
	
	@Autowired
	private ApplicationProperties applicationProperties;
	
	@Override
	public WeatherEntity saveData(String city) {
		String url = applicationProperties.getApi().getUrl().replace("{city}", city).replace("{appid}", applicationProperties.getApi().getKey());
        ResponseEntity<WeatherResponse> response = restTemplate.getForEntity(url, WeatherResponse.class);
		return mapper(response.getBody());
	    }
	
	public WeatherEntity mapper(WeatherResponse response) {
		WeatherEntity entity = new WeatherEntity();
	    entity.setCity(response.getName());
	    entity.setCountry(response.getSys().getCountry());
	    entity.setTemperature(response.getMain().getTemp());
	    	return weatherRepository.save(entity);
		
	}
}
	

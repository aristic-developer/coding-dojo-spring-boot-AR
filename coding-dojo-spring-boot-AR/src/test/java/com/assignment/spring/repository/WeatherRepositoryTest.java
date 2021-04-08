package com.assignment.spring.repository;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assignment.spring.model.WeatherEntity;
import com.assignment.spring.service.WeatherService;

@ExtendWith(MockitoExtension.class)
public class WeatherRepositoryTest 
{
	@Mock
    WeatherRepository weatherRepository;
	@Mock
    WeatherService weatherService;
    
	@Before
	public void setUp() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
    public void testRepository() 
    {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setId(55);
        weatherEntity.setCity("London");
        weatherEntity.setCountry("UK");
        weatherEntity.setTemperature(234.00);
        
        weatherRepository.save(weatherEntity);
        
        
    }
}
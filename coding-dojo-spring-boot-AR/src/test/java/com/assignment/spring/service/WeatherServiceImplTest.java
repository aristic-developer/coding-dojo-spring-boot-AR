package com.assignment.spring.service;

/*import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assignment.spring.model.WeatherEntity;
import com.assignment.spring.repository.WeatherRepository;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceImplTest {
	
	@Mock
    WeatherRepository weatherRepository;
	
	@InjectMocks
	WeatherService weatherService;
	
	@Test
    public void testRepository() 
    {
        WeatherEntity weatherEntity = new WeatherEntity();
        weatherEntity.setCity("London");
        
        when(weatherRepository.save(any(WeatherEntity.class))).thenReturn(new WeatherEntity());
        WeatherEntity we = weatherService.saveData(weatherEntity.getCity());
        
        assertThat(we.getCity().equals(weatherEntity.getCity()));
  
    }
}*/
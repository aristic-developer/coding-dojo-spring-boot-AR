package com.assignment.spring.controller;

import com.assignment.spring.model.WeatherEntity;
import com.assignment.spring.service.WeatherService;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestParam;

@RestController
@Validated
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public WeatherEntity weather(@Valid @NotBlank @RequestParam(name = "city", required = true ) String city) {
        return weatherService.saveData(city);
    }
    
}

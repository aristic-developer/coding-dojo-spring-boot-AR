package com.assignment.spring.model;

import javax.persistence.*;

import lombok.Data;


@Data
@Entity
@Table(name = "weather")
public class WeatherEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String city;
    private String country;
    private Double temperature;

}

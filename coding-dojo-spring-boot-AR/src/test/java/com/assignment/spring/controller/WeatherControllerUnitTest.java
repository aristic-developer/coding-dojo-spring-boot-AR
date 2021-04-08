package com.assignment.spring.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.assignment.spring.Application;
import com.assignment.spring.service.WeatherService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = WeatherController.class)
@ContextConfiguration(classes = { Application.class })
//@TestPropertySource(properties = "authorization.authorize=true")
public class WeatherControllerUnitTest {
	
	@Autowired
	private WebApplicationContext wac;
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private WeatherService weatherService;
	
	@BeforeEach
	void setUp() throws Exception {
		DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
		this.mockMvc = builder.build();
	}
	
	@Test
	public void when_missing_city_query_param_then_returns_400() throws Exception {
		System.out.println("Query parameter city is missing. 400 - Bad Request");
		mockMvc.perform(get("/weather?"))
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void when_not_missing_city_query_param_then_returns_200() throws Exception {
		System.out.println("200 OK");
		mockMvc.perform(get("/weather?city=London"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void when_bad_path_then_returns_404() throws Exception {
		System.out.println("Bad path. 404 - Not Found");
		mockMvc.perform(get("/"))
		.andExpect(status().isNotFound());
	}
	
	@Test
	public void when_not_bad_path_then_returns_200() throws Exception {
		System.out.println("Good path. 200 OK");
		mockMvc.perform(get("/weather?city=London"))
		.andExpect(status().isOk());
	}
	
	/*@Test
	public void when_empty_city_query_param_then_returns_500() throws Exception {
		System.out.println("empty query");
		mockMvc.perform(get("/weather?city="))
		.andExpect(status().isInternalServerError());
	}*/
	
	@Test
	public void when_not_empty_city_query_param_then_returns_200() throws Exception {
		System.out.println("not empty query");
		mockMvc.perform(get("/weather?city=London"))
		.andExpect(status().isOk());
	}
	
	
	
	

}

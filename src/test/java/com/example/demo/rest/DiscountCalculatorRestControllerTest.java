package com.example.demo.rest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.model.Bill;
import com.example.demo.service.DiscountCalculatorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class DiscountCalculatorRestControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private DiscountCalculatorService service;
	
	private static final String URL = "/discount-calculator/netpayable";
	
	@Test
	public void calculateDiscountForGeneralCustomer() throws Exception {
		
		String path = "src/test/resources/input/general-customer.json";
		String data = readFileAsString(path);
		
		ObjectMapper om = new ObjectMapper();
		Bill bill = om.readValue(data, Bill.class);
		
		Double netPayable = service.calculateNetPayable(bill);
		
		this.mockMvc
		.perform(MockMvcRequestBuilders.post(URL)
				.content(data)
				.contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(String.format("Net payable amount for the given bill is = %s", netPayable))));
	}
	
	@Test
	public void calculateDiscountFor2YearOldGeneralCustomer() throws Exception {
		
		String path = "src/test/resources/input/general-customer-2year-old.json";
		String data = readFileAsString(path);
		
		ObjectMapper om = new ObjectMapper();
		Bill bill = om.readValue(data, Bill.class);
		
		Double netPayable = service.calculateNetPayable(bill);
		
		this.mockMvc
		.perform(MockMvcRequestBuilders.post(URL)
				.content(data)
				.contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(String.format("Net payable amount for the given bill is = %s", netPayable))));
	}
	
	@Test
	public void calculateDiscountForStoreAffiliate() throws Exception {
		
		String path = "src/test/resources/input/store-affiliate.json";
		String data = readFileAsString(path);
		
		ObjectMapper om = new ObjectMapper();
		Bill bill = om.readValue(data, Bill.class);
		
		Double netPayable = service.calculateNetPayable(bill);
		
		this.mockMvc
		.perform(MockMvcRequestBuilders.post(URL)
				.content(data)
				.contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(String.format("Net payable amount for the given bill is = %s", netPayable))));
	}
	
	@Test
	public void calculateDiscountForStoreEmployee() throws Exception {
		
		String path = "src/test/resources/input/store-employee.json";
		String data = readFileAsString(path);
		
		ObjectMapper om = new ObjectMapper();
		Bill bill = om.readValue(data, Bill.class);
		
		Double netPayable = service.calculateNetPayable(bill);
		
		this.mockMvc
		.perform(MockMvcRequestBuilders.post(URL)
				.content(data)
				.contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString(String.format("Net payable amount for the given bill is = %s", netPayable))));
	}
	
	public static String readFileAsString(String file)throws Exception
    {
        return new String(Files.readAllBytes(Paths.get(file)));
    }
	
}

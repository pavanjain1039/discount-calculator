package com.example.demo.rest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class DiscountCalculatorRestControllerTest {

	@Autowired
    private MockMvc mockMvc;
	
	@Test
	public void test() throws Exception {
		this.mockMvc
		.perform(MockMvcRequestBuilders.post("/discount-calculator/netpayable"))
//        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Net payable amount for the given bill")));
	}
	
}

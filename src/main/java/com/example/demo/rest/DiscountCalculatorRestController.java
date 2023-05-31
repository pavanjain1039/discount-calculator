package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Bill;
import com.example.demo.service.DiscountCalculatorService;

@RestController
@RequestMapping("/discount-calculator")
public class DiscountCalculatorRestController {

	@Autowired
	private DiscountCalculatorService service;
	
	@PostMapping(value = "/netpayable", 
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<String> calculateNetPayable(@RequestBody Bill bill) {
		
		Double finalNetPayable = service.calculateNetPayable(bill);
		
		return ResponseEntity.ok(String.format("Net payable amount for the given bill is = %s", finalNetPayable));
	}
}

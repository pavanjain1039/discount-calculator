package com.example.demo.service;

import com.example.demo.model.Bill;

public interface DiscountCalculatorService {

	Double calculateNetPayable(Bill bill);
}

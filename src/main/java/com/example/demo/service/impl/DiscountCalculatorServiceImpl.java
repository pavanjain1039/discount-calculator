package com.example.demo.service.impl;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.demo.model.Bill;
import com.example.demo.model.User;
import com.example.demo.service.DiscountCalculatorService;

@Service
public class DiscountCalculatorServiceImpl implements DiscountCalculatorService {

	@Override
	public Double calculateNetPayable(Bill bill) {
		Float discount = 0.0f;
		Double netPayable = 0.0;
		
		// step-1 : Get the User object from bill & check if user is employee OR affiliate (and apply discount) 
		User user = bill.getUser();
		if(User.UserType.STORE_EMPLOYEE == user.getUserType()) {
			discount = 30f;
		} else if (User.UserType.STORE_AFFILIATE == user.getUserType()){
			discount = 10f;
		} else if(isOlderThan2Years(user)) {
			discount = 5f;
		} 
		//System.out.println("applicable discount = "+discount+"%");
		
		//step-2 calculate payable amount of non-grocery items
		Double nonGroceryItemsTotal = bill.nonGroceryItemsTotal();
		//System.out.println("non-grocery itemTotal = "+nonGroceryItemsTotal);
		
		// step-3 apply percentage discount on non-grocery items & add it to netPayable
		netPayable = nonGroceryItemsTotal*(100-discount) / 100;
		//System.out.println("netPayable = "+netPayable);
		
		// step-4 calculate total bill amount
		Double groceryItemsTotal = bill.groceryItemsTotal();
		Double totalBillAmount = netPayable + groceryItemsTotal;
		//System.out.println("totalBillAmount = "+totalBillAmount);
		
		//step-5 apply additional discount
		int intValue = totalBillAmount.intValue();
		//System.out.println("intValue = "+intValue);
		int multiples = intValue/100;
		Integer additionalDiscount = multiples*5;
		//System.out.println("additionalDiscount = "+additionalDiscount);
		totalBillAmount -= additionalDiscount;
		//System.out.println("final netPayable = "+totalBillAmount);
		
		return totalBillAmount;
	}
	
	private boolean isOlderThan2Years(User user) {
		Date joinDate = user.getUserSince();
		//System.out.println("joinDate = "+joinDate);
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.YEAR, -2);
		Date backDate = cal.getTime();
		//System.out.println("backDate = "+backDate);
		boolean isOlderThan2Years = joinDate.before(backDate);
		//System.out.println("isOlderThan2Years = "+isOlderThan2Years);
		return isOlderThan2Years;
	}
	
}

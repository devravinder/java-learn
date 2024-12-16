package com.paravar.labs.lab8.demo;

import java.math.BigDecimal;

public class Account
{
	BigDecimal balance;
	
	public void credit(BigDecimal amt)
	{
		//peform input validations
		//perform business validations
		//apply business logic
		balance.add(amt);
	}
}

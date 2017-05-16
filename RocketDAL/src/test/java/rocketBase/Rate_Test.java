package rocketBase;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import rocketDomain.RateDomainModel;

public class Rate_Test {
	@Test
	public void test() {
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		System.out.println ("Rates size: " + rates.size());
		assert(rates.size() > 0);
		
		assert(1==1);
	
	for (RateDomainModel rdm : rates) {
		System.out.println(rdm);
	}
	
	assertEquals(rates.get(0).getiRateID(), 5);
	assertEquals(rates.get(1).getiRateID(), 4);
	assertEquals(rates.get(2).getiRateID(), 3);
	assertEquals(rates.get(3).getiRateID(), 2);
	assertEquals(rates.get(4).getiRateID(), 1);
	
	assertEquals(rates.get(0).getiMinCreditScore(), 800);
	assertEquals(rates.get(1).getiMinCreditScore(), 750);
	assertEquals(rates.get(2).getiMinCreditScore(), 700);
	assertEquals(rates.get(3).getiMinCreditScore(), 650);
	assertEquals(rates.get(4).getiMinCreditScore(), 600);

	assertEquals(rates.get(0).getdInterestRate(), 3.5,  0.001);
	assertEquals(rates.get(1).getdInterestRate(), 3.75, 0.001);
	assertEquals(rates.get(2).getdInterestRate(), 4.0,  0.001);
	assertEquals(rates.get(3).getdInterestRate(), 4.5,  0.001);
	assertEquals(rates.get(4).getdInterestRate(), 5.0,  0.001);

}

}
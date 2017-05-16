package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	@Test
	public void testgetrate1() throws RateException {
		assertEquals(RateBLL.getRate(1000),4.0,0.001);
	}
	@Test
	public void testgetrate2() throws RateException {
		assertEquals(RateBLL.getRate(0),0,0.001);
	}

	@Test
	public void test() {
		assert(1==1);
	}

}

package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;
import org.hibernate.HibernateException;

import exceptions.RateException;
import rocketData.LoanRequest;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException
	{

		ArrayList<RateDomainModel> alRates = new ArrayList<RateDomainModel>();
		
		double bestRate = 0;
		 for (RateDomainModel rat : alRates) {
			 if(GivenCreditScore > rat.getiMinCreditScore()){
				 bestRate = rat.getdInterestRate();
			 }
			else{
				 return bestRate;
			 	}
				if (bestRate < 0.0) {
					throw new RateException(rat);
					} 
			else {
					return bestRate;
					}
	      }
	
		return bestRate;
	}
	public boolean incomecheck(double income){
		LoanRequest lq = new LoanRequest();
		
		double PMT = Math.abs(lq.getdPayment());
		if ((PMT * 12 * 30 * 0.28 < (income - lq.getExpenses() * 12) * 30* 0.28)
				|| PMT * 12 * 30* 0.36 < (income - lq.getExpenses() * 12) * 30* 0.36) {
			return true;
		}
		return false; 
	}
	

	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return Math.abs(FinanceLib.pmt(r, n, p, f, t));
	}
}
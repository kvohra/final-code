package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	private RateDomainModel ratedomainmodel = null;

	public RateDomainModel getRatedomainmodel() {
		return ratedomainmodel;
	}

	public RateException(RateDomainModel ratedomainmodel){
		this.ratedomainmodel = ratedomainmodel;
	}
}
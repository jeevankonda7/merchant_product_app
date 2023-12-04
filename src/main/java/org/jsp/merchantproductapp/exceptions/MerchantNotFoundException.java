package org.jsp.merchantproductapp.exceptions;

public class MerchantNotFoundException extends RuntimeException{

	@Override
	public String getMessage() {
		return "Merchant not available to update";
	}

}

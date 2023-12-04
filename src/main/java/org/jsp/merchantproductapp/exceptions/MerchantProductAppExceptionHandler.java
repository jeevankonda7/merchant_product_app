package org.jsp.merchantproductapp.exceptions;

import org.jsp.merchantproductapp.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MerchantProductAppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(MerchantNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> MNFEHandler(MerchantNotFoundException exception) {
		ResponseStructure<String> structure = new ResponseStructure<>();
		structure.setData(exception.getMessage());
		structure.setMessage("no Merchant found");
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.NOT_FOUND);
	}

}

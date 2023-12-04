package org.jsp.merchantproductapp.service;

import java.util.Optional;

import org.jsp.merchantproductapp.dao.MerchantDao;
import org.jsp.merchantproductapp.dto.Merchant;
import org.jsp.merchantproductapp.dto.ResponseStructure;
import org.jsp.merchantproductapp.exceptions.MerchantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
	
	@Autowired
	private MerchantDao merchantDao;
	
	public ResponseEntity<ResponseStructure<Merchant>> saveMerchant(Merchant merchant) {
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		structure.setData(merchantDao.saveMerchant(merchant));
		structure.setMessage("Merchant saved successfully");
		structure.setStatusCode(HttpStatus.CREATED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Merchant>> updateMerchant(Merchant merchant) {
		Optional<Merchant> recMerchant = merchantDao.findMerchantById(merchant.getId());
		ResponseStructure<Merchant> structure = new ResponseStructure<>();
		if(recMerchant.isPresent()) {
		Merchant dbMerchant = recMerchant.get();
		dbMerchant.setId(merchant.getId());
		dbMerchant.setName(merchant.getName());
		dbMerchant.setGst_no(merchant.getGst_no());
		dbMerchant.setEmail(merchant.getEmail());
		dbMerchant.setPhone(merchant.getPhone());
		dbMerchant.setPassword(merchant.getPassword());
		structure.setData(merchantDao.updateMerchant(dbMerchant));
		structure.setMessage("Merchant updated");
		structure.setStatusCode(HttpStatus.ACCEPTED.value());
		return new ResponseEntity<ResponseStructure<Merchant>>(structure, HttpStatus.ACCEPTED);
	}
		throw new MerchantNotFoundException();
	}

}

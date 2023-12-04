package org.jsp.merchantproductapp.service;

import java.util.Optional;

import org.jsp.merchantproductapp.dao.MerchantDao;
import org.jsp.merchantproductapp.dao.ProductDao;
import org.jsp.merchantproductapp.dto.Merchant;
import org.jsp.merchantproductapp.dto.Product;
import org.jsp.merchantproductapp.dto.ResponseStructure;
import org.jsp.merchantproductapp.exceptions.MerchantNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private MerchantDao merchantDao;
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product, int merchant_id) {
		Optional<Merchant> dbMerchant = merchantDao.findMerchantById(merchant_id);
		ResponseStructure<Product> structure = new ResponseStructure<>();
		if(dbMerchant.isPresent()) {
			Merchant merchant = dbMerchant.get();
			merchant.getProducts().add(product);
			merchantDao.saveMerchant(merchant);
			product.setMerchant(merchant);
			structure.setData(productDao.saveProduct(product));
			structure.setMessage("Product added");
			structure.setStatusCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<Product>>(structure,HttpStatus.CREATED);
			
		}
		throw new MerchantNotFoundException();
	}

}

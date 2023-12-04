package org.jsp.merchantproductapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantproductapp.dto.Merchant;
import org.jsp.merchantproductapp.dto.Product;
import org.jsp.merchantproductapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	
	@Autowired
	private ProductRepository productRepository;
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Product updateProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Optional<Product> findProductById(int id) {
		return productRepository.findById(id);
	}
	public List<Product> findAll(){
		return productRepository.findAll();
	}
	
	public boolean deleteProduct(int id) {
		Optional<Product> product = findProductById(id);
		if(product.isPresent()) {
			productRepository.delete(product.get());
			return true;
		}
		return false;
	}

}

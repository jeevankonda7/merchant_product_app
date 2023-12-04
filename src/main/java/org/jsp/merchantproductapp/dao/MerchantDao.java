package org.jsp.merchantproductapp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.merchantproductapp.dto.Merchant;
import org.jsp.merchantproductapp.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MerchantDao {

	@Autowired
	private MerchantRepository merchantRepository;

	public Merchant saveMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}
	
	public Merchant updateMerchant(Merchant merchant) {
		return merchantRepository.save(merchant);
	}
	
	public Optional<Merchant> findMerchantById(int id) {
		return merchantRepository.findById(id);
	}
	
	public List<Merchant> findAll(){
		return merchantRepository.findAll();
	}
	
	public boolean deleteMerchant(int id) {
		Optional<Merchant> merchant = findMerchantById(id);
		if(merchant.isPresent()) {
			merchantRepository.delete(merchant.get());
			return true;
		}
		return false;
	}

}

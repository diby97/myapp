package com.homera.ecommerce.process.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homera.ecommerce.model.Seller;
import com.homera.ecommerce.process.HomeraProcess;
import com.homera.ecommerce.process.beans.SellersInfoProcessReq;
import com.homera.ecommerce.repository.SellerRepository;

@Service
public class HomeraProcessImpl implements HomeraProcess {
	
	@Autowired
	SellerRepository sellerRepo;
	
	
	public String saveSellerInfo(SellersInfoProcessReq processReq) {
		Seller seller=new Seller();
		seller.setFname(processReq.getFname());
		seller.setLname(processReq.getLname());
		seller.setDob(processReq.getJob());
		seller.setJob(processReq.getJob());
		seller.setAddress(processReq.getAddress());
		sellerRepo.save(seller);
		return "saved successfuly";
	}
	public Iterable<Seller> getSeller(){
		
		return sellerRepo.findAll();
	}

}

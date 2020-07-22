package com.homera.ecommerce.resource.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.homera.ecommerce.model.Seller;
import com.homera.ecommerce.process.HomeraProcess;
import com.homera.ecommerce.process.beans.SellersInfoProcessReq;
import com.homera.ecommerce.resource.beans.SellersInfoResourceReq;

@Controller
public class HomeraResourceImpl {

	@Autowired
	HomeraProcess homeraProcess;
	
	@GetMapping(path="/index")
	public String index() {
		return "index.jsp";
	}
	
	@GetMapping(path="/contactus")
	public String getAddress() {
		return "contact.jsp";
	}
	
	@GetMapping(path="/aboutus")
	public String getInfo() {
		return "about.jsp";
	}
	
	@GetMapping(path="/getseller")
	public @ResponseBody Iterable<Seller> getSeller(){
		
		return homeraProcess.getSeller();
	}
	
	@PostMapping(path = "/saveseller")
	public String saveSellerInfo(@RequestBody SellersInfoResourceReq newInfoReq ) {
		SellersInfoProcessReq sellersInfoProcessReq=new SellersInfoProcessReq();
		sellersInfoProcessReq.setFname(newInfoReq.getFname());
		sellersInfoProcessReq.setLname(newInfoReq.getLname());
		sellersInfoProcessReq.setDob(newInfoReq.getDob());
		sellersInfoProcessReq.setJob(newInfoReq.getJob());
		sellersInfoProcessReq.setAddress(newInfoReq.getAddress());
		return homeraProcess.saveSellerInfo(sellersInfoProcessReq);
	}
}

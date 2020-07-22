package com.homera.ecommerce.process;

import com.homera.ecommerce.model.Seller;
import com.homera.ecommerce.process.beans.SellersInfoProcessReq;

public interface HomeraProcess {

	public String saveSellerInfo(SellersInfoProcessReq processReq);
	public Iterable<Seller> getSeller();
}

package com.sony.springbootbasics.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sony.springbootbasics.entity.Shipper;

@Service // a type of @Component that has business logic
public class ShipperManager {

	private List<Shipper> shippers;

	public ShipperManager() {
		shippers = new ArrayList<>();
		shippers.add(new Shipper(1, "Speedy Express", "(987) 827-2234"));
		shippers.add(new Shipper(2, "United Packages", "(726) 123-2145"));
		shippers.add(new Shipper(3, "DHL Couriers", "(912) 727-1222"));
	}
	
	public Shipper addNewShipper(Shipper sh) {
		String name =sh.getCompanyName().trim();
		if(name.length()<5 || name.length()>25) {
			throw new ServiceException(
				"Shipping company name must be between 5 to 25 letters");
		}
		
		// validation #2
		// try validating phone with pattern "(999) 999-9999"
		// hint: use regular expression

		Optional<Shipper> op = shippers
				.stream()
				.filter(s->s.getPhone().equals(sh.getPhone()))
				.findFirst();
		
		if(op.isPresent()) {
			throw new ServiceException("A shipping company with this phone already present - " + sh.getPhone());
		}
		
		int newId = shippers.size()==0 ? 1 : 1 + shippers
			.stream()
			.mapToInt(s->s.getShipperId())
			.max()
			.getAsInt();
		
		sh.setShipperId(newId);
		shippers.add(sh);
		return sh;
	}

	public List<Shipper> getAllShippers() {
		return this.shippers;
	}

	public Shipper getShipperById(Integer id) {
		Optional<Shipper> op = shippers
				.stream()
				.filter(sh->sh.getShipperId()==id)
				.findFirst();
		
		if(op.isPresent()) {
			return op.get();
		}
		return null;
	}
}











package com.sony.springbootbasics;

import java.util.ArrayList;
import java.util.List;

import com.sony.springbootbasics.entity.Shipper;

public class Test {
	
	public static void main(String[] args) {
		
		List<Shipper> shippers= new ArrayList<>();
		shippers.add(new Shipper(12, "Speedy Express", "(987) 827-2234"));
		shippers.add(new Shipper(211, "United Packages", "(726) 123-2145"));
		shippers.add(new Shipper(35, "DHL Couriers", "(912) 727-1222"));
		
		int maxId = shippers.stream()
			.mapToInt(sh -> sh.getShipperId())
			.max()
			.getAsInt();
		
		System.out.println("maxId = " +maxId);
			
		
	}

}

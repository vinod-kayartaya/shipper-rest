package com.sony.springbootbasics.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sony.springbootbasics.entity.Shipper;
import com.sony.springbootbasics.entity.ShipperList;
import com.sony.springbootbasics.service.ServiceException;
import com.sony.springbootbasics.service.ShipperManager;

//@CrossOrigin(originPatterns = {"http://localhost:3000", "http://127.0.0.1:3000"})
@CrossOrigin
@RestController
@RequestMapping("/api/shippers")
public class ShipperController {

	@Autowired
	private ShipperManager mgr;

	@GetMapping(produces = { "application/xml", "application/json" })
	public ShipperList getAllShippers() {
		List<Shipper> shippers = mgr.getAllShippers();
		return new ShipperList(shippers);
	}

	@GetMapping(produces = "text/plain")
	public String getAllShippersAsString() {
		return mgr.getAllShippers().toString();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getOneShipper(@PathVariable Integer id) {
		Shipper shipper = mgr.getShipperById(id);

		if (shipper == null) {
			return ResponseEntity.status(404).body("No data found for id: " + id);
		}
		return ResponseEntity.ok(shipper);
	}

	@PostMapping
	public ResponseEntity<Object> addNewShipper(@RequestBody Shipper shipper) {
		try {
			shipper = mgr.addNewShipper(shipper);
			return ResponseEntity.ok(shipper);
		} catch (ServiceException e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

}

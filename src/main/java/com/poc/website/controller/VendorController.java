package com.poc.website.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.website.model.Product;
import com.poc.website.model.Vendor;
import com.poc.website.service.VendorService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/vendor")
public class VendorController {
	
	@Autowired
	VendorService vendorService;
	
	@GetMapping("/{id}")
	public Vendor getVendorById(@PathVariable long id) {
		return vendorService.getVendorById(id);
	}
	@PostMapping("/addVendor")
	public Vendor createVendor(@RequestBody Vendor vendor) {
		return vendorService.saveVendor(vendor);
	}
	@GetMapping("/{id}/products")
	public Set<Product> getProduct(@PathVariable long id){
		return vendorService.getProduct(id);
	}
	@DeleteMapping("/{id}")
	public void deleteVendor(@PathVariable long id) {
		vendorService.deleteVendor(id);
	}
	@PutMapping("/{id}")
	public Vendor updateVendor(@PathVariable long id,@RequestBody Vendor vendor) {
		return vendorService.updateVendor(id, vendor);
	}
	@GetMapping("/allVendor")
	public List<Vendor> getAllVendor() {
		return vendorService.getAllVendors();
	}
	@PostMapping("/updateVendor/{id}")
	public Vendor updateVendor(@RequestBody Vendor vendor, @PathVariable long id) {
		return vendorService.updateVendor(id, vendor);
	}

}

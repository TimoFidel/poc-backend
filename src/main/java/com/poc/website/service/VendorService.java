package com.poc.website.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.poc.website.model.Product;
import com.poc.website.model.Vendor;
import com.poc.website.repository.ProductRepository;
import com.poc.website.repository.VendorRepository;

@Service
public class VendorService {
	
	@Autowired
	VendorRepository vendorRepository;
	
	@Autowired
	ProductRepository productRepository;
	
	public Vendor getVendorById(long id) {
		return vendorRepository.getById(id);
	}
	
	public Vendor saveVendor(Vendor vendor) {
		return vendorRepository.save(vendor);
	}
	public Set<Product> getProduct(long id){
		Vendor vendor= vendorRepository.getById(id);
		return vendor.getProduct();
	}
	public void deleteVendor(long id) {
		Vendor vendor= vendorRepository.getById(id);
		productRepository.deleteAllInBatch(vendor.getProduct());
		vendorRepository.save(vendor);
		vendorRepository.deleteById(id);
	}
	
	public Vendor updateVendor(long id, Vendor vendor) {
		Vendor tempVendor= vendorRepository.getById(id);
		tempVendor.setAddress(vendor.getAddress());
		tempVendor.setContactNumebr(vendor.getContactNumebr());
		tempVendor.setVendorName(vendor.getVendorName());
		tempVendor.setRating(vendor.getRating());
		return vendorRepository.save(tempVendor);
	}
	
	public List<Vendor> getAllVendors(){
		return vendorRepository.findAll();
	}
	
	

}

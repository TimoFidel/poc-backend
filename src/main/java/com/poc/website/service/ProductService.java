package com.poc.website.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poc.website.model.Product;
import com.poc.website.model.Vendor;
import com.poc.website.repository.ProductRepository;
import com.poc.website.repository.VendorRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	
	public Product getProductById(long id) {
		return productRepository.getById(id);
	}
	
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	public Product updateProduct(long id, Product product) {
		Product tempProduct=productRepository.getById(id);
		tempProduct.setModelName(product.getModelName());
		tempProduct.setDriveSize(product.getDriveSize());
		tempProduct.setOs(product.getOs());
		tempProduct.setRam(product.getRam());
		tempProduct.setStockAvailable(product.getStockAvailable());
		tempProduct.setVendor(product.getVendor());
		return productRepository.save(tempProduct);
	}

}

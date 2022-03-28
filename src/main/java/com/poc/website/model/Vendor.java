package com.poc.website.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table
public class Vendor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="vendor_id")
	private long id;
	
	@Column(name="vendor_name")
	private String vendorName;
	
	@Column(name="rating")
	private double rating;
	
	@Column(name="address")
	private String address;
	
	@Column(name="number")
	private String contactNumebr;
	
	@OneToMany(mappedBy="vendor")
	@Cascade(value = { CascadeType.DELETE, CascadeType.SAVE_UPDATE })
	@JsonIgnore
	public Set<Product> product;

	public Vendor(long id, String vendorName, double rating, String address, String contactNumebr, Set<Product> product) {
		super();
		this.id = id;
		this.vendorName = vendorName;
		this.rating = rating;
		this.address = address;
		this.contactNumebr = contactNumebr;
		this.product = product;
	}

	public Vendor() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumebr() {
		return contactNumebr;
	}

	public void setContactNumebr(String contactNumebr) {
		this.contactNumebr = contactNumebr;
	}

	public Set<Product> getProduct() {
		return product;
	}

	public void setProduct(Set<Product> product) {
		this.product = product;
	}
	public void updateProduct(Product product) {
		this.product.add(product);
	}
	

}

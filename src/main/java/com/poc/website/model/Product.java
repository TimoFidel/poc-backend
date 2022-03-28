package com.poc.website.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private long id;
	
	@Column(name="model_name")
	private String modelName;
	
	@Column(name="os")
	private String os;
	
	@Column(name="ram")
	private String ram;
	
	@Column(name="drive_size")
	private String driveSize;
	
	@Column(name="stock_available")
	private int stockAvailable;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "vendor_id")
	//@JsonIgnore
	private Vendor vendor;

	public Product(long id, String modelName, String os, String ram, String driveSize, int stockAvailable, Vendor vendor) {
		super();
		this.id = id;
		this.modelName = modelName;
		this.os = os;
		this.ram = ram;
		this.driveSize = driveSize;
		this.stockAvailable = stockAvailable;
		this.vendor = vendor;
	}

	public Product() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getDriveSize() {
		return driveSize;
	}

	public void setDriveSize(String driveSize) {
		this.driveSize = driveSize;
	}

	public int getStockAvailable() {
		return stockAvailable;
	}

	public void setStockAvailable(int stockAvailable) {
		this.stockAvailable = stockAvailable;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}
	
	
	

}

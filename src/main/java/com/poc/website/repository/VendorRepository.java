package com.poc.website.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.website.model.Vendor;

public interface VendorRepository extends JpaRepository<Vendor,Long> {

}

package com.example.electro.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electro.entity.BillingAddress;

public interface BillingAddressService extends JpaRepository<BillingAddress, Long> {

	
}

package com.example.electro.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electro.entity.BillingAddress;

public interface BillingAddressServiceJpa extends JpaRepository<BillingAddress, Long> {

	
}

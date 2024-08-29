package com.example.electro.service;

import org.springframework.http.ResponseEntity;

import com.example.electro.entity.Address;

public interface ShippingAddressService {

	ResponseEntity<String> saveShippingAddress(Address address);

}

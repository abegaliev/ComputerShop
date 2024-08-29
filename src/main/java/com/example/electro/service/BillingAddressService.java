package com.example.electro.service;

import org.springframework.http.ResponseEntity;

import com.example.electro.payload.BillingAddressRecord;

public interface BillingAddressService {

	ResponseEntity<String> saveBillingAddress(BillingAddressRecord billingAddress);

}

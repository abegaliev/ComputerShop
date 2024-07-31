package com.example.electro.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.electro.entity.ShippingAddress;

public interface ShippingAddressService extends JpaRepository<ShippingAddress, Long> {

}

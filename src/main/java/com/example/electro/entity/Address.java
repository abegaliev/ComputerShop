package com.example.electro.entity;

import jakarta.validation.Valid;

public class Address {

	@Valid
	private BillingAddress billingAddress;
	
	@Valid
	private ShippingAddress shippingAddress;

	public Address() {

	}

	public Address(BillingAddress billingAddress, ShippingAddress shippingAddress) {
		super();
		this.billingAddress = billingAddress;
		this.shippingAddress = shippingAddress;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public ShippingAddress getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(ShippingAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "Address [billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress + "]";
	}

}

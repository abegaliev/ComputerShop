package com.example.electro.entity;

public class Address {

	private BillingAddress billingAddress;
	private ShippingAddress shippingAddress;

	public Address() {
		super();
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
		return "Adress [billingAddress=" + billingAddress + ", shippingAddress=" + shippingAddress + "]";
	}

}

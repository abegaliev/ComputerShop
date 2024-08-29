package com.example.electro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "BILLING_ADDRESS")
public class BillingAddress {

	@Id
	@GeneratedValue
	@Column(name = "BILLING_ID")
	private Long billAddressId;

	@Column(name = "FIRST_NAME")
	@NotBlank(message = "First name is required")
	private String firstName;

	@Column(name = "LAST_NAME")
	@NotBlank(message = "Last name is required")
	private String lastName;

	@NotBlank(message = "Please, enter your email address")
	@Email(message = "Please, enter a valid email address")
	@Column(name = "EMAIL")
	private String email;

	@NotBlank(message = "Street is required")
	@Column(name = "STREET")
	private String street;

	@NotBlank(message = "City is required")
	@Column(name = "CITY")
	private String city;

	@NotBlank(message = "Country is required")
	@Column(name = "COUNTRY")
	private String country;

	@NotBlank(message = "ZIP code is required")
	@Column(name = "ZIP_CODE")
	private String zipCode;

	@NotBlank(message = "Phone number is required")
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	public BillingAddress() {

	}

	public BillingAddress(String firstName, String lastName, String email, String street, String city, String country,
			String zipCode, String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.street = street;
		this.city = city;
		this.country = country;
		this.zipCode = zipCode;
		this.phoneNumber = phoneNumber;
	}

	public Long getOrderId() {
		return billAddressId;
	}

	public void setOrderId(Long orderId) {
		this.billAddressId = orderId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "BillingAddress [billAddressId=" + billAddressId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", street=" + street + ", city=" + city + ", country=" + country + ", zipCode="
				+ zipCode + ", phoneNumber=" + phoneNumber + "]";
	}



}

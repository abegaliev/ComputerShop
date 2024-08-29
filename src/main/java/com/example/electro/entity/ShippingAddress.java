package com.example.electro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "SHIPPING_ADDRESS")
public class ShippingAddress {

	@Id
	@GeneratedValue
	@Column(name = "SHIPPING_ID")
	private Long shipAddress_id;

	@Column(name = "FIRST_NAME")
	@NotBlank(message = "First name is required", groups = ConditionalGroup.class)
	private String firstName;

	@Column(name = "LAST_NAME")
	@NotBlank(message = "Last name is required", groups = ConditionalGroup.class)
	private String lastName;

	@NotBlank(message = "Please, enter your email address", groups = ConditionalGroup.class)
	@Email(message = "Please, enter a valid email address", groups = ConditionalGroup.class)
	@Column(name = "EMAIL")
	private String email;

	@NotBlank(message = "Street is required", groups = ConditionalGroup.class)
	@Column(name = "STREET")
	private String street;

	@NotBlank(message = "City is required", groups = ConditionalGroup.class)
	@Column(name = "CITY")
	private String city;

	@NotBlank(message = "Country is required", groups = ConditionalGroup.class)
	@Column(name = "COUNTRY")
	private String country;

	@NotBlank(message = "ZIP code is required", groups = ConditionalGroup.class)
	@Column(name = "ZIP_CODE")
	private String zipCode;

	@NotBlank(message = "Phone number is required", groups = ConditionalGroup.class)
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	public ShippingAddress() {

	}

	public ShippingAddress(String firstName, String lastName, String email, String street, String city, String country,
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
		return shipAddress_id;
	}

	public void setOrderId(Long orderId) {
		this.shipAddress_id = orderId;
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
		return "ShippingAddress [shipAddress_id=" + shipAddress_id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", street=" + street + ", city=" + city + ", country=" + country + ", zipCode="
				+ zipCode + ", phoneNumber=" + phoneNumber + "]";
	}



}

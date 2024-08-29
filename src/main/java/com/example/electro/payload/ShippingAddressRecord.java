package com.example.electro.payload;

import jakarta.validation.constraints.*;

public record ShippingAddressRecord(
		
		@NotBlank(message = "The firstname is required.")
		String firstName,
		
		@NotBlank(message = "The lastname is required.")
		String lastName,
		
		@NotEmpty(message = "The email is required.")
        @Email(message = "The email is not a valid email.")
		String email,
		
		@NotEmpty(message = "The Phone number is required.")
		String phoneNumber,
		
		@NotBlank(message = "The city is required.")
		String city,
		
		@NotBlank(message = "The street is required.")
		String street,
		
		@NotBlank(message = "The country is required.")
		String country,
		
		@NotBlank(message = "The zip code is required.")
		String zipCode) {
}

package com.example.electro.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.electro.entity.Address;
import com.example.electro.entity.BillingAddress;
import com.example.electro.entity.ConditionalGroup;
import com.example.electro.entity.ShippingAddress;
import com.example.electro.service.ShippingAddressService;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;

@Service
public class ShippingAddressRepository implements ShippingAddressService {

	private final JpaRepository<ShippingAddress, Long> shippJpaRepository;

	public ShippingAddressRepository(JpaRepository<ShippingAddress, Long> shippJpaRepository) {
		this.shippJpaRepository = shippJpaRepository;
	}

	public ResponseEntity<String> saveShippingAddress(Address address) {
		try {
			if (address.getShippingAddress().getStreet().isBlank()
					|| address.getShippingAddress().getCity().isBlank()) {

				BillingAddress billAddress = address.getBillingAddress();
				ShippingAddress shipAddress = new ShippingAddress();

				shipAddress.setFirstName(billAddress.getFirstName());
				shipAddress.setLastName(billAddress.getLastName());
				shipAddress.setEmail(billAddress.getEmail());
				shipAddress.setStreet(billAddress.getStreet());
				shipAddress.setCity(billAddress.getCity());
				shipAddress.setCountry(billAddress.getCity());
				shipAddress.setZipCode(billAddress.getZipCode());
				shipAddress.setPhoneNumber(billAddress.getPhoneNumber());
				shippJpaRepository.save(shipAddress);
			} else {
				shippJpaRepository.save(address.getShippingAddress());
			}
			return new ResponseEntity<>("Shipping Address was saved successfully.", HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Issue in saving a Shipping Address: ", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@Override
//	public ResponseEntity<String> saveShippingAddress(ShippingAddressRecord shippingAddress) {
//		ShippingAddress shipAddressEntity = new ShippingAddress();
//		try {
//			shipAddressEntity.setFirstName(shippingAddress.firstName());
//			shipAddressEntity.setLastName(shippingAddress.lastName());
//			shipAddressEntity.setEmail(shippingAddress.email());
//			shipAddressEntity.setPhoneNumber(shippingAddress.phoneNumber());
//			shipAddressEntity.setStreet(shippingAddress.street());
//			shipAddressEntity.setCity(shippingAddress.city());
//			shipAddressEntity.setCountry(shippingAddress.country());
//			shipAddressEntity.setZipCode(shippingAddress.zipCode());
//
//			shippJpaRepository.save(shipAddressEntity);
//
//			return new ResponseEntity<>("Shipping Address was saved successfully.", HttpStatus.CREATED);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			return new ResponseEntity<>("Issue in saving a Shipping Address: ", HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	
	public void applyConditionalValidation(Address address, String shippingCheckbox, BindingResult bindingResult) {
		if (shippingCheckbox != null) {
			// Appling a ConditionalGroup validation if checkbox is checked
			// Create a validator that validates based on group
			Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
			Set<ConstraintViolation<Address>> violations = validator.validate(address, ConditionalGroup.class);

			for (ConstraintViolation<Address> violation : violations) {
				bindingResult.rejectValue(violation.getPropertyPath().toString(),
						violation.getConstraintDescriptor().getAnnotation().annotationType().getSimpleName(),
						violation.getMessage());
			}
		}
	}
	
	

}

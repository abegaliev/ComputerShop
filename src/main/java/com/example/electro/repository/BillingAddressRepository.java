package com.example.electro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.electro.entity.BillingAddress;
import com.example.electro.payload.BillingAddressRecord;
import com.example.electro.service.BillingAddressService;

@Service
public class BillingAddressRepository implements BillingAddressService {

	private final JpaRepository<BillingAddress, Long> billJpaRepository;

	public BillingAddressRepository(JpaRepository<BillingAddress, Long> billJpaRepository) {
		this.billJpaRepository = billJpaRepository;
	}

	@Override
	public ResponseEntity<String> saveBillingAddress(BillingAddressRecord billingAddress) {
		BillingAddress bilAddressEntity = new BillingAddress();

		try {
			bilAddressEntity.setFirstName(billingAddress.firstName());
			bilAddressEntity.setLastName(billingAddress.lastName());
			bilAddressEntity.setEmail(billingAddress.email());
			bilAddressEntity.setPhoneNumber(billingAddress.phoneNumber());
			bilAddressEntity.setStreet(billingAddress.street());
			bilAddressEntity.setCity(billingAddress.city());
			bilAddressEntity.setCountry(billingAddress.country());
			bilAddressEntity.setZipCode(billingAddress.zipCode());

			billJpaRepository.save(bilAddressEntity);
			return new ResponseEntity<>("Billing Address was saved successfully.", HttpStatus.CREATED);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Issue in saving a Billing Address: ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}

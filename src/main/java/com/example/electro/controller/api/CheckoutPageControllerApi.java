package com.example.electro.controller.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.electro.entity.ShippingAddress;
import com.example.electro.service.ShippingAddressServiceJpa;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutPageControllerApi {

	ShippingAddressServiceJpa shippAdServiceJpa;

	public CheckoutPageControllerApi(ShippingAddressServiceJpa shippAdServiceJpa) {
		this.shippAdServiceJpa = shippAdServiceJpa;
	}

	@GetMapping("/get")
	public ShippingAddress getOrder(@RequestParam Long orderId) {
		return shippAdServiceJpa.getById(orderId);
	}

	@PostMapping
	public ResponseEntity<String> createAnOrder(@RequestBody ShippingAddress shippingAddress) {

		try {
			shippAdServiceJpa.save(shippingAddress);
			return new ResponseEntity<>("Order has been created: " + shippingAddress.getOrderId(), HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Order was not created: ", HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAnOrder(@RequestParam Long orderId) {
		try {
			shippAdServiceJpa.deleteById(orderId);
			return new ResponseEntity<>("Order has been deleted: " + orderId, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>("Order was not deleted: ", HttpStatus.BAD_REQUEST);
		}

	}

}

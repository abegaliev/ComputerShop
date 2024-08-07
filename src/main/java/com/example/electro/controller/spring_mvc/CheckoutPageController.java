package com.example.electro.controller.spring_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.electro.entity.Address;
import com.example.electro.entity.ShippingAddress;
import com.example.electro.service.BillingAddressService;
import com.example.electro.service.ShippingAddressService;

@Controller
@RequestMapping("/checkout")
public class CheckoutPageController {

	private final BillingAddressService bilAddressService;
	private final ShippingAddressService shipAddressService;

	public CheckoutPageController(BillingAddressService bilAddressService, ShippingAddressService shipAddressService) {
		this.bilAddressService = bilAddressService;
		this.shipAddressService = shipAddressService;

	}

	@GetMapping
	public String getCheckout(Model model) {
//		BillingAddress bilgAddress = new BillingAddress();
//		bilgAddress.setFirstName("Almaz");
//		bilgAddress.setLastName("Bega");
//		bilgAddress.setEmail("almaz@gmail.com");
//		bilgAddress.setStreet("55 Chui Ave");
//		bilgAddress.setCity("Bishkek");
//		bilgAddress.setCountry("Kyrgyzstan");
//		bilgAddress.setZipCode("77004");
//		bilgAddress.setPhoneNumber("+996 999 99 99 99");

		model.addAttribute("checkout", new Address());

		return "checkout";
	}

	@PostMapping
	public String userCheckout(@ModelAttribute Address address) {
		System.out.println(address.getBillingAddress().toString());
		System.out.println(address.getShippingAddress().toString());

		bilAddressService.save(address.getBillingAddress());
		shipAddressService.save(address.getShippingAddress());
		

		return "result";
	}

}

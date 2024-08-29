package com.example.electro.controller.spring_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.electro.entity.Address;
import com.example.electro.entity.BillingAddress;
import com.example.electro.repository.ShippingAddressRepository;
import com.example.electro.service.BillingAddressServiceJpa;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/checkout")
public class CheckoutPageController {

	private final BillingAddressServiceJpa billServiceJpa;
	private final ShippingAddressRepository shippAddressRepo;

	public CheckoutPageController(BillingAddressServiceJpa bilAddressService,
			ShippingAddressRepository shippAddressRepo) {
		this.billServiceJpa = bilAddressService;
		this.shippAddressRepo = shippAddressRepo;
	}

	@GetMapping
	public String getCheckout(Model model) {
		Address address = new Address();
		BillingAddress bilgAddress = new BillingAddress();
		bilgAddress.setFirstName("Almaz");
		bilgAddress.setLastName("Bega");
		bilgAddress.setEmail("almaz@gmail.com");
		bilgAddress.setStreet("55 Chui Ave");
		bilgAddress.setCity("Bishkek");
		bilgAddress.setCountry("Kyrgyzstan");
		bilgAddress.setZipCode("77004");
		bilgAddress.setPhoneNumber("+996 999 99 99 99");
		address.setBillingAddress(bilgAddress);

		model.addAttribute("address", address);
		return "checkout";
	}

	@PostMapping
	public String userCheckout(@RequestParam(name = "shipingCheckbox", required = false) String shipingCheckbox,
			@Valid @ModelAttribute Address address, BindingResult bindingResult) {

		// Appling a ConditionalGroup validation if checkbox is checked
		shippAddressRepo.applyConditionalValidation(address, shipingCheckbox, bindingResult);
		
		if (bindingResult.hasErrors())
			return "checkout";

		shippAddressRepo.saveShippingAddress(address);
		billServiceJpa.save(address.getBillingAddress());
		return "result";
	}

}

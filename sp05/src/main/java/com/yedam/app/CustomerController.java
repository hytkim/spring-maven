package com.yedam.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	
	@Autowired CustomerRepository repository;
	
	@GetMapping("/")
	public Iterable<Customer> list() {
		return repository.findAll();
	}
	
	@GetMapping("/find")
	public Iterable<Customer> listName(String e) {
		return repository.findByfirstNameLike("%"+e+"%");
	}
	
	@GetMapping("/addr")
	public Iterable<Customer> addr(String e) {
		return repository.findByAddrNameLike("%"+e+"%");
	}
}

package com.cg.smms;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class CustomerController {
	@Autowired
	private ICustomerService service;
//RESTful API methods for Retrieval operations
@GetMapping("/customers")
	public List<Customer> list(){
	return service.listAll();
}
@GetMapping("/customers/{id}")
public ResponseEntity<Customer> get(@PathVariable Integer id)
{
try
{
Customer customer = service.get(id);
return new ResponseEntity<Customer>(customer, HttpStatus.OK);
}
catch (NoSuchElementException e)
{
return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
}
}
// RESTful API method for Create operation
@PostMapping("/customers")
public void add(@RequestBody Customer customer)
{
service.save(customer);
}
// RESTful API method for Update operation
@PutMapping("/customers/{id}")
public ResponseEntity<?> update(@RequestBody Customer customer, @PathVariable Integer id)
{
try
{
Customer existcustomer = service.get(id);
service.save(customer);
return new ResponseEntity<>(HttpStatus.OK);
}
catch (Exception e)
{
return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
}
// RESTful API method for Delete operation
@DeleteMapping("/customers/{id}")
public void delete(@PathVariable Integer id)
{
service.delete(id);
}
}


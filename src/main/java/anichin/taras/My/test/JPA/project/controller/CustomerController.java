package anichin.taras.My.test.JPA.project.controller;

import anichin.taras.My.test.JPA.project.repository.CustomerRepository;
import anichin.taras.My.test.JPA.project.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @PostMapping("/save")
  public Customer saveCustomer(@RequestBody Customer customer) {
    System.out.println(customer);
    return customerRepository.save(customer);
  }


  @GetMapping("/findAllCustomers")
  public List <Customer> findAll() {
    return customerRepository.findAll();
  }

}

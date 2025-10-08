package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/v1/customers")
    public String addCustomer(@RequestParam String first, @RequestParam String last) {
        Customer customer = new Customer();
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return "Added new customer to repo!";
    }

    @GetMapping("/v1/customers")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/v1/customers/{id}")
    public Customer findCustomerById(@PathVariable Integer id) {
        return customerRepository.findCustomerById(id);
    }

    @DeleteMapping("/v1/customers/{id}")
    public String deleteCustomerById(@PathVariable Integer id) {
        customerRepository.deleteById(id);
        return "Deleted customer with id: " + id;
    }
    @PutMapping("/v1/customers")
    public String updateCustomer(@RequestParam Integer id, @RequestParam String first, @RequestParam String last) {
        Customer customer = customerRepository.findCustomerById(id);
        customer.setFirstName(first);
        customer.setLastName(last);
        customerRepository.save(customer);
        return "Updated customer with id: " + id;
    }
}
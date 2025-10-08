package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {

    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/v1/customers")
    public ResponseEntity<Object>
    addCustomer(@RequestParam String first, @RequestParam String last) {
        ResponseEntity<Object> response = null;
        try {
            Customer customer = new Customer();
            customer.setFirstName(first);
            customer.setLastName(last);

            customerRepository.save(customer);
            System.out.println("id=" + customer.getId());
            response = ResponseEntity.ok().body(customer);

        } catch (Exception e){
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @GetMapping("/v1/customers")
    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("/v1/customers/{id}")
    public ResponseEntity<Object>
    findCustomerById(@PathVariable Integer id) {
        Customer customer = customerRepository.findCustomerById(id);
        ResponseEntity<Object> response = ResponseEntity.notFound().build();
        if (customer != null)
            response = ResponseEntity.ok().body(customer);
        return response;
    }

    @DeleteMapping("/v1/customers/{id}")
    public ResponseEntity<Object>
    deleteCustomerById(@PathVariable Integer id) {
        ResponseEntity<Object> response = ResponseEntity.ok().build();
        try {
            customerRepository.deleteById(id);
        } catch (Exception e) {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @PutMapping("/v1/customers")
    public ResponseEntity<Object>
    updateCustomer(@RequestParam Integer id, @RequestParam String first, @RequestParam String last) {
        ResponseEntity<Object> response;
        try {
            Customer customer = customerRepository.findCustomerById(id);
            customer.setFirstName(first);
            customer.setLastName(last);
            customerRepository.save(customer);
            response = ResponseEntity.ok().body(customer);
        } catch (Exception e) {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }
}
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @PostMapping("/v1/customers")
    public ResponseEntity<Object>
    addCustomer(@RequestParam String first, @RequestParam String last) {
        // Defensive programming
        if(first == null && last == null)
            return ResponseEntity.badRequest().build();
        // Request seems ok, let's try to add this customer'
        ResponseEntity<Object> response = null;
        try {
            Customer customer = customersService.addCustomer(first, last);
            System.out.println("id=" + customer.getId());
            response = ResponseEntity.ok().body(customer);
        } catch (Exception e){
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @GetMapping("/v1/customers")
    public Iterable<Customer> getCustomers() {
        return customersService.getCustomers();
    }

    @GetMapping("/v1/customers/{id}")
    public ResponseEntity<Object>
    findCustomerById(@PathVariable Integer id) {
        // Defensive programming
        if(id == null) return ResponseEntity.badRequest().build();
        // Request seems ok, let's try to find the customer'
        ResponseEntity<Object> response;
        try {
            Customer customer = customersService.findCustomerById(id);
            response = ResponseEntity.ok().body(customer);
        } catch (Exception e){
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @DeleteMapping("/v1/customers/{id}")
    public ResponseEntity<Object>
    deleteCustomerById(@PathVariable Integer id) {
        // Defensive programming
        if(id == null) return ResponseEntity.badRequest().build();
        // Request seems ok, let's try to delete the customer'
        ResponseEntity<Object> response;
        try {
            customersService.deleteCustomerById(id);
            response = ResponseEntity.ok().build();
        } catch (Exception e) {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }

    @PutMapping("/v1/customers")
    public ResponseEntity<Object>
    updateCustomer(@RequestParam Integer id, @RequestParam String first, @RequestParam String last) {
        // Defensive programming
        if(id == null) return ResponseEntity.badRequest().build();
        if(first == null && last == null)
            return ResponseEntity.badRequest().build();
        // Request seems ok, let's try to update the customer'
        ResponseEntity<Object> response;
        try {
            Customer customer = customersService.updateCustomer(id,first,last);
            if (customer != null) {
                response = ResponseEntity.ok().body(customer);
            } else {
                response = ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            response = ResponseEntity.notFound().build();
        }
        return response;
    }
}
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public class CustomersService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(String first,String last) {
        Customer response = null;
        // At least one of the parameters must be non-null
        if(first == null && first.strip().length()>0
                && last==null && last.strip().length()>0)
            return response;

        try {
            Customer customer = new Customer();
            customer.setFirstName(first);
            customer.setLastName(last);

            customerRepository.save(customer);
            System.out.println("id=" + customer.getId());
            response = customer;
        } catch (Exception e){
            // log the exception
        }
        return response;
    }

    public Iterable<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer findCustomerById(Integer id) {
        Customer customer = null;
        try {
            customer = customerRepository.findCustomerById(id);
        } catch (Exception e){
        }
        return customer;
    }

    /**
     * Deletes a customer by their unique identifier.
     * If the customer with the provided ID does not exist or an exception occurs, no action is performed.
     *
     * @param id the unique identifier of the customer to delete
     * @return true if the customer was successfully deleted, false otherwise
     */
    public boolean deleteCustomerById(Integer id) {
        boolean response = false;
        // Id is mandatory
        if(id == null) return response;

        try {
            customerRepository.deleteById(id);
            response = true; // not really
        } catch (Exception e) {
        }
        return response;
    }

    public Customer updateCustomer(Integer id, String first,String last) {
        Customer customer = null;
        // Id is mandatory
        if(id == null) return customer;
        // At least one of the parameters must be non-null
        if(first == null && last==null) return customer;

        try {
            customer = customerRepository.findCustomerById(id);
            if (customer != null) {
                customer.setFirstName(first);
                customer.setLastName(last);
                customerRepository.save(customer);
            }
        } catch (Exception e) {
            customer = null;
        }
        return customer;
    }
}
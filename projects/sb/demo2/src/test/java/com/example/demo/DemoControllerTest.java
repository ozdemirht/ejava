package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.CustomersController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class DemoControllerTest {

    @Autowired
    private CustomersController demoController;

    @BeforeEach
    void setUp() {
        assertThat(demoController).isNotNull();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void addCustomer() {
        String first = "John";
        String last = "Doe";
        Object ret = demoController.addCustomer(first, last);
        System.out.print(">" + ret + "<");
        assertThat(ret).isNotNull();
    }

    @Test
    void getCustomers() {
    }

    @Test
    void findCustomerById() {
        int id = 1;
        ResponseEntity ret = demoController.findCustomerById(id);
        assert(ret.getStatusCode()== HttpStatus.OK);
        System.out.print(">" + ret + "<");
        assertThat(ret).isNotNull();
    }

    @Test
    void deleteCustomerById() {
    }

    @Test
    void updateCustomer() {
    }
}
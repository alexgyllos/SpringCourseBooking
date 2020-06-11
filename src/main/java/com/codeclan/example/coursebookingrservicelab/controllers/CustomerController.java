package com.codeclan.example.coursebookingrservicelab.controllers;

import com.codeclan.example.coursebookingrservicelab.models.Customer;
import com.codeclan.example.coursebookingrservicelab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> findCustomer (
            @RequestParam(name = "course_name", required = false) String courseName
    ){
        if (courseName != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseName(courseName), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/customers/{id}")
    public ResponseEntity getOneCustomer(@PathVariable Long id) {
        return new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/customers")
    public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @PutMapping(value = "/customers/{id}")
    public ResponseEntity editOneCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customerRepository.save(customer);
        return new ResponseEntity(customer, HttpStatus.CREATED);
    }

//    @DeleteMapping(value = "/customers/{id}")
//    public ResponseEntity deleteOneCustomer(@PathVariable Long id) {
//        Customer customer = new ResponseEntity<>(customerRepository.findById(id), HttpStatus.OK);
//        return new ResponseEntity<>(customerRepository.delete(id), HttpStatus.OK);
//    }
}

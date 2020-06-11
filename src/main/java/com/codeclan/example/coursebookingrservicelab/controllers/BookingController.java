package com.codeclan.example.coursebookingrservicelab.controllers;

import com.codeclan.example.coursebookingrservicelab.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

//    @GetMapping(name = "/bookings")
}

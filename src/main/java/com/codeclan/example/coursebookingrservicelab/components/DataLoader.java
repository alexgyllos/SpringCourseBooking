package com.codeclan.example.coursebookingrservicelab.components;

import com.codeclan.example.coursebookingrservicelab.models.Booking;
import com.codeclan.example.coursebookingrservicelab.models.Course;
import com.codeclan.example.coursebookingrservicelab.models.Customer;
import com.codeclan.example.coursebookingrservicelab.repositories.BookingRepository;
import com.codeclan.example.coursebookingrservicelab.repositories.CourseRepository;
import com.codeclan.example.coursebookingrservicelab.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    public DataLoader() {

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Course course1 = new Course("Software Development", "Glasgow", 5);
        courseRepository.save(course1);

        Customer customer1 = new Customer("Alex", "Glasgow", 22);
        customerRepository.save(customer1);

        Booking booking1 = new Booking("09-03-2020", course1, customer1);
        bookingRepository.save(booking1);

        Course course2 = new Course("Data Analysis", "Edinburgh", 4);
        courseRepository.save(course2);

        Customer customer2 = new Customer("George", "Edinburgh", 30);
        customerRepository.save(customer2);

        Booking booking2 = new Booking("10-01-2020", course2, customer2);
        bookingRepository.save(booking2);

        Customer customer3 = new Customer("John", "Glasgow", 25);
        customerRepository.save(customer3);

        Booking booking3 = new Booking("09-03-2020", course1, customer3);
        bookingRepository.save(booking3);

        course1.addBooking(booking1);
        course1.addBooking(booking3);
        courseRepository.save(course1);
        customer1.addBooking(booking1);
        customerRepository.save(customer1);
        course2.addBooking(booking2);
        courseRepository.save(course2);
        customer2.addBooking(booking2);
        customerRepository.save(customer2);
        customer3.addBooking(booking3);
        customerRepository.save(customer3);
    }
}

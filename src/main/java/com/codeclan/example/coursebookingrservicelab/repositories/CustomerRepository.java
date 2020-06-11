package com.codeclan.example.coursebookingrservicelab.repositories;

import com.codeclan.example.coursebookingrservicelab.models.Course;
import com.codeclan.example.coursebookingrservicelab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByBookingsCourseName(String course);
//    List<Customer> findByTownAndByCourseName(String town, String courseName);
//    List<Customer> findByAgeGreaterThanAndByTownAndByCourseName(Integer age,)
}

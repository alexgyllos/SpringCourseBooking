package com.codeclan.example.coursebookingrservicelab.repositories;

import com.codeclan.example.coursebookingrservicelab.models.Course;
import com.codeclan.example.coursebookingrservicelab.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByRating(Integer rating);
    List<Course> findByBookingsCustomerName(String name);
}

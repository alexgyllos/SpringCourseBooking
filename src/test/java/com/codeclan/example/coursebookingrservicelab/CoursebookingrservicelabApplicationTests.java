package com.codeclan.example.coursebookingrservicelab;

import com.codeclan.example.coursebookingrservicelab.models.Booking;
import com.codeclan.example.coursebookingrservicelab.models.Course;
import com.codeclan.example.coursebookingrservicelab.models.Customer;
import com.codeclan.example.coursebookingrservicelab.repositories.BookingRepository;
import com.codeclan.example.coursebookingrservicelab.repositories.CourseRepository;
import com.codeclan.example.coursebookingrservicelab.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
class CoursebookingrservicelabApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void canFindCoursesByRating() {
		List<Course> found = courseRepository.findByRating(4);
		assertEquals(2L, found.get(0).getId().longValue());
		assertEquals("Data Analysis", found.get(0).getName());
		assertEquals(1, found.size());
	}

	@Test
	void canFindCoursesByBookingsCustomerName() {
		List<Course> found = courseRepository.findByBookingsCustomerName("Alex");
		assertEquals(1L, found.get(0).getId().longValue());
		assertEquals("Software Development", found.get(0).getName());
		assertEquals(1, found.size());
	}

	@Test
	void canFindBookingsByDate() {
		List<Booking> found = bookingRepository.findByDate("10-01-2020");
		assertEquals(2L, found.get(0).getId().longValue());
		assertEquals("George", found.get(0).getCustomer().getName());
		assertEquals("Data Analysis", found.get(0).getCourse().getName());
		assertEquals(1, found.size());
	}

	@Test
	void canFindCustomersByBookingsCourseName() {
		List<Customer> found = customerRepository.findByBookingsCourseName("Software Development");
		assertEquals(1L, found.get(0).getId().longValue());
		assertEquals("Alex", found.get(0).getName());
		assertEquals(2, found.size());
	}
}

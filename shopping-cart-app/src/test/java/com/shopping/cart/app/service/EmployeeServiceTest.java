package com.shopping.cart.app.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.cart.app.model.Employee;
import com.shopping.cart.app.repository.EmployeeRepository;

@SpringBootTest
class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;

	@Test
	void testFindById() {

		Employee employee = new Employee();

		employee.setEmployeeNumber(1);
		employee.setFirstName("Ranu");
		employee.setLastName("Yadav");
		employee.setExtension("Full Time");
		employee.setJobTitle("Salesman");
		employee.setEmail("ranu3@gmail.com");

		Mockito.when(employeeRepository.save(employee)).thenReturn(employee);
		assertThat(employeeService.findById(1L)).isNotNull();
	}

	@Test
	void testSave() {
		Employee employee = new Employee();

		employee.setEmployeeNumber(1);
		employee.setFirstName("Ranu");
		employee.setLastName("Yadav");
		employee.setExtension("Full Time");
		employee.setJobTitle("Salesman");
		employee.setEmail("ranu3@gmail.com");
		
		Mockito.when(employeeRepository.save(employee)).
		thenReturn(employee);
		assertThat(employeeService.save(employee)).
		isEqualTo(employee);
		
		
	}

	@Test
	void testDelete() {
		Employee employee = new Employee();

		employee.setEmployeeNumber(3);
		employee.setFirstName("Karishma");
		employee.setLastName("Kushwah");
		employee.setExtension("Part Time");
		employee.setJobTitle("Developer");
		employee.setEmail("krish@gmail.com");
		
		Mockito.when(employeeRepository.save(employee)).
		thenReturn(employee);
		employeeService.delete(1L);
		assertThat(employeeService.findById(1L)).
		isEmpty();
	}

	@Test
	void testFindAll() {
		Employee employee = new Employee();

		employee.setEmployeeNumber(4);
		employee.setFirstName("Kamal");
		employee.setLastName("Soni");
		employee.setExtension("Part Time");
		employee.setJobTitle("Developer");
		employee.setEmail("kamal@gmail.com");
		
		Mockito.when(employeeRepository.save(employee)).
		thenReturn(employee);
		assertThat(employeeService.findAll()).
		isNotNull();
	}
}

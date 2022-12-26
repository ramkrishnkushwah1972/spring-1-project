package com.shopping.cart.app.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shopping.cart.app.model.Customer;
import com.shopping.cart.app.model.Employee;
import com.shopping.cart.app.model.Office;
import com.shopping.cart.app.model.Order;
import com.shopping.cart.app.model.OrderDetail;
import com.shopping.cart.app.model.Payment;
import com.shopping.cart.app.model.Product;
import com.shopping.cart.app.model.ProductLine;
import com.shopping.cart.app.repository.CustomerRepository;
import com.shopping.cart.app.repository.OfficeRepository;
import com.shopping.cart.app.repository.OrderDetailRepository;
import com.shopping.cart.app.repository.PaymentRepository;
import com.shopping.cart.app.repository.ProductLineRepository;


@Controller
public class AdminController {

//	@Autowired
//	private ProductRepository productRepository;
	
	@Autowired
	private ProductLineRepository productLineRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
//	@Autowired
//	private OrderRepository orderRepository;
	
//	@Autowired
//	private EmployeeRepository employeeRepository;
	
	@Autowired
	private OfficeRepository officeRepository;
	
	@Autowired
	private OrderDetailRepository orderDetailRepository;
	
	
		public void run() {
			
			//Creating productline objects
			ProductLine pl1 = new ProductLine("This Bucket","Html decription","img.jpeg",null);
			ProductLine pl2 = new ProductLine("This is 2nd productline","Html desc","image2",null);
			ProductLine pl3 = new ProductLine("3rd productline","html desc","image3.jpg",null);
		
			//Creating product objects
			Product p1 = new Product("Bucket", pl1,"product scale","product vendor","This is bucket",5,110,133.5);
			Product p2 = new Product("Mobile",pl1,"mobile scale","mobile vendor","This is mobile",2,3300,44.5);
			Product p3 = new Product("Bottle",pl1,"bottle scale","bottle vendor","This is bottle",10,45,50);
			
			List<Product> producList1 = new ArrayList<>();
			producList1.add(p1);
			producList1.add(p2);
			producList1.add(p3);
			
			//Set product list in productline
			pl1.setProducts(producList1);

			//Save objects in database
			productLineRepository.save(pl1);
			productLineRepository.save(pl2);
			productLineRepository.save(pl3);
			
			//Creating orderdetails objects
			OrderDetail orderDetail1 = new OrderDetail(2, 125, 1,p1, null);
			OrderDetail orderDetail2 = new OrderDetail(2, 125, 1,p2, null);
			OrderDetail orderDetail3 = new OrderDetail(2, 125, 1,p3, null);
			
			//Saving orderDetails objects in db
			orderDetailRepository.save(orderDetail1);
			orderDetailRepository.save(orderDetail2);
			orderDetailRepository.save(orderDetail3);
			
			//Creating office objects
			Office office1 = new Office("Bengaluru", "9659372627", "White field 1", "White field bengaluru",
					"Karnataka" , "India", "560001","territory", null);
			
			Office office2 = new Office("Indore", "8593932098", "Vijay nagar", "Vijay nagar square",
					"Madhya Pradesh" , "India", "451010","territory", null);


			//Creating employee objects
			Employee employee1 = new Employee("Kushwah","Ramkrishna","extention","ram123@gmail.com",office1,"Manager",
					"Software engineer",null,null);
			
			Employee employee2 = new Employee("Kumar","Yes","extention","yes11@gmail.com",office1,"CEO",
					"Developer",null,null);
			
			Employee employee3 = new Employee("Kushwah","Ramkrishna","extention","ram123@gmail.com",office1,"Manager",
					"Software engineer",null,null);
			
			Employee employee4 = new Employee("Kumar","Yes","extention","yes11@gmail.com",office1,"CEO",
					"Developer",null,null);

			//Creating list of employees
			List<Employee> employeeList1 = new ArrayList<>();
			employeeList1.add(employee1);
			employeeList1.add(employee2);
			
			List<Employee> employeeList2 = new ArrayList<>();
			employeeList2.add(employee3);
			employeeList2.add(employee4);
			
			office1.setEmployees(employeeList1);
			office2.setEmployees(employeeList2);
			//Saving offices in the database
			officeRepository.save(office1);
			officeRepository.save(office2);

			
			//Creating customer objects
			Customer customer1 = new Customer();
			
			customer1.setCustomerName("Rakesh Patil");
			customer1.setContactLastName("Patil");
			customer1.setContactFirstName("Rakesh");
			customer1.setPhone("9682982238");
			customer1.setAddressLine1("Indore road");
			customer1.setAddressLine2("ktg");
			customer1.setCity("Khategaon");
			customer1.setState("Dewas");
			customer1.setPostalCode("455336");
			customer1.setCountry("India");
			customer1.setSalesRepEmployeeNumber(employee1);//employee number
			customer1.setCreditLimit(7000);
			customer1.setOrders(null);//order list
			
			Customer customer2 = new Customer("Amit Yadav","Yadav","Amit","9589822389",
					"JP colony","Jp colony ktg","Bhopal","Bhopal","342822","India",employee1,5000,null);
			
			//Creating list of customers
			List<Customer> customersList1= new ArrayList<>();
			customersList1.add(customer1);
			customersList1.add(customer2);			

			//Set customerlist to employee
			employee1.setCustomers(customersList1);
			
			//Saveing employees in database
//			employeeRepository.save(employee1);

			//Creating order objects
			LocalDate orderDate1 = LocalDate.of(2022,12,15);
			LocalDate requiredDate1 = LocalDate.of(2022,12,18);
			LocalDate shippedDate1 = LocalDate.of(2022,12,15);
			
			Order order1 = new Order(orderDate1, requiredDate1, shippedDate1, 1, "This is first order", customer2, orderDetail1);
			Order order2 = new Order(orderDate1,requiredDate1,shippedDate1,0,"This is second product",customer2,orderDetail2);
			Order order3 = new Order(orderDate1,requiredDate1,shippedDate1,1,"Third order",customer1,null);		
	
			//Creating list of order objects
			List<Order> orderList1 = new ArrayList<>();
			orderList1.add(order1);
			orderList1.add(order2);
//			
			List<Order> orderList2 = new ArrayList<>();
			orderList1.add(order3);
			
			//Set order list to customers
			customer2.setOrders(orderList1);
			customer1.setOrders(orderList2);
			
			//Saving customers in database
			customerRepository.save(customer1);
			customerRepository.save(customer2);
			
			//Creating local date objects
			LocalDate date1 = LocalDate.of(2022,12,13);
			LocalDate date2 = LocalDate.of(2022,12,14);
			
			//Creating payment objects
			Payment payment1 = new Payment(date1,250.1,customer1);
			Payment payment2 = new Payment(date2,2500.50,customer2);
			
			//Saving payment objects in db
			paymentRepository.save(payment1);
			paymentRepository.save(payment2);
			
		
	
		}
}

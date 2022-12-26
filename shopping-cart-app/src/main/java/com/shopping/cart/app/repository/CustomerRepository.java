package com.shopping.cart.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopping.cart.app.model.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	@Query("select c from Customer c where c.contactFirstName = ?1 and c.contactLastName = ?2")
	List<Customer> findByContactFirstNameAndContactLastName(String firstName, String lastName);
	
	@Query("select c from Customer c where c.city = ?1 and c.state = ?2")
	List<Customer> findByCityAndState(String city, String state);
	
	@Query("select c from Customer c where c.phone= ?1")
	List<Customer> findByPhoneNumber(String phone);
	
	@Query("from Customer order by buyPrice desc")
	List<Customer> findAllCustomerOrderByCreditLimit();
	
	@Query("select c from Customer c where c.creditLimit < ?1")
	List<Customer> findByCreditLimitLessThan(double creditLimit);
	
	@Query("select c from Customer c where c.creditLimit > ?1")
	List<Customer> findByCreditLimitGreaterThan(double creditLimit);                  
	
	@Query("SELECT c FROM Customer c WHERE c.customerName LIKE ?1")
	List<Customer> findByCustomerNameStartingWith(String name);
	
	@Query("SELECT c FROM Customer c WHERE c.customerName LIKE CONCAT('%',:cName,'%')")
	List<Customer> findByCustomerNameContains(@Param("cName") String likePattern);
	

}

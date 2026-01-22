package com.yedam.app;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);
    
    List<Customer> findByfirstNameLike(String name);
    
    @Query("SELECT c from Customer c where c.addr IS NULL")//, naitivQuery = true)
    List<Customer> findByAddrNameLike(String name);
    
    Customer findById(long id);
}
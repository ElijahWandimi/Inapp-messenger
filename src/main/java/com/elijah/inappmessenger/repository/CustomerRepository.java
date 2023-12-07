package com.elijah.inappmessenger.repository;

import com.elijah.inappmessenger.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String customerName);
}

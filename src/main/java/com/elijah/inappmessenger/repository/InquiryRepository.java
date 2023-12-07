package com.elijah.inappmessenger.repository;

import com.elijah.inappmessenger.model.Agent;
import com.elijah.inappmessenger.model.Customer;
import com.elijah.inappmessenger.model.Inquiry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    Page<Inquiry> findByReplyAgent(Agent agent, Pageable pageable);

    List<Inquiry> findByInquiryCustomer(Customer customer);
}

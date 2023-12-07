package com.elijah.inappmessenger.service;

import com.elijah.inappmessenger.model.Customer;
import com.elijah.inappmessenger.model.Inquiry;
import com.elijah.inappmessenger.repository.CustomerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final InquiryService inquiryService;

    public CustomerService(CustomerRepository customerRepository, InquiryService inquiryService) {
        this.customerRepository = customerRepository;
        this.inquiryService = inquiryService;
    }

    public Optional<Customer> addCustomer(Customer customer) {
        return Optional.of(customerRepository.save(customer));
    }
    public List<Inquiry> getAllInquiries(String customerName) {
        Customer customer = customerRepository.findByName(customerName);
        PageRequest pageRequest = PageRequest.of(1, 10);
        return inquiryService.getInquiriesByCustomer(customer, pageRequest);
    }

    public Inquiry addInquiries(Inquiry inquiry, String customerName) {
        Optional<Customer> customer = Optional.ofNullable(customerRepository.findByName(customerName));
        return inquiryService.addInquires(inquiry, customer.get());
    }

    public Optional<Customer> getCustomerById(long customerId) {
        return customerRepository.findById(customerId);
    }

}

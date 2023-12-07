package com.elijah.inappmessenger.web.rest;

import com.elijah.inappmessenger.model.Customer;
import com.elijah.inappmessenger.model.Inquiry;
import com.elijah.inappmessenger.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/customer/")
public class CustomerResource {
    private final CustomerService customerService;
    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    ResponseEntity<Customer> loginCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok().body(customerService.addCustomer(customer).get());
    }

    @PostMapping(path = "inquiries")
    ResponseEntity<Inquiry> postInquiry(@RequestBody Inquiry inquiry,
                                        @RequestParam(name = "customerName")String customerName ) {
        return ResponseEntity.ok().body(customerService.addInquiries(inquiry, customerName));
    }

    @GetMapping(path = "inquiries")
    ResponseEntity<Inquiry> getAllInquiries(@RequestParam(name = "customerName") String customerName) {
        // TODO: Convert return objects to ResponseEntity stream of inquiries
        return ResponseEntity.ok().body((Inquiry) customerService.getAllInquiries(customerName));
    }
}

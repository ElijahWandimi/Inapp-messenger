package com.elijah.inappmessenger.service;

import com.elijah.inappmessenger.model.Agent;
import com.elijah.inappmessenger.model.Customer;
import com.elijah.inappmessenger.model.Inquiry;
import com.elijah.inappmessenger.model.enums.ReplyStatus;
import com.elijah.inappmessenger.repository.InquiryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class InquiryService {
    private  final InquiryRepository inquiryRepository;

    public InquiryService(InquiryRepository inquiryRepository) {
        this.inquiryRepository = inquiryRepository;
    }

    public Page<Inquiry> getInquiriesByAgent(Agent agent, Pageable pageable) {
        return inquiryRepository.findByReplyAgent(agent, pageable);
    }

    public Optional<Inquiry> getInquiryById(long id) {
        return inquiryRepository.findById(id);
    }

    public Inquiry replyInquiry(long id, String responseBody) {
        Inquiry inquiry = inquiryRepository.findById(id).get();
        inquiry.setInquiryReply(responseBody);
        inquiry.setReplyStatus(ReplyStatus.REPLIED);
        return inquiryRepository.save(inquiry);
    }

    public Inquiry addInquires(Inquiry inquiry, Customer customer) {
        inquiry.setInquiryCustomer(customer);
        inquiry.setDateOfInquiry(LocalDate.now());
        return inquiryRepository.save(inquiry);
    }

    public List<Inquiry> getInquiriesByCustomer(Customer customer, PageRequest pageRequest) {
        return inquiryRepository.findByInquiryCustomer(customer);
    }

    public Page<Inquiry> getInquiries(Pageable pageable) {
        return inquiryRepository.findAll(pageable);
    }
}

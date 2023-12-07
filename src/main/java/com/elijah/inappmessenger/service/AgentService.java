package com.elijah.inappmessenger.service;

import com.elijah.inappmessenger.model.Agent;
import com.elijah.inappmessenger.model.Inquiry;
import com.elijah.inappmessenger.repository.AgentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AgentService {
    private final AgentRepository agentRepository;
    private final InquiryService inquiryService;

    public AgentService(AgentRepository agentRepository, InquiryService inquiryService) {
        this.agentRepository = agentRepository;
        this.inquiryService = inquiryService;
    }

    public Page<Inquiry> getInquiries(Pageable pageable) {
        return inquiryService.getInquiries(pageable);
    }

    public Inquiry respondToInquiry(long id, String responseBody) {
        return inquiryService.replyInquiry(id, responseBody);
    }

    public Agent loginAgent(Agent agent) {
        return agentRepository.save(agent);
    }
}

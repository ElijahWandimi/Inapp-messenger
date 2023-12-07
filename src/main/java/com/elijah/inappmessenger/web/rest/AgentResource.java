package com.elijah.inappmessenger.web.rest;

import com.elijah.inappmessenger.model.Agent;
import com.elijah.inappmessenger.model.Inquiry;
import com.elijah.inappmessenger.service.AgentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/api/agent/")
public class AgentResource {
    private final AgentService agentService;

    public AgentResource(AgentService agentService) {
        this.agentService = agentService;
    }

    @PostMapping
    ResponseEntity<Agent> loginAgent(@RequestBody Agent agent) {
        return ResponseEntity.ok().body(agentService.loginAgent(agent));
    }

    @PostMapping(path = "inquiries/{id}")
    ResponseEntity<Inquiry> answerInquiry(@RequestBody String responseBody,
                                          @PathVariable long id) {
        return ResponseEntity.ok().body(agentService.respondToInquiry(id, responseBody));
    }

    @GetMapping(path = "inquiries")
    ResponseEntity<List<Inquiry>> getAllMessages(@RequestParam(name = "agentName") String agentName,
                                                 Pageable pageable) {
        Page<Inquiry> inquiryPage = agentService.getInquiries(pageable);
        return ResponseEntity.ok().body(inquiryPage.getContent());
    }
}

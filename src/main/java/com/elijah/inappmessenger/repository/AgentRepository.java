package com.elijah.inappmessenger.repository;

import com.elijah.inappmessenger.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Long> {

    Agent getByName(String agentName);
}

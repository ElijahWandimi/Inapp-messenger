package com.elijah.inappmessenger.model;

import com.elijah.inappmessenger.model.enums.ReplyStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "tbl_messages")
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String inquiryBody;

    private String inquiryReply;

    private LocalDate dateOfInquiry;

    @Enumerated(EnumType.STRING)
    private ReplyStatus replyStatus;

    @ManyToOne
    @JoinColumn(name = "reply_agent_id")
    private Agent replyAgent;

    @ManyToOne
    @JoinColumn(name = "inquiry_customer_id")
    private Customer inquiryCustomer;
}

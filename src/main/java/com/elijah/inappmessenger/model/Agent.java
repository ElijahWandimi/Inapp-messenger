package com.elijah.inappmessenger.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "tbl_agent")
public class Agent {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private long id;

    private String name;
}

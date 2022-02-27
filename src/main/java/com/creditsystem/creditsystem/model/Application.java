package com.creditsystem.creditsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Application")
@Table(name="tbl_application")
public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Tckn can not be empty or null")
    private String tckn;

    @Column(name="result")
    private String creditResult;

    @Column(name="credit_limit")
    private Integer creditLimit;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private Date createdAt;

}

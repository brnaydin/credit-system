package com.creditsystem.creditsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "Customer")
@Table(name="tbl_customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tckn", insertable = false, updatable = false)
    private String tckn;

    @NotEmpty(message = "full name can not be null ")
    private String fullname;

    @Column(name = "monthly_income")
    private Integer monthlyIncome;

    @Column(name = "phone_number")
    private String phoneNumber;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tckn", referencedColumnName = "tckn")
    private Application application;

}

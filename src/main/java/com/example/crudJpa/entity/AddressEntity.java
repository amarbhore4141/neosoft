package com.example.crudJpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;
    private String addressline1;
    private String city;
    private String state;
    private long pincode;
    @ManyToOne
    @JoinColumn ( name = "empId")
    @JsonIgnore
    private EmployeeEntity employee;
}

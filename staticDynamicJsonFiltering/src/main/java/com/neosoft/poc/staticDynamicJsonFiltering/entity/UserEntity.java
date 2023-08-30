package com.neosoft.poc.staticDynamicJsonFiltering.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
// here we can give multiple properties to inore
@JsonIgnoreProperties({"email","Residential_city"})
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("user_id")
    private int id;
    @JsonProperty("user_first_name")
    private String name;
    @JsonProperty("Login_user_name")
    private String userName;
    //this won't serialize Json
    @JsonIgnore
    private String password;
    private String email;
    @JsonProperty("Residential_city")
    private String city;
}

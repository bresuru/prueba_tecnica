package com.consult.customer.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//@Entity(name = "Customer")
public class CustomerEntity implements Serializable {

//    @Id
    private String identificationNumber;

    private String documentType;

    private String firstName;

    private String secondName;

    private String firstSurname;

    private String secondSurname;

    private String phoneNumber;

    private String address;

//    @ManyToOne
    @JsonManagedReference
//    @JoinColumn(name = "city", nullable = false)
    private CityEntity city;

}

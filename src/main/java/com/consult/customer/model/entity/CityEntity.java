package com.consult.customer.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
//@Entity(name = "City")
public class CityEntity implements Serializable {

//    @Id
    private UUID id;

    private String name;

//    @JoinColumn(name = "customers")
    @JsonBackReference
//    @OneToMany
    private List<CustomerEntity> customerEntityList;

}

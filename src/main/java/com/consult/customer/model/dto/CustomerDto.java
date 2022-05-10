package com.consult.customer.model.dto;

import com.consult.customer.model.entity.CityEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    @NotNull(message = "La cedula no puede estar vacio")
    @NotBlank(message = "El cedula nombre no puede estar vacio")
    private String identificationNumber;

    @NotNull(message = "La cedula no puede estar vacio")
    @NotBlank(message = "El cedula nombre no puede estar vacio")
    private String documentType;



}

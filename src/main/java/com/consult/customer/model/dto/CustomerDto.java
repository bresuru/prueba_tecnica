package com.consult.customer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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

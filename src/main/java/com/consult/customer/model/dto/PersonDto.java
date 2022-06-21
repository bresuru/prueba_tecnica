package com.consult.customer.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDto {

    private String id;

    @NotNull(message = "El numero de identificacion no puede estar null")
    @NotBlank(message = "El numero de identificacion no puede estar vacio")
    private String identificationNumber;

    @NotNull(message = "El nomre no puede estar null")
    @NotBlank(message = "El nomre no puede estar vacio")
    private String firstName;

    private String lastName;

    @NotNull(message = "El correo no puede estar null")
    @NotBlank(message = "El correo no puede estar vacio")
    private String address;

}

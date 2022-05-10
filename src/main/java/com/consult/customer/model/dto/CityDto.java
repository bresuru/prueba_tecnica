package com.consult.customer.model.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CityDto implements Serializable {

    private UUID id;

    @NotNull(message = "El nombre de la ciudad no puede estar vacio")
    @NotBlank(message = "El nombre de la ciudad no puede estar vacio")
    private String name;

    @JsonManagedReference
    private List<CustomerDto> customerDtoList;

}

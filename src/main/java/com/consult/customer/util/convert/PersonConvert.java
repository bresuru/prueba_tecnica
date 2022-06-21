package com.consult.customer.util.convert;

import com.consult.customer.model.dto.CustomerDto;
import com.consult.customer.model.dto.PersonDto;
import com.consult.customer.model.entity.CustomerEntity;
import com.consult.customer.model.entity.PersonEntity;
import com.consult.customer.util.DataTemp;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Clase utilizada para convertir de entidad a dto y dto a entidad
 */
@Component
@Qualifier("Person")
public class PersonConvert {

    public static PersonEntity dtoToEntity(PersonDto req) {
        return PersonEntity.builder().id(req.getId()).firstName(req.getFirstName()).address(req.getAddress()).lastName(req.getLastName())
                .identificationNumber(req.getIdentificationNumber()).build();
    }

    public static PersonDto entityToDto(PersonEntity req) {
        return PersonDto.builder().id(req.getId()).firstName(req.getFirstName()).address(req.getAddress()).lastName(req.getLastName())
                .identificationNumber(req.getIdentificationNumber()).build();
    }

}

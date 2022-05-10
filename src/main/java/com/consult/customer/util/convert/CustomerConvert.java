package com.consult.customer.util.convert;

import com.consult.customer.model.dto.CustomerDto;
import com.consult.customer.model.entity.CustomerEntity;
import com.consult.customer.util.DataTemp;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Clase utilizada para convertir de entidad a dto y dto a entidad
 */
@Component
@Qualifier("Customer")
public class CustomerConvert {

    public static CustomerEntity dtoToEntity(CustomerDto customerDto) {
        return CustomerEntity.builder().identificationNumber(customerDto.getIdentificationNumber()).firstName("BRESURU")
                .secondName("").firstSurname("SURUS").secondSurname("CARD").documentType(customerDto.getDocumentType())
                .phoneNumber("3125803221").address("TEMPORAL").city(DataTemp.getCityEntities().get(1)).build();
    }

    public static CustomerDto entityToDto(CustomerEntity customerEntity) {
        return CustomerDto.builder().identificationNumber(customerEntity.getIdentificationNumber()).documentType(customerEntity.getDocumentType()).build();
    }

}

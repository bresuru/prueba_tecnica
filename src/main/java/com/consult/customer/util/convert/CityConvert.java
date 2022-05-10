package com.consult.customer.util.convert;

import com.consult.customer.model.dto.CityDto;
import com.consult.customer.model.entity.CityEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Clase utilizada para convertir de entidad a dto y dto a entidad
 */
@Component
@Qualifier("City")
public class CityConvert {

    public static CityEntity dtoToEntity(CityDto cityDto){
        return CityEntity.builder().id(cityDto.getId()).name(cityDto.getName()).build();
    }

    public static CityDto entityToDto(CityEntity cityEntity){
        return CityDto.builder().id(cityEntity.getId()).name(cityEntity.getName()).build();
    }

}

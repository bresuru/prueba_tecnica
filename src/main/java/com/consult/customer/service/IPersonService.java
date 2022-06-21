package com.consult.customer.service;

import com.consult.customer.model.entity.PersonEntity;
import com.consult.customer.util.JsonResponse;
import org.springframework.stereotype.Service;

@Service
public interface IPersonService {

    /**
     * Guardar los datos de una persona
     * @param personEntity
     * @return
     */
    JsonResponse save(PersonEntity personEntity);

    /**
     * Consultar datos
     * @return
     */
    JsonResponse getAll();

    JsonResponse deleteAll();

}

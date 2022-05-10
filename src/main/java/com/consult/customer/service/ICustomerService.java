package com.consult.customer.service;

import com.consult.customer.model.entity.CustomerEntity;
import com.consult.customer.repository.CustomerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomerService {

    /**
     * Consulta un cliente por su numero de identifiacion
     * @param identificationNumber Numero de identificacion
     * @return  Informacion del cliente encontrado
     */
    CustomerEntity findOneByIdentificationCustomer(String identificationNumber);

    /**
     * Consulta todos los clientes
     * @return
     */
    List<CustomerEntity> findAll();

    /**
     * Elimina un cliente por el numero de identificaicon (Temporal)
     * @param identificationNumber Numero de cedula
     * @return si se elimino algun cliente
     */
    boolean deleteByIdentificationNumber(String identificationNumber);

    /**
     * Guarda los datos de un cliente
     * @param customerEntity
     * @return
     */
    CustomerEntity save(CustomerEntity customerEntity);

}

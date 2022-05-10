package com.consult.customer.repository;

import com.consult.customer.model.entity.CustomerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Repositorio , normalmente se usa con la etiqueta @repositori pero como no va haber conexion a base de datos entonces todo esta quemado y simulo algo parecido
 */
@Repository
public interface ICustomerRepo
//        extends JpaRepository<CustomerEntity, UUID>
{

    /**
     * Consulta a un cliente por su numero de identificacion
     *
     * @param identificationNumber
     *
     * @return CustomerEntity
     */
    CustomerEntity findOneByIdentificationNumber(String identificationNumber);

    /**
     * Consulta todos los clientes
     * @return
     */
    List<CustomerEntity> findAll();

    /**
     * Elimina un cliente
     * @param customerEntity
     */
    boolean delete(CustomerEntity customerEntity);

    /**
     * Elimina un cliente
     * @param id
     */
    boolean delete(String identificationNumber);

    /**
     * Guarda la informacion de un cliente
     * @param customerEntity
     * @return
     */
    CustomerEntity save(CustomerEntity customerEntity);

}

package com.consult.customer.repository;

import com.consult.customer.model.entity.CustomerEntity;
import com.consult.customer.util.DataTemp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepo implements ICustomerRepo {
    private static Logger logger = LoggerFactory.getLogger(CustomerRepo.class);

    @Override
    public CustomerEntity findOneByIdentificationNumber(String identificationNumber) {
        logger.debug("findOneByIdentificationNumber identificationNumber=[{}]", identificationNumber);
        List<CustomerEntity> customerEntities = DataTemp.getCustomerEntities();
        for (CustomerEntity customerEntity:
             customerEntities) {
            if (customerEntity.getIdentificationNumber().equals(identificationNumber)) {
                logger.info("====== CLIENTE ENCONTRADO ==============");
                logger.debug("findOneByIdentificationNumber customerEntity=[{}]", customerEntity);
                return customerEntity;
            }
        }

        logger.info("====== ERROR NO EXISTE CLIENTE CON ESE NUMERO DE IDENTIFICACION ==============");
        return null;
    }

    @Override
    public List<CustomerEntity> findAll() {
        logger.debug("findAll");
        return DataTemp.getCustomerEntities();
    }

    @Override
    public boolean delete(CustomerEntity customerEntity) {
        if (customerEntity != null) {
            DataTemp.deleteCustomer(customerEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String identificationNumber) {
        CustomerEntity customerEntity = findOneByIdentificationNumber(identificationNumber);
        return delete(customerEntity);
    }

    @Override
    public CustomerEntity save(CustomerEntity customerEntity) {
        logger.debug("save customerEntity=[{}]", customerEntity);
        return DataTemp.addCustomer(customerEntity);
    }
}

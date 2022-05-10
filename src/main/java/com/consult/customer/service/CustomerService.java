package com.consult.customer.service;

import com.consult.customer.model.entity.CustomerEntity;
import com.consult.customer.repository.CustomerRepo;
import com.consult.customer.repository.ICustomerRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    private static Logger logger = LoggerFactory.getLogger(CustomerService.class);

    private ICustomerRepo customerRepo;

    @Autowired
    CustomerService(CustomerRepo customerRepo){
        this.customerRepo = customerRepo;
    }

    @Override
    public CustomerEntity findOneByIdentificationCustomer(String identificationNumber)
    {
        logger.debug("findOneByIdentificationCustomer identificationNumber=[{}]", identificationNumber);
        return customerRepo.findOneByIdentificationNumber(identificationNumber);
    }

    @Override
    public List<CustomerEntity> findAll() {
        logger.debug("findAll");
        return customerRepo.findAll();
    }

    @Override
    public boolean deleteByIdentificationNumber(String identificationNumber) {
        logger.debug("deleteByIdentificationNumber identificationNumber=[{]]", identificationNumber);
        return customerRepo.delete(identificationNumber);
    }

    @Override
    public CustomerEntity save(CustomerEntity customerEntity) {
        logger.debug("save customerEntity=[{}]", customerEntity);
        return customerRepo.save(customerEntity);
    }

}

package com.consult.customer;

import com.consult.customer.model.entity.PersonEntity;
import com.consult.customer.repository.IPersonRepo;
import com.consult.customer.service.IPersonService;
import com.consult.customer.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * Pruebas sobre todo lo relacionado con person
 */
@SpringBootTest
public class PersonApplicationTests {

    @Autowired
    private IPersonService personService;

    @Autowired
    private IPersonRepo personRepo;

    @Test
    public void testPerson(){
        System.out.println(personService.getAll());
    }

    @Test
    public void testInsertPerson(){
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId(UUID.randomUUID().toString());
        personEntity.setFirstName("Breiner");
        personEntity.setLastName("Sebastian");
        personEntity.setAddress("breinersebastian2@gmail.com");
        personEntity.setIdentificationNumber("1192802098");

        personService.save(personEntity);

        System.out.println(personService.getAll());

        personRepo.delete(personEntity);
    }

}

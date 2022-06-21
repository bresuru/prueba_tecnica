package com.consult.customer.repository;

import com.consult.customer.model.entity.PersonEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IPersonRepo extends MongoRepository<PersonEntity, String> {

    PersonEntity save(PersonEntity personEntity);

}

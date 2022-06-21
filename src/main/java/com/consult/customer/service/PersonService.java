package com.consult.customer.service;

import com.consult.customer.model.entity.PersonEntity;
import com.consult.customer.repository.IPersonRepo;
import com.consult.customer.util.JsonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class PersonService implements IPersonService {

    @Autowired
    private IPersonRepo iPersonRepo;

    @Override
    public JsonResponse save(PersonEntity personEntity) {
        personEntity.setId(UUID.randomUUID().toString());
        JsonResponse jsonResponse = new JsonResponse(HttpStatus.OK, "Guardado con exito", iPersonRepo.save(personEntity));
        return jsonResponse;
    }

    @Override
    public JsonResponse getAll() {
        JsonResponse<PersonEntity> jsonResponse = new JsonResponse();
        jsonResponse.setStatus(HttpStatus.OK);
        jsonResponse.setMessage("Personas");
        jsonResponse.setData(iPersonRepo.findAll());
        return jsonResponse;
    }

    @Override
    public JsonResponse deleteAll() {
        JsonResponse<PersonEntity> jsonResponse = new JsonResponse();
        jsonResponse.setStatus(HttpStatus.OK);
        jsonResponse.setMessage("Personas");
        iPersonRepo.deleteAll();
        jsonResponse.setData(iPersonRepo.findAll());
        return jsonResponse;
    }

}

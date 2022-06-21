package com.consult.customer.controller;

import com.consult.customer.model.dto.PersonDto;
import com.consult.customer.service.IPersonService;
import com.consult.customer.util.JsonResponse;
import com.consult.customer.util.convert.PersonConvert;
import com.consult.customer.valid.PersonValid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/person")
public class PersonController {
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private IPersonService personService;

    @Autowired
    private PersonValid personValid;

    @GetMapping
    public @ResponseBody ResponseEntity<JsonResponse> getFormatRequest(){

        JsonResponse<PersonDto> jsonResponse =
                new JsonResponse(
                        HttpStatus.OK,
                        "Formato Persona",
                        PersonDto.builder().id("").identificationNumber("string").firstName("string").lastName("string").address("string").build()
                );

        return new ResponseEntity(jsonResponse, HttpStatus.OK);
    }

    @PostMapping("/save")
    public @ResponseBody
    ResponseEntity<JsonResponse> savePerson(@RequestBody PersonDto personDto){
        JsonResponse jsonResponse = personValid.isValidPersonAll(personDto);

        if (jsonResponse.getStatus().isError())
            return new ResponseEntity(jsonResponse, HttpStatus.BAD_REQUEST);

        jsonResponse = personService.save(PersonConvert.dtoToEntity(personDto));

        return new ResponseEntity(jsonResponse, HttpStatus.OK);
    }

    @GetMapping("/list")
    public @ResponseBody
    ResponseEntity<JsonResponse> getAll(){
        JsonResponse jsonResponse = personService.getAll();
        return new ResponseEntity(jsonResponse, HttpStatus.OK);
    }

    @GetMapping("/deleteAll")
    public @ResponseBody
    ResponseEntity<JsonResponse> getDeleteAll(){
        JsonResponse jsonResponse = personService.getAll();
        return new ResponseEntity(jsonResponse, HttpStatus.OK);
    }

}

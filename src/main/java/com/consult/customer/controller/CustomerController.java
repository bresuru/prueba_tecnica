package com.consult.customer.controller;

import com.consult.customer.model.dto.CustomerDto;
import com.consult.customer.model.entity.CustomerEntity;
import com.consult.customer.service.ICustomerService;
import com.consult.customer.util.DocumentTypeEnum;
import com.consult.customer.util.JsonResponse;
import com.consult.customer.util.convert.CustomerConvert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private static Logger logger = LoggerFactory.getLogger(CustomerController.class);

    private ICustomerService customerService;

    @Autowired
    CustomerController(ICustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/findByIdentificationNumber/{identificationNumber}")
    public @ResponseBody ResponseEntity<Object> getCustomerByIdentificationNumber(@PathVariable("identificationNumber")
                                                                                      @Valid String identificationNumber) throws Exception {
        logger.debug("getCustomerByIdentificationNumber identificationNumber=[{}]", identificationNumber);
        CustomerEntity customerEntity = customerService.findOneByIdentificationCustomer(identificationNumber);
        if (customerEntity != null) {
            CustomerDto customerDto = CustomerConvert.entityToDto(customerEntity);
            logger.debug("getCustomerByIdentificationNumber customerDto=[{}]", customerDto);
            return new ResponseEntity<>(customerDto, HttpStatus.OK);
        }
        return new ResponseEntity<>("No se encontro ningun cliente con la cedula: " + identificationNumber, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public @ResponseBody ResponseEntity<JsonResponse<Object>> getAllCustomer() throws Exception {
        logger.debug("getAllCustomer");
        JsonResponse<Object> jsonResponse = new JsonResponse<Object>(HttpStatus.OK,"Lista de clientes", customerService.findAll());
        return new ResponseEntity<>(jsonResponse
                , HttpStatus.OK);
    }

    @PostMapping("/save")
    public @ResponseBody ResponseEntity<JsonResponse<Object>> saveCustomer(@RequestBody CustomerDto customerDto) throws Exception {
        logger.debug("saveCustomer customerDto=[{}]", customerDto);
        if (DocumentTypeEnum.findByValue(customerDto.getDocumentType()) == null){
            return new ResponseEntity<>(new JsonResponse<>(HttpStatus.BAD_REQUEST, "EL TIPO DE DOCUMENTO NO EXISTE, FORMATO DEL JSON:", new CustomerDto()),
                    HttpStatus.BAD_REQUEST);
        }

        CustomerEntity customerSaved = customerService.save(CustomerConvert.dtoToEntity(customerDto));
        try {
            if (customerSaved != null)
                return new ResponseEntity<>(new JsonResponse<>(HttpStatus.OK, "Cliente guardado correctamente"
                        , customerSaved), HttpStatus.OK);
        } catch (Exception exception) {
            logger.error("error=[{}]", exception);
        }
        return new ResponseEntity<>(new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR, "", null),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{identificationNumber}")
    public @ResponseBody ResponseEntity<JsonResponse<Object>> delete(@Valid @PathVariable("identificationNumber") String identificationNumber){
        logger.debug("delete identificationNumber=[{}]", identificationNumber);
        if (identificationNumber == null || identificationNumber.isEmpty()) {
            return new ResponseEntity<>(new JsonResponse<>(HttpStatus.BAD_REQUEST, "El numero de documento no puede estar vacio: " + identificationNumber, null)
                    , HttpStatus.OK);
        }

        boolean delete = customerService.deleteByIdentificationNumber(identificationNumber);
        if (delete)
            return new ResponseEntity<>(new JsonResponse<>(HttpStatus.OK, "Se elimino correctemente el cliente: " + identificationNumber, null)
                    , HttpStatus.OK);

        return new ResponseEntity<>(new JsonResponse<>(HttpStatus.OK, "No se encontro el usuario " + identificationNumber, null)
                , HttpStatus.OK);
    }

}

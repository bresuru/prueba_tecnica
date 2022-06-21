package com.consult.customer.valid;

import com.consult.customer.model.dto.PersonDto;
import com.consult.customer.util.JsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PersonValid {

    /**
     * Metodo que valida los datos de las personas
     * @param personDto
     * @return
     */
    public JsonResponse isValidPersonAll(PersonDto personDto){
        HashMap<String, String> msm = new HashMap<>();

        if (personDto.getIdentificationNumber() == null || personDto.getIdentificationNumber().isEmpty()) {
            msm.put("identificationNumber", "Numero de identificacion invalido");
        }

        if (personDto.getFirstName() == null || personDto.getFirstName().isEmpty()) {
            msm.put("firstName", "Primer nombre vacio");
        } else if (personDto.getFirstName().matches("(.*)10(.*)")) {
            msm.put("firstName", "Primer nombre invalido");
        }

        if (personDto.getLastName() == null || personDto.getLastName().isEmpty()) {
            msm.put("firstName", "Segundo nombre vacio");
        } else if (personDto.getLastName().matches("(.*)10(.*)")) {
            msm.put("firstName", "Segundo nombre invalido");
        }

        if (personDto.getAddress() == null || personDto.getAddress().isEmpty()) {
            msm.put("identificationNumber", "El correo no puede estar vacio");
        } else if (!personDto.getAddress().contains("@") || !personDto.getAddress().contains(".")) {
            msm.put("identificationNumber", "Correo invalido");
        }

        JsonResponse<HashMap<String, String>> jsonResponse = new JsonResponse();

        if (!msm.isEmpty()) {
            jsonResponse = new JsonResponse<>(HttpStatus.BAD_REQUEST, "ERROR EN VALIDACION", msm);
        } else {
            jsonResponse.setStatus(HttpStatus.OK);
        }

        return jsonResponse;
    }

}

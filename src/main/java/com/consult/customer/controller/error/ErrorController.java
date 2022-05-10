package com.consult.customer.controller.error;

import com.consult.customer.util.DataTemp;
import com.consult.customer.util.JsonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/error")
@RestController
public class ErrorController {

    @RequestMapping("/404")
    public ResponseEntity<JsonResponse<Object>> getError404(){
        return new ResponseEntity<>(new JsonResponse<>(HttpStatus.NOT_FOUND,"ERROR: La pagina no existe.",
                DataTemp.getServices()), HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/405")
    public ResponseEntity<JsonResponse<Object>> getError405(){
        return new ResponseEntity<>(new JsonResponse<>(HttpStatus.METHOD_NOT_ALLOWED,"ERROR: Tipo de mapeo incorrecto, revisar si no es: GET, POST, DELETE, PUT....",
                DataTemp.getServices()), HttpStatus.METHOD_NOT_ALLOWED);
    }

    @RequestMapping("/500")
    public ResponseEntity<JsonResponse<Object>> getError500(){
        return new ResponseEntity<>(new JsonResponse<>(HttpStatus.INTERNAL_SERVER_ERROR,"ERROR CON EL SERVIDOR POR FAVOR CONTACTESE CON EL SOPORTE TECNICO.",
                "ERROR CON EL SERVIDOR POR FAVOR CONTACTESE CON EL SOPORTE TECNICO."), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

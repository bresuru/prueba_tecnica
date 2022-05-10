package com.consult.customer.util;

import com.consult.customer.model.entity.CityEntity;
import com.consult.customer.model.entity.CustomerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Clase utlizada para cargar datos temporales y quemados
 */
public class DataTemp {


    private static List<CustomerEntity> customerEntities;
    private static List<CityEntity> cityEntities;
    private static StringBuilder pathServices;

    public static CustomerEntity addCustomer(CustomerEntity customerEntity){
        getCustomerEntities();

        customerEntities.add(customerEntity);

        return customerEntity;
    }

    public static CustomerEntity deleteCustomer(CustomerEntity customerEntity){
        getCustomerEntities();

        customerEntities.remove(customerEntity);

        return customerEntity;
    }

    /**
     * Obtiene datos de los clientes
     * @return
     */
    public static List<CustomerEntity> getCustomerEntities(){

        if (customerEntities == null) {
            customerEntities = new ArrayList<>();

            CustomerEntity customerEntity = new CustomerEntity();
            customerEntity.setFirstName("Breiner");
            customerEntity.setSecondName("Sebastian");
            customerEntity.setFirstSurname("Suarez");
            customerEntity.setSecondSurname("Rubiano");
            customerEntity.setAddress("Calle 90temp sur $ 22f-1");
            customerEntity.setIdentificationNumber("23445322");
            customerEntity.setDocumentType("C");
            customerEntity.setPhoneNumber("3125803221");
            getCityEntities();
            customerEntity.setCity(cityEntities.get(0));

            customerEntities.add(customerEntity);
        }

        return customerEntities;
    }

    /**
     * Obtiene datos de las ciudades
     * @return
     */
    public static List<CityEntity> getCityEntities(){

        if (cityEntities == null) {
            cityEntities = new ArrayList<>();

            cityEntities.add(new CityEntity(UUID.randomUUID(),"Bogota D.C.", new ArrayList<>()));
            cityEntities.add(new CityEntity(UUID.randomUUID(),"Barranquilla", new ArrayList<>()));
            cityEntities.add(new CityEntity(UUID.randomUUID(),"Cartagena", new ArrayList<>()));
            cityEntities.add(new CityEntity(UUID.randomUUID(),"Cúcuta", new ArrayList<>()));
        }

        return cityEntities;
    }

    /**
     * Devuelve un listado de los servicios disponibles
     * @return
     */
    public static StringBuilder getServices(){

        if (pathServices == null) {
            pathServices = new StringBuilder();

            pathServices.append("servicios disponibles:  ");
            pathServices.append("GET: /customer/findAll |  ");
            pathServices.append("GET: /customer/findByIdentificationNumber/{identificationNumber}    |  ");
            pathServices.append("POST: /customer/save    |  ");
            pathServices.append("DELETE: /customer/delete/{identificationNumber}  ");
        }

        return  pathServices;
    }

}

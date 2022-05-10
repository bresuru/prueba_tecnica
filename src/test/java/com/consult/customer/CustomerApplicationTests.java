package com.consult.customer;

import com.consult.customer.model.entity.CustomerEntity;
import com.consult.customer.service.CustomerService;
import com.consult.customer.util.DataTemp;
import com.microsoft.sqlserver.jdbc.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Clase de pruebas muy basicas
 */
@SpringBootTest
class CustomerApplicationTests {

	private final String IDENTIFICATION_NUMBER_DEFAULT = "23445322";

	@Autowired
	private CustomerService customerService;

	@Test
	void consultCustomerDefault() {
		CustomerEntity customerEntity = customerService.findOneByIdentificationCustomer(IDENTIFICATION_NUMBER_DEFAULT);
		Assertions.assertNotNull(customerEntity);
	}

	@Test
	void validPhoneNumberCustomers() {
		List<CustomerEntity> customerEntities = customerService.findAll();
		customerEntities.forEach(customerEntity ->
		{
			System.out.println("Cliente: " + customerEntity.getFirstName() + ", Telefono: " + customerEntity.getPhoneNumber());
			Assertions.assertTrue(StringUtils.isNumeric(customerEntity.getPhoneNumber()));
		});
	}

	@Test
	void validDeleteCustomer(){
		CustomerEntity customerEntity = customerService.findOneByIdentificationCustomer(IDENTIFICATION_NUMBER_DEFAULT);
		Assertions.assertNotNull(customerEntity);
		Assertions.assertTrue(customerService.deleteByIdentificationNumber(customerEntity.getIdentificationNumber()));
		Assertions.assertNull(customerService.findOneByIdentificationCustomer(IDENTIFICATION_NUMBER_DEFAULT));
		System.out.println("ELIMINADO CORRECTAMENTE");
	}

	@Test
	void validSaveCustomer(){
		String identificationNumber = "1233445322";

		// Carga de datos
		CustomerEntity customerEntity = new CustomerEntity();
		customerEntity.setFirstName("Prueba");
		customerEntity.setSecondName("Hola");
		customerEntity.setFirstSurname("Mundo");
		customerEntity.setSecondSurname("");
		customerEntity.setAddress("Calle 30temp sur $ 25f-1");
		customerEntity.setIdentificationNumber(identificationNumber);
		customerEntity.setPhoneNumber("3125803228");

		DataTemp.getCityEntities();
		customerEntity.setCity(DataTemp.getCityEntities().get(1));

		// Guardado
		CustomerEntity customerSaved = customerService.save(customerEntity);

		Assertions.assertEquals(customerEntity, customerSaved);
		Assertions.assertNotNull(customerService.findOneByIdentificationCustomer("1233445322"));
	}

}

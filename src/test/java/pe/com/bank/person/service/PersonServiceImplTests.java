package pe.com.bank.person.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.AllArgsConstructor;
import pe.com.bank.person.PersonServiceApplication;
import pe.com.bank.person.client.CustomerRestClient;
import pe.com.bank.person.entity.PersonEntity;
import reactor.test.StepVerifier;


@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
public class PersonServiceImplTests {
	
    @Autowired	
	PersonService personService;

	PersonEntity personEntity;
	
	
	@Before
	public  void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void getPersonByIdOkTest() {
		
		personEntity = new PersonEntity();
		personEntity.setId("6275c71fb557542205eb1c2c");
		personEntity.setFirstName("Jose");
		personEntity.setLastName("Martinez");
		personEntity.setDocumentType("DNI");
		personEntity.setDocumentNumber("78805885");
		personEntity.setPhoneNumber("912345678");
		personEntity.setAddress("Av Universitaria 200");
		personEntity.setEmail("jose.martinez@gmail.com");
		personEntity.setCustomerId("6275a7aab557542205eb1c1d");
		
		StepVerifier
		.create(personService.getPersonById("6275c71fb557542205eb1c2c"))
		.expectNext(personEntity)
        .expectComplete()
        .verify();
		
	}	

}

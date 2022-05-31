package pe.com.bank.person.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import pe.com.bank.person.entity.PersonEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PersonControllerTests {
	
	
	@Autowired
	private WebTestClient webTestClient;
	
	PersonEntity personEntity;
	
	@Test
	 void getPersons(){
	      this.webTestClient
	          .get()
	          .uri("/v1")
	          .accept(MediaType.APPLICATION_STREAM_JSON)
	          .exchange()
	          .expectStatus().isOk()
	          .expectBodyList(PersonEntity.class)
	          .hasSize(1);
	    }

}

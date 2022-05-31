package pe.com.bank.person.service;

import pe.com.bank.person.entity.Customer;
import pe.com.bank.person.entity.PersonEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonService {
	
	 public Mono<PersonEntity> addPerson(PersonEntity person);
	 public Flux<PersonEntity> getPersons();
	 public Mono<PersonEntity> getPersonById(String id);
	 public Mono<PersonEntity> updatePerson(PersonEntity person, String id);
	 public Mono<Void> deletePersonById(String id);
	 public Mono <Customer> getCustomerByPersonId(String id);

}

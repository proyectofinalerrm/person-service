package pe.com.bank.person.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import pe.com.bank.person.client.CustomerRestClient;
import pe.com.bank.person.entity.Customer;
import pe.com.bank.person.entity.PersonEntity;
import pe.com.bank.person.repository.PersonRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class PersonServiceImpl implements PersonService{

    
    PersonRepository personRepository;
    private CustomerRestClient customerRestClient;
    
    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);

    public Mono<PersonEntity> addPerson(PersonEntity person){
    	log.info("addPerson");    	
    	return personRepository.save(person).doOnNext(personSaved -> log.info("Person id :"+person.getId()+" Saved"));
    }
    
    public Flux<PersonEntity> getPersons(){
    	log.info("getPersons");  
       return personRepository.findAll().doOnNext(person -> log.info("Person id :"+person.getId()));
    }
    
    public Mono<PersonEntity> getPersonById(String id){
    	log.info("getPersonById");  
    	return personRepository.findById(id).doOnNext(person -> log.info("Person id :"+person.getId()));
    }
    
    public Mono<PersonEntity> updatePerson(PersonEntity personUpdate, String id){
    	log.info("updatePerson"); 
    	return personRepository.findById(id).flatMap(person -> {
    			
    		person.setFirstName(personUpdate.getFirstName() != null ? personUpdate.getFirstName():person.getFirstName());
    		person.setLastName(personUpdate.getLastName()!= null ? personUpdate.getLastName():person.getLastName());
    		person.setDocumentType(personUpdate.getDocumentType()!= null ? personUpdate.getDocumentType():person.getDocumentType());
    		person.setDocumentNumber(personUpdate.getDocumentNumber()!= null ? personUpdate.getDocumentNumber():person.getDocumentNumber());
    		person.setPhoneNumber(personUpdate.getPhoneNumber()!= null ? personUpdate.getPhoneNumber():person.getPhoneNumber());
    		person.setAddress(personUpdate.getAddress()!= null ? personUpdate.getAddress():person.getAddress());
    		person.setEmail(personUpdate.getEmail()!= null ? personUpdate.getEmail():person.getEmail());
    		person.setCustomerId(personUpdate.getCustomerId() != null ? personUpdate.getCustomerId():person.getCustomerId());
    		return personRepository.save(person);
 
    	}).doOnNext(person -> log.info("Person id :"+person.getId()+" Updated"));
    }
    
    public Mono<Void> deletePersonById(String id){
    	log.info("deletePersonById"); 
    	return personRepository.deleteById(id);
    }

	public Mono<Customer> getCustomerByPersonId(String id) {
		return personRepository.findById(id).flatMap( person -> {
			return customerRestClient.getCustomer(person.getCustomerId());
			
		});
	}
    
	//public Flux
	
	//public Mono  
   
    
}

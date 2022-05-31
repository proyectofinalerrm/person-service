package pe.com.bank.person.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.com.bank.person.entity.PersonEntity;
import pe.com.bank.person.service.PersonService;
import pe.com.bank.person.service.PersonServiceImpl;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/v1")
public class PersonController {

    PersonService personService;
    
    private static final Logger log = LoggerFactory.getLogger(PersonServiceImpl.class);
    
    @PostMapping("/persons")
    public Mono<PersonEntity> addPerson(@RequestBody PersonEntity person){
    	log.info("addPerson");
    	return personService.addPerson(person);
    }
    
    @GetMapping
    public Flux<PersonEntity> getPersons() {
    	log.info("getPersons");
        return personService.getPersons();
    }
    
    @GetMapping("/{id}")
    public Mono<PersonEntity> getPersonById(@PathVariable String id){
    	log.info("getPersonById");
    	return personService.getPersonById(id);
    }
    
    @PutMapping("/{id}")
    public Mono<PersonEntity> updatePerson(@RequestBody PersonEntity personUpdate, @PathVariable String id){
    	return personService.updatePerson(personUpdate, id);
    }
    
    @DeleteMapping("/{id}")
    public Mono<Void> deletePersonById(@PathVariable String id){
    	return personService.deletePersonById(id);
    }
    	
}

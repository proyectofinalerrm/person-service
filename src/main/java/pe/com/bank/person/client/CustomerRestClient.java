package pe.com.bank.person.client;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import pe.com.bank.person.entity.Customer;
import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Value;
@Component
public class CustomerRestClient {
	
	
	  private WebClient webClient;		
	  
	  public CustomerRestClient(WebClient webClient) {
	        this.webClient = webClient;
	    }
	  
	  
	  @Value("${restClient.customersUrl}")
	  private String customerUrl;
	  
	  public Mono<Customer> getCustomer(String idCustomer){
		  
		  var url = UriComponentsBuilder.fromHttpUrl(customerUrl)
	                .queryParam("customersId", idCustomer)
	                .buildAndExpand().toUriString();
		  
		  return  webClient
	                .get()
	                .uri(url)
	                .retrieve()
	                .bodyToMono(Customer.class)
	                .log();
  
	  }  
	  
}

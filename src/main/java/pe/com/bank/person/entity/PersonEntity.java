package pe.com.bank.person.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="person")
public class PersonEntity {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String documentType;
	private String documentNumber;
	private String phoneNumber;
	private String address;
	private String email;
	private String customerId;


}
 
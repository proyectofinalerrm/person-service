package pe.com.bank.person;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;


//@SpringBootTest
class PersonServiceApplicationTests {

	
	@InjectMocks
	private PersonServiceApplication personServiceApplication;
	
	@BeforeEach
	public void setup() {
		MockitoAnnotations.openMocks(this);
	}
	
	//@Test
	void mainTest() {
				
			String[] idTransaction = { "123456789" };
			PersonServiceApplication.main(idTransaction);
			Assert.assertNotNull(personServiceApplication);
	}

}

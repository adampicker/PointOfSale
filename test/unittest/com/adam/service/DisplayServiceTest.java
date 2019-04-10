package unittest.com.adam.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.adam.service.DisplayService;

class DisplayServiceTest {

	protected DisplayService displayInstance;
	
	@BeforeEach
	protected void setUp() {
		displayInstance = DisplayService.getInstance();
	}
	
	@Test
	void displayInstanceSingletonTest() {
		assertNotNull(displayInstance);
	}
	
	@Test
	void displayInstanceSingletonTest2() {
		DisplayService secondDisplayInstance = DisplayService.getInstance();
		assertSame(secondDisplayInstance, displayInstance);
	}

}

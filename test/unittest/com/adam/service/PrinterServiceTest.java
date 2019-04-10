package unittest.com.adam.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.adam.service.PrinterService;

class PrinterServiceTest {
	
	protected PrinterService printerInstance;
		
		@BeforeEach
		protected void setUp() {
			printerInstance = PrinterService.getInstance();
		}
		
		@Test
		void printerInstanceSingletonTest() {
			assertNotNull(printerInstance);
		}
		
		@Test
		void printerInstanceSingletonTest2() {
			PrinterService secondPrinterInstance = PrinterService.getInstance();
			assertSame(secondPrinterInstance, printerInstance);
		}

}

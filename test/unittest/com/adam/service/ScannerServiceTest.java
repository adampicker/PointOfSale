package unittest.com.adam.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.adam.service.ScannerService;

class ScannerServiceTest {

	private static final long EMPTY_BARCODE_CODE = 0L;
	private static final long EXIT_CODE = -1L;
	
	protected String emptyInput, newLine, whiteSpace, properLong, exit;
	protected ScannerService scannerInstance = null;
	
	@BeforeEach
	protected void setUp() {
		emptyInput = "";
		newLine = "\n";
		whiteSpace = " ";
		properLong = "12345";
		exit = "exit";
		scannerInstance = ScannerService.getScannerInstance();
	}
	
	@Test
	void  resolveInputFromScannerEmptyInputTest(){
		assertEquals(EMPTY_BARCODE_CODE, scannerInstance.resolveInputFromScanner(emptyInput));
	}
	
	@Test
	void  resolveInputFromScannerNewLineTest(){
		assertEquals(EMPTY_BARCODE_CODE, scannerInstance.resolveInputFromScanner(newLine));
	}
	
	@Test
	void  resolveInputFromScannerWhitespaceTest(){
		assertEquals(scannerInstance.resolveInputFromScanner(whiteSpace), EMPTY_BARCODE_CODE);
	}
	
	@Test
	void  resolveInputFromScannerExitTest(){
		assertEquals(EXIT_CODE, scannerInstance.resolveInputFromScanner(exit));
	}
	
	@Test
	void  resolveInputFromScannerLongTest(){	
		assertEquals(Long.parseLong(properLong), scannerInstance.resolveInputFromScanner(properLong));
	}

}

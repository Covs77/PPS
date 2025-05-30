package bmicalc;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.*;


public class BMICalcTest {
	
	private BMICalcImpl number = new BMICalcImpl();
	
	
	@Test 
	@DisplayName("Test 1")
	public void bmiCalculation2(){
		
		assertEquals(56/(Math.pow(1.56, 2)), number.calculateBodyMassIndex(56, 1.56));
	}
	
	@Test 
	@DisplayName("Test 2")
	public void bmiCalculation3(){
		
		assertNotEquals(48/(Math.pow(1.52, 2)), number.calculateBodyMassIndex(56, 1.56));
	}
	
	@Test
	@DisplayName("Test 3")
	public void bmiCalculation() {
		assertThrows(ArithmeticException.class, () -> number.calculateBodyMassIndex(58, 0));
	}
	
	@Test 
	@DisplayName("Test 4")
	public void bmiCalculationtimeNotexceeded(){
		assertTimeout(Duration.ofSeconds(1), () -> number.calculateBodyMassIndex(56, 1.56));
	}
	
	@Test
	@DisplayName("Example 5")
	public void bmiObesity() {
		assertEquals("UNDERWEIGHT", number.getObesityCategory(17).toString());
	}
	
	@Test
	@DisplayName("Example 6")
	public void bmiObesity2() {
		assertNotEquals("NORMAL", number.getObesityCategory(26));
		
	}
	
	@Test
	@DisplayName("Example 7")
	public void bmiObesity3() {
		assertThrows(RuntimeException.class, () -> number.getObesityCategory(0));
		
	}
	
	@Test
	@DisplayName("Example 8")
	public void abdominalObesity() {
		assertTrue(number.abdominalObesity(85, Gender.FEMALES));
		
	}
	
	@Test
	@DisplayName("Example 9")
	public void abdominalObesity2() {
		assertFalse(number.abdominalObesity(70, Gender.FEMALES));
		
	}
	
	@Test
	@DisplayName("Example 10")
	public void abdominalObesity3() {
		assertTrue(number.abdominalObesity(100, Gender.MALE));
		
	}
	
	@Test
	@DisplayName("Example 11")
	public void abdominalObesity4() {
		assertFalse(number.abdominalObesity(82, Gender.MALE));
		
	}
	@Test
	@DisplayName("Test 12")
	public void abdominalObesity5() {
		assertThrows(IllegalArgumentException.class, () -> number.abdominalObesity(88, null));
	}
	
}

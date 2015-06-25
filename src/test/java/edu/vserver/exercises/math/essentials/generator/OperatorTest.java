package edu.vserver.exercises.math.essentials.generator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import fi.utu.ville.standardutils.PreciseDecimal;

public class OperatorTest {

	@Test
	public void sumObscuresCorrectly() {
		Operator operator = Operator.SUM;
		
		/*PreciseDecimal[] first = new PreciseDecimal[]{new PreciseDecimal(-10), new PreciseDecimal(10)};
		PreciseDecimal[] second = new PreciseDecimal[]{new PreciseDecimal(-5), new PreciseDecimal(15)};
		
		int solution = 9;
		
		for(int i=first[0].intValue();i<=first[1].intValue(); i++){
			for(int j=second[0].intValue();j<=second[1].intValue(); j++){
				
				if(i+j == solution)
					System.out.println(i+"+"+j+"="+(i+j));
			}	
		}*/
		
		for(int i=-10; i<20; i++){
			PreciseDecimal number = new PreciseDecimal(i);
			PreciseDecimal[] result = operator.obscure(new PreciseDecimal(i), new PreciseDecimal[]{new PreciseDecimal(-10), new PreciseDecimal(10)}, new PreciseDecimal[]{new PreciseDecimal(-10), new PreciseDecimal(10)});
			if(result == null)
				fail("Sum did not obscure number "+i);
//			System.out.println(result[0]+" + "+ result[1]+" = "+number);
			assertTrue(PreciseDecimal.add(result[0], result[1]).equals(number));
		}
	}

	@Test
	public void subtractObscuresCorrectly(){
		Operator operator = Operator.SUBTRACT;
		for(int i=-10; i<20; i++){
			PreciseDecimal number = new PreciseDecimal(i);
			PreciseDecimal[] result = operator.obscure(new PreciseDecimal(i), new PreciseDecimal[]{new PreciseDecimal(-100), new PreciseDecimal(100)}, new PreciseDecimal[]{new PreciseDecimal(-100), new PreciseDecimal(100)});
			if(result == null)
				fail("Subtract did not obscure number "+i);
//			System.out.println(result[0]+" - "+ result[1]+" = "+number);
			assertTrue(PreciseDecimal.subtract(result[0], result[1]).equals(number));
		}
	}
	
	@Test
	public void multiplyObscuresCorrectly(){
		Operator operator = Operator.MULTIPLICATION;
		for(int i=-10; i<20; i++){
			PreciseDecimal number = new PreciseDecimal(i);
			PreciseDecimal[] result = operator.obscure(new PreciseDecimal(i), new PreciseDecimal[]{new PreciseDecimal(-100), new PreciseDecimal(100)}, new PreciseDecimal[]{new PreciseDecimal(-100), new PreciseDecimal(100)});
			if(result == null)
				fail("Multiply did not obscure number "+i);
//			System.out.println(result[0]+" * "+ result[1]+" = "+number);
			assertTrue("Could not find multiplication expression for solution "+i, PreciseDecimal.multiply(result[0], result[1]).equals(number));
		}
	}
	
	@Test
	public void divisionObscuresCorrectly(){
		Operator operator = Operator.DIVISION;
		for(int i=-10; i<20; i++){
			PreciseDecimal number = new PreciseDecimal(i);
			PreciseDecimal[] result = operator.obscure(new PreciseDecimal(i), new PreciseDecimal[]{new PreciseDecimal(-100), new PreciseDecimal(100)}, new PreciseDecimal[]{new PreciseDecimal(-100), new PreciseDecimal(100)});
			if(result == null)
				fail("Division did not obscure number "+i);
//			System.out.println(result[0]+" / "+ result[1]+" = "+number);
			assertTrue("Could not find dividable expression for solution "+i, PreciseDecimal.divide(result[0], result[1]).equals(number));
		}
	}
}

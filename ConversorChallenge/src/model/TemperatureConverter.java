package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TemperatureConverter implements Converter {

	//Fahrenheit = (grados centígrados × 9/5) +32
	//Centígrados =  ((Fahrenheit - 32) x 5 ) / 9
	
	@Override
	public double converter(String initialType, String finalType, double value) {
		// TODO Auto-generated method stub
		if(initialType.equals("C°")) {
			value = (value * 9/5)+ 32;
		}else {
			value = ((value - 32) * 5 ) / 9;
		}
		
		System.out.println("value: "+ value);
		
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);

		return bd.doubleValue();
	}

}

package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MeasureConverter implements Converter {
	
	private double KmToMi = 0.621;


	@Override
	public double converter(String initialType, String finalType, double value) {
		// TODO Auto-generated method stub
		boolean flagMiles = false;
		
		switch (initialType) {
		case "cm":
			
			switch (finalType) {

				case "mts":
					
					value /= 100;
					
					break;
				case "km":
					
					value /= 100000;
					
					break;
					
				case "mi":
					
					if(value>=100) {
						flagMiles = true;
					}
					
					value = (value/100000)*KmToMi;					
					
					break;

			}			
			break;
			
		case "mts":
			
			switch (finalType) {

				case "km":
					
					value /= 1000;
					
					break;
				case "mi":
					
					value = (value/1000)*KmToMi;
					flagMiles = true;
					
					break;
					
				case "cm":
					
					value *= 100;
					
					break;

			}			
			break;
			
		case "km":
			
			switch (finalType) {

				case "mi":
					
					value *= KmToMi;
					flagMiles = true;
					
					break;
				case "mts":
					
					value *= 1000;
					
					break;
					
				case "cm":
					
					value *= 100000;
					
					break;

			}
			
			break;
			
		case "mi":
			
			flagMiles = true;
			
			switch (finalType) {

				case "km":
					
					value /= KmToMi;
					
					break;
				case "mts":
					
					value = (value/KmToMi)*1000;
					
					break;
					
				case "cm":
					
					value = (value/KmToMi)*100000;
					
					break;

			}
			
			break;

		}
	
	
	
		if(flagMiles) {
			BigDecimal bd = new BigDecimal(value);
			bd = bd.setScale(4, RoundingMode.HALF_UP);
	
			return bd.doubleValue();
		}
	
		System.out.println("value: "+ value);
		
		return value;
	}

}

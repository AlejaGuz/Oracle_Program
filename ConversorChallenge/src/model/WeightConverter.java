package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class WeightConverter implements Converter{

	private double lbsToGr = 453.592;
	@Override
	public double converter(String initialType, String finalType, double value) {
		// TODO Auto-generated method stub
		switch (initialType) {
			case "Gr":
			
				switch (finalType) {
	
					case "Lb":
						
						value /= lbsToGr;
						
						break;
					case "Kg":
						
						value /= 1000;
						
						break;
						
	
				}			
				break;
			
		case "Lb":
			
			switch (finalType) {

				case "Kg":
					
					value = (value * lbsToGr) / 1000;
					
					break;
				case "Gr":
					
					value *= lbsToGr;
					
					break;

			}			
			break;
			
		case "Kg":
			
			switch (finalType) {

				case "Lb":
					
					value =(value * 1000)/ lbsToGr;
					
					break;
				case "Gr":
					
					value *= 1000;
					
					break;
					

			}
			
			break;
			

		}
		
		System.out.println("value: "+ value);
		
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(4, RoundingMode.HALF_UP);

		return bd.doubleValue();
	}

}

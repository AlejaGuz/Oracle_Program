package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CurrencyConverter implements Converter{
	
	private double usdToEur = 0.92;
	private double usdToCop = 4173;

	
	@Override
	public double converter(String initialType, String finalType, double value) {
		// TODO Auto-generated method stub
		
		System.out.println("InitialType: "+ initialType);
		System.out.println("finalType: "+ finalType);
		
		switch (initialType) {
			case "USD":
				
				switch (finalType) {

					case "EUR":
						
						value *= usdToEur;
						
						break;
					case "COP":
						
						value *= usdToCop;
						
						break;

				}
				
				break;
			case "EUR":
				
				switch (finalType) {

					case "USD":
						
						value /= usdToEur;
						
						break;
					case "COP":
						
						value =(value /= usdToEur)* usdToCop;
						
						break;

			}
				
				break;
			case "COP":
				
				switch (finalType) {

					case "EUR":
						
						value = (value /= usdToCop)*usdToEur;
						
						break;
					case "USD":
						
						value /= usdToCop;
						
						break;

			}
				
				break;

		}
		
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(2, RoundingMode.HALF_UP);
		
		System.out.println("value: "+ value);
		
		return bd.doubleValue();
	}

}

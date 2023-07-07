package controller;

import model.Converter;
import model.CurrencyConverter;
import model.MeasureConverter;
import model.TemperatureConverter;
import model.WeightConverter;
import view.MainView;
import view.SecondView;

public class ControllerConverter {
	
	public Converter converter;
	
	private String selection;
	
	private MainView mainView;
	
	private String [] options = {"Currency","Temperature", "Weight", "Measure"};
	
	private String [] types;
	
	public ControllerConverter(MainView view) {
		
		this.mainView = view;
	}
	
	public String [] getOptions() {
		return this.options;
				
	}
	
	public void setSelection(String selection) {
		this.selection = selection;
		
		this.mainView.setVisible(false);
		
		setTypes(this.selection);
		
		SecondView view2 = new SecondView(this, this.selection);
		view2.setVisible(true);
	}
	
	
	public String [] getTypes() {
		return this.types;
				
	}
	
	public void setTypes(String selection) {
		
		switch (selection) {
		case "Currency":
			
			String[] currency = {"USD","EUR","COP"};
			this.types = currency;
			
			this.converter = new CurrencyConverter();
			
			break;
			
		case "Temperature":
			
			String[] temperature = {"C°","F°"};
			this.types = temperature;
			
			this.converter = new TemperatureConverter();
			
			break;
			
		case "Weight":
			
			String[] weight = {"Gr","Lb","Kg"};
			this.types = weight;
			
			this.converter = new WeightConverter();
			
			break;
			
		case "Measure":
			
			String[] measure = {"cm","mts","km","mi"};
			this.types = measure;
			
			this.converter = new MeasureConverter();
			
			break;

		default:
			this.types = new String [1];
			this.converter = new CurrencyConverter();
			break;
		}
		
	}

	public double resultConverter(String initialType, String finalType, double value) {
		
		return converter.converter(initialType, finalType, value);
		
	}

	public void setVisibleMain(boolean visible) {
		this.mainView.setVisible(visible);
		
	}
}

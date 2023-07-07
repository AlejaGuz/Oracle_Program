package Main;

import controller.ControllerConverter;
import view.MainView;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		MainView view = new MainView();
		
		ControllerConverter controller = new ControllerConverter(view);
		
		view.setController(controller);
		
		view.setVisible(true);

	}

}

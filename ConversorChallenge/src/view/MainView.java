package view;

import javax.swing.*;

import controller.ControllerConverter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame{
	
	private ControllerConverter controller;
	
	private JComboBox<String> converterOptionsComboBox;
	private JLabel label;
	
	public void setController(ControllerConverter controller) {
		this.controller = controller;
		
		this.converterOptionsComboBox = new JComboBox<>(controller.getOptions());
		
		this.converterOptionsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String opcionSeleccionada = (String) converterOptionsComboBox.getSelectedItem();
                
                setSelection(opcionSeleccionada);
                
            }

        });
		
		getContentPane().setLayout(new FlowLayout());
        getContentPane().add(converterOptionsComboBox);
		
	}
	
	public MainView() {
		
		setTitle("Interfaz Principal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);
        
        this.label = new JLabel("What kind of convertion would you like to make?");
        getContentPane().add(label);
        
	}
	
	private void setSelection(String selection) {
		
		this.controller.setSelection(selection);
		
	}

}

package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.*;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.NumberFormatter;

import controller.ControllerConverter;

public class SecondView extends JFrame {
	
	private JLabel mainLabel;
	private JComboBox<String> comboBoxType1;
	private JComboBox<String> comboBoxType2;
	private JTextField value;
	private ControllerConverter controller;
	private JButton converterButton;
	private JLabel result;
	private JButton homeButton;
	
	
	public SecondView(ControllerConverter controller, String opt) {
		
		setTitle("Interfaz Secundaria");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
		
		this.controller = controller;
		
		this.mainLabel = new JLabel("<html> What <b>"+ opt + "</b> would you like to convert? <html>" );
		
		this.comboBoxType1 = new JComboBox<>(controller.getTypes());
		this.comboBoxType2 = new JComboBox<>(controller.getTypes());
		
        
		this.value = new JTextField();
		this.value.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if(value.getText()!=null&& !value.getText().equals("")) {
					enableButton(true);
					
				}else {
					enableButton(false);
				}
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
				char c = e.getKeyChar();
                if (!(Character.isDigit(c) || c == '.' || c == KeyEvent.VK_BACK_SPACE 
                		|| c == KeyEvent.VK_DELETE)) {
                	
                	if(opt.equals("Temperature")) {
                		if(c != '-') {
                			e.consume();
                		}
                	}else {
                		e.consume();
                	}
                    
                }
				
			}
			
		});
		
		
		this.converterButton = new JButton("Convert");
		this.converterButton.setEnabled(false);
		this.converterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            	if(!comboBoxType1.getSelectedItem()
            			.equals(comboBoxType2.getSelectedItem())) {
            		try {
                		double valueTXT = Double.parseDouble(value.getText());
                		
                		setResult(getResult(valueTXT));
                		
                		getContentPane().revalidate();
                		getContentPane().repaint();
                		
                		pack();
                		
                	}catch (Exception exc) {
    					// TODO: handle exception
                		JOptionPane.showMessageDialog(null, exc.getMessage());
    				}
            	}else {
            		JOptionPane.showMessageDialog(null, "Types can't be equals");
            	}
                
            }
        });
		
		this.homeButton = new JButton("HOME");
		this.homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				backHome(true);
				dispose();
			}
			
		});
		
		this.result = new JLabel();
		
		addComponents();
		
		
	}
	
	public void addComponents() {
		
		getContentPane().setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(10, 10, 10, 10);
		
        getContentPane().add(mainLabel, gbc);
        
        
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 1.0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        getContentPane().add(comboBoxType1, gbc);
        

        gbc.gridx = 1;
        getContentPane().add(comboBoxType2, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 0;
        getContentPane().add(value, gbc);
        
        gbc.gridx = 1;
        getContentPane().add(converterButton, gbc);
        
        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        getContentPane().add(result, gbc);
        
        gbc.gridy = 4;
        getContentPane().add(homeButton, gbc);
        
        this.pack();
		
	}
	
	public void setResult(double result) {
		
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		symbols.setGroupingSeparator(',');
		DecimalFormat decimalFormat = new DecimalFormat("#,##0.###", symbols);
		
		String formattedResult="";
		
		if(result>=1) {
			formattedResult = decimalFormat.format(result);
		}else {
			formattedResult = result+"";
		}

		
		String formattedNumber = "";
		
		try {
			
			formattedNumber = decimalFormat.format(
					Double.parseDouble(this.value.getText()));
			
		}catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		this.result.setText( formattedNumber +" " 
				+  comboBoxType1.getSelectedItem()
				+ " are " + formattedResult + " " + comboBoxType2.getSelectedItem());
	}
	
	private void enableButton(boolean enable) {
		
		this.converterButton.setEnabled(enable);
		
	}
	
	private double getResult(double value) {
		return this.controller.resultConverter((String)comboBoxType1.getSelectedItem(),
				(String)comboBoxType2.getSelectedItem(), value);
	}
	
	private void backHome(boolean visible) {
		this.controller.setVisibleMain(visible);
	}

}

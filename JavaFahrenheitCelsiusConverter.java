// Code by nathaliarmolina
// https://github.com/nathaliarmolina

package main;

//libraries

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class JavaFahrenheitCelsiusConverter implements ActionListener {
	
	//elements
	
	JFrame frame;
	JPanel panel;
	JLabel title, label, answerLabel, alert1, alert2;
	JTextField txtField, resultField;
	JButton convert, clear;
	Double number = 0.0, result;
	String text, resultText;
	
	
	// ComboBox settings
	
	String[] option = {"Choose converter", "Fahrenheit To Celsius", "Celsius To Fahrenheit"};
	JComboBox<String> options = new JComboBox<String>(option);
	
	// constructor
	public JavaFahrenheitCelsiusConverter () {
		
		// Font Settings (font, type, size)
		Font fontMax = new Font("Candara",Font.BOLD,26);
		Font fontMid = new Font("Candara",Font.BOLD,20);
		Font fontMin = new Font("Candara",Font.BOLD,15);
		

		// Frame Settings	
		frame = new JFrame("JavaFahrenheitCelsiusConverter"); // creating JFrame 
		frame.setSize(600, 450); // size
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // closing method
		frame.setLayout(null); // no layout type
		frame.setLocationRelativeTo(null); // centralize program
		frame.setResizable(false); // disable window resize
		
		
		//Panel Settings
		panel = new JPanel();  // creating JPanel
		panel.setSize(600,450); // size
		panel.setBackground(Color.white); // color background
		panel.setLayout(null); // no layout type
		frame.add(panel); // add panel to frame
		
		//Title Settings
		title = new JLabel("Java Fahrenheit Celsius Converter"); // creating Title Label
		title.setBounds(110,20,400,45); // set coordinates and size
		title.setFont(fontMax); // set font
		panel.add(title); // add title to panel
			
		//ComboBox Settings
		options.setBounds(195,75,190,27); // set coordinates and size
		options.setFont(fontMin); // set font
		panel.add(options); // add options to panel
		

		//Label Settings
		label = new JLabel("Type the number to be converted"); // creating Label
		label.setBounds(150,115,400,45); // set coordinates and size
		label.setFont(fontMid); // set font
		panel.add(label); // add label to panel
		
		//TextField Settings
		txtField = new JTextField(); // creating txtField
		txtField.setBounds(180, 160, 215,35); // set coordinates and size
		txtField.setFont(fontMax); // set font
		panel.add(txtField); // add txtField to panel
		

		//Convert Button Settings
		convert = new JButton("Convert!"); // creating convert button
		convert.setBounds(180, 210,100,35); // set coordinates and size
		convert.setFont(fontMin); // set font
		convert.addActionListener(this); // convert button action listener
		panel.add(convert); // add convert button to panel
		
		//Clear Button Settings
		clear = new JButton("Clear"); // creating clear button
		clear.setBounds(295, 210,100,35); // set coordinates and size
		clear.setFont(fontMin); // set font
		clear.addActionListener(this); // clear button action listener
		panel.add(clear); // add clear button to panel
		
		//Answer Label Settings
		answerLabel = new JLabel("Result:"); // creating answerLabel
		answerLabel.setBounds(180, 280, 90,35); // set coordinates and size
		answerLabel.setFont(fontMid); // set font
		panel.add(answerLabel); // add answerLabel to panel
				
		
		//ResultField Settings
		resultField = new JTextField(""); // creating resultField
		resultField.setBounds(250, 280, 145,35); // set coordinates and size
		resultField.setFont(fontMid); // set font
		resultField.setEditable(false); // no edition allowed
		panel.add(resultField); // add resultField to panel
				
		
		//Error Alert 1 Label - Not a Number
		alert1 = new JLabel("This is not a valid number!"); // creating alert 1
		alert1.setBounds(190,330,400,45); // set coordinates and size
		alert1.setFont(fontMid); // set font
		alert1.setForeground(Color.red); // set font color
		alert1.setVisible(false); // not visible until is necessary
		panel.add(alert1); // add alert 1 to panel
		
		//Error Alert 2 Label - No converter Selected
		alert2 = new JLabel("Choose a converter!"); // creating alert 2
		alert2.setBounds(200,350,400,45); // set coordinates and size
		alert2.setFont(fontMid); // set font
		alert2.setForeground(Color.red); // set font color
		alert2.setVisible(false); // not visible until is necessary
		panel.add(alert2); // add alert 2 to panel

		// options action listener
		options.addActionListener(this);
		
		frame.setVisible(true); // visible true at the end of elements
		
	}
	

	// main method to start the program
	public static void main(String[] args) {
		JavaFahrenheitCelsiusConverter converter = new JavaFahrenheitCelsiusConverter();
	}

	// Events
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//get Selected Item from Combobox and set it to a string
		String selectedItem = (String) options.getSelectedItem();
		
		// Convert Button Events
		if(e.getSource() == convert) {
			
			// try to convert txtField into double and do the math in both converter
			try {
				
			// Fahrenheit To Celsius converter Selected
			if(selectedItem.equals("Fahrenheit To Celsius")) {
					
					alert1.setText(""); // clear alert 1
					alert2.setText(""); // clear alert 2
					text = txtField.getText(); // gets text in txtField
					number = Double.parseDouble(text); // convert it to double
					result = (number - 32) * 5/9; // do the math
					resultText = Double.toString(result); // set it to a string variable
					resultField.setText(resultText); // show result 
				
				}

			// Celsius To Fahrenheit converter Selected
			if(selectedItem.equals("Celsius To Fahrenheit")) {
						
					alert1.setText(""); // clear alert 1
					alert2.setText(""); // clear alert 2
					text = txtField.getText(); // gets text in txtField
					number = Double.parseDouble(text); // convert it to double
					result = (number * 9/5) + 32; // do the math
					resultText = Double.toString(result); // set it to a string variable
					resultField.setText(resultText); // show result
				
				} // end if
			} // end try
	        	
	        //catch if can't convert txtField into double	
	        catch (NumberFormatException ex){ 
	        	alert1.setVisible(true); // show alert 1
	        	alert1.setText("This is not a valid number!"); // alert 1 text
	        	
	        } // end catch
	         

			// No converter Selected
			if(selectedItem.equals("Choose converter")) {
				alert2.setVisible(true); // show alert 2
				alert2.setText("Choose a converter!"); // alert 2 text
				
			} //end if
				
			
		} // end convert button event
		
		// clear button event
		if(e.getSource() == clear) {
			
			resultField.setText(""); // clear resultField
			txtField.setText(""); // clear txtField
			number = 0.0; // clear number
			result = 0.0; // clear result
			alert1.setText(""); // clear alert 1
			alert2.setText(""); // clear alert 2
			
			
		} //end clear button event

	} // end action performed

} // end class

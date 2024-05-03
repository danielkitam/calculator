package calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calc implements ActionListener{
	
	JFrame frame;
	JTextField textField;
	JButton[] numButtons = new JButton[10];
	JButton functionButtons[] = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
	Font font = new Font("Monospaced", Font.BOLD, 20);
	
	double num1=0, num2=0, result=0;
	char operator;
	
	Calc(){
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(400, 530);
		frame.setLayout(null);
		frame.setResizable(false);
		
		textField = new JTextField();
		textField.setBounds(30, 50, 330, 50);
		textField.setFont(font);
		textField.setEditable(false);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("delete");
		clrButton = new JButton("clear");
		negButton = new JButton("(-)");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		negButton.setBounds(30, 430, 110, 50);
		delButton.setBounds(140, 430, 110, 50);
		clrButton.setBounds(250, 430, 110, 50);
		
		for(int i=0; i<10; i++) {
			numButtons[i] = new JButton(String.valueOf(i));
			numButtons[i].setFont(font);
			numButtons[i].setFocusable(false);
			numButtons[i].addActionListener(this);
		}
		
		for(int i=0; i<9; i++) {
			functionButtons[i].setFont(font);
			functionButtons[i].setFocusable(false);
			functionButtons[i].addActionListener(this);
		}
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(4,4));
		//panel.setBackground(Color.black);
		panel.setBounds(30, 110, 330, 310);
		
		panel.add(numButtons[1]);
		panel.add(numButtons[2]);
		panel.add(numButtons[3]);
		panel.add(addButton);
		panel.add(numButtons[4]);
		panel.add(numButtons[5]);
		panel.add(numButtons[6]);
		panel.add(subButton);
		panel.add(numButtons[7]);
		panel.add(numButtons[8]);
		panel.add(numButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textField);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new Calc();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		for(int i=0; i<10; i++) {
			if(event.getSource() == numButtons[i]) {
				textField.setText(textField.getText().concat(String.valueOf(i)));
			}
		}
		if(event.getSource() == decButton) {
			textField.setText(textField.getText().concat("."));
		}
		if(event.getSource() == addButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '+';
			textField.setText("");
		}
		if(event.getSource() == subButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '-';
			textField.setText("");
		}
		if(event.getSource() == mulButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '*';
			textField.setText("");
		}
		if(event.getSource() == divButton) {
			num1 = Double.parseDouble(textField.getText());
			operator = '/';
			textField.setText("");
		}
		if(event.getSource() == equButton) {
			num2 = Double.parseDouble(textField.getText());
			
			switch(operator) {
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
			}
			
			textField.setText(String.valueOf(result));
		}
		if(event.getSource() == negButton) {
			double valChanged = Double.parseDouble(textField.getText());
			valChanged *= -1;
			textField.setText(String.valueOf(valChanged));
		}
		if(event.getSource() == delButton) {
			String string = textField.getText();
			textField.setText("");
			for(int i=0; i<string.length()-1; i++) {
				textField.setText(textField.getText() + string.charAt(i));
			}
		}
		if(event.getSource() == clrButton) {
			textField.setText("0");
		}
		
	}

}

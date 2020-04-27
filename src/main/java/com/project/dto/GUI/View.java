package com.project.dto.GUI;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class View {

} 
class logInScreen {
	
	public void goToLogIn(String type) {
		JFrame f=new JFrame(type + " log-in");
		JLabel label = new JLabel();
		label.setBounds(20,150, 400,20);
		JPasswordField value = new JPasswordField();  
		value.setBounds(100,75,100,30); 
		JLabel l1=new JLabel("Username:");    
        l1.setBounds(20,20, 80,30);    
        JLabel l2=new JLabel("Password:");    
        l2.setBounds(20,75, 80,30);    
        JButton b = new JButton("Login");  
        b.setBounds(100,120, 80,30);
        JTextField text = new JTextField();  
        text.setBounds(100,20, 100,30);
        f.add(value); f.add(l1); f.add(label); f.add(l2); f.add(b); f.add(text);
        f.setSize(300,300);    
        f.setLayout(null);    
        f.setVisible(true);
        b.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
            String correctness;
            if (type.equals("Company")){ 
	            if (text.getText().equals("Maersk")&&new String(value.getPassword()).equals("007")) {correctness = " [valid]";}
	            else {correctness = " [invalid]";}
	            
	            String data = "Username " + text.getText();  
	               		data += ", Password: " + new String(value.getPassword()) + correctness;   
	               label.setText(data);      
	              
            }
            else if (type.equals("Client")){ 
	            if (text.getText().equals("Miguel")&&new String(value.getPassword()).equals("girafa")) {correctness = " [valid]";}
	            else {correctness = " [invalid, try again]";}
	            
	            String data = "Username " + text.getText();  
	               		data += ", Password: " + new String(value.getPassword()) + correctness;   
	               label.setText(data);      
	              
            }
            }
        });
    }	
	
	
	
	
}

class clientMainMenuScreen {
	
}

class compMainMenuScreen {
	
}

class compClientsScreen {
	
}

class compJourneyScreen {
	
}



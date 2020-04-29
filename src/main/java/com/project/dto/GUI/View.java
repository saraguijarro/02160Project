package com.project.dto.GUI;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class View {
	
	public static void main(String[] args) {
		//new logInScreen();
		new compMainMenuScreen();

	}

} 

/////////////////////////////////////////////////////////////////////////
class logInScreen {
	
	public void goToLogIn(String type) {
		JFrame f=new JFrame(type + " log-in");
		JLabel label = new JLabel();
		label.setBounds(20,150, 280,20);
		JPasswordField value = new JPasswordField();  
		value.setBounds(100,75,140,30); 
		JLabel l1=new JLabel("Username:");    
        l1.setBounds(20,20, 80,30);    
        JLabel l2=new JLabel("Password:");    
        l2.setBounds(20,75, 80,30);    
        JButton b = new JButton("Login");  
        b.setBounds(100,120, 80,30);
        JTextField text = new JTextField();  
        text.setBounds(100,20, 140,30);
        f.add(value); f.add(l1); f.add(label); f.add(l2); f.add(b); f.add(text);
        f.setSize(300,300);    
        f.setLayout(null);    
        f.setVisible(true);
        b.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {       
            String correctness;
            
            if (type.equals("Company")){ 
	            if (text.getText().equals("Maersk")&&new String(value.getPassword()).equals("007")) {correctness = " [valid]";
	            
	            
	            }
	            else {correctness = " [invalid, try again]";}
	                         
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
	
	logInScreen(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton compButton = new JButton("Log-in as Company");
		JButton clientButton = new JButton("Log-in as Client");
		JLabel welcomeLabel = new JLabel("Welcome to RCMS");
		
		
		welcomeLabel.setFont(new Font("Serif", Font.PLAIN, 48));
		
		
		panel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panel.setLayout(new GridLayout(2,2));
		panel.add(welcomeLabel);
		panel.add(compButton);
		panel.add(clientButton);
		
		
		frame.add(panel, BorderLayout.NORTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Remote Container Management system");
		frame.pack();
		frame.setVisible(true);
		
		clientButton.addActionListener(e -> goToLogIn("Client"));
		compButton.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){
				goToLogIn("Company");
			}		    
		});
	}
	
	
	
	
}


///////////////////////////////////////////////////////////////////////////////////

class compMainMenuScreen extends JFrame {


	compMainMenuScreen(){
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JButton cliButton = new JButton("Clients Information");
		JButton jouButton = new JButton("Journeys Management");
		JButton conButton = new JButton("Containers Management");
		JButton funButton = new JButton("Functionalities tracking");
		JButton LOButton = new JButton("Log-out");
		JButton aboutButton = new JButton("About Software");



		aboutButton.addActionListener((ActionEvent ev) -> {
					AboutDialog aboutDialog = new AboutDialog(this);
					aboutDialog.setVisible(true);
		});

		panel.setBorder(BorderFactory.createEmptyBorder(50, 100, 50, 100));
		panel.setLayout(new GridLayout(0,1));
		panel.add(cliButton);
		panel.add(jouButton);
		panel.add(conButton);
		panel.add(funButton);
		panel.add(LOButton);
		panel.add(aboutButton);
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Logistics Company Main Menu");
		frame.pack();
		frame.setVisible(true);
		
	}
}

class compClientsScreen {
	
}

class compJourneyScreen {
	
}



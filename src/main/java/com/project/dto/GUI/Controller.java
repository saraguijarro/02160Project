package com.project.dto.GUI;

import com.project.dto.Application;
import com.project.dto.LogisticCompany;
import com.project.dto.User;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
	
	static User activeUser;
	static LogisticCompany company;
	static Application app;
	
	
	static ChooseContainer chooseContainer = new ChooseContainer();
	static ClientJourney clientJourney = new ClientJourney();
	static ClientJourneyContainer_Details clientJourneyContainer_Details = new ClientJourneyContainer_Details();
	static ClientMainMenu clientMainMenu = new ClientMainMenu();
	static ClientProfile clientProfile = new ClientProfile();
	static ClientProfileEdit clientProfileEdit= new ClientProfileEdit();
	static ClientRegister clientRegister = new ClientRegister();
	static CompClients compClients = new CompClients();
	static CompJourneyContainer_Details compJourneyContainer_Details = new CompJourneyContainer_Details();
	static CompMainMenu compMainMenu = new CompMainMenu();
	static ContainerHistory containerHistory = new ContainerHistory();
	static ContainerStorage containerStorage = new ContainerStorage();
	static JourneyRegister journeyRegister = new JourneyRegister();
	static LogIn logIn = new LogIn();
	static Saved saved = new Saved();
	static UpdateStatus updateStatus = new UpdateStatus();
	static Welcome welcome = new Welcome();
	
	
	
	static public void initialize() {
		//Import all the objects from SQL tables
		company = new LogisticCompany("Maersk","0000","details");
		Welcome.newScreen();
				
	}
	
	
	public static class Listeners implements ActionListener{
		
		static void LogIn_CompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogIn_CompanyActionPerformed
			welcome.dispose();
	        LogIn.newScreen("company");
	    }//GEN-LAST:event_LogIn_CompanyActionPerformed    
	    

	    static void LogIn_ClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogIn_ClientActionPerformed
	        welcome.dispose();
	        LogIn.newScreen("client");
	    }//GEN-LAST:event_LogIn_ClientActionPerformed
	        
	        
//        static void LoginConfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmActionPerformed
//
//            if (LogIn.loggedIn.equals("client")){
//                String username = logIn.fieldName.getText();
//                String password = new String(logIn.fieldPassword.getPassword());
//
//                ResponseObject responseObject = logIn.loginService.loginCompany(username, password);
//                if (responseObject == null) {
//                    ClientMainMenu.newScreen();
//                    logIn.dispose();
//                } else {
//                    logIn.errorLabel.setText(responseObject.getMessage());
//                    logIn.errorLabel.setVisible(true);
//                }
//            }
//            else if (logIn.loggedIn.equals("company")){
//                String username = logIn.fieldName.getText();
//                String password = new String(logIn.fieldPassword.getPassword());
//
//                ResponseObject responseObject = logIn.loginCompany(username, password);
//                if (responseObject == null) {
//                    CompMainMenu.newScreen();
//                    logIn.dispose();
//                } else {
//                    logIn.errorLabel.setText(responseObject.getMessage());
//                    logIn.errorLabel.setVisible(true);
//                }
//            }
//    }//GEN-LAST:event_ConfirmActionPerformed
	        
	        
	    



		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		initialize();
	}
	
	

	
	
}

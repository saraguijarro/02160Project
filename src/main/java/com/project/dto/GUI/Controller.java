package com.project.dto.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.project.dto.Application;
import com.project.dto.LogisticCompany;
import com.project.dto.User;

public class Controller {
	
	static User activeUser;
	static LogisticCompany company;
	static Application app;
	
	
	static ChooseContainer chooseContainer;
	static ClientJourney clientJourney;
	static ClientJourneyContainer_Details clientJourneyContainer_Details;
	static ClientMainMenu clientMainMenu;
	static ClientProfile clientProfile;
	static ClientProfileEdit clientProfileEdit;
	static ClientRegister clientRegister;
	static CompClients compClients;
	static CompJourneyContainer_Details compJourneyContainer_Details;
	static CompMainMenu compMainMenu;
	static ContainerHistory containerHistory;
	static ContainerStorage containerStorage;
	static JourneyRegister journeyRegister;
	static LogIn logIn;
	static Saved saved;
	static UpdateStatus updateStatus;
	static Welcome welcome;
	
	
	
	static public void initialize() {
		//Import all the objects from SQL tables
		company = new LogisticCompany("Maersk","0000","details");
		Welcome.newScreen();
				
	}
	
	public static class Listeners implements ActionListener{
		static void LogIn_CompanyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogIn_CompanyActionPerformed
	        // TODO add your handling code here:
	        welcome.dispose();
	        LogIn.newScreen("company");
	    }//GEN-LAST:event_LogIn_CompanyActionPerformed
	    
	    

	    static void LogIn_ClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogIn_ClientActionPerformed
	        // TODO add your handling code here:
	        welcome.dispose();
	        LogIn.newScreen("client");
	        
	        
	    }//GEN-LAST:event_LogIn_ClientActionPerformed



		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		initialize();
	}
	
	

	
	
}

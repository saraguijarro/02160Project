package com.project.dto.GUI;


import com.project.dto.Client;
import com.project.repository.ClientRepository;

public class View {
	
	public static void main(String[] args) {
		//new logInScreen();
		Welcome welcomeScreen = new Welcome();
		welcomeScreen.newScreen();


//		Client client = new Client();
//
//		client.setName("client");
//		client.setPassword("password");
//		client.setEmail("hello@gmail.com");
//		ClientRepository clientRepository = new ClientRepository();
//		clientRepository.create(client);
	}

}

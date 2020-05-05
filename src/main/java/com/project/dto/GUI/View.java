package com.project.dto.GUI;


import com.project.dto.Client;
import com.project.dto.LogisticCompany;
import com.project.repository.ClientRepository;
import com.project.repository.CompanyRepository;

public class View {
	
	public static void main(String[] args) {
		//new logInScreen();
		Welcome welcomeScreen = new Welcome();
		welcomeScreen.newScreen();

//		LogisticCompany company = new LogisticCompany();
//
//		company.setName("maersk");
//		company.setPassword("denmark");
//		CompanyRepository companyRepository = new CompanyRepository();
//		companyRepository.create(company);

//		Client client = new Client();
//
//		client.setName("client");
//		client.setPassword("0000");
//		client.setEmail("hello@gmail.com");
//		client.setReferencePerson("fadi");
//		ClientRepository clientRepository = new ClientRepository();
//		clientRepository.create(client);
	}

}

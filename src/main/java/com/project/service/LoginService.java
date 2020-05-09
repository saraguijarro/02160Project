//package com.project.service;
//
//import com.project.dto.Client;
//import com.project.dto.LogisticCompany;
//import com.project.dto.ResponseObject;
//import com.project.repository.ClientRepository;
//import com.project.repository.CompanyRepository;
//
//public class LoginService {
//    private ClientRepository clientRepository = new ClientRepository();
//    private CompanyRepository companyRepository = new CompanyRepository();
//
//
//    public ResponseObject loginClient(String username, String password) {
//        Client client = clientRepository.loginUser(username, password);
//        if (client == null) {
//            return new ResponseObject(401, "Username or password is invalid");
//        }
//        return null;
//    }
//
//    public ResponseObject loginCompany(String username, String password) {
//        LogisticCompany company = companyRepository.loginUser(username, password);
//        if (company == null) {
//            return new ResponseObject(401, "Username or password is invalid");
//        }
//        return null;
//    }
//
//
//}

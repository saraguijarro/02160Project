package com.project.dto;

import java.util.ArrayList;
import com.project.repository.ClientDatabase;
public class Application {

    static public ResponseObject login(String loginType, String username, String password, LogisticCompany company) {

        boolean matchUsername=false;
        boolean matchPassword=false;
        ResponseObject loginResponse = new ResponseObject(141,"Failed login.");

        if (loginType.equals("Company")){
            if (username.equals("Maersk")){matchUsername=true;}
            if (password.equals(company.getPassword())){matchPassword=true;}
            
        }
        

        else if (loginType.equals("Client")){
            ArrayList<Client> matchedClients = company.clientDatabase.searchClient(username, "name");
            int matchSize = matchedClients.size();
            if (matchSize == 1) {
                if (username.equals(matchedClients.get(0).getName())){matchUsername=true;}
                if (password.equals(matchedClients.get(0).getPassword())){matchPassword=true;}
                
                
            }

        }

        if (matchUsername && matchPassword) {loginResponse.setMessage("Succesfull login.");loginResponse.setCode(140);}

        return loginResponse;
    }
}

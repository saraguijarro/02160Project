#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Loggin in the application

	Background: 
		Given a logistic company "Maersk"

  
  Scenario: Company succesfull first log-in
    Given The log-in type "Company"
    And The username "Maersk"
    And The password is "0000"
    And The password "0000"
    When Logging-in
    Then Log-in is succesfull
    And active user is updated
    
  Scenario: Company succesfull regular log-in
    Given The log-in type "Company"  
    And The username "Maersk"  
    And The password is "password00"   
    And The password "password00"
    When Logging-in
    Then Log-in is succesfull
    And active user is updated
    
   Scenario: Company not log-in (wrong password)
    Given The log-in type "Company"   
    And The username "Maersk"
    And The password is "password00"
    And The password "445"
    When Logging-in
    Then Log-in fails
    
  Scenario: Company not succesfull log-in (wrong username)
    Given The log-in type "Company"
    And The password is "password00"    
    And The username "Mark"   
    And The password "password00"
    When Logging-in
    Then Log-in fails
    
    
   Scenario: Client succesfull log-in (name)
    Given The log-in type "Client"
    And a client database with the client "Sara" "Mihai" "Thomas" and "Miguel"
    And The username "Miguel"   
    And The password is "password00"
    And The password "password00"
    When Logging-in
    Then Log-in is succesfull
    And active user is updated
    
   Scenario: Client not succesfull log-in (wrong password)
    Given The log-in type "Client"
    And a client database with the client "Sara" "Mihai" "Thomas" and "Miguel"
    And The username "Miguel"
    And The password is "password00"
    And The password "445"
    When Logging-in
    Then Log-in fails
    
  Scenario: Client not succesfull log-in (wrong name)
    Given The log-in type "Client"
    And a client database with the client "Sara" "Mihai" "Thomas" and "Miguel"
    And The username "George"
    And The password is "password00"
    And The password "password00"
    When Logging-in
    Then Log-in fails
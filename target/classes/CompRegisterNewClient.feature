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

@tag
Feature: Company registers new clients
	

	Background: 
		Given a logistic company "Maersk"
		And a client database
	
	
  @tag1
  Scenario: The company gives all information about the client
    Given a valid client name "Miguel"
    And a valid address: "Denmark", "Lyngby", "2800", "Fysikvej", "315"
    And a valid reference person "Suzan"
    And a valid email "s184468@student.dtu.dk"
    When Registering in "client database"
    Then the system displays a message confirming the registration of client
    And a new client id is automaticly generated
    
   @tag2
   Scenario: The company does not give all information about the client
	  Given a valid client name "Miguel"
	  And a valid email "s184468@student.dtu.dk"
	  When Registering in "client database"
	  Then the system displays a message confirming the registration and indicating the missing fields
	  And a new client id is automaticly generated
	  
	 @tag3
   Scenario: The company does not give the name of the client
	  Given a valid reference person "Suzan"
	  And a valid email "s184468@student.dtu.dk"
	  When Registering in "client database"
	  Then the system displays a message telling that the client needs a name
	   
	 @tag4
	 Scenario: The company registers an already registered client
	 	Given a valid client name "Miguel"
    And a valid address: "Denmark", "Lyngby", "2800", "Fysikvej", "315"
    And a valid reference person "Suzan"
    And a valid email "s184468@student.dtu.dk"
    And a client database with the client "Miguel"
    When Registering in "client database"
    Then the system displays a message telling that the client is already registered
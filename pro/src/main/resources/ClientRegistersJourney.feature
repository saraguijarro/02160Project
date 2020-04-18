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
Feature: User registers containers

Background: 
		Given a client "danish porks"
		And a journey database

  @tag1
  Scenario: The user gives all information about the container's journey.
    Given a valid port of origin "Copenhaguen"
    And a valid destination "Beirut"
    And a valid content "Pork meat"
    And a valid company "danish porks"
    When Registering
    Then the system displays a message confirming the registration
    And a new journey id is automaticly generated

 @tag2
   Scenario: The client does not give the content of the container's journey
	  Given a valid port of origin "Copenhaguen"
	  And a valid destination "Beirut"
    And a valid company "danish porks"
	  When Registering
	  Then the system displays a message telling that the content needs to be filled
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	 
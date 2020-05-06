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
		Given a client "Thomas"
		And a journey database


 @tag1
   Scenario: The client does not give all of the container's journey
	  Given a valid port of origin "Copenhaguen"
	  And a valid destination "Beirut"
    And a valid company "Netto"
	  When Registering in "journey database"
	  Then the system displays a message telling that the field "content" needs to be filled
	  
 @tag2
  Scenario: The client gives all information about the container's journey, chooses a container that is availble at the port of origin.
    Given a valid port of origin "Copenhaguen"
    And a valid destination "Beirut"
    And a valid content "Pork meat"
    And a valid company "Netto"
    And an available container at the port of origin
    And a selected container
    When Registering in "journey database"
    Then the system displays a message confirming the registration of journey
    And a new journey id is automaticly generated
    And the container is in that journey
	  
	 @tag3
  Scenario: The client gives all information about the container's journey, chooses a new container when there is availble ones at the port of origin.
    Given a valid port of origin "Copenhaguen"
    And a valid destination "Beirut"
    And a valid content "Pork meat"
    And a valid company "Netto"
    And an available container at the port of origin
    And a new generated container
    When Registering in "journey database"
    Then the system displays a message confirming the registration of journey
    And a new journey id is automaticly generated
    And the container is in that journey
    
   @tag4
  Scenario: The client gives all information about the container's journey, chooses a new container when there is no availble ones at the port of origin.
    Given a valid port of origin "Copenhaguen"
    And a valid destination "Beirut"
    And a valid content "Pork meat"
    And a valid company "Netto"
    And no container at the port of origin
    And a new generated container
    When Registering in "journey database"
    Then the system displays a message confirming the registration of journey
    And a new journey id is automaticly generated
    And the container is in that journey
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	 
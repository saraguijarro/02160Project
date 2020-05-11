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
Feature: Company find client
  
  Background: 
		Given a logistic company "Maersk"
		And a client database with the client "Sara" "Mihai" "Thomas" and "Miguel"

  @tag1
  Scenario: The company uses the criteria from an existing client without filter
    Given a searchword "Fysikvej"
    And a filter "None"
    When searching for client
    Then the corresponding "2" client(s) is/are found.
    
   @tag2
   Scenario: The company uses criteria that do not exist, without filter
   	Given a searchword "Lisbon"
   	And a filter "None"
   	When searching for client
   	Then the corresponding "0" client(s) is/are found.
   	
   @tag3
   Scenario: The company uses the criteria from an existing client with a filter
   Given a searchword "m"
   And a filter "reference person"
   When searching for client
   Then the corresponding "1" client(s) is/are found.
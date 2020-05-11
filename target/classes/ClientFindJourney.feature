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
Feature: Client Find Journey
  
 ##TF
  Background: 
  	Given a client "Thomas"
		And a journey database with the departing port "Copenhagen"  "New York" and "Beirut" 

   @tag1
  Scenario: The client uses the criteria from an existing journey without filter
    Given a searchword "Bananas"
    And a filter "None"
    When searching for journey
    Then the corresponding "2" journey(s) is/are found.
    
   @tag2
   Scenario: The client uses criteria that do not exist, without filter
   	Given a searchword "Lisbon"
   	And a filter "None"
   	When searching for journey
   	Then the corresponding "0" journey(s) is/are found.
   	
   @tag3
   Scenario: The client uses the criteria from an existing journey with a filter
   Given a searchword "c"
   And a filter "Port of Origin"
   When searching for journey
   Then the corresponding "1" journey(s) is/are found.
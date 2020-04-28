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
Feature: Company updates journey information
  
  Background: 
		Given a logistic company "Maersk"
		And a container database with the container ID "CON0004"
		
  @tag1
  Scenario: The company updates the current position"
    Given a container in a journey
    When Update current position
    Then the current position is updated
    
    @tag2
  Scenario: The company updates the current position
    Given an update choice "current position"
    And a container in a journey
    When Update current position
    Then the current position is updated

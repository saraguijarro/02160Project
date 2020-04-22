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
Feature: Retrieve info about each container
  Retrieve data about the evolution of each container

  @tag1
  Scenario: Retrieve data about the internal status
    Given a journey id "JO002160" exists for the corresponding container
		And a database exists for the measures of the container internal status
		When the system decides to retrieve the internal status facts
		Then the system retrieves the data from the database

  @tag2
  Scenario: Retrieve data from the journey evolution
		Given a journey id "JO002160" exists for the corresponding container
		And a database exists for the container journeys
		When the system decides to retrieve a location from the database
		Then the system retrieves the data from the journey database
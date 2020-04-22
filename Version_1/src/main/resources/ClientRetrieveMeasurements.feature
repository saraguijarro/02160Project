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
Feature: Retrieve measurements about the container’s internal status
  Retrieve the collected measurements from the system

  @tag1
  Scenario: Retrieve measurements from the system
		Given a journey id "JO002160" exists for the corresponding container
		And an update choice "humidity"
		And the container corresponds to the client "Alberto"
		When a client "Alberto" wants to retrieve measurements from the internal status
		Then these measurements are retrieved from the internal status

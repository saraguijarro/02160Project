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
Feature: Retrieve measurements about the container internal status
  Retrieve the collected measurements from the system

  @tag1
  Scenario: Retrieve measurements from the system
		Given a journey id exists for the corresponding container
		And a container with temperature 15 humidity 10 pressure 0.4
		And the container corresponds to the client "Alberto"
		When a client retrieves measurements from the internal status
		Then the measurements temperature 15 humidity 10 pressure 0.4 are retrieved
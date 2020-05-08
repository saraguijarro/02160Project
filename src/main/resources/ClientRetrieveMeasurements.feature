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
		Given a container with a container id "J02061"
		And a container with temperature 15.7 humidity 10.8 pressure 0.4
		When a client wants to retrieve the measurements from the internal status
		Then the measurements are retrieved

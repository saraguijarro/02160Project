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
Feature: Add measurements about the container’s internal status
  Add the collected measurements to the system

  @tag1
  Scenario: Update measurements about the container’s internal status
		Given a journey id exists for the corresponding container
		And a logistic company "Maersk"
		And an update choice "humidity"
		When updating the internal status
		Then the system sets the internal status to the latests measurements
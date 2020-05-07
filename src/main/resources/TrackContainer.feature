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
Feature: Track each container
  Keep track of the evolution of each container

  @tag1
  Scenario: Tracking the internal status
    Given a container with a container id "J02061"
		When the logistic company measures 9.66 about the internal status
		Then the logistic company adds the data given to the internal status database

  @tag2
  Scenario: Tracking the journey
		Given a container with a container id "J02061"
		When the logistic company determines the location "Italy" of the container
		Then the logistic company adds the location found to the journey database

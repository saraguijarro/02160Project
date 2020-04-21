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
    Given a journey id "JO002160" exists for the corresponding container
		And a database exists for the measures of the container’s internal status
		When the system measures the internal status facts
		Then the system adds the data given to the internal status’ database

  @tag2
  Scenario: Tracking the journey
		Given a journey id "JO002160" exists for the corresponding container
		And a database exists for the container’s journeys
		When the system determines the location of the container
		Then the system add the location found to the journey’s database

  @tag3
  Scenario: There is no journey id for the tracked container
		Given the journey id "JO002160" doesn’t exist for the corresponding container
		When trying to obtain information about the internal status or the journey evolution
		Then the search is unsuccessful
		And no information is given

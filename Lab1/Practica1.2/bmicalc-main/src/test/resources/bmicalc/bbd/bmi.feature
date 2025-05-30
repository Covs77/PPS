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
Feature: BMI Calculation

	@tag1
  Scenario: Calculate BMI for valid values
    Given mass is 70.0 kg
    And height is 1.75 m
    When BMI is calculated
    Then BMI should be 22.8571428571
    

	@tag2
  Scenario: Categorize BMI as underweight
    Given BMI is 18.4
    When BMI category is determined
    Then BMI category should be "UNDERWEIGHT"

	@tag3
  Scenario: Categorize BMI as normal
    Given BMI is 20.0
    When BMI category is determined
    Then BMI category should be "NORMAL"
	
	@tag4
  Scenario: Categorize BMI as overweight
    Given BMI is 27.0
    When BMI category is determined
    Then BMI category should be "OVERWEIGHT"


	@tag5
  Scenario: Categorize BMI as obese
    Given BMI is 35.0
    When BMI category is determined
    Then BMI category should be "OBESE"



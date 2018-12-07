Feature: BMJ login test feature 

Scenario: Test Login with invalid login credentials
	Given I am in BMJ bestpractice login page
	When I enter invalid credentials
	Then I should not be logged in
	And  I get error message

Feature: BMJ login test feature 

Scenario: Test Login with invalid login credentials
	Given I am in BMJ bestpractice login page
	When I enter invalid credentials
	Then I see the error message "The entered sign-in details are incorrect. Please enter a valid username and password and try again."
	
Scenario: Test Login with valid login credentials
	Given I am in BMJ bestpractice login page
	When I enter valid credentials
	Then I am logged  in and go to the next page
	
Scenario: Test Login with valid email and invalid password details
	Given I am in BMJ bestpractice login page
	When I enter valid email and invalid password
	Then I see the error message "The entered sign-in details are incorrect. Please enter a valid username and password and try again."
	
Scenario: Test Login with invalid email and valid password details
	Given I am in BMJ bestpractice login page
	When I enter invalid email and valid password
	Then I can see the error message "The entered sign-in details are incorrect. Please enter a valid username and password and try again."
	
Scenario: Test Login with blank email and blank password details
	Given I am in BMJ bestpractice login page
	When I enter blank email and blank password
	Then I can see the  message "This field is required."	
	
	

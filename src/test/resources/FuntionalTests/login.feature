Feature: BMJ login test feature 

Scenario: Test Login with invalid email and invalid password
	Given I am in BMJ bestpractice login page
	When I enter invalid email and invalid password
	Then I see the error message "The entered sign-in details are incorrect. Please enter a valid username and password and try again."
	
Scenario: Test Login with valid email and valid password
	Given I am in BMJ bestpractice login page
	When I enter valid email and valid password
	Then I am logged  in and go to the next page
	
Scenario: Test Login with valid email and invalid password details
	Given I am in BMJ bestpractice login page
	When I enter valid email and invalid password
	Then I  the error message "The entered sign-in details are incorrect. Please enter a valid username and password and try again."
	
Scenario: Test Login with invalid email and valid password details
	Given I am in BMJ bestpractice login page
	When I enter invalid email and valid password
	Then I  see the error message "The entered sign-in details are incorrect. Please enter a valid username and password and try again."
	
Scenario: Test Login with blank email and blank password details
	Given I am in BMJ bestpractice login page
	When I enter blank email and blank password
	Then I  see the  message "This field is required."	
	
Scenario: Test Login with blank email 
	Given I am in BMJ bestpractice login page
	When I enter blank email 
	Then I  see the  message "This field is required."

Scenario: Test Login with blank password 
	Given I am in BMJ bestpractice login page
	When I enter blank password 
	Then I  see the  message "This field is required."		

Scenario: Test Login with invalid email format
	Given I am in BMJ bestpractice login page
	When I enter invalid email format 
	Then I  see the  message "Please enter a valid email address."				
	
	

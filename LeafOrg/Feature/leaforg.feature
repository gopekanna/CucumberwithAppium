Feature: Test the Login Functionality in Hybrid App

Scenario: Launch the App and enter the credentials
	Given User on Login screen
	When User enters Username and Password
	Then User click the Login button
	And Click the settings menu
	
Scenario: Logout from the Hybrid App
	When User Click Logout
	Then User Click Yes Logout
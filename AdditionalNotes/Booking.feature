Feature: Booking one-way ticket for non-signed user

	Scenario: Booking button is working
		Given user on page with information about fly
		When user clicking "Book for <price>" button
		Then "My booking" screen is showed
		
	Scenario: User can read about COVID-19 restricitons
		Given user is on "My booking" screen and see block with inforamtion about "COVID-19"
		When user clicking underlined text "travel restrictions" in "COVID-19 inforamtion" block
		Then "COVID-19" inforamtion screen is opened
		
	Scenario: User can open "Add traveler" screen
		Given user is on "My booking" screen
		When user clicking "Add traveler" in "Traveler 1" block
		Then "Add traveler" screen is opened
		
	Scenario: After filling all field in "Add traveler" screen "Preview" button appearing
		Given user is on "Add traveler" screen
		When all fields are filled with information
		Then "Preview" button appearing
		
	Scenario: "Preview" screen is opened after clicking "Preview" button
		Given user is on "Add traveler" screen with all details filled
		When "Preview" button is clicked
		Then "Preview" screen is opened
		
	Scenario: "Save" button on "Preview" screen is working
		Given user is on "Preview" screen
		When "Save" button is clicked
		Then "My booking" screen is opened
		And information for traveler is visible
		
	Scenario: Insurance for traveler can be picked
		Given user in on "My booking" screen
		When user chooses on of three insurance options
		Then information about choosen insurance in "Traveler" block showed accordingly
		
	Scenario: Contact details can be filled
		Given "Contact details" block is empty
		When correct email and correct number filled in
		Then "Contact details" block containing all information
		And there is no errors
			
	Scenario: "Continue" button on "My booking" screen is working
		Given user on "My booking" screen
		And all information filled correctly
		When user pressed "Continue" button
		Then "Baggage" screen is opened
		
	Scenario: "Continue" button on "Baggage" screen is working
		Given user on "Baggage" screen
		When user pressed "Continue" button
		Then "Ticket Fare" screen is opened
		
	Scenario: Ticket fare for traveler can be picked
		Given user in on "Ticket Fare" screen
		When user chooses on of three ticket fare options
		Then information about choosen ticket fare in "Select your ticket fare" block showed accordingly
		And price of ticket updated accordingly
		
	Scenario: "Continue" button on "Ticket Fare" screen is working
		Given user on "Ticket Fare" screen
		And ticket fare option is picked
		When user pressed "Continue" button
		Then "Kiwi.com guarantee" screen is opened
		
	Scenario: Kiwi guarantee for traveler can be picked
		Given user in on "Kiwi.com guarantee" screen
		When user chooses on of two options
		Then option is selected
		And price of ticket updated accordingly
		
	Scenario: "Continue" button on "Kiwi.com guarantee" screen is working
		Given user on "Kiwi.com guarantee" screen
		And guarantee option is picked
		When user pressed "Continue" button
		Then "Trip customization" screen is opened
		
	
		
	
	

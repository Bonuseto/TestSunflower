Feature: Testing "Search" function for tickets


	Scenario Outline: Verify non-signed user can search "One way" ticket
		Given non-signed user on Travel search screen with choosen "One Way" for ticket type
		When user fill fields <From:>, <To:>, <Departure:>
		And clicked button "Search"
		Then screen with seacrh results are presented
		
		Examples: 
			| From:  | To:       | Departure: |
			| Rome   | Prague    | Anytime    |
			| Paris  | Amsterdam | 23/05/2021 |
			| Berlin | Istanbul  | 06/06/2021 |
			
	
	Scenario Outline: Verify non-signed user can search "Return" ticket
		Given non-signed user on Travel search screen with choosen "Return" for ticket type
		When user fill fields <From:>, <To:>, <Departure:>, <Return:>
		And clicked button "Search"
		Then screen with seacrh results are presented
		
		Examples:
			| From:  | To:       | Departure: | Return:    |
			| Rome   | Prague    | Anytime    | Anytime    |
			| Paris  | Amsterdam | 23/05/2021 | 29/05/2021 |
			| Berlin | Istanbul  | 06/06/2021 | 06/06/2021 |
			
			
    Scenario Outline: Verify non-signed user can search "MultiCity" ticket
		Given non-signed user on Travel search screen with choosen "MultiCity" for ticket type
		When user clicked button "Add destination"
		Then "Trip 2" will appear under "Trip 1"
		When user fill fields under "Trip 1": <Trip 1 From:>, <Trip 1 To:>, <Trip 1 Departure:>
		And user fill fields under "Trip 2": <Trip 2 From:>, <Trip 2 To:>, <Trip 2 Departure:>
		And clicked button "Search"
		Then screen with seacrh results are presented
		
		Examples:
			| Trip 1 From: | Trip 1 To: | Trip 1 Departure:       | Trip 2 From: | Trip 2 To: | Trip 2 Departure:       |  		
		    | Rome         | Prague     | 10/05/2021 - 15/05/2021 | Prague       | Barcelona  | 17/05/2021 - 20/05/2021 |
		    | Paris        | Amsterdam  | 23/05/2021 - 05/06/2021 | Amsterdam    | Berlin     | 08/06/2021 - 13/06/2021 |
			| London       | Istanbul   | 20/08/2021 - 25/08/2021 | Antalya      | Krakov     | 30/08/2021 - 30/08/2021 |
			
			
	Scenario Outline: Verify non-signed user can search "NOMAD" ticket
		Given non-signed user on Travel search screen with choosen "NOMAD" for ticket type
		When user fill fields under "Departure": <From:>, <Departure:>
		And user clicked button "Add destination"
		Then destination stop will appear under "Destinations"
		When user fill fields under "Stop 1": <Stop 1 At:>, <Stop 1 Stay for:>
		And user clicked button "Add next destination"
		Then second destination stop will appear under "Stop 1"
		When user fill fields under "Stop 2": <Stop 2 At:>, <Stop 2 Stay for:>
		And user fill fields under "Final destination": <To:>, <Return:>
		And clicked button "Search"
		Then screen with seacrh results are presented
		
		Examples:
			| From: | Trip 1 Departure:       | Stop 1 At: | Stop 1 Stay for: | Stop 2 At: | Stop 2 Stay for: | To:     | Return: |
		    | Rome  | 10/05/2021 - 15/05/2021 | Prague     | 3-5 nights       | Barcelona  | 3-5 nights       | Glasgow | Anytime |
		    
		
			
			
	
	
			
	
		
		
	
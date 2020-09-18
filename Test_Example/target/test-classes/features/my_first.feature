@Weather1
Feature: to check weather comparision
 Scenario Outline: I login with valid credential
 		Given I navigate to "<URL>"
 		Then I click on subMenu options
 		Then I click on weather tab
 		Then I enter "<city>" into input searchBox field
 		Then Entered "<city>" should be present
 		Then I check the checkbox having "<city>"
 		Then I store the temperature for "<city>"
 		Then I need to call weatehr API endpoint "<API_URL>" with city "<city>" and appid "<appid>"
 		Then I need to compare the temperature with variance of "<variance>" degree
        Then I take screenshot

Examples:

| URL                   | city   |                API_URL                    |     appid                       |      variance  |
|https://www.ndtv.com/. | Bhopal |   api.openweathermap.org/data/2.5/weather |7fe67bf08c80ded756e598d6f8fedaea  |       2       |
 
 Scenario: Close browser
 		  Then I close browser 	
 		
 		
 		
 		
 	
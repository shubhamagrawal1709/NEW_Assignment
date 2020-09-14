Feature: to check weather comparision
 
 Scenario: I login with valid credential
 		Given I navigate to "https://www.ndtv.com/"
 		Then I click on element having xpath "//*[@id="h_sub_menu"]"
 		Then I click on element having xpath "//a[text()='WEATHER']"
 		Then I enter "Bhopal" into input field having id "searchBox"
 		Then element having id "Bhopal" should be present
 		Then I check the checkbox having id "Bhopal"
 		Then I store the temperature for "Bhopal"
 		Then I need to call weatehr API endpoint "api.openweathermap.org/data/2.5/weather" with q "Bhopal" and appid "7fe67bf08c80ded756e598d6f8fedaea"
 		Then I need to compare the temperature with variance of "2" degree
        #Then I should get logged-in
        #Then I take screenshot
 
 Scenario: Close browser
 		  Then I close browser 	
 		
 		
 		
 		
 	
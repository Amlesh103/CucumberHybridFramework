Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on login button
Then User should be successfully logged in
Examples:
|username                |password|
|amlesh.shukla1@gmail.com|1234		|
|amlesh.shukla2@gmail.com|1234		|
|amlesh.shukla3@gmail.com|1234		|

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field
And User enters invalid password "123456789" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "amleshkumarshukla1@gmail.com" into email field
And User enters invalid password "12345678" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login with invalid email and valid password
Given User navigates to login page
When User enters invalid email address into email field
And User enters valid password "123456" into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch

Scenario: Login without providing any credentials
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on login button
Then User should get a proper warning message about credentials mismatch    

Feature: Registration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to Register account page
When User enters the details into below fields
|firstName		|Amlesh											|
|lastName 		|Shukla											|
|telephone		|1234567890									|
|password			|12345											|
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully


Scenario: User creates an account with all fields
Given User navigates to Register account page
When User enters the details into below fields
|firstName		|Amlesh 									  |
|lastName			|Shukla										  |
|telephone		|1234567890									|
|password			|12345											|
And User selects Yes for Newsletter
And User selects privacy policy
And User clicks on continue button
Then User account should get created successfully

Scenario: User creates a duplicate account
Given User navigates to Register account page
When User enters the details into below fields with duplicate fields
|firstName		|Amlesh 									  |
|lastName			|Shukla										  |
|email				|amleshkumarshukla@gmail.com|
|telephone		|1234567890									|
|password			|12345											|
And User selects Yes for Newsletter
And User selects privacy policy
And User clicks on continue button
Then User should get a proper warning about duplicate email

Scenario: User creates an account without filling any details
Given User navigates to Register account page
When User dont enters any details into fields
And User clicks on continue button
Then User should get proper warning message for every mandatory field
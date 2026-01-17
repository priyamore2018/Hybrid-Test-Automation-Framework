Feature: Login Functionality  of QABrains site

Scenario Outline: Login with multiple data of Excel
Given User should be on Login Page
When  User should enter valid username and password from Excel "<SheetName>" and <RowNumber> then click on login button
Then User should land on the sucessful Login Home page. 
And User click on logout button from Login Home Page.

Examples:

|SheetName 		|RowNumber|
|LoginTestData  |0		  |
|LoginTestData  |1		  |


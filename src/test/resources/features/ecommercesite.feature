Feature: E-Commerce Site Functionality of QABrains

Scenario Outline: E-Commerce Site Login with multiple sets of Data
Given User should on Home Page
When User should land to E-Commerce Site by clicking on link 
Then User click on Visit Demo Site
And  User will successful naviate to Login Page of E-Commerce
Then User should enter "<username>", "<password>" and click on Login button
Then User should sucessful land on Product page.
Then User select product and Add to cart 
Then User click on cart 
And  Verify selected product
Then User click on logout 


Examples:
|username 			    |password     |
|test@qabrains.com      |Password123  |
|student@qabrains1.com  |Password123  |




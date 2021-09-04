Feature: Login into the application

Background:
Given Load the login page
Given Open the chrome browser

@ValidLogin
Scenario Outline:Login with Valid Creditnals

When user enters the valid user name <username> and password <password>
Then click on login button

Examples:
|username            |password      |
|spraslam@gmail.com  |Peerbasha@1006|

@InValidLogin
Scenario Outline:Login with InValid Creditnals

When user enters the Invalid user name <username> and password <password>
Then click on login button

Examples:
|username   |password  |
|2wr        |Sheik     |

@Register
Scenario Outline:Registered User 

When user enters the rgister username <regemail> and password <regpassword>
Then click on Register button

Examples:
|regemail           |regpassword    |
|spraslam@gmail.com |Peerbasha@1006 |
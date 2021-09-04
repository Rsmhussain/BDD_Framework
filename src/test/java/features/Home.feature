@Signin
Feature: Sign up in home page


Background:
Given Open the chrome browser
Given Load the Sign In Page


Scenario Outline: Enter the Valid Email ID 
When user enters the <emailID>
Then click the register button
Then verify register page is opened or not

Examples:
|emailID           |
|spraslam@gmail.com|










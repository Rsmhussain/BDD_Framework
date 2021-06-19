@Login
Feature: Login into the application

Background:
Given Load the login page
Given Open the chrome browser

Scenario Outline:Login with Valid Creditnals

When user enters the <username> and <password>
Then click on login button

Examples:
|username   |password  |
|sheik      |Sheik@1006|

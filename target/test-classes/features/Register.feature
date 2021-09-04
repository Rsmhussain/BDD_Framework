Feature: New User Registration

Background:
Given User on the Registeration Page

Scenario Outline: Verification of successful registration when the inputs are correct
When user enters the vaild <FirstName> and <SecondName>
And enters the valid <Address>
And enters the valid <emailaddress>
And enters the valid <phone>
And user choose the <gender>
And user select the <hobbies>
And user enters the <language>
And user select the <skills>
And user select the <country>
And user select the <dateofbirth>
And user enter the <password> and <confirmpassword>
Then the user registration should be successful 

Examples:
|FirstName  |SecondName   |Address   |emailaddress     |phone       |gender    |hobbies    |language    |skills   |country    |dateofbirth     |password     |confirmpassword   |

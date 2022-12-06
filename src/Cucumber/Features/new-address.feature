Feature: New Address

Scenario Outline: Create new address
Given A browser with My Store website
And Click SignIn button
  When the registered user enters a correct e-mail address and correct password
And the user opens the Addresses feature
  And completes the form with <alias> and <address> and <city> and <zip> and <country> and <phone>
  Then new address is correctly saved
Examples:
| alias    | address    | city         | zip  | country | phone
| Address1 | Carrot 23  | London       | 12345 | United Kingdom | 123456789
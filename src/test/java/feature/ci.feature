Feature: CIndividual

@cretaeIndiv
Scenario: CreatesIndividual
And navigates to individuals from App launcher
And Clicks on the Dropdown icon in the Individuals tab
And Clicks on New Individual
Then gives data for first name and last name as
|FirstName|Lastname|
|Bharathi|Priya|
And Click Save
And Verif message
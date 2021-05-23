Feature: Individual



#@cretaeIndiv
#Scenario: CreateIndividual
#And navigate to individuals from App launcher
#And Click on the Dropdown icon in the Individuals tab
#And Click on New Individual
#Then give data for first name and last name as
#|FirstName|Lastname|
#|Bharathi|Priya|
#And Click on Save
#And Verify message


@EditIndiv
Scenario: EditIndividual
And navigate to individuals from App launcher for edit
Then give data for first name to edit
|FirstName|
|bharathi|
And Click Edit
Then Edit data for first name
|FirstName|
|priya|
And click save
And verify edited message


@SortIndiv
Scenario Outline: SortIndividual
And navigate to individuals from App launcher for sorting
Then Sort the name

@DelIndv
Scenario Outline: DeleteIndividual
And navigate to individuals from App launcher
Then give data for first name
|FirstName|
|bharathi|
And Delete the Individual
And Verifymessage

	    
	    
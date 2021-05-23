Feature: Appointment

@cretaeServive
Scenario: CreateServiceAppointment
And navigate to Appointments from App launcher
And click New
Then Enter the description
|Description|Creating Service Appointments|
Then Click newAccount
|AccountName|Priya|
And Give todays date
And Verify Service message
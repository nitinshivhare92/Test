Feature: Find how much could I borrow from ANZ test site
Scenario: calculate the borrow with given inputs
Given user should be navigated to ANZ test site
When user should select application type dependents property type under your details
And user should select your income and other other income under your earnings
And user should select living expense home loan repayment other loan repayment commitments credit limit under your expenses and click borrow button 
Then user checks the borrowing estimate as $479,000

Scenario: clear the form using start over button 
Given user should have already estimated the borrowing
When user should use the start over button to clear the form
Then validate whether form is cleared

Scenario: Entering only $1 for Living expenses, and leaving all other fields as zero.
Given borrowing estimate form should be empty
When User enters $1 for living expense and clicks the work out how much I could borrow
Then Validates the message
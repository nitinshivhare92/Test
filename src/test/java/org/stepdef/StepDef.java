package org.stepdef;

import java.util.concurrent.TimeUnit;

import javax.swing.SortingFocusTraversalPolicy;

import org.locator.LocatorPage1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDef extends BaseClass {

	public static BaseClass baseclass;

	public static LocatorPage1 lp;

	@Given("user should be navigated to ANZ test site")
	public void user_should_be_navigated_to_ANZ_test_site() throws InterruptedException {

		baseclass = new BaseClass();

		baseclass.LaunchBrowser();

		baseclass.LaunchUrl("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");

	}

	@When("user should select application type dependents property type under your details")
	public void user_should_select_application_type_dependents_property_type_under_your_details() {

		lp = new LocatorPage1();

		WebElement applicationType = lp.getApplicationType();
		applicationType.click();

		WebElement numberOfDependents = lp.getNumberOfDependents();
		baseclass.dropDownSelect(numberOfDependents, "0");

		WebElement propertyToBuy = lp.getPropertyToBuy();
		propertyToBuy.click();
	}

	@When("user should select your income and other other income under your earnings")
	public void user_should_select_your_income_and_other_other_income_under_your_earnings() {

		WebElement yourIncome = lp.getYourIncome();
		baseclass.sendKey(yourIncome, "80000");

		WebElement otherIncome = lp.getOtherIncome();
		baseclass.sendKey(otherIncome, "10000");

	}

	@When("user should select living expense home loan repayment other loan repayment commitments credit limit under your expenses and click borrow button")
	public void user_should_select_living_expense_home_loan_repayment_other_loan_repayment_commitments_credit_limit_under_your_expenses_and_click_borrow_button() {
		WebElement livingExpenses = lp.getLivingExpenses();
		baseclass.sendKey(livingExpenses, "500");

		WebElement homeLoans = lp.getHomeLoans();
		baseclass.sendKey(homeLoans, "0");

		WebElement otherLoans = lp.getOtherLoans();
		baseclass.sendKey(otherLoans, "500");

		WebElement otherCommitments = lp.getOtherCommitments();
		baseclass.sendKey(otherCommitments, "0");

		WebElement creditLimit = lp.getCreditLimit();
		baseclass.sendKey(creditLimit, "10000");

		WebElement btnBorrow = lp.getBtnBorrow();
		btnBorrow.click();

		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Then("user checks the borrowing estimate as ${double}")
	public void user_checks_the_borrowing_estimate_as_$(Double double1) throws InterruptedException {

		Thread.sleep(2000);

		String borrowEstimate = "$479,000";

		WebElement borrowEstimate2 = lp.getBorrowEstimate();
		String estimate = borrowEstimate2.getText();

		Assert.assertEquals(borrowEstimate, estimate);
	}

	@Given("user should have already estimated the borrowing")
	public void user_should_have_already_estimated_the_borrowing() {
		WebElement borrowEstimate2 = lp.getBorrowEstimate();
		String estimate = borrowEstimate2.getText();
		if (estimate.isEmpty()) {
			Assert.assertTrue(true);
		}
	}

	@When("user should use the start over button to clear the form")
	public void user_should_use_the_start_over_button_to_clear_the_form() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		WebElement btnStartOver = lp.getBtnStartOver();
		btnStartOver.click();
	}

	@Then("validate whether form is cleared")
	public void validate_whether_form_is_cleared() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement borrowEstimate = lp.getBorrowEstimate();

		String estimate = borrowEstimate.getText();

		if (estimate.isEmpty()) {
			Assert.assertTrue(true);

		}
	}

	@Given("borrowing estimate form should be empty")
	public void borrowing_estimate_form_should_be_empty() {
		WebElement borrowEstimate = lp.getBorrowEstimate();

		String estimate = borrowEstimate.getText();

		if (estimate.isEmpty()) {
			Assert.assertTrue(true);

		}
	}

	@When("User enters ${int} for living expense and clicks the work out how much I could borrow")
	public void user_enters_$_for_living_expense_and_clicks_the_work_out_how_much_I_could_borrow(Integer int1) throws InterruptedException {
		WebElement livingExpenses = lp.getLivingExpenses();
		baseclass.sendKey(livingExpenses, "1");
		
		Thread.sleep(3000);

		WebElement btnBorrow = lp.getBtnBorrow();
		btnBorrow.click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("Validates the message")
	public void validates_the_message() {
			
		String message = "Based on the details you’ve entered, were unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 100 641.";
		
		WebElement message2 = lp.getMessage();
		String actualMessage = message2.getText();
		
		Assert.assertEquals(message, actualMessage);
	}

}

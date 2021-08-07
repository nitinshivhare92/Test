package org.locator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.stepdef.BaseClass;

public class LocatorPage1 extends BaseClass {

	public LocatorPage1() {
		PageFactory.initElements(driver, this);
		;
	}

	@FindBy(xpath = "//label[contains(text(),'Single')]")
	private WebElement applicationType;

	@FindBy(xpath = "//select[@title='Number of dependants']")
	private WebElement numberOfDependents;

	@FindBy(xpath = "//label[contains(text(),'Home to live')]")
	private WebElement propertyToBuy;

	@FindBy(xpath = "//input[@aria-labelledby='q2q1']")
	private WebElement yourIncome;

	@FindBy(xpath = "//input[@aria-labelledby='q2q2']")
	private WebElement otherIncome;

	@FindBy(id = "expenses")
	private WebElement livingExpenses;

	@FindBy(id = "homeloans")
	private WebElement homeLoans;

	@FindBy(id = "otherloans")
	private WebElement otherLoans;

	@FindBy(xpath = "//span[@id=\"q3q4i2\"][@class=\"year\"]/preceding-sibling::input")
	private WebElement otherCommitments;

	@FindBy(id = "credit")
	private WebElement creditLimit;

	@FindBy(id = "borrowResultTextAmount")
	private WebElement borrowEstimate;

	@FindBy(xpath = "//span[contains(text(),'Based on the details')]")
	private WebElement message;

	@FindBy(xpath = "(//button[@role=\"button\"][@class=\"start-over\"])[1]")
	private WebElement btnStartOver;

	@FindBy(id = "btnBorrowCalculater")
	private WebElement btnBorrow;

	public WebElement getMessage() {
		return message;
	}

	public WebElement getBtnStartOver() {
		return btnStartOver;
	}

	public WebElement getBorrowEstimate() {
		return borrowEstimate;
	}

	public WebElement getBtnBorrow() {
		return btnBorrow;
	}

	public WebElement getLivingExpenses() {
		return livingExpenses;
	}

	public WebElement getHomeLoans() {
		return homeLoans;
	}

	public WebElement getOtherLoans() {
		return otherLoans;
	}

	public WebElement getOtherCommitments() {
		return otherCommitments;
	}

	public WebElement getCreditLimit() {
		return creditLimit;
	}

	public WebElement getApplicationType() {
		return applicationType;
	}

	public WebElement getYourIncome() {
		return yourIncome;
	}

	public WebElement getOtherIncome() {
		return otherIncome;
	}

	public WebElement getNumberOfDependents() {
		return numberOfDependents;
	}

	public WebElement getPropertyToBuy() {
		return propertyToBuy;
	}

}

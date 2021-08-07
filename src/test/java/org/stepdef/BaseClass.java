package org.stepdef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;

	public void LaunchBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}

	public void LaunchUrl(String URL) {
		driver.get(URL);
	}

	public WebElement FindElementByID(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;

	}

	public WebElement findElementByXpath(String Xpath) {
		WebElement findElement = driver.findElement(By.xpath(Xpath));
		return findElement;

	}

	public void sendKey(WebElement webelement, String Value) {
		webelement.sendKeys(Value);
	}

	public void btnClick(WebElement webelement) {
		webelement.click();

	}
	
	public void dropDownSelect(WebElement element, String text) {
		
		Select select = new Select(element);
		select.selectByVisibleText(text);

	}


}

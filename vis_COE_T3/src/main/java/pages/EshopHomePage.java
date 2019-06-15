package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;

public class EshopHomePage{
	// variables
	WebDriver driver;
	// locators 
	By searchBox= By.id("search-q");
	public EshopHomePage(WebDriver driver) {
		this.driver= driver;

	}
	@Step("Navigate to Website URL")
	public void navigateToURL(String URL) {

		driver.navigate().to(URL);
	}

	//@FindBy(id="search-q")
	//WebElement searchBox;
    @Step("find Elemnt and send text to textbox then click enter")
	public void searchQuery(String text) {
		driver.findElement(searchBox).sendKeys(text);
		driver.findElement(searchBox).sendKeys(Keys.ENTER);
	}
}

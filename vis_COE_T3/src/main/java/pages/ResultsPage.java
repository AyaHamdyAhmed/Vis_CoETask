package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class ResultsPage  {
	// variables
	WebDriver driver;
	// locators
	By searchRes = By.xpath("//p[@class='no-gutter no-gutter--top']//strong[1]");
	public ResultsPage(WebDriver driver) {
		this.driver=driver;
	}

	//@FindBy(xpath = "//p[@class='no-gutter no-gutter--top']//strong[1]")
	//WebElement searchRes;
	@Description("get current url from browser")
	public String checkUrl() {
		String link = driver.getCurrentUrl();
		System.out.println(link);
		return link;
	}
	@Step("verify that search results match expected result")
	public void searchResults(String res) {

		Assert.assertEquals(driver.findElement(searchRes).getText(), res);
	}
}

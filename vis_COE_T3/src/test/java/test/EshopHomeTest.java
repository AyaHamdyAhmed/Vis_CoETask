package test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
//import static org.testng.Assert.assertEquals;

//import java.io.IOException;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;

import data.Browser;
import data.ExcelReader;
import io.qameta.allure.Description;
//import data.ExcelReader;
import pages.EshopHomePage;
import pages.ResultsPage;

public class EshopHomeTest {
	/**
	 * objects
	 * **/
	EshopHomePage homeObject;
	ResultsPage resultObject;
	WebDriver driver;
	//String URL="https://www.vodafone.com.eg/eshop/homePage/index.jsp";
	//String searchKeyword="iPhone";
	//String expectedUrl="https://www.vodafone.com.eg/eshop/Catalogue/Search-Results";
	//String searchres="16";
	@BeforeClass
	@Parameters({"browser"})
	public void beforeClass(String browser) {
		///// test
		System.out.print("browserName  " + browser);
		Browser.setBrowser(browser);
		driver = Browser.getBrowser();
	}

	/**
	 * 
	 * test method 
	 * **/
	@Description("search test with specific product")
	@Test(dataProvider= "EshopData")
	public void userSearch(String URL,String searchKeyword,String expectedUrl,String searchres) {
		homeObject = new EshopHomePage(driver);
		homeObject.navigateToURL(URL);
		System.out.println(URL);
		driver.manage().timeouts().implicitlyWait(200,TimeUnit.SECONDS);
		homeObject.searchQuery(searchKeyword);
		resultObject = new ResultsPage(driver);
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		String url= resultObject.checkUrl();
		System.out.println("Test Url "+url);
		Assert.assertTrue(url.contains(expectedUrl));
		System.out.println(url.contains(expectedUrl));
		resultObject.searchResults(searchres);
	}

	@DataProvider
	public Object[][] EshopData() throws Exception{
		/**
		 * get data from excel reader class
		 * */
		//ExcelReader er = new ExcelReader();
		Object[][] exceldata = ExcelReader.getExcelData();
		//	System.out.println(exceldata);
		//System.out.println("Dataaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		return exceldata;
		//return er.getExcelData();

	}


	/*	@Test(dependsOnMethods= {"userSearch"})
	public void Queryresult() {

	}*/


	@AfterClass
	public void afterClass() {
		driver.close();
	}

}

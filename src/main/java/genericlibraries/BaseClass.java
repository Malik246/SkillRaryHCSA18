package genericlibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pompages.ContactUsPage;
import pompages.CoreJavaForSeleniumPage;
import pompages.CoreJavaVideoPage;
import pompages.HomePage;
import pompages.SeleniumTrainingPage;
import pompages.SkillRaryDemoApppage;
import pompages.TestingPages;

public class BaseClass {

	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected HomePage home;
	protected SkillRaryDemoApppage demoApp;
	protected SeleniumTrainingPage selenium;
	protected TestingPages testing;
	protected CoreJavaForSeleniumPage coreJava;
	protected CoreJavaVideoPage javaVideo;
	protected ContactUsPage contact;

	// @BeforeSuite
	// @BeforeTest
	@BeforeClass
	public void classConfiguration() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		web = new WebDriverUtility();

		property.propertiesInitialization(IConstantPath.PROPERTIES_FILE_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
	}

	@BeforeMethod
	public void methodConfiguration() {
		long time = Long.parseLong(property.fetchProperty("timeouts"));
		driver = web.openApplication(property.fetchProperty("browser"), property.fetchProperty("url"), time);

		home = new HomePage(driver);
		Assert.assertTrue(home.getLogo().isDisplayed());
		demoApp = new SkillRaryDemoApppage(driver);
		selenium = new SeleniumTrainingPage(driver);
		testing = new TestingPages(driver);
		coreJava = new CoreJavaForSeleniumPage(driver);
		javaVideo = new CoreJavaVideoPage(driver);
		contact = new ContactUsPage(driver);
	}

	@AfterMethod
	public void methodTeardown() {
		web.quitBrowser();
	}

	@AfterClass
	public void classTeardown() {
		excel.closeExcel();
	}
}
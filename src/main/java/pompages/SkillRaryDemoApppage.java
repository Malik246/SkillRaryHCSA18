package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibraries.WebDriverUtility;

public class SkillRaryDemoApppage {

	//Declaration 
	@FindBy(xpath="//div[@class='navbar-header']")
	private WebElement pageHeader;
	@FindBy(id="course")
	private WebElement courseTab;
	@FindBy(xpath="//span[@class='wrappers']/a[text()='Selenium Training']")
	private WebElement seleniumTrainingLink;
	@FindBy(xpath="//select[@name='addresstype']")
	private WebElement categoryDropDown;
	@FindBy(xpath="//a[text()='contactUs']")
	private WebElement contactUsLink;
	
	
	//initia`lization
	public SkillRaryDemoApppage(WebDriver driver) {
		PageFactory.initElements( driver,this);
		
	
	}
	//utilization
	public String getPageHeader() {
		return pageHeader.getText();
		
	}
	public void mouseHoverToCourse(WebDriverUtility web) {
		web.mouseHover(courseTab);
		
	}
	public void clickSeleniumTraining() {
	seleniumTrainingLink.click();
	}
	
	public void selectCategory(WebDriverUtility web, int index) {
		web.dropdown(categoryDropDown,index);
	}
	public void clickContactUs() {
		contactUsLink.click();
	}
	public WebElement getContactUs() {
		return contactUsLink;
	
		 
	 }
}

package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestingPages {

//Declaration
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageHeader;
	@FindBy(xpath="//img[@id='java']")
	private WebElement javaImage;
	@FindBy(xpath="//div[@id='cartArea']")
	private WebElement mycartArea;
	@FindBy(xpath="//footer/descendant::i[@class='fa fa-facebook']")
	private WebElement facebookIcon;
	
	//Initialization
	
	public TestingPages(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	
	public WebElement getJavaImage() {
		return javaImage;
	}
	
	public WebElement getMyCartArea() {
		return mycartArea;
	}
	
	public void clickFacebookIcon() {
		facebookIcon.click();
	}

	public WebElement getFacebookIcon() {
	return facebookIcon;
	}
}

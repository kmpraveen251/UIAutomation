package co.test.SeleniumFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import co.test.AbstractComponents.AbstractComponents;

public class HomePage extends AbstractComponents{
	WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="user-name")
	WebElement userName;
	
	@FindBy(id="password")
	WebElement userPassword;
	
	@FindBy(id="login-button")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\"login_button_container\"]//h3")
	WebElement errorMessage;

	
	public ProductPage loginApplication(String userId,String userPwd) {
		//userName
		userName.sendKeys(userId);
		//userPassword
		userPassword.sendKeys(userPwd);
		//click on the Login button
		loginButton.click();
		ProductPage productPage=new ProductPage(driver);
		return productPage;
	}
	
	public void gotoLandingPage() {
		if(driver!=null) {
			driver.get("https://www.saucedemo.com/");
		}
	}
	
	public String getErrorMessage() {
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}

package co.test.SeleniumFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.test.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{
	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="first-name")
	WebElement userFirstName;
	
	@FindBy(id="last-name")
	WebElement userLastName;
	
	@FindBy(id="postal-code")
	WebElement userPostalCode;
	
	@FindBy(id="continue")
	WebElement continueButton;
		
	
	public CheckoutOverviewPage inputUserDetailsInCheckoutPage() {
		userFirstName.sendKeys("testFirstname");
		userLastName.sendKeys("testLastname");
		userPostalCode.sendKeys("00-00-01");
		continueButton.click();
		CheckoutOverviewPage checkoutOverviewPage=new CheckoutOverviewPage(driver);
		return checkoutOverviewPage;
	}
}

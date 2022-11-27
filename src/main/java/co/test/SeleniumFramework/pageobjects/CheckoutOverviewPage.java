package co.test.SeleniumFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.test.AbstractComponents.AbstractComponents;

public class CheckoutOverviewPage extends AbstractComponents{
	WebDriver driver;
	public CheckoutOverviewPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h2[contains(@class,'complete-header')]")
	WebElement pageTitle;
	
	@FindBy(id="finish")
	WebElement finishButton;

	public ConfirmationPage clickOnFinishButton() {
		
		finishButton.click();
		waitForWebElementToAppear(pageTitle);
		ConfirmationPage confirmationPage=new ConfirmationPage(driver);
		return confirmationPage;
	}
}

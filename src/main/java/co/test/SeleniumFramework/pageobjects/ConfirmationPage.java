package co.test.SeleniumFramework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.test.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//h2[contains(@class,'complete-header')]")
	WebElement confirmationHeader;
	
	@FindBy(id="back-to-products")
	WebElement gotToHomePage;
	
	public String getConfirmationPage() {
		return confirmationHeader.getText().trim();
	}
	
	public void goToHomePage() {
		gotToHomePage.click();
	}
		
}

package co.test.SeleniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.test.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[contains(@class,'cart_list')]/div[contains(@class,'cart_item')]//a")
	List<WebElement> cartPageProductItems;
	
	@FindBy(xpath="//*[@id='header_container']//span")
	WebElement headerContent;

	
	@FindBy(id="checkout")
	WebElement checkoutButton;
	
	public Boolean verifyProductMatch(String productName) {
		Boolean match=cartPageProductItems.stream().anyMatch(cartProduct->cartProduct.getText().trim().equals(productName));
		return match;
	}
	
	public CheckoutPage clickOnCheckout() {
		checkoutButton.click();
		waitForWebElementToAppear(headerContent);
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		return checkoutPage;

	}
		
}

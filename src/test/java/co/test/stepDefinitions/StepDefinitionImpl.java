package co.test.stepDefinitions;

import java.io.IOException;
import org.testng.Assert;

import co.TestComponents.BaseTest;
import co.test.SeleniumFramework.pageobjects.CartPage;
import co.test.SeleniumFramework.pageobjects.CheckoutOverviewPage;
import co.test.SeleniumFramework.pageobjects.CheckoutPage;
import co.test.SeleniumFramework.pageobjects.ConfirmationPage;
import co.test.SeleniumFramework.pageobjects.HomePage;
import co.test.SeleniumFramework.pageobjects.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImpl extends BaseTest{

	public HomePage landingPage;
	public ProductPage productPage;
	public CartPage cartPage;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage = launchApplication();
	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		productPage = landingPage.loginApplication(username,password);
	}
		
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		//products page and AddToCart
		productPage.getProductByNameAndAddtoCart(productName);
		//click on the cart link
		cartPage=productPage.clickOnTheCartContainer();
	}
		
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName)
	{
		CartPage cartPage = productPage.clickOnTheCartContainer();
		//navigate to Cart page
		boolean match=cartPage.verifyProductMatch(productName);
		//validation product matches or not
		Assert.assertEquals(match,true);
		
		//click on the checkout button
		CheckoutPage checkoutPage=cartPage.clickOnCheckout();
		
		//input the userDetails in checkout page
		CheckoutOverviewPage checkoutOverviewPage=checkoutPage.inputUserDetailsInCheckoutPage();
		confirmationPage=checkoutOverviewPage.clickOnFinishButton();
	}
	
    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String confirmationMessage)
    {
		//verify the confirmation
		Assert.assertEquals(confirmationPage.getConfirmationPage(),confirmationMessage);
		confirmationPage.goToHomePage();
		driver.close();
    }
    
    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
       	Assert.assertEquals(strArg1, landingPage.getErrorMessage());
    }
       
}

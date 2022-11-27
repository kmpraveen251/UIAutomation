package co.test.SeleniumFramework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import co.test.AbstractComponents.AbstractComponents;

public class ProductPage extends AbstractComponents{
	WebDriver driver;
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[contains(@class,'inventory_list')]/div[contains(@class,'inventory_item')]")
	List<WebElement> products;
	
	@FindBy(id="shopping_cart_container")
	WebElement cartContainer;
	
	By productsBy=By.xpath("//div[contains(@class,'inventory_list')]/div[contains(@class,'inventory_item')]");
	
	public List<WebElement> getProductList() {
		waitForElementToVisible(productsBy);
		return products;
	}
	
	public void getProductByNameAndAddtoCart(String productName) {
		String strProductName = null;
		List<WebElement> products=getProductList();
		for(int i=1;i<=products.size();i++) {
			strProductName=driver.findElement(By.xpath("//div[contains(@class,'inventory_list')]/div["+i+"]//div[contains(@class,'inventory_item_name')]")).getText().trim();
			if(strProductName.equals(productName)) {
				//click on the Add to Cart button
				driver.findElement(By.xpath("//div[contains(@class,'inventory_list')]/div["+i+"]//button[contains(@class,'btn_primary')]")).click();
				//wait until Remove button appear on this page
				waitForElementToVisible(By.xpath("//div[contains(@class,'inventory_list')]/div["+i+"]//button[contains(@id,'remove-sauce-labs')]"));
			}
		}
	}
	
	public CartPage clickOnTheCartContainer() {
		cartContainer.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}
		
}

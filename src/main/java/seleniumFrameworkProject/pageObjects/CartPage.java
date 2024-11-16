package seleniumFrameworkProject.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkProject.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
	
	
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//ul[@class='cartWrap ng-star-inserted']")
	List<WebElement> we;
	
	@FindBy(xpath="//div/div/button[contains(text(),'Buy Now')]")
	WebElement BuyNow;
	
	By addedProduct = By.xpath("//div[@class='cart']//div[@class='cartSection']//h3");
	 
	public Boolean verifyItemAddedToCart(String productName) {
		Boolean b = we.stream().anyMatch(s->s.findElement(addedProduct).getText().equalsIgnoreCase(productName));
		return b;
	}
	
	public CheckOutPage CheckoutNow() {
		BuyNow.click();
		CheckOutPage co = new CheckOutPage(driver);
		return co;
	}
//	List<WebElement> we = driver.findElements(By.);
//	System.out.println(we);
//	WebElement orderproduct = we.stream().filter(pro->pro.findElement(By.xpath(xp)).getText().equals(productName)).findFirst().orElse(null);
//	String itmeNumber = orderproduct.findElement(By.className("itemNumber")).getText();
	
	
	

}

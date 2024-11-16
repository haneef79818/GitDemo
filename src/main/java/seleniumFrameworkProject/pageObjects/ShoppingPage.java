package seleniumFrameworkProject.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkProject.AbstractComponents.AbstractComponents;

public class ShoppingPage extends AbstractComponents {
	
WebDriver driver;
	
	public ShoppingPage(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy (css = ".mb-3")
	List<WebElement> wb;
	
	@FindBy(css ="b")
	WebElement bc;
	By product = By.cssSelector(".mb-3");
	By tag = By.cssSelector("b");
	By button = By.cssSelector(".card-body button:last-of-type");
	By ele1 = By.xpath("//div[contains(text(),'Product Added To Cart')]");
	By ele2 = By.xpath("//div[contains(@class,'ng-trigger ng-trigger')]");
	
//This is the example for the below piece of code
	
//	List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
//	WebElement text =	
//	products.stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
//	text.findElement(By.xpath("//button[contains(text(),'Add To Cart')]")).click();
	
	public List<WebElement> getProductList(){
		waitUntilElementVisible(product);
		return wb;		
	}	
	
//	WebElement text =	
//			products.stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
//			text.findElement(By.xpath("//button[contains(text(),'Add To Cart')]")).click();
	
	public void addProductToCart(String productName) {
	
		List<WebElement> wb = getProductList();
		System.out.println(wb);
		WebElement w = wb.stream().filter(p->{ WebElement element = p.findElement(tag); String text = element.getText(); System.out.println("Comparing: " + text + " with " + productName); return text.equals(productName);}).findFirst().orElse(null);
		w.findElement(button).click();
		waitUntilElementVisible(ele1);
		WaitUntilElementIsInvisible(ele2);
		System.out.println(w);	
		
	}
	
	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Product Added To Cart')]")));
	//wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'ng-trigger ng-trigger')]")));

}

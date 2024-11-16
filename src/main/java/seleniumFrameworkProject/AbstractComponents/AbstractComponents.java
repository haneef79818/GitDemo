package seleniumFrameworkProject.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumFrameworkProject.pageObjects.CartPage;
import seleniumFrameworkProject.pageObjects.OrdersPage;

public class AbstractComponents {
	
	WebDriver driver;
	WebDriverWait wait ;
	public AbstractComponents(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	
	
	@FindBy(xpath= "//button[@routerlink='/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(xpath="//button[@routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	public void waitUntilElementVisible(By findBy) {
		//This method will wait for 5 sec or until the element is visible in the  UI.	
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	}
	
	public void WaitUntilElementIsInvisible(By findBy){
		//This method will wait for 5sec or until the element is invisible
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
		
	}
	
	public void waitUntilElementVisible(WebElement findby) {
		//This method will wait for 5 sec or until the element is visible in the  UI.	
	wait.until(ExpectedConditions.visibilityOf(findby));
	
	}
	
	public CartPage ClickOnGlobalCart() {
		
		cartButton.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
	
	public OrdersPage clickOnOrderHeader() {
		orderHeader.click();
		OrdersPage op = new OrdersPage(driver);
		return op;
	}
	
	

}

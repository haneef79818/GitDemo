package seleniumFrameworkProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkProject.AbstractComponents.AbstractComponents;

public class CheckOutPage extends AbstractComponents{
WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@placeholder='Select Country']")
		WebElement countryBox;
	@FindBy (xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement countryInOption;
	@FindBy (xpath="//a[contains(@class,'submit')]")
	WebElement submit;
	By ele1 = By.xpath("//section[contains(@class,'list-group ng')]");
	
	
	public void selectCountry() {
		countryBox.sendKeys("india");
////	Select sc = new Select(driver.findElement(By.xpath("//section[contains(@class,'list-group ng')]")));
////	sc.selectByVisibleText(" India");//span[text()=' India']
		waitUntilElementVisible(ele1);
//	//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//section[contains(@class,'list-group ng')]")));
		countryInOption.click();
//	driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	}
	
	public ConfirmationPage placeOrder() {
		submit.click();
		ConfirmationPage ccp = new ConfirmationPage(driver);
		return ccp;
	}
	

}

package seleniumFrameworkProject.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkProject.AbstractComponents.AbstractComponents;

public class LandingPageClass extends AbstractComponents {
	
	WebDriver driver;
	
	public LandingPageClass(WebDriver driver){
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
    @FindBy(id = "userEmail")
    WebElement userEmail;
    
    //driver.findElement(By.id("userEmail")).sendKeys("test.user7981@gmail.com");
    
    @FindBy(id = "userPassword")
    WebElement userPassword;
	//driver.findElement(By.id("userPassword")).sendKeys("Demo@123");
    @FindBy(name = "login")
    WebElement login;
    @FindBy(css=".toast-error")
    WebElement errorPopUp;
	//driver.findElement(By.name("login")).click();
    //driver.get("https://rahulshettyacademy.com/client");
    public void goTo(String URL)
    {
    	driver.get(URL);
    }
    
    public ShoppingPage login(String usname, String uspwd) throws InterruptedException
    {
    	userEmail.sendKeys(usname);
    	Thread.sleep(5000);
    	userPassword.sendKeys(uspwd);
    	login.click();
    	ShoppingPage sp = new ShoppingPage(driver);
		return sp;
    }
    
    public void clickOnOrderPage() {
    	
    }
    
    public String getLoginFailedMessage() {
    	waitUntilElementVisible(errorPopUp);
    	String message = errorPopUp.getText();
    	return message;
    }


}

package seleniumFrameworkProject.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumFrameworkProject.AbstractComponents.AbstractComponents;

public class OrdersPage extends AbstractComponents{

	WebDriver driver;
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//tr /td")
	List<WebElement> we;
	
	public Boolean getOrderDetails(String ProductName) {
		
		Boolean prop = we.stream().map(s->s.getText().equals(ProductName)).findFirst().orElse(null);
		return prop;
		
	}

	
	
}



package seleniumFrameworkProject;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.Files;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import seleniumFrameworkProject.TestComponents.BaseTest;
import seleniumFrameworkProject.pageObjects.CartPage;
import seleniumFrameworkProject.pageObjects.CheckOutPage;
import seleniumFrameworkProject.pageObjects.ConfirmationPage;
import seleniumFrameworkProject.pageObjects.LandingPageClass;
import seleniumFrameworkProject.pageObjects.OrdersPage;
import seleniumFrameworkProject.pageObjects.ShoppingPage;

public class StandAloneTest extends BaseTest {
	String productName = "ADIDAS ORIGINAL";
	@Test(dataProvider = "getData")
	public  void placeOrder(HashMap<String, String> input) throws IOException, InterruptedException {
		
		ShoppingPage sp = Landingpage.login(input.get("userName"), input.get("password"));		
		sp.addProductToCart(productName);
		CartPage cp = sp.ClickOnGlobalCart();
		Boolean prod = cp.verifyItemAddedToCart(input.get("product"));
		Assert.assertTrue(prod);
		CheckOutPage co = cp.CheckoutNow();		
		co.selectCountry();
		ConfirmationPage ccp = co.placeOrder();
		String Str2 = ccp.readConfirmationMeassage();
		Assert.assertTrue(Str2.trim().equalsIgnoreCase("Thankyou for the order."));
		System.out.println("Order has been placed successfully");
		
	}
	
	@Test(dependsOnMethods = {"placeOrder"})
	public void verifyOrder() throws InterruptedException {
		Landingpage.login("test.user7981@gmail.com", "Demo@123");
		OrdersPage op = Landingpage.clickOnOrderHeader();
		Thread.sleep(3);
		op.getOrderDetails(productName);
		
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException {		
		List<HashMap<String,String>> data = dataProvider(System.getProperty("user.dir")+"//src//test//java//data//data.json");
		return new Object[][] {{data.get(0)}};
	}
	

}

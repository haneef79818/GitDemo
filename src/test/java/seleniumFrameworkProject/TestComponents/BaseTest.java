package seleniumFrameworkProject.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumFrameworkProject.pageObjects.LandingPageClass;

public class BaseTest {
	public WebDriver driver;
	String URL;
	public LandingPageClass Landingpage ;
	public  WebDriver initializeDriver() throws IOException {		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/seleniumFrameworkProject/resources/GolbalData.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("ChromeBrowser")) {
			WebDriverManager.chromedriver().setup();		
		 driver = new ChromeDriver();
		}
		URL = prop.getProperty("URL");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();	
		
		return driver;
	}
	@BeforeMethod
	public LandingPageClass lunchApplication() throws IOException {
		driver = initializeDriver();
		Landingpage = new LandingPageClass(driver);
		Landingpage.goTo(URL);
		return Landingpage;
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.quit();
	}
	
public List<HashMap<String, String>> dataProvider(String filePath) throws IOException {
		
		String jsonData = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		ObjectMapper  mapper = new ObjectMapper();
		List<HashMap<String,String>> jasonData1 = mapper.readValue(jsonData, new TypeReference<List<HashMap<String,String>>>(){});
		return jasonData1;
	}

public String takeScreenShot(String screenshot, WebDriver driver) throws IOException {
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	String filePath= System.getProperty("user.dir")+"//src//test//java//data//" + screenshot+".png";
	File dest = new File(filePath);
	FileUtils.copyFile(source, dest);
	return filePath;
}

}

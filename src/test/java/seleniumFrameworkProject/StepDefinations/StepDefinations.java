package seleniumFrameworkProject.StepDefinations;

import java.io.IOException;

import io.cucumber.java.en.Given;
import seleniumFrameworkProject.TestComponents.BaseTest;
import seleniumFrameworkProject.pageObjects.LandingPageClass;
import seleniumFrameworkProject.pageObjects.ShoppingPage;

public class StepDefinations extends BaseTest {
	LandingPageClass lp;
	ShoppingPage sp;
	@Given("^user should be landed on the Login page.$")
	public void user_should_be_landed_on_the_login_page() throws IOException {
		lp = lunchApplication();
	}
	
	@Given("^Login with (.+) and (.+)$")
	public void login_with_userName_and_password(String userName, String password) throws InterruptedException {
		 sp= lp.login(userName, password);
	}
	

}

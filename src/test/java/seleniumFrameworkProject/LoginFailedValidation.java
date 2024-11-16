package seleniumFrameworkProject;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumFrameworkProject.TestComponents.BaseTest;
import seleniumFrameworkProject.pageObjects.ShoppingPage;

public class LoginFailedValidation extends BaseTest {
	@Test
	public void verifyLoginFailed() throws InterruptedException {

		 Landingpage.login("test.user7981@gmail.com", "Dem@123");
		String message = Landingpage.getLoginFailedMessage();		
		Assert.assertTrue(message.equalsIgnoreCase("Incorrect email or password."));
	}

}

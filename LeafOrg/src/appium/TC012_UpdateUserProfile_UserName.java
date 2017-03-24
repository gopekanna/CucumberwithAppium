package appium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;

public class TC012_UpdateUserProfile_UserName {
	
	public static AndroidDriver<WebElement> driver ;
	String user = "sakthivel@testleaf.com";
	String cPass = "XXXXXXXXX";
	
	@Given("^User on Login screen$")
	public void LoginScreen() throws MalformedURLException, InterruptedException  {
	
		File targetApp = new File("/Users/gopikannan/Downloads/LeafOrg.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName", "RQ30011RJZ");
//		capabilities.setCapability("fullReset", "true");
		capabilities.setCapability("app", targetApp.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.testleaf.leaforg");
		capabilities.setCapability("appActivity", "com.testleaf.leaforg.MainActivity");

		driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
	}
	
	@When("^User enters Username and Password$")	
	public void EnterUserDetails() throws Throwable {
		Thread.sleep(5000);
		Set<String> contextNames = driver.getContextHandles();

		for (String contextName : contextNames) {

			if (contextName.contains("WEBVIEW"))
				driver.context(contextName);				

		}
		Thread.sleep(5000);
		WebDriverWait wait= new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(text(),'Create an Account')]")));
		driver.findElementByXPath("(//input[@formcontrolname='email'])").sendKeys(user);
		driver.findElementByXPath("(//input[@formcontrolname='password'])").sendKeys(cPass);
	}
	
	@Then("^User click the Login button")
	public void ClickLogin() throws InterruptedException
	{
	driver.findElementByXPath("//span[contains(text(),'Login')]").click();
	Thread.sleep(5000);
	}
	
	@And("^Click the settings menu")
	public void ClickSettings() throws InterruptedException
	{
		WebDriverWait wait= new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//Span[contains(text(),'Settings')]")));
		driver.findElementByXPath("//Span[contains(text(),'Settings')]").click();
		Thread.sleep(5000);
		
	}
	
	@When("^User Click Logout$")
	public void Logout() throws InterruptedException, IOException
	{
		driver.findElementByXPath("//Span[contains(text(),'LOGOUT')]").click();
		Thread.sleep(5000);
	}
	
	@Then("^User Click Yes Logout")
	public void ConfirmLogout() throws InterruptedException, IOException
	{
		driver.findElementByXPath("//Span[contains(text(),'Yes')]").click();
		Thread.sleep(5000);
	}
	
	

}

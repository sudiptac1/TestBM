package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.junit.Assert;
import pageObjects.BPLogin_Page;


import org.apache.log4j.Logger;



	public class loginfeature {
		
		private final static Logger logger = Logger.getLogger(loginfeature.class);
		WebDriver driver = null;

		@Before
		public void StartBrowser() {
			System.setProperty("webdriver.chrome.driver", "Lib//chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			logger.info("browser starting");
		}

		@After
		public void quitBrowser() {
			driver.quit();
		}

		@Given("^I am in BMJ bestpractice login page$")
		public void i_am_in_BMJ_login_page() throws Throwable {
			driver.get("https://bestpractice.bmj.com/login");
			
			logger.info("At BMJ bestpractice Login page");
		    
		}
		
		@When("^I enter invalid email and invalid password$")
		public void i_enter_invalid_email_and_invalid_password() throws Throwable {
		  
			
			BPLogin_Page logInPage = new BPLogin_Page();
			logInPage.ele_UserEmail(driver).sendKeys("abc@abc.com");
			logInPage.ele_UserPass(driver).sendKeys("pass");
		 
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("window.scrollBy(0,400)");
			
			WebElement element1 = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".form-group #loginSubmit")));

			logInPage.btn_LogIn(driver).click();
			logger.info("Login Button clicked  with invalid credentials at BMJ bestpractice Login page");
		}
		
		@Then("^I see the error message \"([^\"]*)\"$")
		public void i_see_the_error_message(String arg1) throws Throwable {
		    
			BPLogin_Page logInPage = new BPLogin_Page();
			
			String actualStrlogInPage = logInPage.ele_LoginFailed(driver).getAttribute("innerText");
			Assert.assertEquals("Error messages are not matching", arg1, actualStrlogInPage);
		}


}
	

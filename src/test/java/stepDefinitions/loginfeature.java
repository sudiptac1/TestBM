package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
			//driver.quit();
		}

		@Given("^I am in BMJ bestpractice login page$")
		public void i_am_in_BMJ_login_page() throws Throwable {
			driver.get("https://bestpractice.bmj.com/login");
			
			logger.info("At BMJ bestpractice Login page");
		    
		}
		
		@When("^I enter invalid credentials$")
		public void i_enter_invalid_credentials() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			//driver.manage().window().maximize();
			System.out.println("window size"+driver.manage().window().getSize());
			driver.manage().window().fullscreen();
			BPLogin_Page logInPage = new BPLogin_Page();
			logInPage.ele_UserEmail(driver).sendKeys("abc@abc.com");
			logInPage.ele_UserPass(driver).sendKeys("pass");
		    //loginSubmit
			
			logInPage.btn_CookiDis(driver).click();
			System.out.println("window size2"+driver.manage().window().getSize());
			WebElement element1 = (new WebDriverWait(driver, 10))
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".form-group #loginSubmit")));

			logInPage.btn_LogIn(driver).click();
			logger.info("Login Button clicked  with invalid credentials at BMJ bestpractice Login page");
		}
		
		@Then("^I should not be logged in$")
		public void i_should_not_be_logged_in() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    
		}
		
		@Then("^I get error message$")
		public void i_get_error_message() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		    
		

	}


}

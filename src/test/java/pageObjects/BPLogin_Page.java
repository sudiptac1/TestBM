package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BPLogin_Page {
	
	
		private WebElement element = null;

		public WebElement ele_UserEmail(WebDriver driver) {

			element = driver.findElement(By.id("lfInputEmail"));

			return element;

		}
		
		public WebElement ele_UserPass(WebDriver driver) {

			element = driver.findElement(By.id("lfInputPass"));

			return element;

		}
		
		public WebElement btn_LogIn(WebDriver driver) {

			element = driver.findElement(By.cssSelector(".form-group #loginSubmit"));

			return element;

		}
		//cc-btn cc-dismiss
		public WebElement btn_CookiDis(WebDriver driver) {

			element = driver.findElement(By.cssSelector(".cc-btn cc-dismiss"));

			return element;

		}
	}


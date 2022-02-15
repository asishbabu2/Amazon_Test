package MyPkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AmazonLogin {
	WebDriver driver;
        WebDriverWait wait;
	
	public AmazonLogin(WebDriver driver) {
		this.driver = driver;
	}
	By signinButton = By.xpath("(//*[text()='Hello, Sign in'])[1]");
	By emailID = By.xpath("//input[@name='email']");
	By continueButton = By.xpath("//input[@id='continue']");
	By password = By.xpath("//input[@name='password']");
	By submit = By.xpath("//input[@id='signInSubmit']");

	public void Email(String email) {
		wait = new WebDriverWait(driver, 20);
		WebElement we1 = wait.until(ExpectedConditions.visibilityOfElementLocated(signinButton));
		we1.click();
		WebElement we2 = wait.until(ExpectedConditions.visibilityOfElementLocated(emailID));
		we2.sendKeys(email);
		WebElement we3 = wait.until(ExpectedConditions.visibilityOfElementLocated(continueButton));
		we3.click();
	}
	public void password(String Password) {
		wait = new WebDriverWait(driver, 20);
		WebElement we2 = wait.until(ExpectedConditions.visibilityOfElementLocated(password));
		we2.sendKeys(Password);
		WebElement we3 = wait.until(ExpectedConditions.visibilityOfElementLocated(submit));
		we3.click();
	}
}

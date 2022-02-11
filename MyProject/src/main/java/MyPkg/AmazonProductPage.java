package MyPkg;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonProductPage {

	WebDriver driver;
	WebDriverWait wait;

	public AmazonProductPage(WebDriver driver) {
		this.driver = driver;
	}

	By addtocart = By.xpath("//input[@id='add-to-cart-button']");

	public void addToCart() {
		wait = new WebDriverWait(driver, 20);
		String handle = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		handles.remove(handle);
		String newhandle1 = handles.iterator().next();
		driver.switchTo().window(newhandle1);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement we5 = wait.until(ExpectedConditions.visibilityOfElementLocated(addtocart));
		js.executeScript("arguments[0].scrollIntoView();", we5);
		we5.click();
	}
}

package utilityClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	
	public WebDriverWait wait;

	public void elementToBeClickableWait(WebDriver driver, WebElement element) {
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void elementToBeSelectedWaait(WebDriver driver, WebElement element) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void presenceOfElementsLocatedByName(WebDriver driver, String locator) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(locator)));
	}

	public void presenceOfElementsLocatedByXpath(WebDriver driver, String locator) {
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

}

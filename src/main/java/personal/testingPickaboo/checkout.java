package personal.testingPickaboo;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkout {
	WebDriver driver;

	public checkout(WebDriver x) {
		this.driver = x;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='Button__StyledBtn-sc-55nib8-0 kjtuoW dc-btn'] //a //span")
	WebElement checkoutbuttonElement;

	@FindBy(xpath = "//div[@class='logo col-sm-2'] //a")
	WebElement pickaboologoElement;
	
	public void proceedToCheckout() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(checkoutbuttonElement));
		
		checkoutbuttonElement.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(checkoutbuttonElement));
		checkoutbuttonElement.click();
		
		assertTrue(driver.getTitle().contains("Payment | Pickaboo"));
		
		pickaboologoElement.click();
	}

}

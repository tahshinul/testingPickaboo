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

public class submenu {
	WebDriver driver;

	public submenu(WebDriver x) {
		this.driver = x;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='sub-items'] //p")
	WebElement subbeforeexpandElement;

	@FindBy(xpath = "//div[@class='sub-items menu-open'] //p")
	WebElement subafterexpandElement;
	
	@FindBy(xpath = "//div[@class='sub-items menu-open'] //li")
	List<WebElement> expandeditemsElements;
	
	public void expandMenu() {
		subbeforeexpandElement.click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOf(expandeditemsElements.get(0)));
		System.out.println("Submenu items "+expandeditemsElements.size());
		expandeditemsElements.get(0).click();
	}

}

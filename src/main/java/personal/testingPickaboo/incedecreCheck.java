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

public class incedecreCheck {
WebDriver driver;
	
	public incedecreCheck ( WebDriver x ) {
		this.driver =x;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "(//div[@class='CounterStyle__CounterBox-sc-lgbdny-0 fnGLlG'] //button)[2]")
	WebElement plusElement;
	
	@FindBy(xpath = "(//span[@class='CounterStyle__CounterValue-sc-lgbdny-2 kuFuNi'])[2]")
	WebElement valuElement;
	
	public void increment() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(plusElement));		
		plusElement.click();
		int x = Integer.parseInt(valuElement.getText());
		if (x>1) {
			assertTrue(true);
		}
		else {
			assertTrue(false);
		}
		
	}
	
	
	
	
	
}

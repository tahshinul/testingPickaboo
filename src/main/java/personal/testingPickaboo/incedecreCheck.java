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

	public incedecreCheck(WebDriver x) {
		this.driver = x;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//div[@class='CounterStyle__CounterBox-sc-lgbdny-0 fnGLlG'] //button //img)[2]")
	WebElement plusElement;

	@FindBy(xpath = "(//span[@class='CounterStyle__CounterValue-sc-lgbdny-2 kuFuNi'])[2]")
	WebElement valuElement;

	@FindBy(xpath = "//div[@class='MyProgressBar__StyledMain-sc-jbihv8-0 gRkhKd']")
	WebElement progressElement;

	@FindBy(xpath = "(//div[@class='CounterStyle__CounterBox-sc-lgbdny-0 fnGLlG'] //button //img)[1]")
	WebElement minusElement;

	public void increment() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(plusElement));
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait2.until(ExpectedConditions.invisibilityOf(progressElement));
		int y = Integer.parseInt(valuElement.getText());
		System.out.println("ekhon item " + y + "ta");
		plusElement.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait1.until(ExpectedConditions.elementToBeClickable(plusElement));
		WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait12.until(ExpectedConditions.invisibilityOf(progressElement));
		int x = Integer.parseInt(valuElement.getText());
		if (x > y) {
			assertTrue(true);
			System.out.println("ekhon item " + x + "ta");
		} else {
			assertTrue(false);
		}

	}

	public void decrement() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(minusElement));
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait2.until(ExpectedConditions.invisibilityOf(progressElement));
		int y = Integer.parseInt(valuElement.getText());
		System.out.println("ekhon item " + y + "ta");
		minusElement.click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait1.until(ExpectedConditions.elementToBeClickable(minusElement));
		WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait12.until(ExpectedConditions.invisibilityOf(progressElement));
		int x = Integer.parseInt(valuElement.getText());
		if (x < y) {
			assertTrue(true);
			System.out.println("ekhon item " + x + "ta");
		} else {
			assertTrue(false);
		}

	}

}

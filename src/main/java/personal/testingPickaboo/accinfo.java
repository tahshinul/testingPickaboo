package personal.testingPickaboo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.description.NamedElement;

public class accinfo {
	WebDriver driver;

	public accinfo(WebDriver x) {
		this.driver = x;

		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "(//h2[@class='Title__StyledTitle-sc-gk5zya-0 dCwtgO title'])[1]")
	WebElement manageaccElement;
	
	@FindBy(xpath = "(//h2[@class='Title__StyledTitle-sc-gk5zya-0 dCwtgO title'])[2]")
	WebElement nextElement;

	@FindBy(xpath = "//div[@class='Button__StyledBtn-sc-55nib8-0 hTAfjy dc-btn'] //a //span")
	WebElement editbuttonElement;
	
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiInput-input'])[1]")
	WebElement nameinput;
	
	@FindBy(xpath = "//div[@class='Button__StyledBtn-sc-55nib8-0 bXDtfW dc-btn'] //a //span")
	WebElement savebuttonElement;
	
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiInput-input Mui-disabled Mui-disabled'])[1]")
	WebElement namElement;
	
	@FindBy(xpath = "//div[@class='MyProgressBar__StyledMain-sc-jbihv8-0 gRkhKd']")
	WebElement progressElement;
	
	public void upadate(String x) {
		System.out.println("Ager name = "+namElement.getAttribute("value"));		
		editbuttonElement.click();
		nameinput.clear();
		nameinput.sendKeys(x);
		savebuttonElement.click();
		manageaccElement.click();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		nextElement.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.invisibilityOf(progressElement));
		manageaccElement.click();
		System.out.println("Notun name = "+namElement.getAttribute("value"));
		assertEquals(namElement.getAttribute("value"), x);
	}

}

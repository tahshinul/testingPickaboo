package personal.testingPickaboo;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class buynow {
WebDriver driver;
	
	public buynow ( WebDriver x ) {
		this.driver =x;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//div[@class='Button__StyledBtn-sc-55nib8-0 jhQlOz dc-btn']")
	WebElement buybutton;
	
	
	public void checkbuynow() {
		WebElement required = driver.findElement(By.xpath("//div[@class='ColorSection__StyledSection-sc-ksmhhv-0 ceJa-D'] //label[@class='MuiFormLabel-root text-view Mui-required']"));
        driver.findElement(RelativeLocator.with(By.className("views")).toRightOf(required)).click();
        buybutton.click();
	}
	
	
	
}

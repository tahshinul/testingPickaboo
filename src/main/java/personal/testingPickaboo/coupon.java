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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class coupon {
WebDriver driver;
	
	public coupon ( WebDriver x ) {
		this.driver =x;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//button[.='Apply Discount Code']")
	WebElement xpandDiscountpanel;
	
	@FindBy (xpath = "//input[@placeholder='Enter Voucher Code']")
	WebElement textfieldElement;
	
	@FindBy (xpath = "//div[@class='Button__StyledBtn-sc-55nib8-0 EzMEX dc-btn'] //span")
	WebElement applybutton;
	
	@FindBy (xpath = "//div[@class='MuiSnackbar-root MuiSnackbar-anchorOriginBottomLeft']")
	WebElement barElement;
	
	@FindBy (xpath = "//div[@class='MuiSnackbar-root MuiSnackbar-anchorOriginBottomLeft'] //div[@class='MuiAlert-message']")
	WebElement barelementtext;
	
	public void applyCoupon() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.elementToBeClickable(xpandDiscountpanel));
		xpandDiscountpanel.click();
		textfieldElement.sendKeys("abc");
		applybutton.click();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait2.until(ExpectedConditions.visibilityOf(barElement));
		System.out.println(barelementtext.getText());
		driver.navigate().to("http://pickaboo.com/");
		
	}
	
	
	
	
	
}

package personal.testingPickaboo;

import org.apache.hc.core5.http.io.entity.StringEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class landingPage {
	
	WebDriver driver;
	
	public landingPage ( WebDriver x ) {
		this.driver =x;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInput-input']")
	WebElement email;
	
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInput-input MuiInputBase-inputAdornedEnd']")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text custom-buttons']")
	WebElement submit;
	
	
	public void loginAction(String mail,String pass) {
		email.sendKeys(mail);
		password.sendKeys(pass);
		submit.click();
	}
	
	public void goToLogin() {
		driver.get("http://pickaboo.com/");
		driver.findElement(By.xpath("//div[@class='Button__StyledBtn-sc-55nib8-0 eUtGXp dc-btn']")).click();
	}
	
	public void verifylogin() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertEquals(driver.getTitle(), "Pickaboo: Your Trusted Partner for Hassle-Free Online Shopping");
	}
	

}

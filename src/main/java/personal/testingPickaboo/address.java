package personal.testingPickaboo;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.asn1.tsp.ArchiveTimeStampSequence;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.description.NamedElement;

public class address {
	WebDriver driver;

	public address(WebDriver x) {
		this.driver = x;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//h2[@class='Title__StyledTitle-sc-gk5zya-0 dCwtgO title'])[7]")
	WebElement manageadressElement;

	@FindBy(xpath = "(//div[@class='default-address-grid-section-white'] //h2)[4]")
	WebElement actualadressElement;

	@FindBy(xpath = "//div[@class='default-address-grid-section-white'] //h2[@class='Title__StyledTitle-sc-gk5zya-0 cgrHOf title']")
	WebElement editadressbuttonElement;

	@FindBy(xpath = "//div[@class='MuiFormControl-root MuiTextField-root input-field'] //input")
	WebElement inputfElement;

	@FindBy(xpath = "//div[@class='ButtonSubmit__StyledBtnSubmit-sc-lv78mv-0 bCHWUx dc-btn'] //button //span[normalize-space()='Save Address']")
	WebElement savebuttonElement;

	@FindBy(xpath = "//div[@class='MyProgressBar__StyledMain-sc-jbihv8-0 gRkhKd']")
	WebElement progressElement;

	@FindBy(xpath = "(//h2[@class='Title__StyledTitle-sc-gk5zya-0 dCwtgO title'])[2]")
	WebElement nextElement;

	@FindBy(xpath = "(//div[@class='MuiInputBase-root MuiInput-root MuiInput-underline input-field'] //input)[1]")
	WebElement namelElement;

	public void upadateExistingAdress(String x) {
		manageadressElement.click();
		System.out.println("ager address = " + actualadressElement.getText());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		
		editadressbuttonElement.click();
		inputfElement.click();
		inputfElement.clear();
		inputfElement.sendKeys(x);

		namelElement.click();
		
		wait.until(ExpectedConditions.elementToBeClickable(savebuttonElement));
		savebuttonElement.click();
		

//		nextElement.click();
		wait.until(ExpectedConditions.invisibilityOf(progressElement));

//		manageadressElement.click();
		System.out.println("ekhonkar address = " + actualadressElement.getText());
		assertEquals(actualadressElement.getText(), x);

	}
	
	public void addNewAddress() {
		
	}

}

package personal.testingPickaboo;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class buy_wo_req {
WebDriver driver;
	
	public buy_wo_req ( WebDriver x ) {
		this.driver =x;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void checkrequired() {
		driver.findElement(By.xpath("//div[@class='Button__StyledBtn-sc-55nib8-0 jhQlOz dc-btn']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".MuiTooltip-popper.MuiTooltip-popperArrow"))); 
        
        if ( driver.findElement(By.cssSelector(".MuiTooltip-popper.MuiTooltip-popperArrow")).getText().contains("Please select variant") ) {
        	assertTrue(true);
        	System.out.println("ase");
		}else {
			assertTrue(false);
			System.out.println("nai");
		}
	}
	
	
	
}

package personal.testingPickaboo;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class test1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//Create a map to store  preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();
		    
		//add key and value to map as follow to switch off browser notification
		//Pass the argument 1 to allow and 2 to block
		prefs.put("profile.default_content_setting_values.notifications", 2);
		    
		//Create an instance of ChromeOptions 
		ChromeOptions options = new ChromeOptions();
		    
		// set ExperimentalOption - prefs 
		options.setExperimentalOption("prefs", prefs);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("http://pickaboo.com/");
		
		driver.findElement(By.xpath("//div[@class='Button__StyledBtn-sc-55nib8-0 eUtGXp dc-btn']")).click();
		driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiInput-input']")).sendKeys("tahshin2019@gmail.com");
		driver.findElement(By.xpath("//input[@class='MuiInputBase-input MuiInput-input MuiInputBase-inputAdornedEnd']")).sendKeys("Wtfisthat123@");
		driver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text custom-buttons']")).click();
		Thread.sleep(3000);

		Assert.assertEquals(driver.getTitle(), "Pickaboo: Your Trusted Partner for Hassle-Free Online Shopping");
		
		driver.findElement(By.xpath("//input[@class='searchInput form-control']")).sendKeys("watch ");
		List<WebElement> elements = driver.findElements(By.xpath("//div[@class='search-item'] //h4"));
        List<String> elementTexts = new ArrayList<>();
        for (WebElement element : elements) {
            elementTexts.add(element.getText());
        }
        for ( String x:elementTexts  ) {
        	if (x.contains("Watch")) {
				assertTrue(true);
			}
        }
        
        elements.get(0).click();
        
        driver.findElement(By.xpath("//div[@class='Button__StyledBtn-sc-55nib8-0 jhQlOz dc-btn']")).click();
        Thread.sleep(1000);
        if ( driver.findElement(By.cssSelector(".MuiTooltip-popper.MuiTooltip-popperArrow")).getText().contains("Please select variant") ) {
        	assertTrue(true);
		}else {
			assertTrue(false);
		}
        
        
        
        //testing if i can buy without clicking required option
        
        
        
		//div[@class='ColorSection__StyledSection-sc-ksmhhv-0 ceJa-D'] //label[@class='MuiFormLabel-root text-view Mui-required']
		
//		System.out.println(driver.getTitle());
//		driver.quit();
		
	}

}

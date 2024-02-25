package personal.testingPickaboo;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class search {
WebDriver driver;
	
	public search ( WebDriver x ) {
		this.driver =x;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifySearch() {
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
	}
	
	
	
	
	
}

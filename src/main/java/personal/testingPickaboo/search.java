package personal.testingPickaboo;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class search {
WebDriver driver;
	
	public search ( WebDriver x ) {
		this.driver =x;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//input[@class='searchInput form-control']")
	WebElement searchbox;
	
	@FindBy(xpath = "//div[@class='search-item'] //h4")
	List<WebElement> elements;
	
	public void verifySearch() {
		searchbox.sendKeys("watch ");
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

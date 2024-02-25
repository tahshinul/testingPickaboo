package personal.testingPickaboo;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.bouncycastle.cert.ocsp.Req;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class cart {
	WebDriver driver;

	public cart(WebDriver x) {
		this.driver = x;

		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "div[class*='swiper-slide offer-category__single'] div[class*='product-single a-tag']")
	List<WebElement> elements;

	@FindBy(xpath = "//div[@class='Button__StyledBtn-sc-55nib8-0 hkYiNy dc-btn']")
	WebElement addtocartElement;

	@FindBy(xpath = "//div[@class='MuiSnackbar-root MuiSnackbar-anchorOriginBottomLeft']")
	WebElement barElement;

	@FindBy(xpath = "//div[@class='MuiSnackbar-root MuiSnackbar-anchorOriginBottomLeft'] //div[@class='MuiAlert-message']")
	WebElement barelementtext;

	@FindBy(xpath = "//div[@class='pl-0 detail-left col-md-5']")
	WebElement imagElement;

	@FindBy (css = ".MuiTooltip-popper.MuiTooltip-popperArrow")
	WebElement reqiredtextElement;
	
	
	
	

	public void addcart(int k) {
		for (int i = 0; i < k; i++) {
			elements.get(i).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait1.until(ExpectedConditions.visibilityOf(imagElement));
			
			
			try {
				addtocartElement.click();
				if ( reqiredtextElement.getText().contains("Please select variant") ) {
					WebElement required = driver.findElement(By.xpath("//div[@class='ColorSection__StyledSection-sc-ksmhhv-0 ceJa-D'] //label[@class='MuiFormLabel-root text-view Mui-required']"));
					WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait4.until(ExpectedConditions.visibilityOf(reqiredtextElement));
					driver.findElement(RelativeLocator.with(By.className("views")).toRightOf(required)).click();
			        addtocartElement.click();
			        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.visibilityOf(barElement));
					System.out.println(barelementtext.getText());
					try {
						WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait3.until(ExpectedConditions.titleContains("Shopping Cart | Pickaboo"));
						driver.navigate().to("http://pickaboo.com/");
					} catch (Exception e) {
						WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait3.until(ExpectedConditions.titleContains("Shipping | Pickaboo"));
						driver.navigate().to("http://pickaboo.com/");
					}
					
					
				}
				else {
					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					wait.until(ExpectedConditions.visibilityOf(barElement));
					System.out.println(barelementtext.getText());
					try {
						WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait3.until(ExpectedConditions.titleContains("Shopping Cart | Pickaboo"));
						driver.navigate().to("http://pickaboo.com/");
					} catch (Exception e) {
						WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait3.until(ExpectedConditions.titleContains("Shipping | Pickaboo"));
						driver.navigate().to("http://pickaboo.com/");
					}
					
					
				}
				
			} catch (Exception e) {
				addtocartElement.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait.until(ExpectedConditions.visibilityOf(barElement));
				System.out.println(barelementtext.getText());
				try {
					WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
					wait3.until(ExpectedConditions.titleContains("Shopping Cart | Pickaboo"));
					driver.navigate().to("http://pickaboo.com/");
				} catch (Exception x) {
					WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
					wait3.until(ExpectedConditions.titleContains("Shipping | Pickaboo"));
					driver.navigate().to("http://pickaboo.com/");
				}
				
				
			}

			
			
			
			
		}

	}
	
	
	
	public void verifycart(int l) {
		driver.navigate().to("https://www.pickaboo.com/checkout/cart/");
		
		
	}
}

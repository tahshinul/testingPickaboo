package personal.testingPickaboo;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.bouncycastle.cert.ocsp.Req;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	@FindBy(xpath = "//div[@class='Button__StyledBtn-sc-55nib8-0 hkYiNy dc-btn'] //a //span")
	WebElement addtocartElement;

	@FindBy(xpath = "//div[@class='MuiSnackbar-root MuiSnackbar-anchorOriginBottomLeft']")
	WebElement barElement;

	@FindBy(xpath = "//div[@class='MuiSnackbar-root MuiSnackbar-anchorOriginBottomLeft'] //div[@class='MuiAlert-message']")
	WebElement barelementtext;

	@FindBy(xpath = "//div[@class='pl-0 detail-left col-md-5']")
	WebElement imagElement;

	@FindBy(css = ".MuiTooltip-popper.MuiTooltip-popperArrow")
	WebElement reqiredtextElement;

	@FindBy(xpath = "//div[@class='CartItem__StyledDiv-sc-1uy634i-0 diseeT']")
	List<WebElement> cartElements;


	@FindBy(xpath = "(//div[contains(text(),'Remove')])[2]")
	WebElement removElement;

	@FindBy(xpath = "//div[@class='logo col-sm-2'] //a")
	WebElement pickaboologoElement;

	@FindBy(xpath = "(//div[@class='parent-row'] //span)[1]")
	WebElement required;

	@FindBy(xpath = "(//div[@class='parent-row'] //div[@class='color-box'])[1]")
	WebElement optionsElement;
	
	@FindBy(xpath = "(//div[@class='parent-row'] //div[@class='color-box-selected'])[1]")
	WebElement optionsElement2;
	

	@FindBy(xpath = "//div[@class='cart']")
	WebElement movElement;

	public void addcart(int k) {
		for (int i = 0; i < k; i++) {
			elements.get(i).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait1.until(ExpectedConditions.visibilityOf(imagElement));

			try {
				if (required.getText().contains("Color")) {
//					WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(5));
//					wait4.until(ExpectedConditions.visibilityOf(reqiredtextElement));

					Actions actions = new Actions(driver);
					actions.moveToElement(movElement).build().perform();
					actions.moveToElement(optionsElement).click().build().perform();
					actions.moveToElement(optionsElement).click().build().perform();

					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,150)");

					WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(5));
//					actions.moveToElement(optionsElement).click().build().perform();
//					actions.moveToElement(optionsElement).click().build().perform();
					
					JavascriptExecutor jse1 = (JavascriptExecutor) driver;
					jse1.executeScript("window.scrollBy(0,150)");
					wait6.until(ExpectedConditions.elementToBeClickable(addtocartElement));

					actions.moveToElement(addtocartElement).click().build().perform();

					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
					wait.until(ExpectedConditions.visibilityOf(barElement));
					System.out.println(barelementtext.getText());
					try {
						WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait3.until(ExpectedConditions.titleContains("Shopping Cart | Pickaboo"));
						pickaboologoElement.click();
					} catch (Exception e) {
						WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait3.until(ExpectedConditions.titleContains("Shipping | Pickaboo"));
						pickaboologoElement.click();
					}

				} else {
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,150)");

					Actions actions = new Actions(driver);
					actions.moveToElement(movElement).build().perform();

					WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
					wait2.until(ExpectedConditions.elementToBeClickable(addtocartElement));

					actions.moveToElement(addtocartElement).click().build().perform();

					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
					wait.until(ExpectedConditions.visibilityOf(barElement));
					System.out.println(barelementtext.getText());

					try {
						WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait3.until(ExpectedConditions.titleContains("Shopping Cart | Pickaboo"));
						pickaboologoElement.click();
					} catch (Exception e) {
						WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait3.until(ExpectedConditions.titleContains("Shipping | Pickaboo"));
						pickaboologoElement.click();
					}

				}

			} catch (Exception e) {
				if (required.getText().contains("Color")) {
//					WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(5));
//					wait4.until(ExpectedConditions.visibilityOf(reqiredtextElement));

					Actions actions = new Actions(driver);
					actions.moveToElement(movElement).build().perform();


					actions.moveToElement(optionsElement2).click().build().perform();
					actions.moveToElement(optionsElement2).click().build().perform();
//					actions.moveToElement(optionsElement).click().build().perform();
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,150)");

					WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(5));
					wait6.until(ExpectedConditions.elementToBeClickable(addtocartElement));
//					actions.moveToElement(optionsElement).click().build().perform();
					JavascriptExecutor jse3 = (JavascriptExecutor) driver;
					jse3.executeScript("window.scrollBy(0,150)");
					
					actions.moveToElement(addtocartElement).click().build().perform();

					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
					wait.until(ExpectedConditions.visibilityOf(barElement));
					System.out.println(barelementtext.getText());
					try {
						WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait3.until(ExpectedConditions.titleContains("Shopping Cart | Pickaboo"));
						pickaboologoElement.click();
					} catch (Exception f) {
						WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait3.until(ExpectedConditions.titleContains("Shipping | Pickaboo"));
						pickaboologoElement.click();
					}

				} else {
					JavascriptExecutor jse = (JavascriptExecutor) driver;
					jse.executeScript("window.scrollBy(0,150)");

					Actions actions = new Actions(driver);
					actions.moveToElement(movElement).build().perform();

					WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
					wait2.until(ExpectedConditions.elementToBeClickable(addtocartElement));

					actions.moveToElement(addtocartElement).click().build().perform();

					WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
					wait.until(ExpectedConditions.visibilityOf(barElement));
					System.out.println(barelementtext.getText());

					try {
						WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait3.until(ExpectedConditions.titleContains("Shopping Cart | Pickaboo"));
						pickaboologoElement.click();
					} catch (Exception f) {
						WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait3.until(ExpectedConditions.titleContains("Shipping | Pickaboo"));
						pickaboologoElement.click();
					}

				}
			}
			try {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollBy(0,150)");
				addtocartElement.click();
				WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(5));
				wait3.until(ExpectedConditions.titleContains("Shopping Cart | Pickaboo"));
				pickaboologoElement.click();
			} catch (Exception e) {

			}
		}

	}

	public void verifycart(int l) {
		driver.navigate().to("https://www.pickaboo.com/checkout/cart/");
		int cartsize = cartElements.size();
		if (cartsize == l) {
			assertTrue(true);
			System.out.println("number of items in cart " + l);
		} else {
			assertTrue(false);
		}
	}

	public void removeFromCart() {
		removElement.click();
		
		
		
	}
}

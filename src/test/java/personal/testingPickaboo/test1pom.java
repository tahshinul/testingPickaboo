package personal.testingPickaboo;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.compress.archivers.zip.X000A_NTFS;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class test1pom {

	public static void main(String[] args) throws InterruptedException {
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				WebDriver driver = new ChromeDriver(options);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.manage().window().maximize();
				
				//testing login
				landingPage landingPage = new landingPage(driver);		
				landingPage.goToLogin();
				landingPage.loginAction("tahshin2019@gmail.com", "Wtfisthat123@");
				landingPage.verifylogin();
				
				//testing search
				search search = new search(driver);
				search.verifySearch();
				
				//testing if we can buy now without clicking required option
				buy_wo_req buy =  new buy_wo_req(driver);
				buy.checkrequired();
				
				//testing if buy now works
				buynow buynow = new buynow(driver);
				buynow.checkbuynow();

				//testing if applying coupon code works
				coupon coupon = new coupon(driver);
				coupon.applyCoupon();
				
				//testing if adding multiple items to cart works
				cart cart = new cart(driver);
				int noOfItems= 3;
				int itemInCart=4;
				cart.addcart(noOfItems);
				
				//verifying if the number of items added to cart matches
				cart.verifycart(itemInCart);
				
				//testing if removing from cart works
				cart.removeFromCart();
				
				//testing if incrementing works in the cart
				incedecreCheck c = new incedecreCheck(driver);
				c.increment();
				
				//testing if incrementing works in the cart
				c.decrement();

				//testing if proceed to checkout works
				checkout checkout = new checkout(driver);
				checkout.proceedToCheckout();
				
				
				
//				driver.quit();
				

	}

}

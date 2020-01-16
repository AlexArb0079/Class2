package tests;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class SearchTest {
	@Test
	public void search() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		
		// PC no tiene chrome
		ChromeOptions options = new ChromeOptions().setBinary("K:\\Programas\\BraveSoftware\\Brave-Browser\\Application\\Brave.exe");
		WebDriver driver = new ChromeDriver(options);
		//WebDriver driver = new ChromeDriver();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.manage().window().maximize();
		driver.navigate().to("http://automationpractice.com/index.php");
		driver.findElement(By.id("search_query_top")).sendKeys("Tennis");
		driver.findElement(By.name("submit_search")).click();
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("center_column")));
		

		String targetText = driver.findElement(By.className("heading-counter")).getText();
		Assert.assertEquals(targetText, "0 results have been found.");
        
		driver.close();
		driver.quit();
		
		
		
		
	}
}

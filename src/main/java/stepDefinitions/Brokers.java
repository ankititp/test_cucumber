package stepDefinitions;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.chrome.ChromeDriver;
 import cucumber.api.java.en.Given;
 import cucumber.api.java.en.Then;
 import cucumber.api.java.en.When;
 import junit.framework.Assert;

 
 public class Brokers {
 
 	WebDriver driver;
 
 	@Given("^I visit Aussie home Loan Website$")
 	public void test() {
 		System.setProperty("webdriver.chrome.driver", "/Users/ankit/Downloads/chromedriver");
 		driver = new ChromeDriver();
 		driver.get("https://www.aussie.com.au/");
 		driver.manage().window().maximize();
 	}
 	@When("^I select NSW sydney Menu$")
 	public void SydneyMenu() throws InterruptedException {
 		WebElement dd=driver.findElements(By.xpath("//span[@class='caret']")).get(2);
 		dd.click();
 		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
 		driver.findElement(By.xpath("//a[text()='NSW']")).click();
 		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
 		}
 
 	@Then("^I click 'A' from the alphabetical listing of store$")
 	public void Store()  {
 		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
 		driver.findElement(By.xpath("//a[text()='A']")).click();
 		}
 
 	@When("^I click on aussie Albury Link$")
 	public void aussie_albury() {
 		JavascriptExecutor js = (JavascriptExecutor) driver;  
 		 // This  will scroll down the page by  1000 pixel vertical		
        js.executeScript("scroll(0, 250);");
 		driver.findElement(By.xpath("//a[text()='Aussie Albury']")).click();
 		
 	}
 
 	@Then("^should be navigated to Aussie Albury Screen$")
 	public void details() {
 	 System.out.println("Aussie Albury Screen");
 	driver.findElement(By.id("fname")).sendKeys("Ankit");
 	driver.findElement(By.id("lname")).sendKeys("Gupta");
 	driver.findElement(By.id("email")).sendKeys("Ankit@gmail.com");
 	driver.findElement(By.id("phoneMobile")).sendKeys("0123456789");
 	driver.findElement(By.id("Suburb")).sendKeys("SEVEN HILLS, 2147, NSW");
 	driver.findElement(By.id("supertag_home_loan_raa_start_submit")).click();
 	}
 
 	
 
 	@Then("^following message congrats$")
 	public void sucessMessage() {
 		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
 		String message= driver.findElement(By.xpath("//div[@class='title text advancedtext parbase']")).getText();
 		Assert.assertEquals("Congrats. You’re on your way.", message);
 	}
 
 
 
 }

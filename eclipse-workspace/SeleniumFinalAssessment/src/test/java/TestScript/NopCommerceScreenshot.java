package TestScript;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



//WAP to take screen shot after user register on nopcommerce successful(You can open the register page directly also)
public class NopCommerceScreenshot {
public static void main(String[] args) {
	
	try
	{
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver = new ChromeDriver();
	
	    driver.get("https://www.nopcommerce.com/en");
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	
		WebElement userIcon = driver.findElement(By.xpath("(//ul[@class='navigation-top-menu navigation-top-menu-user-actions'])/li[3]"));
		WebElement registerLink = driver.findElement(By.xpath("((//ul[@class='navigation-top-menu-sublist'])[6]/li)[2]"));
		
		Actions action = new Actions(driver);
		
		action.moveToElement(userIcon); 
		Thread.sleep(3000);
		action.click(registerLink).build().perform(); 
		Thread.sleep(3000);
		
		WebElement firstName = driver.findElement(By.xpath("//input[@id='FirstName']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@id='LastName']"));
		WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
		WebElement Cemail = driver.findElement(By.xpath("//input[@Id='ConfirmEmail']"));
		WebElement time = driver.findElement(By.xpath("//select[@id='TimeZoneId']"));
		WebElement userName = driver.findElement(By.xpath("//input[@id='Username']"));
	
		Select dropDown = new Select(driver.findElement(By.xpath("(//select[@name='CountryId'])[1]")));  
		Select timeDrop = new Select(time);
		
		WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
		WebElement Cpassword = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		
		Select mPdropDown = new Select(driver.findElement(By.xpath("//select[@id='Details_CompanyIndustryId']")));
		Select mRdropDown = new Select(driver.findElement(By.xpath("//select[@id='Details_CompanyRoleId']")));
		Select mDdropDown = new Select(driver.findElement(By.xpath("//select[@id='Details_WebsitesDevelopmentPeriodId']")));
		Select cDropDown = new Select(driver.findElement(By.xpath("//select[@id='Details_CompanySizeId']")));
		
		WebElement radioBNo = driver.findElement(By.xpath("((//div[@class='custom-control custom-radio custom-control-inline'])[2]/label)[1]"));
		WebElement radioBYes = driver.findElement(By.xpath("((//div[@class='custom-control custom-radio custom-control-inline'])[1]/label)[1]"));
		WebElement inputText = driver.findElement(By.xpath("//input[@id='Details_CompanyWebsiteUrl']"));
		
		WebElement register = driver.findElement(By.name("register-button"));
		
		
		firstName.sendKeys("Jyoti");
		lastName.sendKeys("Satpute");
		email.sendKeys("jyotisatpute1112@gmail.com");
		Cemail.sendKeys("jyotisatpute1112@gmail.com");
		userName.sendKeys("jyoti303");
		password.sendKeys("Pass@1234");
		Cpassword.sendKeys("Pass@1234");
			
		dropDown.selectByVisibleText("India");
		
		timeDrop.selectByVisibleText("(UTC-10:00) Hawaii");
		mPdropDown.selectByIndex(1);
		mRdropDown.selectByIndex(2);
		mDdropDown.selectByVisibleText("We are going to start");
		cDropDown.selectByIndex(2);
		
		radioBYes.click();
		radioBNo.click();
		
		Thread.sleep(2000);
		
		inputText.sendKeys("www.google.com");
		
		register.click();
		Thread.sleep(2000);
		
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(src, new File(".//Screenshots/screen.png"));
		
         Thread.sleep(2000);
	
	    
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		
	}
	
}

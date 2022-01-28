package week4Day1.Assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SNOWCreateIncident {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://dev91913.service-now.com");
		driver.manage().window().maximize();
		WebElement loginFrame = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(loginFrame);
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("ArBkJ7lBnL3t");
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("Incident");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[contains(@href,'incident')]//div[text()='Create New']")).click();
		
		driver.switchTo().frame("gsft_main");
		
		String incId = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println("Incident ID is "+incId);
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		String childWindow1 = windows.get(1);
		String childWindow = windows.get(0);
		driver.switchTo().window(childWindow1);
		
		driver.findElement(By.xpath("//tr[1]/td[3]/a[@class='glide_ref_item_link']")).click();
		driver.switchTo().window(childWindow);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("Incident description");
		
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(incId, Keys.ENTER);
		
		String incID1 = driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
		
		System.out.println("Incident number displayed is "+incID1);
		if(incID1.equalsIgnoreCase(incId))
		{
			System.out.println("Incident created successfully");
		}
		else
		{
			System.out.println("Unable to create the incident");
		}
		
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./images/SNOWCreateIncident.png");
		FileUtils.copyFile(source, dest);
		
	}	
	}

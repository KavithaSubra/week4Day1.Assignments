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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SNOWAssignIncident {
	
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
		
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//label[text()='Search']/following-sibling::input[@class='form-control']")).sendKeys("INC0000027", Keys.ENTER);	
		
		driver.findElement(By.xpath("//tr[1]/td[3]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		String childWindow1 = windows.get(0);
		
		driver.switchTo().window(childWindow1);
		driver.switchTo().frame("gsft_main");
		
		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']/span")).click();
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		String childWindow2 = windows1.get(1);
		
		driver.switchTo().window(childWindow2);
		
		driver.findElement(By.xpath("//span[contains(text(),'submit the search')]/following-sibling::input")).sendKeys("Software",Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@id='sys_user_group_table']//tr[1]/td[3]/a[contains(text(),'Software')]")).click();
		
		driver.switchTo().window(childWindow1);
		driver.switchTo().frame("gsft_main");	
		
	    driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Log notes for the incident");
		
		driver.findElement(By.xpath("//button[@id='sysverb_update_bottom']")).click();
		
		driver.findElement(By.xpath("//tr[1]/td[3]")).click();
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./images/SNOWAssignIncident.png");
		FileUtils.copyFile(source, dest);
		
		driver.close();
		
	}	
	}

package week4Day1.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chercher {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		driver.switchTo().frame("frame1");
		driver.findElement(By.xpath("//b[@id = 'topic']/following-sibling::input")).sendKeys("Frame Examples");
		driver.switchTo().frame("frame3");
		driver.findElement(By.xpath("//input[@id = 'a']")).click();
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		WebElement dd1 = driver.findElement(By.xpath("//select[@id = 'animals']"));
		Select dropdown1 = new Select(dd1);
		dropdown1.selectByValue("avatar");
		driver.close();
	}

}

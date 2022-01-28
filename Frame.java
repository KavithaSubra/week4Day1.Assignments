package week4Day1.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.get("http://leafground.com/pages/frame.html");
	driver.manage().window().maximize();
	driver.switchTo().frame(0);
	
	driver.findElement(By.id("Click")).click();
	
    driver.switchTo().frame("frame2");
	
	driver.findElement(By.id("Click Me")).click();
}
}

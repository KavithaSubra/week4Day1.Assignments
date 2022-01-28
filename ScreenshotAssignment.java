package week4Day1.Assignments;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotAssignment {
	
	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/frame.html");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		WebElement click = driver.findElement(By.xpath("//button[@id ='Click']"));
		File source = click.getScreenshotAs(OutputType.FILE);
		File dest = new File("./images/ClickMe.png");
		FileUtils.copyFile(source, dest);
		
		driver.switchTo().defaultContent();
		List<WebElement> findElements = driver.findElements(By.tagName("iframe"));
		int count=0;
		for(WebElement element:findElements)
		{
			count=count+1;
		}
		System.out.println("No. of Frames in the screen: "+ count);
		
		driver.close();
		
	}

}

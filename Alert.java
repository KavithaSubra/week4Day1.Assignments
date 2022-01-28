package week4Day1.Assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {
	
	public static void main(String[] args) throws InterruptedException {
		//set up the driver
		WebDriverManager.chromedriver().setup();
		//load the browser
		ChromeDriver driver = new ChromeDriver();
		//load the url
		
		driver.get("http://leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		Thread.sleep(2000);
		
		
		//Accept the alert
		
		org.openqa.selenium.Alert alert = driver.switchTo().alert();
		String text1 = alert.getText();
		alert.accept();
		System.out.println(text1);
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		Thread.sleep(2000);
		
		
		//Accept the alert
		
		org.openqa.selenium.Alert alert2 = driver.switchTo().alert();
		String text2 = alert2.getText();
		alert2.dismiss();
		System.out.println(text2);
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		Thread.sleep(2000);
		
		
		//Accept the alert
		
		org.openqa.selenium.Alert alert3 = driver.switchTo().alert();
		String text3 = alert3.getText();
		alert3.sendKeys("ABC");
		alert3.accept();
		System.out.println(text3);
		
		driver.findElement(By.xpath("//button[text()='Line Breaks?']")).click();
		Thread.sleep(2000);
		
		org.openqa.selenium.Alert alert4 = driver.switchTo().alert();
		String text4 = alert4.getText();
		alert4.accept();
		System.out.println(text4);
		
		driver.findElement(By.xpath("//button[text()='Sweet Alert']")).click();
		Thread.sleep(2000);
		
		
		//Accept the alert
		
		//org.openqa.selenium.Alert alert3 = driver.switchTo().alert();
		driver.findElement(By.xpath("//button[text()='OK']")).click();
		
		
	}

}

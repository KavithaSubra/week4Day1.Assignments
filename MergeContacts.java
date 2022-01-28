package week4Day1.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContacts {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("DemoCSR");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		//driver.findElement(By.xpath("//*[@id=\"widget_ComboBox_partyIdFrom\"]/following-sibling::a")).click();
		driver.findElement(By.xpath("//table[@class='twoColumnForm']//tr[1]/td//img[@alt='Lookup']")).click();
		
		String windowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> windows = new ArrayList<String>(windowHandles);
		String childWindow = windows.get(1);
		
		String title = driver.switchTo().window(childWindow).getTitle();
		
		System.out.println(title);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='x-grid3-body']/div[1]//a")).click();
		
		driver.switchTo().window(windowHandle);
		
driver.findElement(By.xpath("//table[@class='twoColumnForm']//tr[2]/td//img[@alt='Lookup']")).click();
		
		String windowHandle1 = driver.getWindowHandle();
        Set<String> windowHandles1 = driver.getWindowHandles();
		
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		String childWindow1 = windows1.get(1);
		
		driver.switchTo().window(childWindow1);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='x-grid3-body']/div[2]//a")).click();
		
		driver.switchTo().window(windowHandle);
		
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		driver.switchTo().alert().accept();
		
		String title2 = driver.switchTo().window(windowHandle).getTitle();
		System.out.println(title2);
	
	}

}

package week4Day1.Assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Windows {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		System.out.println(driver.getTitle());
	//To open Home Page	
		driver.findElement(By.id("home")).click();
		
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		
		for(String window: windowHandles)
		{
			System.out.println(window);
		}
		
		List<String> windows = new ArrayList<String>(windowHandles);
		String childWindow = windows.get(1);
		System.out.println(childWindow);
		//Switch to ChildWindow
		String title2 = driver.switchTo().window(childWindow).getTitle();
		System.out.println(title2);
		
		driver.close();
	
		//To print no. of open windows	
		
		driver.switchTo().window(windowHandle);
		
		
		driver.findElement(By.xpath("//button[contains(text(),'Open Multiple')]")).click();
		Thread.sleep(2000);
		
		Set<String> windowHandles1 = driver.getWindowHandles();
		
		int count=0;
		for(String window: windowHandles1)
		{
			count=count+1;
		}
		
		System.out.println("No. of open windows: "+count);
		
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		String childWindow1 = windows1.get(1);
		String childWindow2 = windows1.get(2);
		String title3 = driver.switchTo().window(childWindow1).getTitle();
		driver.close();
		String title4 = driver.switchTo().window(childWindow2).getTitle();
		driver.close();
		System.out.println(title3);
		System.out.println(title4);
		
		System.out.println("Closed the multiple Open windows");
		
		driver.switchTo().window(windowHandle);
		
		driver.findElement(By.xpath("//button[@onclick='openWindows();']")).click();
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> windows2 = new ArrayList<String>(windowHandles2);
		String childWindow3 = windows2.get(1);
		String childWindow4 = windows2.get(2);
		driver.switchTo().window(childWindow3).close();
		driver.switchTo().window(childWindow4).close();
		
		System.out.println("Closed the 'Do not close' windows");
		
        driver.switchTo().window(windowHandle);
		
		driver.findElement(By.xpath("//button[@onclick='openWindowsWithWait();']")).click();
		
		Thread.sleep(5000);
		
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> windows3 = new ArrayList<String>(windowHandles3);
		String childWindow5 = windows3.get(1);
		String childWindow6 = windows3.get(2);
		driver.switchTo().window(childWindow5).close();
		driver.switchTo().window(childWindow6).close();
		
		System.out.println("Closed the wait windows");
		
		Thread.sleep(1000);
		
		driver.quit();
}

}

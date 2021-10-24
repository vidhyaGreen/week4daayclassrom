package week4day1;

import java.awt.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class windowHandlingirctc {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.irctc.co.in/");
		
//disable notifications	
		
	//ChromeOptions option= new ChromeOptions();
	//option.addArguments("--disable-notifications");
	//ChromeDriver driver1=new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	//clickok button	
		driver.findElement(By.xpath("//button[(text()='OK')]")).click();
		 driver.findElement(By.partialLinkText("FLIGHTS")).click();
         
    //step 1: 
		
		Set<String> WinHandle =driver.getWindowHandles();
		
  //step 2: conveting set to array	
		
		ArrayList<String> WinListHandles= new ArrayList<String>(WinHandle);
		
   //step 3:go to the 2nd window
		
		driver.switchTo().window(WinListHandles.get(1));
		
	//step 4: print customer care email id: 
		
		String email= driver.findElement(By.xpath("(//div[@class='block-nav-right d-none d-md-block'])[2]")).getText();
		
		System.out.println("The Given Email is :" + email);
		
	//step 5:	First tab(Train ticket booking) alone 
		
		driver.switchTo().window(WinListHandles.get(0));
		
		String Title= driver.getTitle();
		System.out.println("The First Window Title  is :" + Title);
	
	//close pnly the first window	
		
		driver.close();
	}
	

}

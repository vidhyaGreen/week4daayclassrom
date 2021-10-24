package week4day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlerts {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		 driver.get("http://leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[(text()='Alert Box')]")).click();
	//	simple alert box
		
		Alert alert=driver.switchTo().alert();
        String text= alert.getText();
        System.out.println("the simple  alert box: " + text);
        alert.accept();

//confirm ALERT box 
        driver.findElement(By.xpath("//button[(text()='Confirm Box')]")).click();
        System.out.println("confirmation Box: " + alert.getText());
        alert.dismiss();
        
      //Prompt Box alert
        driver.findElement(By.xpath("//button[(text()='Prompt Box')]")).click();
        System.out.println("Prompt Box: " + alert.getText());
        alert.sendKeys("HELLO EVERYONE");
        alert.accept();
            
        
        
        
	}
	
	
	

}

package week4day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		 driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[(text()='Try it')]")).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		String text=driver.findElement(By.id("demo")).getText();
		if(text.contains("OK"))
		{
			System.out.println("You Pressed OK!");
		}
		else
		{
			System.out.println("You pressed Cancel!");

		}
		

		
		
		
		
	}

}

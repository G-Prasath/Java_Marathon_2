package week5.Marathon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Red_Bus {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.redbus.in/");
		
		
		WebElement from = driver.findElement(By.xpath("//input[@data-message='Please enter a source city']"));
		from.click();
		from.sendKeys("Chennai");
		driver.findElement(By.xpath("//li[text()='Chennai']")).click();
		
		WebElement to = driver.findElement(By.xpath("//input[@data-message='Please enter a destination city']"));
		to.click();
		to.sendKeys("Bangalore");
		driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
		
		driver.findElement(By.xpath("//label[text()='Date']")).click();
		String date = driver.findElement(By.xpath("//td[@class='current day']")).getText();
		int num = Integer.parseInt(date) + 1;
		String num1 = String.valueOf(num);
		driver.findElement(By.xpath("//tr//td[text()='"+num1+"']")).click();
		
		 Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='search_btn']")).click();
		
		String Bus_Count = driver.findElement(By.xpath("//span[@class='f-bold busFound']")).getText();
		System.out.println("Bus Count : "+Bus_Count);
		driver.findElement(By.xpath("//label[@title='SLEEPER']")).click();
		String Bus_name = driver.findElement(By.xpath("(//div[@class='travels lh-24 f-bold d-color'])[2]")).getText();
		System.out.println("Bus_Name : "+Bus_name);
		driver.findElement(By.xpath("(//div[@class='button view-seats fr'])[2]")).click();
		
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest =new File("./snap/frame.png");
		FileUtils.copyFile(source, dest);
		
		driver.quit();
	}

}

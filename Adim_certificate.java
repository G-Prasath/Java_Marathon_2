package week5.Marathon;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Adim_certificate {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions ch = new ChromeOptions();
		ch.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testleaf$321");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//button[@title='Learn More']")).click();
		Shadow shadow = new Shadow(driver);
		shadow.setImplicitWait(15);
		
		Set<String> WH = driver.getWindowHandles();
		List<String> lst = new ArrayList<String>(WH);
		driver.switchTo().window(lst.get(1));
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		shadow.findElementByXPath("//span[text()='Learning']").click();
		WebElement trailHead = shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		Actions hover = new Actions(driver);
		hover.moveToElement(trailHead).perform();
		WebElement Sc = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		driver.executeScript("arguments[0].click()", Sc);
		driver.findElement(By.xpath("(//div[@class='credentials-card_title']//a)[1]")).click();
		System.out.println("----------------- Current URL ---------------------");
		System.out.println(driver.getCurrentUrl());
		
		
		List<WebElement> lst1 = driver.findElements(By.xpath("//div[text()='Certification']"));
		System.out.println("No of Certificate : "+lst1.size());
		System.out.println("---------------------- Cretificate ----------------");
		List<WebElement> lst2 = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		for(int i=0; i<lst1.size(); i++) {
			System.out.println(lst2.get(i).getText());
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

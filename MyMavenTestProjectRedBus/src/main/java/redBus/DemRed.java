package redBus;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemRed 
{
	WebDriver driver;
	static Entervalue obj1 = new Entervalue();
	//public static void main(String[] args)
	public void launch()
	{
		
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
	}
	@Test
	private static void setupTest() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.redbus.in");
        driver.manage().window().maximize();
        driver.findElement(By.id("src")).sendKeys("Lucknow");
        driver.findElement(By.id("dest")).sendKeys("delhi");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[3]/div/label")).click();
        //obj1.dis();
	}

	

	
}

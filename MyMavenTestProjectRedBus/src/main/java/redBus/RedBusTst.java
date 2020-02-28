package redBus;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RedBusTst {
	static WebDriver driver;

	@BeforeTest
	public void launchBrowser() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
		File sr = new File(
				"C:\\Users\\Training\\eclipse-workspace\\MyMavenTestProjectRedBus\\src\\main\\java\\redBus\\org.properties\\");
		System.out.println(sr);
		FileInputStream fis = new FileInputStream(sr);
		Properties pro = new Properties();
		pro.load(fis);
		driver = new ChromeDriver();
		driver.get("http://www.redbus.in");
		driver.manage().window().maximize();

	}

	@Test (priority = 1)
	public void onwardDate() throws InterruptedException {
		Thread.sleep(1000);
		System.out.println("cgfyugfcyu");
		driver.findElement(By.xpath("//*[@id='src']")).sendKeys("Lucknow");
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		WebElement s = driver.findElement(By.xpath("//*[@id='search']/div/div[1]/div/ul/li[3]"));
		s.click();
//		String p = s.getText();
//		System.out.println(p);
		Thread.sleep(3000);
	}

	@Test (priority = 2)
	public void returndDate() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id='dest']")).sendKeys("Delhi");
		Thread.sleep(3000);
		// driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		WebElement d = driver.findElement(By.xpath("//*[@id='search']/div/div[2]/div/ul/li[9]"));
		d.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[3]/span")).click();// select onward date

		String month1 = "Mar 2020";
		String day1 = "9";

		while (true) {
			Thread.sleep(1000);
			String text = driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[2]"))
					.getText();
			if (text.equals(month1)) {
				break;
			} else {
				driver.findElement(By.xpath("//*[@id=\"rb-calendar_onward_cal\"]/table/tbody/tr[1]/td[3]/button"))
						.click();
			}
		}

		driver.findElement(
				By.xpath("//div[@id='rb-calendar_onward_cal']//td[@class='wd day'][contains(text()," + day1 + ")]"))
				.click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"search\"]/div/div[4]/span")).click();// select return date
		String month2 = "Mar 2020";
		String day2 = "12";

		while (true) {
			Thread.sleep(1000);
			String text = driver.findElement(By.xpath("//*[@id=\"rb-calendar_return_cal\"]/table/tbody/tr[1]/td[2]"))
					.getText();
			if (text.equals(month2)) {
				break;
			} else {
				driver.findElement(By.xpath("//*[@id=\"rb-calendar_return_cal\"]/table/tbody/tr[1]/td[3]/button"))
						.click();
			}
		}
		driver.findElement(
				By.xpath("//div[@id='rb-calendar_return_cal']//td[@class='wd day'][contains(text()," + day2 + ")]"))
				.click();

		Thread.sleep(3000);

		driver.findElement(By.id("search_btn")).click();
		Thread.sleep(3000);
		/*driver.findElement(By.xpath("//*[@id='fixer']/div/div[1]/div[2]/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("switchButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='fixer']/section/div/div[5]/button")).click();

		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//*[@id='fixer']/section/div/div[5]/button")).click();
		////*[@id="fixer"]/section/div/div[5]/button
		driver.findElement(By.xpath("//*[@id='filter-block']/div/div[2]/ul[2]/li[4]/label[1]")).click();
		driver.findElement(By.xpath("//*[@id='filter-block']/div/div[2]/ul[2]/li[4]/label[1]")).isSelected();
		
		driver.findElement(By.xpath("//*[@id='filter-block']/div/div[2]/ul[3]/li[3]/label[1]")).click();
		driver.findElement(By.xpath("//*[@id='filter-block']/div/div[2]/ul[3]/li[3]/label[1]")).isSelected();
		
		driver.findElement(By.xpath("//*[@id='14419757']/div/div[2]/div[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='rt_14419757']/div/div/div/div[3]/div[2]/div[2]/canvas")).click();
		Thread.sleep(3000);*/
	}

	@Test (priority = 3)
	public void modify() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//*[@id='fixer']/div/div[1]/div[2]/div[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("switchButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='fixer']/section/div/div[5]/button")).click();

		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id='filter-block']/div/div[2]/ul[2]/li[4]/label[1]")).click();
		driver.findElement(By.xpath("//*[@id='filter-block']/div/div[2]/ul[2]/li[4]/label[1]")).isSelected();
		
		driver.findElement(By.xpath("//*[@id='filter-block']/div/div[2]/ul[3]/li[3]/label[1]")).click();
		driver.findElement(By.xpath("//*[@id='filter-block']/div/div[2]/ul[3]/li[3]/label[1]")).isSelected();
		
		/*driver.findElement(By.xpath("//*[@id='14419757']/div/div[2]/div[1]")).click();
		
		driver.findElement(By.xpath("//*[@id='rt_14419757']/div/div/div/div[3]/div[2]/div[2]/canvas")).click();
		Thread.sleep(3000);*/

	}

	
}

package redBus;

import org.openqa.selenium.By;
import com.gargaylesosoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectCalenderByJS {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","D:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.redbus.in");
        driver.manage().window().maximize();
    //    driver.findElement(By.id("src")).sendKeys("Lucknow");
      //  driver.findElement(By.id("dest")).sendKeys("delhi");
        Thread.sleep(1000);
        WebElement date = driver.findElement(By.linkText("onward_cal"));
        String dateVal = "29-02-2020";
        selectDateByJS(driver, date, dateVal);
	}
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','" + dateVal + "');'", element);
	}

}

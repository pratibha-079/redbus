package redBus;
import java.util.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class Entervalue
{
	WebDriver driver;
void dis() {
	driver.findElement(By.xpath("//*[@id=\"src\"]")).sendKeys("Lucknow");
}
}

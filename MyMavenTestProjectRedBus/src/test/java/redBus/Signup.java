package redBus;

import org.testng.annotations.Test;

//public class Signup {
  /*@Test
  public void f() {
  }*/
	import java.sql.*;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.By;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.testng.annotations.*;
	import java.io.File;
	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.util.Properties;
	
	public class Signup {
	static Connection con;
	static WebDriver driver;
	File src;
	FileInputStream fis;
	Properties pro;
	@BeforeTest
	public void connect() {
	try {
	System.out.println("connecting to database");
	Class.forName("com.mysql.jdbc.Driver"); // class.forName load     the Driver class
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/redbus","root", "nidhi");
	//here wolf is database name, root is username and password
	} catch (Exception e) {
	System.out.println(e);
	}
	}
	@BeforeTest
	public void fileInput() throws IOException {
	src = new File("C:\\Users\\Training\\eclipse-workspace\\MyMavenTestProjectRedBus\\src\\main\\java\\redBus\\org.properties\\");
	fis = new FileInputStream(src);
	pro = new Properties();
	pro.load(fis);
	System.out.println(pro.getProperty("logo"));
	}


	@BeforeTest
	public void launchbrowser() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver", "D:\\selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://www.redbus.in");
	driver.manage().window().maximize();
	//driver.findElement(By.cssSelector("i[id^='i-icon-profile']")).click();
	driver.findElement(By.xpath(pro.getProperty("icon"))).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath(pro.getProperty("signup"))).click();
	Thread.sleep(3000);

	}

	@Test
	public void fetch() throws SQLException {
	try {
	Statement stmt = con.createStatement();
	ResultSet rs = stmt.executeQuery("select * from mobile");

	while (rs.next()) {
	System.out.println(pro.getProperty("logo"));
	System.out.println(rs.getString(1));
	driver.findElement(By.xpath(pro.getProperty("number"))).sendKeys(rs.getString(1));// recharge interface
	Thread.sleep(3000);
	   
	}
	} catch (Exception e) {
	System.out.println(e);
	}

	}

	@AfterTest
	public void closeConnections() {
	try {
	System.out.println("Closing Database Connection...");
	con.close();
	driver.close();
	} catch (Exception e) {
	System.out.println(e);
	}
	}
	}



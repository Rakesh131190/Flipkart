package org.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;

	public static WebDriver chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  return driver;

	}
	
	public static WebDriver browserLaunch(String bname) {
		if(bname.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver();
		}
		
		if(bname.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
		}
		
		if(bname.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
		}
		
		return driver;
	}
	
	public static WebDriver browserLaunch1(String bname) {
		switch(bname) {
		case "chrome":	
		WebDriverManager.chromedriver().setup();
		  driver = new ChromeDriver();
		  break;
		  
		case "firefox":
		WebDriverManager.firefoxdriver().setup();
		  driver = new FirefoxDriver();
		break;
		  
		case "edge":
			WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
		break;
	
		default: System.out.println("Invalid browser name");
		}
		return driver;
		
	}
	
	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static String getCurrenturl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}
	
	public static void implicitWait(int a) {
		driver.manage().timeouts().implicitlyWait(a, TimeUnit.SECONDS);
	}
	
	public static void sendKeys(WebElement e, String value) {
		e.sendKeys(value);
	}
	
	public static void click(WebElement e) {
		e.click();
	}
	
	public static String getTitle() {
		String title = driver.getTitle();
		return title;

	}
	
	public static String getText(WebElement e) {
	String text = e.getText();
	return text;
	}
	
	public static void quit() {
		driver.quit();
	}
	
	public static void clear(WebElement e) {
	e.clear();
	}
	
	public static String getAttribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
		
	}
	
	public static void moveToElemnt(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
		
	}
	
	public static void dragAndDrop(WebElement src,WebElement tar) {
		Actions a = new Actions(driver);
		a.dragAndDrop(src, tar).perform();
		
	}
	
	public static void contextClick(WebElement tar) {
		Actions a = new Actions(driver);
		a.contextClick(tar);
	}
	
	public static void doubleClick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e);

		
	}
	
	public static void click() {
		Actions a = new Actions(driver);
		a.click();
	}
	
	public static void selectByIndex(WebElement e,int a) {
		Select s = new Select(e);
		s.selectByIndex(a);

	}

	public static void selectByValue(WebElement e, String a) {
		Select s = new Select(e);
		s.selectByValue(a);

	}
	
	public static void selectByVisibleText(WebElement e, String a) {
		Select s = new Select(e);
		s.selectByVisibleText(a);
	}
	
	public static List<WebElement> getOpions(WebElement e) {
		Select s = new Select(e);
		List<WebElement> options = s.getOptions();
		return options;

	}
	
	public static List<WebElement> getAllSelectedOptions(WebElement e) {
		Select s = new Select(e);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		return allSelectedOptions;
	}
	
	public static boolean isMultiple(WebElement e) {
		Select s= new Select(e);
		boolean multiple = s.isMultiple();
		return multiple;

	}
	
	public static void deSelectByIndex(WebElement e, int a) {
		Select s  = new Select(e);
		s.deselectByIndex(a);

	}
	
	public static void deSelectByValue(WebElement e, String a) {
		Select s = new Select(e);
		s.deselectByValue(a);
	
	}
	
	public static void deSelectByVisibleText(WebElement e, String a) {
		Select s = new Select(e);
		s.deselectByVisibleText(a);

	}
	
	    public static void deSelectAll(WebElement e) {
			Select s = new Select(e);
			s.deselectAll();

		}
	
	
	    public static void keyPress(String a) throws AWTException {
		Robot r = new Robot();
		if(a.equalsIgnoreCase("Enter")) {
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			
		}

		else if(a.equalsIgnoreCase("DownArrow")){
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}
		else if(a.equalsIgnoreCase("UpArrow")) {
			r.keyPress(KeyEvent.VK_UP);
			r.keyRelease(KeyEvent.VK_UP);
		}
		
	}
	    
	public static void accept(String a) {
		Alert r = driver.switchTo().alert();
		if(a.equalsIgnoreCase("accept")) {
			r.accept();
		}
		
		else if(a.equalsIgnoreCase("dimiss")) {
			r.dismiss();
		}
		else if(a.equalsIgnoreCase("sendkeys")) {
			r.sendKeys(a);
		}
		else if(a.equalsIgnoreCase("getText")) {
			r.getText();
		}
	}
	
	public static void Screenshot(WebElement a) throws IOException {
		TakesScreenshot tk = (TakesScreenshot)a;
		
		File fromSrc = tk.getScreenshotAs(OutputType.FILE);
		
		File dest = new File("C:\\Users\\Rakesh Nithyaraj\\eclipse-workspace\\Selenium\\Screenshot\\facebook.png");
		FileUtils.copyFile(fromSrc, dest);
		
	}
	
	public static void javascriptSet(WebElement a,String b) {
		JavascriptExecutor js = (JavascriptExecutor)a;
		js.executeScript("arguments[0].setAtttribute('value','"+b+"')", a);

	}

	
	public static void javascriptClick(WebElement a) {
		JavascriptExecutor js = (JavascriptExecutor)a;
		js.executeAsyncScript("arguments[0].click()", a);

	}
	
	public static void javascriptScrollDown(WebElement a) {
		JavascriptExecutor js = (JavascriptExecutor)a;
		js.executeScript("arguments[0].scrollIntoView(true)", a);
	}
	
	public static void javascriptScrollUp(WebElement a) {
		JavascriptExecutor js = (JavascriptExecutor)a;
		js.executeScript("arguments[0].scrollIntoView(false)", a);
	}
	
	public static Object javascriptGet(WebElement a) {
		JavascriptExecutor js = (JavascriptExecutor)a;
		Object executeScript = js.executeScript("return arguments[0].getAttribute('value)", a);
		return executeScript;

	}
	
	public static void windowHandle() {
		String parentId = driver.getWindowHandle();
		 driver.switchTo().window(parentId);
		System.out.println(parentId);
	}
	
	public static void WindowHandles(int a) {
		Set<String> allId = driver.getWindowHandles();
		int count=1;
		for(String eachId : allId) {
			if(count==a) {
				driver.switchTo().window(eachId);
			}
			count++;
		}
		
	}
	
	public static void frames(WebElement a) {
		driver.switchTo().frame(a);
	}
	
	public static void sleep(int a) throws InterruptedException {
		Thread.sleep(a);
	}
	
	public static void navigateTo(String url) {
		driver.navigate().to(url);
	}
	
	
	public static void navigateForward() {
		driver.navigate().forward();
	}
	
	public static void navigateBack() {
		driver.navigate().back();;
	}
	
	public static void navigateRefresh() {
		driver.navigate().refresh();
	}
	
	public static boolean isDisplayed(WebElement a) {
		boolean displayed = a.isDisplayed();
		return displayed;
	}
	
	public static boolean isEnabled(WebElement a) {
		boolean enabled = a.isEnabled();
		return enabled;
	}
	
    public static boolean isSelected(WebElement a) {
		boolean selected = a.isSelected();
		return selected;
	}
	
    
    public static Cell getCellValue(File f, String sheet, int rowIndex, int cellIndex) throws IOException {
    	FileInputStream st = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(st);
		Sheet s = w.getSheet("first");
		Row row = s.getRow(rowIndex);
		Cell cell = row.getCell(cellIndex);
		return cell;
		
		}
    
    public static long doublelToLong(Cell value) {
    	double numericCellValue = value.getNumericCellValue();
    	long num =(long)numericCellValue;
		return num;
    	
    }
		

	
	

}

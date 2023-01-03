package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	/**
	 * @author SIVANATHAN
	 * @see Used to Manage Reusable Codes
	 * @Date 27-Dec-2022
	 */

	
	// WebDriver:I
	public static WebDriver driver;

	/**
	 * @see Method to Take WebPage ScreenShot
	 * @return
	 */
	public byte[] screenShot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] screenshotAs = screenshot.getScreenshotAs(OutputType.BYTES);
		return screenshotAs;

	}

	/**
	 * @see Method to Initialize the Browser
	 * @param browserType
	 */
	public static void getDriver(String browserType) {
		switch (browserType) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();

			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			break;

		default:
			break;
		}

	}

	/**
	 * @see Method to Check the Element Visibility using Explicit Wait
	 * @param element
	 */
	public void elementVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	/**
	 * @see Method to get the Project Path using getProperty
	 * @return
	 */
	public static String getProjectPath() {
		String path = System.getProperty("user.dir");
		return path;

	}

	/**
	 * @see Method to get the Configuration Property values using Properties
	 * @param key
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getPropertyFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(getProjectPath() + "\\Config\\config.properties"));
		return (String) properties.get(key);
	}

	/**
	 * @see Method to Initialize the Particular Web Page
	 * @param Url
	 */
	public static void get(String Url) {
		driver.get(Url);

	}

	/**
	 * @see Method to get the Current WebPage Title
	 * @return
	 */
	public String getTitle() {

		String title = driver.getTitle();
		return title;
	}

	/**
	 * @see Method to get the Current WebPage Url
	 * @return
	 */
	public String getCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	/**
	 * @see Method to Close the Particular Page
	 */
	public static void close() {
		driver.close();
	}

	/**
	 * @see Method to Close the Browser
	 */
	public static void quit() {
		driver.quit();
	}

	/**
	 * @see Method to manage the Driver 
	 * @return
	 */
	public Options manage() {
		Options manage = driver.manage();
		return manage;

	}

	/**
	 * @see Method to Target the Locator
	 * @return
	 */
	public TargetLocator switchTo() {
		TargetLocator switchTo = driver.switchTo();
		return switchTo;
	}

	/**
	 * @see Method to Handle Single Window
	 * @return
	 */
	public String getWindowHandle() {
		String handle = driver.getWindowHandle();
		return handle;
	}

	/**
	 * @see Method to Handle Multiple Windows
	 * @return
	 */
	public Set<String> getWindowHandles() {
		Set<String> handles = driver.getWindowHandles();
		return handles;
	}

	/**
	 * @see Method to Find the WebElement
	 * @param e
	 * @param g
	 * @return
	 */
	public WebElement findElement(WebElement e, String g) {
		elementVisibility(e);
		WebElement findElement = e.findElement(By.xpath(g));
		return findElement;

	}

	/**
	 * @see Method to Find Multiple WebElements
	 * @param e
	 * @param g
	 * @return
	 */
	public List<WebElement> findElements(WebElement e, String g) {
		elementVisibility(e);
		List<WebElement> findElements = e.findElements(By.xpath(g));
		return findElements;

	}

	/**
	 * @see Method to Navigate the Driver
	 * @return
	 */
	public Navigation navigate() {
		Navigation navigate = driver.navigate();
		return navigate;
	}

	/**
	 * @see Method to Send values to WebElement
	 * @param e
	 * @param data
	 */
	public void sendkeys(WebElement e, String data) {
		elementVisibility(e);
		e.sendKeys(data);
	}

	/**
	 * @see Method to Click the WebElement
	 * @param element
	 */
	public void click(WebElement element) {
		elementVisibility(element);
		element.click();

	}

	/**
	 * @see Method to get the Text From the WebElement
	 * @param e
	 * @return
	 */
	public String getText(WebElement e) {
		elementVisibility(e);
		String text = e.getText();
		return text;

	}

	/**
	 * @see Method to get the Attribute Values from the WebElement
	 * @param e
	 * @param v
	 * @return
	 */
	public String getAttribute(WebElement e, String v) {
		elementVisibility(e);
		String attri = e.getAttribute(v);

		return attri;
	}

	/**
	 * @see Method to verify WebElement Displayed or Not
	 * @param e
	 * @return
	 */
	public boolean isDisplayed(WebElement e) {
		elementVisibility(e);
		boolean displayed = e.isDisplayed();
		return displayed;

	}

	/**
	 * @see Method to verify WebElement is Selected or Not
	 * @param e
	 * @return
	 */
	public boolean isSelected(WebElement e) {
		elementVisibility(e);
		boolean selected = e.isSelected();
		return selected;

	}

	/**
	 * @see Method to Navigate the WebPage Forward
	 */
	// Navigation:I
	public void forward() {
		navigate().forward();

	}

	/**
	 * @see Method to Navigate the WebPage Backward
	 */
	public void back() {
		navigate().back();
	}

	/**
	 * @see Method to Refresh the WebPage
	 */
	public void refresh() {
		navigate().refresh();
	}

	/**
	 * @see Method to Navigate Driver to Particular WebPage
	 * @param s
	 */
	public void to(String s) {
		navigate().to(s);
	}

	/**
	 * @see Method to Initialize Mouse Actions to the Driver
	 * @return
	 */
	public Actions actions() {
		Actions actions = new Actions(driver);
		return actions;
	}

	/**
	 * @see Method to Initialize MouseOver Action to the WebElement
	 * @param e
	 */
	public void moveToElement(WebElement e) {
		elementVisibility(e);
		actions().moveToElement(e).perform();

	}

	/**
	 * @see Method to Perform Right Click to the WebElement
	 */
	public void contextClick() {
		actions().contextClick().perform();
	}

	/**
	 * @see Method to Perform Double Click to the WebElement
	 */
	public void doubleClick() {
		actions().doubleClick().perform();
	}

	/**
	 * @see Method to Drag and Drop the WebElement
	 * @param e
	 * @param target
	 */
	public void dragAndDrop(WebElement e, WebElement target) {
		elementVisibility(e);
		elementVisibility(target);
		actions().dragAndDrop(e, target).perform();
	}

	// public void keyUp(String s) { actions().keyUp(Keys.s); }

	/**
	 * @see Method to Initialize SelectClass for DropDown
	 * @param e
	 * @return
	 */
	public Select select(WebElement e) {
		elementVisibility(e);
		Select s = new Select(e);
		return s;
	}

	/**
	 * @see Method to Select the WebElement using Index
	 * @param e
	 * @param index
	 */
	public void selectByIndex(WebElement e, int index) {
		elementVisibility(e);
		select(e).selectByIndex(index);
	}

	/**
	 * @see Method to Select the WebElement using value
	 * @param e
	 * @param value
	 */
	public void selectByValue(WebElement e, String value) {
		elementVisibility(e);
		select(e).selectByValue(value);
	}

	/**
	 * @see Method to Select the WebElement using VisibleText
	 * @param e
	 * @param text
	 */
	public void selectByVisibleText(WebElement e, String text) {
		elementVisibility(e);
		select(e).selectByVisibleText(text);
	}

	/**
	 * @see Method to DeSelect the WebElement using Index
	 * @param e
	 * @param index
	 */
	public void deselectByIndex(WebElement e, int index) {
		elementVisibility(e);
		select(e).deselectByIndex(index);
	}

	/**
	 * @see Method to DeSelect the WebElement using Value
	 * @param e
	 * @param value
	 */
	public void deselectByValue(WebElement e, String value) {
		elementVisibility(e);
		select(e).deselectByValue(value);
	}

	/**
	 * @see Method to DeSelect the WebElement using VisibleText
	 * @param e
	 * @param text
	 */
	public void deselectByVisibleText(WebElement e, String text) {
		elementVisibility(e);
		select(e).deselectByVisibleText(text);
	}

	/**
	 * @see Method to get the List of WebElement Options
	 * @param e
	 * @return
	 */
	public List<WebElement> getoptions(WebElement e) {
		elementVisibility(e);
		List<WebElement> options = select(e).getOptions();
		return options;
	}

	/**
	 * @see Method to DeSelect all the WebElement
	 * @param e
	 */
	public void deselectAll(WebElement e) {
		elementVisibility(e);
		select(e).deselectAll();
	}

	/**
	 * @see Method to find the DropDown has Multiple Options or Not
	 * @param e
	 * @return
	 */
	public boolean isMultiple(WebElement e) {
		elementVisibility(e);
		boolean multiple = select(e).isMultiple();
		return multiple;
	}

	/**
	 * @see Method to get all Selected Options from the DropDown
	 * @param e
	 * @return
	 */
	public List<WebElement> getAllSelectedOptions(WebElement e) {
		elementVisibility(e);
		List<WebElement> allSelectedOptions = select(e).getAllSelectedOptions();
		return allSelectedOptions;
	}

	/**
	 * @see Method to get First Selected Option from the DropDown
	 * @param e
	 * @return
	 */
	public WebElement getFirstSelectedOption(WebElement e) {
		elementVisibility(e);
		WebElement firstSelectedOption = select(e).getFirstSelectedOption();
		return firstSelectedOption;
	}

	/**
	 * @see Method to Initialize Alert Handling to Driver
	 * @return
	 */
	public Alert alert() {
		Alert al = switchTo().alert();
		return al;
	}

	/**
	 * @see Method to Accept the Alert PopUp
	 */
	public void accept() {
		alert().accept();
	}

	/**
	 * @see Method to Dismiss the Alert PopUp
	 */
	public void dismiss() {
		alert().dismiss();
	}

	/**
	 * @see Method to Send Values to the Alert PopUp
	 * @param c
	 */
	public void alertSendkeys(String c) {
		alert().sendKeys(c);

	}

	/**
	 * @see Method to get the text values from the Alert PopUp
	 * @return
	 */
	public String alertGetText() {
		String text = alert().getText();
		return text;
	}

	/**
	 * @see Method to Switch in Inner Frames using Name or Id
	 * @param nameOrId
	 * @return
	 */
	public WebDriver frameId(String nameOrId) {
		WebDriver frame = switchTo().frame(nameOrId);
		return frame;
	}

	/**
	 * @see Method to Switch in Inner Frames using Name or Id
	 * @param nameOrId
	 * @return
	 */
	public WebDriver frameName(String nameOrId) {
		WebDriver frame = switchTo().frame(nameOrId);
		return frame;
	}

	/**
	 * @see Method to Switch in Inner Frames using Index Value
	 * @param index
	 * @return
	 */
	public WebDriver frameIndex(int index) {
		WebDriver frame = switchTo().frame(index);
		return frame;
	}

	/**
	 * @see Method to Switch in Inner Frames using WebElement
	 * @param e
	 * @return
	 */
	public WebDriver frameWebElement(WebElement e) {
		elementVisibility(e);
		WebDriver frame = switchTo().frame(e);
		return frame;
	}

	/**
	 * @see Method to maximize the Browser Window
	 */
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * @see Method to Initialize Fixed Time Interval
	 * @param seconds
	 */
	public static void implicitWait(long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

	}

	/**
	 * @see Method to get Datas From The Exel File
	 * @param name
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException
	 */
	public String getData(String name, int rownum, int cellnum) throws IOException {
		String value = null;
		File f = new File("C:\\Users\\natha\\eclipse-workspace\\Second\\ExcelSheets\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet s = w.getSheet(name);
		Row r = s.getRow(rownum);
		Cell c = r.getCell(cellnum);
		CellType type = c.getCellType();
		switch (type) {
		case STRING:
			value = c.getStringCellValue();

			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(c)) {
				Date d = c.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				value = dateFormat.format(d);
			} else {
				double numericCellValue = c.getNumericCellValue();
				long l = (long) numericCellValue;
				value = String.valueOf(l);

			}

		default:
			break;
		}
		return value;
	}

	/**
	 * @see Method to Update Values in the Exel File
	 * @param name
	 * @param rownum
	 * @param cellnum
	 * @param her
	 * @throws IOException
	 */
	public static void updateData(String name, int rownum, int cellnum, String her) throws IOException {
		File f = new File("C:\\Users\\natha\\eclipse-workspace\\Second\\ExcelSheets\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(name);
		Row r = sheet.getRow(rownum);
		Cell c = r.createCell(cellnum);
		c.setCellValue(her);
		FileOutputStream op = new FileOutputStream(f);
		w.write(op);

	}

}

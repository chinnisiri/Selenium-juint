package ButtonsAndCheckBox;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

// it should start with Test..
//it should end with Test..
public class TestJUint {
	static WebDriver driver;
	
	//@BeforeEach  // JUint 5 version
	@BeforeAll
	public static void browserLaunch()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Resources\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
		
		//driver.manage().window().maximize();

	}
	
	@Tag("checkBox")
	@Tag("sanity")
	@Test // JUint 4 version
	@RepeatedTest(value=3) // 3 times this check box is executed
	@DisplayName("This test is test the  click the checkBox in selenium")
	@Order(2)
	public void checkBoxTest() throws InterruptedException
	{
		driver.get("https://demoqa.com");
		WebElement Elements = driver.findElement(By.xpath("//*[text()='Elements']"));
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()",Elements );
		
		WebElement checkbox = driver.findElement(By.xpath("//span[text()=\"Check Box\"]"));
		checkbox.click();
		
		WebElement taggle = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
		taggle.click();
		Thread.sleep(2000);
		
		WebElement checkboxDes = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button"));
		checkboxDes.click();
		Thread.sleep(2000);
		
		WebElement checkboxDesCommands = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/ol/li[2]/span/label/span[1]"));
		checkboxDesCommands.click();
		
		WebElement checkboxDoc = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button"));
		checkboxDoc.click();
		Thread.sleep(2000);
		
		WebElement checkboxDocWorkSpaces = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button"));
		checkboxDocWorkSpaces.click();
		
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 500).perform();
		WebElement checkboxDocWorkSpacesAng = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/ol/li[2]/span/label/span[1]"));
		checkboxDocWorkSpacesAng.click();
	
		
		WebElement checkboxDocOffice = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button"));
		checkboxDocOffice.click();
		
		WebElement checkboxDocOfficeGen = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/ol/li[4]/span/label/span[1]"));
		checkboxDocOfficeGen.click();
		
		
		WebElement checkboxDown = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button"));
		checkboxDown.click();
		
		WebElement checkboxDowWordFile = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/ol/li[1]/span/label/span[1]"));
		checkboxDowWordFile.click();
	}
	
	//@Disabled
	@Tag("Button")
	@Tag("sanity")
	@ParameterizedTest
	@ValueSource(strings= {}) // all the Datatypes are supported [ regularly not used]
	@Order(1)
	//@Test
	public void buttonsTest(String str) throws InterruptedException
	{
		driver.get("https://demoqa.com");
		JavascriptExecutor js =(JavascriptExecutor)driver;
		WebElement Elements = driver.findElement(By.xpath("//*[text()='Elements']"));
		js.executeScript("arguments[0].click()",Elements );
		
		
		//Elements.click();
		
		WebElement Button = driver.findElement(By.xpath("//*[text()='Buttons']"));
		
		js.executeScript("arguments[0].click()",Button );
		//Button.click();
		
		//DoubleClick
		Actions act = new Actions(driver);
		WebElement DoubleClick1 = driver.findElement(By.xpath("//*[@id='doubleClickBtn']"));
		act.doubleClick(DoubleClick1).perform();
		//Thread.sleep(2000);
		
		System.out.println( driver.findElement(By.xpath("//*[@id='doubleClickMessage']")).getText());

		
		//RightClick;
		WebElement RightClick = driver.findElement(By.xpath("//*[@id='rightClickBtn']"));
		act.moveToElement(RightClick, 3, 3).build().perform();
		act.contextClick(RightClick).perform();
		System.out.println( driver.findElement(By.xpath("//*[@id='rightClickMessage']")).getText());
		//Thread.sleep(2000);
		
		//NormalCLick [LeftClick]
		WebElement ClickMe = driver.findElement(By.xpath("//*[text()='Click Me']"));
		ClickMe.click();
		System.out.println( driver.findElement(By.xpath("//*[@id='dynamicClickMessage']")).getText());
		
			
	}
	
   // @AfterEach
    @AfterAll
	public  static void closeBrowser () {
	driver.close();
	}
}

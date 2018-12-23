package startGoogle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class searchTest {

    protected static WebDriver driver;
    protected static Logger logger = Logger.getLogger(searchTest.class.getName());

    @Before
    public void setUpTest(){
        logger.log(Level.INFO, "< **** Application started. **** >");

        System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }



    @Test
    public void searchTest(){
        driver.get("https://google.com");

        driver.findElement(By.name("q")).sendKeys("Test");
        driver.findElement(By.name("btnK")).click();

        List<WebElement> h3 = driver.findElements(By.cssSelector("h3"));

        for (WebElement element: h3) {
            logger.log(Level.INFO, "< "+element.getText()+" >");
        }
    }


    @After
    public void closeTest(){
        driver.quit();
        logger.log(Level.INFO, "< **** Application finished. **** >");
    }
}

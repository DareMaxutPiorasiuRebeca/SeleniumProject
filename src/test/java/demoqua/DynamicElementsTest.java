package demoqua;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicElementsTest {
    WebDriver driver;



    @BeforeTest(alwaysRun = true)
    public void SetUp(){
        //open page
        String url = "https://demoqa.com/dynamic-properties";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
    @Test
    public void checkDynamicElementTest(){

        //waitNumberOfMilliseconds(6000);
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("visibleAfter")));

        WebElement visibleAfterButton = driver.findElement(By.id("visibleAfter"));
        Assert.assertTrue(visibleAfterButton.isDisplayed());

    }
    @AfterTest(alwaysRun = true)
    public void tearDown (){
        driver.close();
    }
    /*public void waitNumberOfMillisecond(int miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/
}

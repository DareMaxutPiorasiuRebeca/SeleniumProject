package kerokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.crypto.KeyAgreementSpi;

public class DownloadTest {
    WebDriver driver;



    @BeforeTest(alwaysRun = true)
    public void SetUp(){
        //open page
        String url = "https://the-internet.herokuapp.com/download";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void downloadTest(){

        WebElement downloadLink = driver.findElement(By.linkText("Test1.txt"));
        downloadLink.click();
        downloadLink.sendKeys(Keys.ENTER);
        String downloadPath = "C:\\Users\\Ana\\Downloads\\Test1.txt";

        Assert.assertFalse(downloadPath.isEmpty());

    }
    @AfterTest(alwaysRun = true)
    public void tearDown (){
        driver.close();
    }
}

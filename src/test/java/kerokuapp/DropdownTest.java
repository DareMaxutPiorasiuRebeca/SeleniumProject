package kerokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropdownTest {
    WebDriver driver;



    @BeforeTest(alwaysRun = true)
    public void SetUp(){
        //open page
        String url = "https://the-internet.herokuapp.com/dropdown";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void dropdownTest(){
        WebElement dropdown = driver.findElement(By.xpath("/html//select[@id='dropdown']"));
        Select option = new Select(dropdown);

        option.selectByValue("2");

        WebElement option2 = driver.findElement(By.xpath("//*[@id=\"dropdown\"]/option[3]"));

        Assert.assertTrue(option2.isSelected());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown (){
        driver.close();
    }
}

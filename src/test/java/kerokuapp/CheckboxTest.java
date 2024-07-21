package kerokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckboxTest {
    WebDriver driver;



    @BeforeTest(alwaysRun = true)
    public void SetUp(){
        //open page
        String url = "https://the-internet.herokuapp.com/checkboxes";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void selectCheckboxses(){
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        if (!checkbox1.isSelected()){
            checkbox1.click();}
        Assert.assertTrue(checkbox1.isSelected());

        if (!checkbox2.isSelected()){
            checkbox2.click();}
        Assert.assertTrue(checkbox2.isSelected());
    }
    @Test
    public void unselectCheckboxes(){
        WebElement checkbox1 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));

        if (checkbox1.isSelected()){
            checkbox1.click();}
        Assert.assertFalse(checkbox1.isSelected());

        if (checkbox2.isSelected()){
            checkbox2.click();}
        Assert.assertFalse(checkbox2.isSelected());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown (){
        driver.close();
    }
}

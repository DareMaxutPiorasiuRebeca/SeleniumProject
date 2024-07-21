package kerokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UploadTest {
    WebDriver driver;



    @BeforeTest(alwaysRun = true)
    public void SetUp(){
        //open page
        String url = "https://the-internet.herokuapp.com/upload";
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void uploadTest(){

        WebElement chooseFileButton = driver.findElement(By.xpath("/html//input[@id='file-upload']"));
        chooseFileButton.sendKeys("C:\\Users\\Ana\\IdeaProjects\\SeleniumProject\\src\\test\\resources\\myFile.txt");

        WebElement uploadButton = driver.findElement(By.xpath("/html//input[@id='file-submit']"));
        uploadButton.click();

        WebElement succesMessage = driver.findElement(By.xpath("//div[@id='content']//h3[.='File Uploaded!']"));
        String expectedMessage ="File Uploaded!";
        Assert.assertTrue(succesMessage.getText().contains(expectedMessage));

        WebElement uploadedFile = driver.findElement(By.id("uploaded-files"));
        String expectedTest = "myFile.txt";
        Assert.assertTrue(uploadedFile.getText().contains(expectedTest));
    }
    @AfterTest(alwaysRun = true)
    public void tearDown (){
        driver.close();
    }
}

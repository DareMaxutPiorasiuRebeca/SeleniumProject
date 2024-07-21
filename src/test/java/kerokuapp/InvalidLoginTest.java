package kerokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class InvalidLoginTest {

    WebDriver driver;

    @Parameters({"browserParam"})
    @BeforeTest(alwaysRun = true)
    public void SetUp(@Optional ("chrome") String browser){
        //open page
        String url = "https://the-internet.herokuapp.com/login";


        //driver = new ChromeDriver();
        switch (browser){
            case "chrome": driver = new ChromeDriver();break;
            case "edge": driver= new EdgeDriver();break;
            default: driver = new ChromeDriver();break;
        }

        driver.get(url);
        driver.manage().window().maximize();
    }

    @Parameters({"usernameParam","passwordParam","errorMesageParam"})
    @Test // anable = false nu se executa
    public void invalidLogin(String username, String password, String errorMessage){
        //enter username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys(username);
        //enter password
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys(password);
        //click Login
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        //check error message
        WebElement errorAlert = driver.findElement(By.id("flash"));
        String expectedErrorMessage = errorMessage; //error message
        String actualErrorMesage = errorAlert.getText();
        Assert.assertTrue(actualErrorMesage.contains(expectedErrorMessage));
    }


    /*@Test
    public void invalidPasswordTest(){
        //enter username
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("tomsmith");
        //enter password
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("password");
        //click Login
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();
        //check error message
        WebElement errorAlert1 = driver.findElement(By.id("flash"));
        String expectedErrorMessage1 = "Your password is invalid!"; //error message
        String actualErrorMesage1 = errorAlert1.getText();
        Assert.assertTrue(actualErrorMesage1.contains(expectedErrorMessage1));
    }*/

    @AfterTest(alwaysRun = true)
    public void tearDown(){
        driver.close();
    }
}

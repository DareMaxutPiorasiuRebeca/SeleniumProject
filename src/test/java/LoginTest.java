import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test

    public void loginTest(){

        //open page
        String url = "https://the-internet.herokuapp.com/login";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        // enter username
        WebElement usernameImput = driver.findElement(By.id("username"));
        usernameImput.sendKeys("tomsmith");

        // enter password
        WebElement passWordImput = driver.findElement(By.name("password"));
        passWordImput.sendKeys("SuperSecretPassword!");

        //click login
        WebElement loginButton = driver.findElement(By.tagName("button"));
        loginButton.click();


        //check loading url
        String expectedURl = "https://the-internet.herokuapp.com/secure";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURl,actualURL);

        //check logaut is present
        WebElement logoutButton = driver.findElement(By.linkText("Logout"));
        Assert.assertTrue(logoutButton.isDisplayed());

        //check success login message
        WebElement successAlert = driver.findElement(By.className("flash"));
        String expectedMessage = "You logged into a secure area!";
        String actualMessage = successAlert.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        //close page
        driver.close();


    }
}

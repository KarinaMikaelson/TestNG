package class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class hardAssertion {
    WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test(dependsOnMethods = {"loginBtnDisplayedAndEnabled"})
    public void loginVerification(){
        WebElement username = driver.findElement (By.xpath ("//input[@name='txtUsername']"));
        username. sendKeys("Admin");
        WebElement password = driver.findElement (By.xpath ("//input[@id = 'txtPassword']"));
        password. sendKeys("HAS TO FAIL");
        WebElement loginBtn = driver.findElement (By.xpath("//input[@name='Submit']")) ;
        loginBtn.click();

//          verify that correct INVALID CREDENTIALS displayed
        String actualErrorMsg = driver.findElement(By.id("spanMessage")).getText();    //inspect "Invalid password" element \
        Assert.assertEquals(actualErrorMsg,"Invalid credentials");

    }
    @Test
    public void loginBtnDisplayedAndEnabled(){
        WebElement loginBtn = driver.findElement (By.xpath("//input[@name='Submit']")) ;
        Assert.assertTrue(loginBtn.isDisplayed(),"login button is not displayed");
        Assert.assertTrue(loginBtn.isEnabled(),"login button is disabled");
        System.out.println("Login button is displayed and enabled");
    }
    @AfterMethod
    public void endTest(){
        driver.quit();
        System.out.println("Test has been executed");
    }
}

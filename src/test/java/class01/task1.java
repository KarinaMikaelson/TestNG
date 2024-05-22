package class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class task1 {
    // First test case: go to hrms, login and verify that user has logged in
    // second test case: go to hrms and verify that the login btn is present
    public static WebDriver driver;
    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void loginVerification(){
        WebElement username = driver.findElement (By.xpath ("//input[@name='txtUsername']"));
        username. sendKeys("Admin");
        WebElement password = driver.findElement (By.xpath ("//input[@id = 'txtPassword']"));
        password. sendKeys("Hum@nhrm123");
        WebElement loginBtn = driver.findElement (By.xpath("//input[@name='Submit']")) ;
        loginBtn.click();
        System.out.println("I am logged in");
//      Testing login
    }
    @Test
    public void loginBtnEnabled(){
        WebElement loginBtn = driver.findElement(By.xpath("//input[@name='Submit']"));
        System.out.println(loginBtn.isEnabled());
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}

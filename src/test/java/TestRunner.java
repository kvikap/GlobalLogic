import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRunner {
    public static WebDriver driver;
    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://semantic-ui.com/examples/login.html");
    }

    @Test
    public void login(){
        WebElement loginfield= driver.findElement(By.cssSelector("body > div > div > form > div.ui.stacked.segment > div:nth-child(1) > div > input[type=text]"));
        //imagine we signed up the system with login test_mail@gmail.com and password pass1111
        loginfield.sendKeys("test_mail@gmail.com");
        WebElement passwordfield= driver.findElement(By.cssSelector("body > div > div > form > div.ui.stacked.segment > div:nth-child(2) > div > input[type=password]"));
        passwordfield.sendKeys("pass1111");
        driver.findElement(By.cssSelector("body > div > div > form > div.ui.stacked.segment > div.ui.fluid.large.teal.submit.button")).click();
        //imagine we know expected url
        String expectedUrl="https://semantic-ui.com/examples/login.html?tab=successful_login";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
    }

    @AfterClass
    public static void exit(){
        driver.quit();
    }
}
package selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.fail;

public class AbstractSeleniumTest {

    protected WebDriver driver;
    String baseUrl;
    protected boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("http://localhost:8080");
    }

    protected void login() {
        driver.get(baseUrl);
        driver.findElement(By.id("loginForm_dni")).clear();
        driver.findElement(By.id("loginForm_dni")).sendKeys("12345678Z");
        driver.findElement(By.id("loginForm_email")).clear();
        driver.findElement(By.id("loginForm_email")).sendKeys("josemanuel.dopereiro@mail.com");
        driver.findElement(By.id("loginForm_password")).clear();
        driver.findElement(By.id("loginForm_password")).sendKeys("jose");
        driver.findElement(By.id("loginForm_0")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}

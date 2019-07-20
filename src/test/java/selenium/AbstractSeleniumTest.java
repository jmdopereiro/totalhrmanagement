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
    protected String baseUrl;
    protected boolean acceptNextAlert = true;
    protected StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() {
        driver = new FirefoxDriver();
        baseUrl = "http://localhost:8080/";//https://totalhrmanagement.appspot.com/
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    protected void loginCandidate() {
        login("12345678Z", "juan@hotmail.com", "juan");
    }

    protected void loginResponsable(String dni, String email, String password) {
        login(dni, email, password);
    }

    private void login(String dni, String email, String password) {
        driver.get(baseUrl);
        driver.findElement(By.id("loginForm_dni")).clear();
        driver.findElement(By.id("loginForm_dni")).sendKeys(dni);
        driver.findElement(By.id("loginForm_email")).clear();
        driver.findElement(By.id("loginForm_email")).sendKeys(email);
        driver.findElement(By.id("loginForm_password")).clear();
        driver.findElement(By.id("loginForm_password")).sendKeys(password);
        driver.findElement(By.id("loginForm_0")).click();
    }

    protected void logout() {
        driver.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}

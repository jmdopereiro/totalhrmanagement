import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Selenium2Exapmple {


    public static void main(String args[]) {

        System.setProperty("webdriver.gecko.driver", "/Users/josemanueldopereiro/IdeaProjects/totalhrmanagement/geckodriver");

        WebDriver webDriver = new FirefoxDriver();

        webDriver.get("http://localhost:8080");



    }
}

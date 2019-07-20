package selenium;

import org.junit.Test;
import org.openqa.selenium.By;

import static org.junit.Assert.assertEquals;

public class Login extends AbstractSeleniumTest {

    @Test
    public void testLogin() {
        loginResponsable("A58818501", "robert.atkins@mail.com", "robert");
    }

    @Test
    public void testLogout() throws Exception {
        logout();
        try {
            assertEquals("About Total HR Management", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Privacy policy'])[1]/following::h3[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

}

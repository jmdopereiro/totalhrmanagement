package selenium.candidate;

import org.junit.Test;
import org.openqa.selenium.By;
import selenium.AbstractSeleniumTest;

import static org.junit.Assert.assertEquals;

public class Create extends AbstractSeleniumTest {

    @Test
    public void testCreate() {

        driver.findElement(By.cssSelector("img[alt=\"Registrate ahora\"]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select an option'])[1]/following::label[1]")).click();
        driver.findElement(By.id("formCandidato_candidato_dni")).clear();
        driver.findElement(By.id("formCandidato_candidato_dni")).sendKeys("12345678Z");
        driver.findElement(By.id("formCandidato_candidato_nombre")).clear();
        driver.findElement(By.id("formCandidato_candidato_nombre")).sendKeys("Juan");
        driver.findElement(By.id("formCandidato_candidato_apellidos")).clear();
        driver.findElement(By.id("formCandidato_candidato_apellidos")).sendKeys("Martinez");
        driver.findElement(By.id("formCandidato_candidato_email")).clear();
        driver.findElement(By.id("formCandidato_candidato_email")).sendKeys("juan@hotmail.com");
        driver.findElement(By.id("formCandidato_email")).clear();
        driver.findElement(By.id("formCandidato_email")).sendKeys("juan@hotmail.com");
        driver.findElement(By.id("formCandidato_pass")).clear();
        driver.findElement(By.id("formCandidato_pass")).sendKeys("juan");
        driver.findElement(By.id("formCandidato_candidato_password")).clear();
        driver.findElement(By.id("formCandidato_candidato_password")).sendKeys("juan");
        driver.findElement(By.id("registrarCand")).click();
        try {
            assertEquals("Jose", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Last offers'])[1]/following::h3[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Logout")).click();
    }

}

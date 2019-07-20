package selenium.candidate.offer;

import org.junit.Test;
import org.openqa.selenium.By;
import selenium.AbstractSeleniumTest;

import static org.junit.Assert.assertEquals;

public class RegisterInOffer extends AbstractSeleniumTest {

    @Test
    public void testInscribirseEnOferta() {
        loginCandidate();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Home'])[1]/following::b[1]")).click();
        driver.findElement(By.linkText("Technical Consultant")).click();
        driver.findElement(By.linkText("Pulsa aqui para inscribirte")).click();
        try {
            assertEquals("Technical Consultant", driver.findElement(By.linkText("Technical Consultant")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("Logout")).click();
    }

    @Test
    public void testUnregisterFromOffer() {
        loginCandidate();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Companies'])[1]/following::b[1]")).click();
        driver.findElement(By.linkText("Technical Consultant")).click();
        driver.findElement(By.id("botonEliminarInscripcion")).click();
        driver.findElement(By.id("eliminarInscripcion_palabraClave")).click();
        driver.findElement(By.id("eliminarInscripcion_palabraClave")).clear();
        driver.findElement(By.id("eliminarInscripcion_palabraClave")).sendKeys("ELIMINAR");
        driver.findElement(By.id("eliminarInscripcion_0")).click();
        try {
            assertEquals("Youre not registered in any offer", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Logout'])[1]/following::strong[1]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

}

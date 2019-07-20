package selenium.candidate;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import selenium.AbstractSeleniumTest;

import static org.junit.Assert.assertEquals;

public class Edit extends AbstractSeleniumTest {

    @Test
    public void testEdit() {
        loginResponsable("A58818501", "robert.atkins@mail.com", "robert");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My inscriptions'])[1]/following::b[1]")).click();
        driver.findElement(By.linkText("Pulsa aqui")).click();
        driver.findElement(By.id("botonFormacion")).click();
        driver.findElement(By.id("botonFormularioConocimiento")).click();
        driver.findElement(By.id("formConocimiento_conocimientoEnCandidato_nivel")).click();
        new Select(driver.findElement(By.id("formConocimiento_conocimientoEnCandidato_nivel"))).selectByVisibleText("Muy alto");
        driver.findElement(By.id("formConocimiento_0")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Companies'])[1]/following::b[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My inscriptions'])[1]/following::b[1]")).click();
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Personal info'])[1]/following::span[1]")).click();
        assertEquals("Muy alto", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Java'])[1]/following::td[1]")).getText());
    }

}

package selenium.candidate;

import org.junit.Test;
import org.openqa.selenium.By;
import selenium.AbstractSeleniumTest;

public class Delete extends AbstractSeleniumTest {

    @Test
    public void testDelete() {
        loginResponsable("A58818501", "robert.atkins@mail.com", "robert");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='My inscriptions'])[1]/following::b[1]")).click();
        driver.findElement(By.id("botonEliminarPerfil")).click();
        driver.findElement(By.id("eliminarPerfil_palabraClave")).click();
        driver.findElement(By.id("eliminarPerfil_palabraClave")).clear();
        driver.findElement(By.id("eliminarPerfil_palabraClave")).sendKeys("ELIMINAR");
        driver.findElement(By.id("eliminarPerfil_0")).click();
    }

}

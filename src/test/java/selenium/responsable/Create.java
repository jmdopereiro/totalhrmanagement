package selenium.responsable;

import org.junit.Test;
import org.openqa.selenium.By;
import selenium.AbstractSeleniumTest;

public class Create extends AbstractSeleniumTest {

    @Test
    public void testRegistrar() throws Exception {
//        registrarResponsable("A58818501", "1111", "A58818501", "Robert", "Atkins", "robert.atkins@mail.com", "robert");
        registrarResponsable("03914762", "03914762", "03914762", "Albert", "Downs", "adowns@redsapsolutions.com", "albert");
    }

    private void registrarResponsable(String cif, String codigo, String dni, String nombre, String apellido, String email, String password) {
        driver.get("http://localhost:8080/index.jsp");
        driver.findElement(By.cssSelector("img[alt=\"Registrate ahora\"]")).click();
        driver.findElement(By.xpath("//div[@id='roles']/label[2]/span")).click();
        driver.findElement(By.id("formResponsable_cif")).clear();
        driver.findElement(By.id("formResponsable_cif")).sendKeys(cif);
        driver.findElement(By.id("formResponsable_codigo")).clear();
        driver.findElement(By.id("formResponsable_codigo")).sendKeys(codigo);
        driver.findElement(By.id("formResponsable_responsable_dni")).clear();
        driver.findElement(By.id("formResponsable_responsable_dni")).sendKeys(dni);
        driver.findElement(By.id("formResponsable_responsable_nombre")).clear();
        driver.findElement(By.id("formResponsable_responsable_nombre")).sendKeys(nombre);
        driver.findElement(By.id("formResponsable_responsable_apellidos")).clear();
        driver.findElement(By.id("formResponsable_responsable_apellidos")).sendKeys(apellido);
        driver.findElement(By.id("formResponsable_email")).clear();
        driver.findElement(By.id("formResponsable_email")).sendKeys(email);
        driver.findElement(By.id("formResponsable_responsable_email")).clear();
        driver.findElement(By.id("formResponsable_responsable_email")).sendKeys(email);
        driver.findElement(By.id("formResponsable_pass")).clear();
        driver.findElement(By.id("formResponsable_pass")).sendKeys(password);
        driver.findElement(By.id("formResponsable_responsable_password")).clear();
        driver.findElement(By.id("formResponsable_responsable_password")).sendKeys(password);
        driver.findElement(By.id("registrarResp")).click();
    }

}

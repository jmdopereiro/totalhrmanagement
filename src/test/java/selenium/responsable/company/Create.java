package selenium.responsable.company;

import org.junit.Test;
import org.openqa.selenium.By;
import selenium.AbstractSeleniumTest;

public class Create extends AbstractSeleniumTest {

    @Test
    public void testCreate() {
        driver.get(baseUrl);
//        createCompany("A58818501", "Researchers Limited", "1111");
        createCompany("03914762", "Red Sap Solutions", "03914762");
    }

    private void createCompany(String cif, String nombre, String codigo) {
        driver.findElement(By.cssSelector("img[alt=\"Registrate ahora\"]")).click();
        driver.findElement(By.xpath("//div[@id='roles']/label[3]/span")).click();
        driver.findElement(By.id("formEmpresa_empresa_cif")).clear();
        driver.findElement(By.id("formEmpresa_empresa_cif")).sendKeys(cif);
        driver.findElement(By.id("formEmpresa_empresa_nombre")).clear();
        driver.findElement(By.id("formEmpresa_empresa_nombre")).sendKeys(nombre);
        driver.findElement(By.id("formEmpresa_empresa_codigo")).clear();
        driver.findElement(By.id("formEmpresa_empresa_codigo")).sendKeys(codigo);
        driver.findElement(By.id("registrarEmpr")).click();
    }

}

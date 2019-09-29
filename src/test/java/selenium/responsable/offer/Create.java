package selenium.responsable.offer;

import org.junit.Test;
import org.openqa.selenium.By;
import selenium.AbstractSeleniumTest;

public class Create extends AbstractSeleniumTest {

    @Test
    public void testCreate() {
//        loginResponsable("A58818501", "robert.atkins@mail.com", "robert");
//        createOffer("Technical Consultant", "24/05/2019", "24/11/2019", "descripcion", "Indefinida", "Completa", "Madrid", "20000", "30000", "bonus", "2", "3", "20", "30", "otros datos");
//        logout();
        loginResponsable("03914762", "adowns@redsapsolutions.com", "albert");

        for (int i = 0; i < 10; i++) {
            createOffer("JAVA Developer Consultant"+i, "01/01/2019", "31/12/2019", "descripcion", "Temporal", "Parcial", "Barcelona", "19000", "35000", "paga extra", "1", "3", "18", "", "");
        }

        logout();
    }

    private void createOffer(String nombre, String fechaInicio, String fechaFin, String descripcion, String duracion, String jornada, String poblacion, String salarioMin, String salarioMax, String retribuciones, String expMin, String expMax, String edadMin, String edadMax, String otrosDatos) {
        driver.findElement(By.xpath("//div[@id='pm_main']/ul/li[2]/a/b")).click();
        driver.findElement(By.id("botonCrearOferta")).click();
        driver.findElement(By.xpath("//input[@name='oferta.tipoOferta']")).click();
        driver.findElement(By.xpath("//input[@name='oferta.tipoContrato']")).click();
        driver.findElement(By.id("formOferta_oferta_nombre")).clear();
        driver.findElement(By.id("formOferta_oferta_nombre")).sendKeys(nombre);
        driver.findElement(By.xpath("//input[@name='oferta.fechaInicio']")).clear();
        driver.findElement(By.xpath("//input[@name='oferta.fechaInicio']")).sendKeys(fechaInicio);
        driver.findElement(By.xpath("//input[@name='oferta.fechaFin']")).clear();
        driver.findElement(By.xpath("//input[@name='oferta.fechaFin']")).sendKeys(fechaFin);
        driver.findElement(By.id("formOferta_oferta_descripcion")).clear();
        driver.findElement(By.id("formOferta_oferta_descripcion")).sendKeys(descripcion);
        driver.findElement(By.id("formOferta_oferta_duracion")).clear();
        driver.findElement(By.id("formOferta_oferta_duracion")).sendKeys(duracion);
        driver.findElement(By.id("formOferta_oferta_jornada")).clear();
        driver.findElement(By.id("formOferta_oferta_jornada")).sendKeys(jornada);
        driver.findElement(By.id("formOferta_oferta_poblacion")).clear();
        driver.findElement(By.id("formOferta_oferta_poblacion")).sendKeys(poblacion);
        driver.findElement(By.id("formOferta_oferta_remuneracionminima")).clear();
        driver.findElement(By.id("formOferta_oferta_remuneracionminima")).sendKeys(salarioMin);
        driver.findElement(By.id("formOferta_oferta_remuneracionmaxima")).clear();
        driver.findElement(By.id("formOferta_oferta_remuneracionmaxima")).sendKeys(salarioMax);
        driver.findElement(By.id("formOferta_oferta_otrasretribuciones")).clear();
        driver.findElement(By.id("formOferta_oferta_otrasretribuciones")).sendKeys(retribuciones);
        driver.findElement(By.id("formOferta_oferta_experienciaminima")).clear();
        driver.findElement(By.id("formOferta_oferta_experienciaminima")).sendKeys(expMin);
        driver.findElement(By.id("formOferta_oferta_experienciaMaxima")).clear();
        driver.findElement(By.id("formOferta_oferta_experienciaMaxima")).sendKeys(expMax);
        driver.findElement(By.id("formOferta_oferta_edadMinima")).clear();
        driver.findElement(By.id("formOferta_oferta_edadMinima")).sendKeys(edadMin);
        driver.findElement(By.id("formOferta_oferta_edadMaxima")).clear();
        driver.findElement(By.id("formOferta_oferta_edadMaxima")).sendKeys(edadMax);
        driver.findElement(By.id("formOferta_oferta_otrosdatos")).clear();
        driver.findElement(By.id("formOferta_oferta_otrosdatos")).sendKeys(otrosDatos);
        driver.findElement(By.id("formOferta_0")).click();
    }

}

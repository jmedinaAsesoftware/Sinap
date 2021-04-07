package Sinap.Steps;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.TakesScreenshot;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.ibm.icu.text.SimpleDateFormat;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;

public class Questions {

	private WebDriver driver;

	public Questions(WebDriver driver) {
		this.driver = driver;
	}

	// Metodo generico para dar clic a un elemento
	public void clickOnElement(WebElement element) {
		element.click();
	}

	@Step
	public void screenShot() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filename = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		File dest = new File("C:\\Users\\jmedina\\Documents\\Captura\\screenshot" + filename + ".png");
		try {
			FileUtils.copyFile(scr, dest);
		} catch (IOException e) {
			e.printStackTrace();

		}
	}

	@Step
	public void tiempoSegundos(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Step
	public void impliciWait() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@Step
	public void AssertConfirmacionCrearVigencia() {

		Assert.assertEquals(" ¿Está seguro que quiere crear este periodo de vigencia? ",
				" ¿Está seguro que quiere crear este periodo de vigencia? ");
	}

	@Step
	public void AssertCrearPrescripcion() {

		Assert.assertEquals(" Desea crear la prescripción", " Desea crear la prescripción");
	}

	@Step
	public void AssertEditarPrescripcion() {
		String mensaje = driver.findElement(By.xpath("//mat-dialog-content[@class= 'mat-dialog-content']")).getText();
		Assert.assertEquals("¿Está seguro que quiere modificar esta prescripción?", mensaje);
	}

	@Step
	public void AssertVigenciaCreada() {

		String mensaje = driver.findElement(By.id("toast-container")).getText();
		Assert.assertEquals("Prescripcion creada satisfactoriamente.", mensaje);
	}

	@Step
	public void AssertVigenciaEditada() {

		String mensaje = driver.findElement(By.id("toast-container")).getText();
		Assert.assertEquals("Prescripcion actualizada satisfactoriamente.", mensaje);
	}

	@Step
	public void AssertCrearConceptoDebito() {

		String mensaje = driver
				.findElement(
						By.xpath("//article[contains(text(),'¿Está seguro que quiere crear este concepto de déb')]"))
				.getText();
		Assert.assertEquals("¿Está seguro que quiere crear este concepto de débito?", mensaje);
	}

	@Step
	public void AssertConceptoDebitoCreada() {

		String mensaje = driver.findElement(By.id("toast-container")).getText();
		Assert.assertEquals("Registro creado exitosamente!", mensaje);
	}

	@Step
	public void AssertConceptoDebitoEditada() {

		String mensaje = driver
				.findElement(By.xpath("//article[contains(text(),'¿Está seguro que quiere modificar este concepto?')]"))
				.getText();
		Assert.assertEquals("¿Está seguro que quiere modificar este concepto?", mensaje);
	}
	
	@Step
	public void AssertConceptoDebitoEditadoExitoso() {

		String mensaje = driver.findElement(By.id("toast-container")).getText();
		System.out.println(mensaje);
		Assert.assertEquals("Registro actualizado exitosamente!", mensaje);
		
	}
	
	@Step
	public void AssertConfirmarCalendarioPago() {

		String mensaje = driver
				.findElement(
						By.xpath("//article[contains(text(),'¿Está seguro que quiere crear este calendario de pago?')]"))
				.getText();
		Assert.assertEquals("¿Está seguro que quiere crear este calendario de pago?", mensaje);
	}
	
	@Step
	public void AssertCreadoCalendarioPagoExitoso() {
		
		String mensaje = driver.findElement(By.id("toast-container")).getText();
		System.out.println(mensaje);
		Assert.assertEquals("Calendario creado satisfactoriamente.", mensaje);
		
	}
	
	@Step
	public void AssertConfirmarEdicionCalendarioPago() {

		String mensaje = driver
				.findElement(
						By.xpath("//div[contains(text(),'¿Está seguro que quiere modificar este calendario?')]"))
				.getText();
		Assert.assertEquals("¿Está seguro que quiere modificar este calendario?", mensaje);
	}
}

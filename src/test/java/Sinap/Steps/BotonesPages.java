package Sinap.Steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.annotations.Step;

public class BotonesPages {

	private WebDriver driver;
	private Questions questions;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Gestión de parámetros')]")
	private WebElement BtnGestionParametros;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Calendario')]")
	private WebElement BtnGestionParametrosCalendario;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Normativas')]")
	private WebElement BtnConceptoDebito;

	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Vigencias')]")
	private WebElement BtnVigencia;

	@FindBy(how = How.XPATH, using = "//button[@class = 'mat-focus-indicator mat-raised-button mat-button-base mat-primary']")
	private WebElement BtnCrearVigencia;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Multas')]")
	private WebElement BtnMultas;

	@FindBy(how = How.XPATH, using = "//button//span[text()='Crear']")
	private WebElement BtnCrearFormulario;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Prescripciones')]")
	private WebElement BtnPrescripciones;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Crear prescripción')]")
	private WebElement BtnCrearPrescripcionesForumario;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Aceptar')]")
	private WebElement BtnAceptar;
	
	@FindBy(how = How.XPATH, using = "//*[@id='mat-dialog-4']/app-confirmation-dialog/section/mat-dialog-actions/button[2]")
	private WebElement BtnAceptarEspacio;

	@FindBy(how = How.XPATH, using = "//tbody/tr/td[contains(text(),'fechas')]")
	private WebElement BtnEditarPrescripcionFormulario;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Editar prescripción')]")
	private WebElement BtnEditarPrescripcion;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Conceptos de débitos')]")
	private WebElement BtnConcetoDeDebito;

	@FindBy(how = How.XPATH, using = "//mat-select[@aria-label = 'Items per page:']")
	private WebElement BtnPagina;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'100')]")
	private WebElement BtnSelectPagina;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Guardar cambios')]")
	private WebElement BtnGuardarCambios;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Calendarios de pagos')]")
	private WebElement BtnCalendarioPagos;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Crear calendario')]")
	private WebElement BtnCrearCalendarioFormulario;

	@FindBy(how = How.XPATH, using = "//button[@class = 'swal2-confirm swal2-styled']")
	private WebElement BtnAceptarEdicion;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Normativas')]")
	private WebElement BtnNormativas;

	@FindBy(how = How.XPATH, using = "//button//span[contains(text(),'Asignar municipios*')]")
	private WebElement BtnAsignarMunicipios;

	@FindBy(how = How.XPATH, using = "//button//span[contains(text(),'Asociar')]")
	private WebElement BtnAsociar;

	@FindBy(how = How.XPATH, using = "//mat-dialog-container//button//span[contains(text(),'Crear multa')]")
	private WebElement BtnCrearMulta;
	
	@FindBy(how = How.XPATH, using = "//button//span[text()='Crear Normativa']")
	private WebElement BtnCrearNormativa;
	
	@FindBy(how = How.XPATH, using = "//button//span[text()='Crear']")
	private WebElement BtnCrear;
	
	@FindBy(how = How.XPATH, using = "//button//span[contains(text(),'Aceptar')]")
	private WebElement BtnAceptarCrearNormativa;
	
	@FindBy(how = How.XPATH, using = "//button//span[contains(text(),'Guardar cambios')]")
	private WebElement BtnGuardarCambiosNormativa;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Guardar Cambios')]")
	private WebElement BtnGuardarCambiosVigencia;
		
	
	
	public BotonesPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		questions = new Questions(driver);
	}

	// Metodo generico para dar clic a un elemento
	public void clickOnElement(WebElement element) {
		element.click();
	}

	@Step
	public void BtnGestionParametros() {
		clickOnElement(BtnGestionParametros);
		questions.impliciWait();
	}

	@Step
	public void BtnGestionParametrosCalendario() {
		clickOnElement(BtnGestionParametrosCalendario);
	}

	@Step
	public void BtnVigencia() {
		questions.impliciWait();
		WebElement listaOptiones = driver.findElement(By.xpath("//mat-expansion-panel-header[@role='button']"));
		questions.tiempoSegundos(1);
		WebElement btnVigencia = listaOptiones.findElement(By.xpath("//h2[contains(text(),'Vigencias')]"));
		btnVigencia.isDisplayed();
		btnVigencia.click();
	}

	@Step
	public void BtnCrearVigencia() {
		clickOnElement(BtnCrearVigencia);
	}

	@Step
	public void BtnMultas() {
		clickOnElement(BtnMultas);
	}

	@Step
	public void BtnCrearFormulario() {
		clickOnElement(BtnCrearFormulario);
	}

	@Step
	public void BtnPrescripciones() {
		clickOnElement(BtnPrescripciones);
	}

	@Step
	public void BtnCrearPrescripcionesForumario() {
		clickOnElement(BtnCrearPrescripcionesForumario);
	}

	@Step
	public void BtnCrearPrescripciones() {
		WebElement BtnCrearPrescripciones = driver.findElement(By.xpath("//mat-dialog-actions[1]/button[2]"));
		BtnCrearPrescripciones.click();
	}

	@Step
	public void BtnAceptar() {
		BtnAceptar.isDisplayed();
		clickOnElement(BtnAceptar);
		questions.tiempoSegundos(1);
	}

	@Step
	public void BtnEditarPrescripcionFormulario(String NombreBuscar) {
		WebElement Nombre = driver.findElement(By.xpath("//tbody/tr/td[contains(text(),'" + NombreBuscar + "')]"));
		WebElement btnModificar = Nombre.findElement(By.xpath("//i[@mattooltip = 'Modificar']"));
		btnModificar.click();
	}

	@Step
	public void BtnEditarPrescripcion() {
		clickOnElement(BtnEditarPrescripcion);
	}

	@Step
	public void BtnConcetoDeDebito() {
		clickOnElement(BtnConcetoDeDebito);
	}

	@Step
	public void BtnPagina() {
		clickOnElement(BtnPagina);
		questions.impliciWait();
		clickOnElement(BtnSelectPagina);
	}

	@Step
	public void BtnEditarConceptoDebito(String NombreBuscar) {
		questions.tiempoSegundos(1);
		WebElement nombre = driver.findElement(By.xpath("//tr/td[contains(text(),'" + NombreBuscar + "')]"));
		questions.tiempoSegundos(1);
		WebElement btnModificar = nombre.findElement(By.xpath("//i[@mattooltip = 'Modificar']"));
		questions.tiempoSegundos(1);
		btnModificar.click();
	}

	public void BtnGuardarCambios() {
		BtnGuardarCambios.isDisplayed();
		clickOnElement(BtnGuardarCambios);
	}

	public void BtnCalendarioPagos() {
		clickOnElement(BtnCalendarioPagos);
		questions.tiempoSegundos(1);
	}

	public void BtnCrearCalendarioFormulario() {
		clickOnElement(BtnCrearCalendarioFormulario);
		questions.impliciWait();
	}

	@Step
	public void BtnEditarCalendarioPago(String NombreBuscar) {
		WebElement td = driver.findElement(By.xpath("//tr/td[contains(text(),'" + NombreBuscar + "')]"));
		WebElement tr = td.findElement(By.xpath("//i[@mattooltip = 'Editar']"));
		questions.impliciWait();
		tr.click();
	}

	@Step
	public void BtnAceptarEdicion() {
		clickOnElement(BtnAceptarEdicion);
		questions.tiempoSegundos(1);
	}
	
	@Step
	public void BtnAceptarEspacio() {
		clickOnElement(BtnAceptarEspacio);
		questions.tiempoSegundos(1);
	}
	
	@Step
	public void BtnNormativas() {
		clickOnElement(BtnNormativas);
	}

	@Step
	public void BtnAsignarMunicipios() {
		clickOnElement(BtnAsignarMunicipios);
		questions.tiempoSegundos(1);
	}

	@Step
	public void BtnAsociar() {
		clickOnElement(BtnAsociar);
		questions.impliciWait();
	}

	@Step
	public void BtnCrearMulta() {
		clickOnElement(BtnCrearMulta);
		questions.tiempoSegundos(1);
	}
	
	@Step
	public void BtnCrearNormativa() {
		clickOnElement(BtnCrearNormativa);
		questions.tiempoSegundos(1);
	}
	
	@Step
	public void BtnCrear() {
		clickOnElement(BtnCrear);
		questions.tiempoSegundos(1);
	}
	
	@Step
	public void BtnAceptarCrearNormativa() {
		clickOnElement(BtnAceptarCrearNormativa);
		questions.tiempoSegundos(1);
	}
	
	@Step
	public void BtnEditarNormativa(String NombreBuscar) {
		questions.tiempoSegundos(1);
		WebElement nombre = driver.findElement(By.xpath("//td[contains(text(),'" + NombreBuscar + "')]/../td[7]/i[2]"));
		//WebElement btnModificar = nombre.findElement(By.xpath("//i[@mattooltip = 'Modificar']"));
		questions.tiempoSegundos(2);
		nombre.click();		
	}
	
	@Step
	public void BtnGuardarCambiosNormativa() {
		clickOnElement(BtnGuardarCambiosNormativa);
		questions.tiempoSegundos(1);		
	}
	
	@Step
	public void BtnGuardarCambiosVigencia() {
		clickOnElement(BtnGuardarCambiosVigencia);
		questions.tiempoSegundos(1);		
	}
	
	@Step
	public void BtnEditarVigencia(String NombreBuscar) {
		WebElement nombre = driver.findElement(By.xpath("//td[contains(text(),'" + NombreBuscar + "')]/../td[8]/i[1]"));
		//WebElement btnModificar = nombre.findElement(By.xpath("//i[@mattooltip = 'Modificar']"));
		questions.impliciWait();
		nombre.click();
	}
		
}

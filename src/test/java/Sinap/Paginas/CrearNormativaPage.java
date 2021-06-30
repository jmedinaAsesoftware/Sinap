package Sinap.Paginas;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Sinap.Steps.BotonesPages;
import Sinap.Steps.ElementosPages;
import Sinap.Steps.ListasDesplegablesPages;
import Sinap.Steps.LoginPage;
import Sinap.Steps.Questions;
import net.thucydides.core.annotations.Step;

public class CrearNormativaPage {

	private BotonesPages botonesPages;
	private Questions questions;
	private ListasDesplegablesPages listasDesplegablesPages;
	private ElementosPages elementosPages;
	private WebDriver driver;
	private LoginPage loginPage;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'nombre']")
	private WebElement TextoNombre;
	
	@FindBy(how = How.XPATH, using = "//textarea[@formcontrolname = 'descripcion']")
	private WebElement TextoDescripcion;
	
	@FindBy(how = How.XPATH, using = "//textarea[@formcontrolname = 'observaciones']")
	private WebElement TextoObservaciones;

	public CrearNormativaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		listasDesplegablesPages = new ListasDesplegablesPages(driver);
		botonesPages = new BotonesPages(driver);
		questions = new Questions(driver);
		elementosPages = new ElementosPages(driver);
		loginPage = new LoginPage(driver);
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	@Step
	public void CrearNormativa() {
		
		loginPage.Login();
		botonesPages.BtnGestionParametros();
		questions.impliciWait();
		botonesPages.BtnNormativas();
		questions.impliciWait();
				
	}

	@Step

	public void FormularioNormativa(String Documento, String NombreNormativa, String DescripcionNormativa) {

		
		botonesPages.BtnCrearNormativa();
		questions.screenShot();
		questions.impliciWait();
		listasDesplegablesPages.BtnListaDocumento(Documento);
		TextoNombre.sendKeys(NombreNormativa);
		TextoDescripcion.sendKeys(DescripcionNormativa);
		elementosPages.BtnCalendarioNormativaPublicacion();
		elementosPages.BtnCalendarioNormativaInicio();
		elementosPages.BtnCalendarioNormativaFin();
		questions.screenShot();
		questions.impliciWait();
		botonesPages.BtnCrear();
		questions.impliciWait();
		questions.screenShot();
		questions.AssertConfirmarCrearNormativa();
		
	}
	
	@Step
	public void ConfirmarCreacion() {
		questions.impliciWait();
		botonesPages.BtnAceptarCrearNormativa();
		questions.impliciWait();
		questions.screenShot();
		questions.AssertCrearNormativa();		
	}
	
	@Step
	public void EditarNormativa(String NombreBuscar, String NombreNormativa, String DescripcionNormativa, String Observaciones) {
		
		botonesPages.BtnEditarNormativa(NombreBuscar);
		questions.impliciWait();
		questions.screenShot();
		TextoNombre.clear();
		TextoNombre.sendKeys(NombreNormativa);
		TextoDescripcion.clear();
		TextoDescripcion.sendKeys(DescripcionNormativa);
		TextoObservaciones.clear();
		TextoObservaciones.sendKeys(Observaciones);
		questions.screenShot();
		botonesPages.BtnGuardarCambiosNormativa();
		questions.impliciWait();
		questions.AssertConfirmarEditarNormativa();
		questions.screenShot();
	}
	
	@Step
	public void ConfirmarEdicion() {
		questions.impliciWait();
		botonesPages.BtnAceptar();
		questions.impliciWait();
		questions.screenShot();
		questions.AssertEditarNormativa();		
	}

}

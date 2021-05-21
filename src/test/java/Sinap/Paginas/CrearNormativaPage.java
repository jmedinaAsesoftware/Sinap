package Sinap.Paginas;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Sinap.Steps.ElementosPages;
import Sinap.Steps.Questions;
import net.thucydides.core.annotations.Step;

public class CrearNormativaPage {

	private BotonesPages botonesPages;
	private Questions questions;
	private ListasDesplegablesPages listasDesplegablesPages;
	private ElementosPages elementosPages;
	private WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'nombre']")
	private WebElement TextoNombre;
	
	@FindBy(how = How.XPATH, using = "//textarea[@formcontrolname = 'descripcion']")
	private WebElement TextoDescripcion;

	public CrearNormativaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		listasDesplegablesPages = new ListasDesplegablesPages(driver);
		botonesPages = new BotonesPages(driver);
		questions = new Questions(driver);
		elementosPages = new ElementosPages(driver);
	}

	public void clickOnElement(WebElement element) {
		element.click();
	}
	
	@Step
	public void CrearNormativa() {

		botonesPages.BtnGestionParametros();
		questions.impliciWait();
		botonesPages.BtnNormativas();
		questions.impliciWait();
		questions.screenShot();
		questions.impliciWait();
		botonesPages.BtnCrearNormativa();
	}

	@Step

	public void FormularioNormativa(String Documento, String NombreNormativa, String DescripcionNormativa) {

		questions.screenShot();
		questions.impliciWait();
		listasDesplegablesPages.BtnListaDocumento(Documento);
		TextoNombre.sendKeys(NombreNormativa);
		TextoDescripcion.sendKeys(DescripcionNormativa);
		elementosPages.BtnCalendarioNormativaPublicacion();
		elementosPages.BtnCalendarioNormativaInicio();
		elementosPages.BtnCalendarioNormativaFin();
		questions.impliciWait();
		botonesPages.BtnCrear();
		questions.impliciWait();
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
	public void EditarNormativa(String NombreBuscar, String NombreNormativa, String DescripcionNormativa) {
		
		questions.screenShot();
		questions.impliciWait();
		elementosPages.scrollBajar(driver);
		questions.impliciWait();
		questions.screenShot();
		botonesPages.BtnEditarNormativa(NombreBuscar);
		TextoDescripcion.clear();
		TextoNombre.sendKeys(NombreNormativa);
		TextoDescripcion.clear();
		TextoDescripcion.sendKeys(DescripcionNormativa);
		botonesPages.BtnGuardarCambiosNormativa();
		questions.impliciWait();
		questions.AssertConfirmarEditarNormativa();		
	}
	
	@Step
	public void ConfirmarEdicion() {
		questions.impliciWait();
		botonesPages.BtnAceptarCrearNormativa();
		questions.impliciWait();
		questions.screenShot();
		questions.AssertEditarNormativa();		
	}

}

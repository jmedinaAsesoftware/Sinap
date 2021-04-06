package Sinap.Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Sinap.Steps.ElementosPages;
import Sinap.Steps.Questions;
import net.thucydides.core.annotations.Step;

public class CalendarioPagosPage {

	private WebDriver driver;
	private BotonesPages botonesPages;
	private Questions questions;
	private ListasDesplegablesPages listasDesplegablesPages;
	private ElementosPages elementosPages;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'nombre']")
	private WebElement TextoNombre;
	
	public CalendarioPagosPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.botonesPages = new BotonesPages(driver);
		this.questions = new Questions(driver);
		this.listasDesplegablesPages = new ListasDesplegablesPages(driver);
		this.elementosPages = new ElementosPages(driver);
	}

	// Metodo generico para dar clic a un elemento
	public void clickOnElement(WebElement element) {
		element.click();
	}

	@Step
	public void CrearCalendarioPagos() {
		questions.impliciWait();
		botonesPages.BtnGestionParametros();
		botonesPages.BtnCalendarioPagos();
		questions.screenShot();
	}
	
	@Step
	public void DiligenciaFormulario(String Nombre, String ConceptoDebito, String Mes, String PlacaTerminada, String TipoPlaca ) {
		botonesPages.BtnCrearCalendarioFormulario();
		questions.screenShot();
		TextoNombre.sendKeys(Nombre);
		questions.impliciWait();
		listasDesplegablesPages.ListaConceptoDebito(ConceptoDebito);
		listasDesplegablesPages.ListaMes(Mes);
		questions.impliciWait();
		elementosPages.BtnCalendarioInicio();
		questions.impliciWait();
		elementosPages.BtnCalendarioFin(driver);
		questions.screenShot();
		questions.impliciWait();
		elementosPages.ScrollCalendarioPagos();
		listasDesplegablesPages.ListaPlacasTerminadas(PlacaTerminada);
		listasDesplegablesPages.ListaTipoPlacas(TipoPlaca);
		questions.screenShot();
		questions.tiempoSegundos(1);
		botonesPages.BtnCrearFormulario();
	}
	@Step
	public void ConfirmarConceptoDebito() {
		questions.impliciWait();
		questions.AssertConfirmarCalendarioPago();
		questions.screenShot();
		botonesPages.BtnAceptar();
		questions.impliciWait();
		questions.AssertCreadoCalendarioPagoExitoso();
		questions.screenShot();
	}
}

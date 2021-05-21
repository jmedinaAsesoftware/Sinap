
package Sinap.Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import Sinap.Steps.ElementosPages;
import Sinap.Steps.Questions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import net.thucydides.core.annotations.Step;

public class ConceptoDebitoPage {

	private WebDriver driver;
	private Questions questions;
	private BotonesPages botonesPages;
	private ListasDesplegablesPages listasDesplegablesPages;
	private ElementosPages calendario;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'nombreConcepto']")
	private WebElement TextoNombreConcepto;

	@FindBy(how = How.XPATH, using = "//textarea[@formcontrolname = 'descripcion']")
	private WebElement TextoDescripcion;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'codigoConcepto']")
	private WebElement TextoCodigoConcepto;
	
	@FindBy(how = How.XPATH, using = "//textarea[@formcontrolname = 'observaciones']")
	private WebElement TextoObservaciones;

	public ConceptoDebitoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		questions = new Questions(driver);
		botonesPages = new BotonesPages(driver);
		listasDesplegablesPages = new ListasDesplegablesPages(driver);
		calendario = new ElementosPages(driver);

	}

	// Metodo generico para dar clic a un elemento
	public void clickOnElement(WebElement element) {
		element.click();
	}

	@Step
	public void CrearConceptoDebito() {

		questions.impliciWait();
		botonesPages.BtnGestionParametros();
		questions.impliciWait();
		botonesPages.BtnConcetoDeDebito();
		questions.impliciWait();
		questions.screenShot();

	}

	@Step
	public void FormularioConcetoDebito(String NombreConcepto, String Normativa, String Descripcion, String Multa,
			String CodigoConcepto, String Registral) {

		botonesPages.BtnCrearFormulario();
		questions.impliciWait();
		questions.screenShot();
		TextoNombreConcepto.sendKeys(NombreConcepto);
		questions.impliciWait();
		listasDesplegablesPages.ListaNormativa(driver, Normativa);
		questions.impliciWait();
		TextoDescripcion.sendKeys(Descripcion);
		questions.impliciWait();
		listasDesplegablesPages.ListaMulta(driver, Multa);
		TextoCodigoConcepto.sendKeys(CodigoConcepto);
		questions.impliciWait();
		listasDesplegablesPages.ListaDebitoRegistral(driver, Registral);
		questions.screenShot();
		questions.impliciWait();
		calendario.BtnCalendarioFin(driver);
		questions.impliciWait();
		calendario.BtnCalendarioFin(driver);
		questions.impliciWait();
		questions.screenShot();
		questions.impliciWait();
		calendario.ScrollConcecptoDebitoFormulario();

	}

	@Step
	public void ConfirmarConceptoDebito() {
		questions.impliciWait();
		questions.AssertCrearConceptoDebito();
		questions.screenShot();
		questions.impliciWait();
		botonesPages.BtnAceptar();
		questions.tiempoSegundos(1);
		questions.AssertConceptoDebitoCreada();
		questions.screenShot();
	}

	@Step
	public void EditarConcepto(String NombreBuscar, String Normativa, String Descripcion, String Multa) {
		
		questions.screenShot();
		questions.impliciWait();
		calendario.scrollBajar(driver);
		questions.impliciWait();
		questions.screenShot();
		botonesPages.BtnEditarConceptoDebito(NombreBuscar);
		questions.impliciWait();
		listasDesplegablesPages.BtnListaEditarNormativa(driver, Normativa);
		questions.impliciWait();
		TextoDescripcion.clear();
		TextoDescripcion.sendKeys(Descripcion);
		questions.impliciWait();
		listasDesplegablesPages.ListaDespleMulta(driver, Multa);
		questions.impliciWait();
		questions.screenShot();
			
	}
	
	@Step
	public void EditarConceptoDos(String Observaciones) {
		
		questions.impliciWait();
		calendario.ScrollConceptoDebito();
		questions.impliciWait();
		TextoObservaciones.clear();
		TextoObservaciones.sendKeys(Observaciones);
		questions.impliciWait();
		questions.screenShot();
		botonesPages.BtnGuardarCambios();
		questions.impliciWait();
		questions.screenShot();
		questions.AssertConceptoDebitoEditada();
		questions.impliciWait();
		botonesPages.BtnAceptar();
		questions.impliciWait();
		questions.AssertConceptoDebitoEditadoExitoso();
		questions.screenShot();
		
	}
}

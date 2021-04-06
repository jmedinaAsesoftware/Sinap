package Sinap.Paginas;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Sinap.Steps.ElementosPages;
import Sinap.Steps.Questions;
import net.thucydides.core.annotations.Step;

public class PrescripcionesPage {

	private WebDriver driver;
	private Questions questions;
	private ElementosPages calendario;
	private ListasDesplegablesPages listasDesplegablesPages;
	private BotonesPages botonesPages;

	@FindBy(how = How.CSS, using = "input[formcontrolname=nombre]")
	private WebElement TextNombrePeriodo;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'nombre']")
	private WebElement TextoNombre;

	@FindBy(how = How.XPATH, using = "//textarea[@formcontrolname = 'descripcion']")
	private WebElement TextoDescripcion;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'periodosVigentes']")
	private WebElement TextoPeriodoVigente;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'inicioVigencia']")
	private WebElement TextoVigenciaInicio;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'finVigencia']")
	private WebElement TextoVigenciaFin;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'fechaAplicacion']")
	private WebElement TextofechaAplicacion;

	@FindBy(how = How.XPATH, using = "//textarea[@formcontrolname = 'observacion']")
	private WebElement TextoObservacion;

	public PrescripcionesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		calendario = new ElementosPages(driver);
		listasDesplegablesPages = new ListasDesplegablesPages(driver);
		botonesPages = new BotonesPages(driver);
		questions = new Questions(driver);

	}

	// Metodo generico para dar clic a un elemento
	public void clickOnElement(WebElement element) {
		element.click();
	}

	// Este metodo permite hacer clic en los botones para llegar al formulario
	@Step
	public void CrearPrescripciones() {

		questions.impliciWait();
		botonesPages.BtnGestionParametros();
		questions.impliciWait();
		calendario.scrollBajar(driver);
		questions.impliciWait();
		botonesPages.BtnPrescripciones();
		questions.impliciWait();
		questions.screenShot();

	}

	// Este metodo permite diligenciar formulario
	@Step
	public void DiligenciarFormularioPrescripcion(String Nombre, String Descripcion, String TipoConcepto,
			String Concepto, String PeriodoVigente, String Periodo) {

		botonesPages.BtnCrearPrescripcionesForumario();
		questions.screenShot();
		TextoNombre.sendKeys(Nombre);
		questions.impliciWait();
		TextoDescripcion.sendKeys(Descripcion);
		listasDesplegablesPages.ListaTipoConcepto(driver, TipoConcepto);
		questions.impliciWait();
		questions.screenShot();
		if (TipoConcepto.equals("Débito")) {

			questions.impliciWait();
			listasDesplegablesPages.ListaConceptoDebito(driver, Concepto);
			questions.impliciWait();
			questions.screenShot();
		}
		TextoPeriodoVigente.sendKeys(PeriodoVigente);
		listasDesplegablesPages.ListaPeriodo(driver, Periodo);
		questions.impliciWait();
		questions.screenShot();

	}

	@Step
	public void DiligenciarFormularioPrescripcionSegunda(String VigenciaInicio, String VigenciaFin,
			String FechaAplicacion) {
		TextoVigenciaInicio.sendKeys(VigenciaInicio);
		TextoVigenciaFin.sendKeys(VigenciaFin);
		TextofechaAplicacion.sendKeys(FechaAplicacion);
		questions.screenShot();

		botonesPages.BtnCrearPrescripciones();

	}

	@Step
	public void ConfirmarCrearPrescripcion() {

		questions.AssertCrearPrescripcion();
		questions.screenShot();
		botonesPages.BtnAceptar();
		questions.tiempoSegundos(1);
		questions.screenShot();
		questions.AssertVigenciaCreada();

	}

	@Step
	public void modificarPrescripcion(String NombreBuscar, String Nombre, String Observacion, String VigenciaFin) {

		questions.screenShot();
		botonesPages.BtnEditarPrescripcionFormulario(NombreBuscar);
		questions.screenShot();
		questions.impliciWait();
		TextoNombre.clear();
		TextoNombre.sendKeys(Nombre);
		questions.screenShot();
		TextoObservacion.clear();
		questions.impliciWait();
		TextoObservacion.sendKeys(Observacion);
		questions.screenShot();
		questions.impliciWait();
		TextoVigenciaFin.sendKeys(Keys.CONTROL + "a");
		questions.impliciWait();
		TextoVigenciaFin.sendKeys(Keys.DELETE);
		questions.impliciWait();
		TextoVigenciaFin.sendKeys(VigenciaFin);
		questions.screenShot();
		botonesPages.BtnEditarPrescripcion();

	}

	@Step
	public void ConfirmarEditarPrescripcion() {
		
		questions.AssertEditarPrescripcion();
		questions.impliciWait();
		questions.screenShot();
		questions.impliciWait();
		botonesPages.BtnAceptar();
		questions.impliciWait();
		questions.screenShot();
		questions.AssertVigenciaEditada();
		questions.impliciWait();
		questions.screenShot();

	}

}
package Sinap.Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Sinap.Steps.ElementosPages;
import Sinap.Steps.Questions;
import net.thucydides.core.annotations.Step;

public class CrearVigenciasPage {

	private WebDriver driver;
	private Questions questions;
	private ElementosPages calendario;
	private ListasDesplegablesPages listasDesplegablesPages;
	private BotonesPages botonesPages;

	@FindBy(how = How.CSS, using = "input[formcontrolname=nombrePeriodo]")
	private WebElement TextNombrePeriodo;


	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Concepto Debito prueba cambio')]")
	private WebElement BtnListaConceptoDeDebito;

	@FindBy(how = How.XPATH, using = "//section[1]/form[1]/footer[1]/button[2]")
	private WebElement BtnGuardarVigencia;

	@FindBy(how = How.XPATH, using = "//mat-checkbox[@formcontrolname ='anual']")
	private WebElement Btncheck;

	@FindBy(how = How.XPATH, using = "//mat-dialog-actions[1]/button[2]")
	private WebElement BtnAceptarVigencia;

	@FindBy(how = How.XPATH, using = "//mat-option[@role ='option']")
	private WebElement lista;

	public CrearVigenciasPage(WebDriver driver) {
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

	// Esta clase permite hacer clic en los botones para llegar al formulario
	@Step
	public void CrearVigencia() {

		botonesPages.BtnGestionParametros();
		questions.impliciWait();
		botonesPages.BtnGestionParametrosCalendario();
		questions.impliciWait();
		botonesPages.BtnVigencia();
		questions.impliciWait();
		questions.screenShot();
		botonesPages.BtnCrearVigencia();

	}

	// Esta metodo es para diligenciar el formulario para crear una vigencia
	@Step
	public void DiligenciarFormularioVigencia(String NombrePeriodo, String TipoPeriodo, String Concepto) {

		questions.screenShot();
		questions.impliciWait();
		TextNombrePeriodo.sendKeys(NombrePeriodo);

		calendario.BtnCalendarioFin(driver);
		questions.impliciWait();

		calendario.BtnCalendarioFin(driver);
		questions.impliciWait();

		listasDesplegablesPages.ListaTipoPeriodo(driver, TipoPeriodo);
		questions.screenShot();

		// este if es para seleccionar tipo de periodo
		if (TipoPeriodo.equals("Período de amnistía")) {

			questions.tiempoSegundos(1);
			clickOnElement(Btncheck);
			questions.tiempoSegundos(8);
			listasDesplegablesPages.ListaConceptoDebito(driver, Concepto);
			// clickOnElement(BtnListaConceptoDeDebito);

		} else {

			questions.impliciWait();
			clickOnElement(Btncheck);
			questions.impliciWait();
			questions.screenShot();
		}

		questions.screenShot();
		clickOnElement(BtnGuardarVigencia);

	}

	// Esta metodo es para confirmar que se creo la vigencia
	@Step
	public void ConfirmarCrearVigencia() {

		questions.AssertConfirmacionCrearVigencia();
		questions.screenShot();
		clickOnElement(BtnAceptarVigencia);
		questions.tiempoSegundos(1);
		questions.screenShot();
	}

}
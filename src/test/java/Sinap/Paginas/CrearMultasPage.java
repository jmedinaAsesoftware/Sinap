package Sinap.Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Sinap.Steps.Questions;
import net.thucydides.core.annotations.Step;

public class CrearMultasPage {
	private WebDriver driver;
	private Questions questions;
	private ListasDesplegablesPages listasDesplegablesPages;
	private BotonesPages botonesPages;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'nombreMulta']")
	private WebElement TextoNombreMulta;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'valorMinimo']")
	private WebElement TextoValorMinmo;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'valorMaximo']")
	private WebElement TextoValorMaximo;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'valor']")
	private WebElement TextoValor;

	public CrearMultasPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		listasDesplegablesPages = new ListasDesplegablesPages(driver);
		botonesPages = new BotonesPages(driver);
		questions = new Questions(driver);

	}

	// Metodo generico para dar clic a un elemento
	public void clickOnElement(WebElement element) {
		element.click();
	}

	// Metodo para llegar al formulario de crear multas
	@Step
	public void CrearMulta() {

		botonesPages.BtnGestionParametros();
		questions.impliciWait();
		botonesPages.BtnMultas();
		questions.impliciWait();
		questions.screenShot();
		botonesPages.BtnCrearFormulario();

	}

//metodo para diligenciar el formulario hasta municipio
	@Step
	public void FormularioMultas(String NombreMulta, String ConceptoCobro, String Departamento, String Municipio) {

		questions.impliciWait();
		questions.screenShot();
		TextoNombreMulta.sendKeys(NombreMulta);
		listasDesplegablesPages.ListaConceptoCobro(driver, ConceptoCobro);
		questions.impliciWait();
		listasDesplegablesPages.ListaDepartamento(driver, Departamento);
		questions.impliciWait();
		listasDesplegablesPages.ListaMunicipio(driver, Municipio);

	}

	// metodo para diligenciar el formulario hasta el final
	@Step
	public void FormularioMultasSegunda(String TipoPlaca, String TipoVehiculo, String ModoCobro, String ValorMinimo,
			String ValorMaximo, String Periocidad, String Cuota, String Valor) {

		questions.impliciWait();
		listasDesplegablesPages.ListaTipoPlaca(driver, TipoPlaca);
		questions.impliciWait();
		listasDesplegablesPages.ListaTipoVehiculo(driver, TipoVehiculo);
		questions.impliciWait();
		listasDesplegablesPages.ListaModoCobro(driver, ModoCobro);
		questions.screenShot();
		questions.impliciWait();
		TextoValorMinmo.sendKeys(ValorMinimo);
		TextoValorMaximo.sendKeys(ValorMaximo);
		questions.impliciWait();
		listasDesplegablesPages.ListaPeriocidad(driver, Periocidad);
		questions.impliciWait();
		listasDesplegablesPages.ListCuotas(driver, Cuota);
		questions.impliciWait();
		TextoValor.sendKeys(Valor);
		botonesPages.BtnActivar();
		questions.screenShot();
		botonesPages.BtnCrearMulta();
		questions.screenShot();
	}
}
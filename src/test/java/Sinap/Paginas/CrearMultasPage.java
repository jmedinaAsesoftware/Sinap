package Sinap.Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Sinap.Steps.ElementosPages;
import Sinap.Steps.Questions;
import net.thucydides.core.annotations.Step;

public class CrearMultasPage {
	private WebDriver driver;
	private Questions questions;
	private ListasDesplegablesPages listasDesplegablesPages;
	private BotonesPages botonesPages;
	private ElementosPages elementosPages;
	
	//Cambios Claudia pruebas git 
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'nombreMulta']")
	private WebElement TextoNombreMulta;

	@FindBy(how = How.XPATH, using = "//textarea[@formcontrolname = 'descripcion']")
	private WebElement TextoDescripcion;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'modoCobroPorcentaje']")
	private WebElement TextoModoCobroPorcentaje;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'modoCobroVehiculoFijo']")
	private WebElement TextoModoCobroVehiculoFijo;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'valorMinimoCuota']")
	private WebElement TextoValorMinimoCuota;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'valorMaximoCuota']")
	private WebElement TextoValorMaximoCuota;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'modoCobroMontoMinimo']")
	private WebElement TextoMontoMinimo;

	@FindBy(how = How.XPATH, using = "//form/div/mat-form-field/div/div[1]/div/input")
	private WebElement TextoCuota;

	public CrearMultasPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		listasDesplegablesPages = new ListasDesplegablesPages(driver);
		botonesPages = new BotonesPages(driver);
		questions = new Questions(driver);
		elementosPages = new ElementosPages(driver);

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
		questions.impliciWait();
		botonesPages.BtnCrearFormulario();

	}

//metodo para diligenciar el formulario hasta municipio
	@Step
	public void FormularioMultas(String NombreMulta, String Descripcion, String ConceptoCobro, String Tarifa,
			String ModoCobro, String Porcentaje, String ConceptoBase, String ValorVehiculo, String Valor,
			String ValorMinimo, String MontoMinimo, String ValorMaximo) {

		questions.impliciWait();
		questions.screenShot();
		TextoNombreMulta.sendKeys(NombreMulta);
		TextoDescripcion.sendKeys(Descripcion);
		questions.impliciWait();
		listasDesplegablesPages.ListaConceptoCobro(ConceptoCobro);
		questions.impliciWait();
		listasDesplegablesPages.BtnListaTipoTarifa(Tarifa);
		listasDesplegablesPages.ListaModoCobro(ModoCobro);
		if (ModoCobro.equals("Porcentaje")) {

			questions.impliciWait();
			TextoModoCobroPorcentaje.sendKeys(Porcentaje);
			questions.screenShot();
			listasDesplegablesPages.BtnListaModoCobroConcepto(ConceptoBase);

			if (ConceptoBase.equals("Valor del vehículo")) {
				questions.impliciWait();
				elementosPages.ScrollCrearMulta();
				listasDesplegablesPages.BtnListaModoCobroVehiculo(ValorVehiculo);
				questions.impliciWait();

				if (ValorVehiculo.equals("Mayor o igual a") || ValorVehiculo.equals("Menor o igual a")) {
					questions.impliciWait();
					elementosPages.ScrollCrearMulta();
					TextoModoCobroVehiculoFijo.sendKeys(Valor);
					questions.screenShot();

				}

			}

			TextoValorMinimoCuota.sendKeys(ValorMinimo);
			TextoMontoMinimo.sendKeys(MontoMinimo);

		} else {
			TextoValorMaximoCuota.sendKeys(ValorMaximo);
			questions.screenShot();
		}

	}

	// metodo para diligenciar el formulario hasta el final
	@Step
	public void FormularioMultasSegunda(String Periocidad, String Cuota, String TipoVehiculo, String TipoPlaca) {
		questions.impliciWait();
		elementosPages.ScrollCrearMulta();
		listasDesplegablesPages.ListaPeriocidad(Periocidad);

		if (Periocidad.equals("Especifico")) {

			questions.impliciWait();
			elementosPages.ScrollCrearMultaDos();
			questions.impliciWait();
			elementosPages.BtnCalendarioCrearMultaInicio();
			elementosPages.BtnCalendarioCrearMultaFin();
			questions.screenShot();
			elementosPages.ScrollCrearMultaTres();
			listasDesplegablesPages.ListaTipoVehiculo(TipoVehiculo);
			TextoCuota.sendKeys(Cuota);
		}

		listasDesplegablesPages.ListaTipoPlacasTres(TipoPlaca);
		questions.screenShot();

	}

	@Step
	public void FormularioMultasTercero(String Departamento, String Municipio) {

		elementosPages.ScrollCrearMultaCuarto();
		questions.screenShot();
		questions.impliciWait();
		botonesPages.BtnAsignarMunicipios();
		questions.impliciWait();
		questions.screenShot();
		questions.impliciWait();
		listasDesplegablesPages.BtnListaAsociarDepartamento(Departamento);
		listasDesplegablesPages.BtnListaAsociarMunicipio(Municipio);
		questions.screenShot();
		botonesPages.BtnAsociar();
		questions.impliciWait();
		questions.screenShot();

	}

	@Step
	public void ConfirmarCreacion() {
		botonesPages.BtnCrearMulta();
		questions.impliciWait();
		questions.screenShot();
		questions.AssertCrearMulta();
	}
}

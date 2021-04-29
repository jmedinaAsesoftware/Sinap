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
			String ModoCobro, String Porcentaje, String ConceptoBase, String ValorVehiculo, String Valor) {

		questions.impliciWait();
		questions.screenShot();
		TextoNombreMulta.sendKeys(NombreMulta);
		TextoDescripcion.sendKeys(Descripcion);
		questions.impliciWait();
		listasDesplegablesPages.ListaConceptoCobro(ConceptoCobro);
		listasDesplegablesPages.BtnListaTipoTarifa(Tarifa);
		listasDesplegablesPages.ListaModoCobro(ModoCobro);
		if (ModoCobro.equals("Porcentaje")) {

			questions.impliciWait();
			TextoModoCobroPorcentaje.sendKeys(Porcentaje);
			questions.screenShot();
			listasDesplegablesPages.BtnListaModoCobroConcepto(ConceptoBase);
// agrego 
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

		}

	}

	// metodo para diligenciar el formulario hasta el final
	@Step
	public void FormularioMultasSegunda(String ValorMinimo) {
		elementosPages.ScrollCrearMulta();
		TextoValorMinimoCuota.sendKeys(ValorMinimo);
		questions.screenShot();

		//listasDesplegablesPages.ListaTipoVehiculo(driver, TipoVehiculo);
		//listasDesplegablesPages.ListaModoCobro(ModoCobro);
		//listasDesplegablesPages.ListaPeriocidad(driver, Periocidad);
		
		//botonesPages.BtnActivar();
		
		
	}
}
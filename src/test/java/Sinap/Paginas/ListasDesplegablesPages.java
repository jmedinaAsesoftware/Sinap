package Sinap.Paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Sinap.Steps.Questions;
import net.thucydides.core.annotations.Step;

//CLase para obtener centralizados las listas desplegables de todas las paginas
public class ListasDesplegablesPages {

	private WebDriver driver;
	private Questions questions;

	@FindBy(how = How.ID, using = "mat-select-value-3")
	private WebElement BtnListaTipoPeriodo;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname ='concepto']")
	private WebElement BtnListaConceptoDeDebito;
// cambios Claudia
	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'conceptoCobro']")
	private WebElement BtnListaConceptoCobro;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'departamento']")
	private WebElement BtnListaDepartamento;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'municipio']")
	private WebElement BtnListaMunicipio;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'tipoVehiculo']")
	private WebElement BtnListaTipoVehiculo;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'modoCobro']")
	private WebElement BtnListaModoCobro;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'periodicidad']")
	private WebElement BtnListaPeriocidad;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'tipoConcepto']")
	private WebElement BtnListaTipoConcepto;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'idTiempo']")
	private WebElement BtnListaPeriodo;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'normativa']")
	private WebElement BtnListaNormativa;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'idNormativa']")
	private WebElement BtnListaEditarNormativa;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'cobroMulta']")
	private WebElement BtnListaMulta;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'cobraMulta']")
	private WebElement BtnListaDespleMulta;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'registral']")
	private WebElement BtnListaDebitoRegistral;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'conceptoCobro']")
	private WebElement BtnListaConceptoDebito;

	@FindBy(how = How.XPATH, using = "//mat-dialog-content//mat-select[@role = 'combobox']")
	private WebElement BtnListaConceptoDebitoDos;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'mes']")
	private WebElement BtnListaMes;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'tipoPlacas']")
	private WebElement BtnListaTipoPlacas;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'tipoPlaca']")
	private WebElement BtnListaTipoPlacasDos;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'tarifa']")
	private WebElement BtnListaTipoTarifa;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'modoCobroConcepto']")
	private WebElement BtnListaModoCobroConcepto;

	@FindBy(how = How.XPATH, using = "//mat-select[@formcontrolname = 'modoCobroVehiculo']")
	private WebElement BtnListaModoCobroVehiculo;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'modoCobroVehiculoFijo']")
	private WebElement BtnListaModoCobroVehiculoFijo;

	@FindBy(how = How.XPATH, using = "//mat-chip-list[@data-mat-chip-input= 'mat-chip-list-input-0']")
	private WebElement BtnListaAsociarDepartamento;

	@FindBy(how = How.XPATH, using = "//mat-chip-list[@data-mat-chip-input= 'mat-chip-list-input-1']")
	private WebElement BtnListaAsociarMunicipio;

	public ListasDesplegablesPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		questions = new Questions(driver);

	}

	// Metodo generico para dar clic a un elemento
	public void clickOnElement(WebElement element) {
		element.click();
	}

	@Step
	public void ListaTipoPeriodo(WebDriver driver, String TipoPeriodo) {

		clickOnElement(BtnListaTipoPeriodo);
		WebElement tipoPerido = driver.findElement(By.xpath("//span[contains(text(),'" + TipoPeriodo + "')]"));
		tipoPerido.click();
	}

	@Step
	public void ListaConceptoDebito(WebDriver driver, String Concepto) {

		questions.tiempoSegundos(1);
		clickOnElement(BtnListaConceptoDeDebito);
		questions.impliciWait();
		WebElement concepto = driver.findElement(By.xpath("//span[contains(text(),'" + Concepto + "')]"));
		concepto.click();

	}

	@Step
	public void ListaConceptoCobro(String ConceptoCobro) {

		clickOnElement(BtnListaConceptoCobro);
		questions.impliciWait();
		WebElement conceptoCobro = driver.findElement(By.xpath("//span[contains(text(),'" + ConceptoCobro + "')]"));
		questions.impliciWait();
		conceptoCobro.click();
	}

	@Step
	public void ListaDepartamento(WebDriver driver, String Departamento) {

		clickOnElement(BtnListaDepartamento);
		WebElement departamento = driver.findElement(By.xpath("//span[contains(text(),'" + Departamento + "')]"));
		departamento.click();
	}

	@Step
	public void ListaMunicipio(WebDriver driver, String Municipio) {

		clickOnElement(BtnListaMunicipio);
		WebElement municipio = driver.findElement(By.xpath("//span[contains(text(),'" + Municipio + "')]"));
		municipio.click();

	}

	@Step
	public void ListaTipoVehiculo(String TipoVehiculo) {

		clickOnElement(BtnListaTipoVehiculo);
		WebElement tipoVehiculo = driver.findElement(By.xpath("//span[contains(text(),'" + TipoVehiculo + "')]"));
		tipoVehiculo.click();
	}

	@Step
	public void ListaModoCobro(String ModoCobro) {
		clickOnElement(BtnListaModoCobro);
		WebElement modoCobro = driver.findElement(By.xpath("//span[contains(text(),'" + ModoCobro + "')]"));
		modoCobro.click();
		questions.impliciWait();
	}

	@Step
	public void ListaPeriocidad(String Periocidad) {

		clickOnElement(BtnListaPeriocidad);
		WebElement periocidad = driver.findElement(By.xpath("//span[contains(text(),'" + Periocidad + "')]"));
		periocidad.click();
	}

	@Step
	public void ListaTipoConcepto(WebDriver driver, String TipoConcepto) {

		clickOnElement(BtnListaTipoConcepto);
		WebElement tipoConcepto = driver
				.findElement(By.xpath("//div[@role = 'listbox']//span[contains(text(),'" + TipoConcepto + "')]"));
		tipoConcepto.click();

	}

	@Step
	public void ListaPeriodo(WebDriver driver, String Periodo) {
		clickOnElement(BtnListaPeriodo);
		WebElement periodo = driver
				.findElement(By.xpath("//div[@role = 'listbox']//span[contains(text(),'" + Periodo + "')]"));
		periodo.click();

	}

	@Step
	public void ListaNormativa(WebDriver driver, String Normativa) {
		clickOnElement(BtnListaNormativa);
		WebElement normativa = driver
				.findElement(By.xpath("//div[@role = 'listbox']//span[contains(text(),'" + Normativa + "')]"));
		normativa.click();

	}

	@Step
	public void BtnListaEditarNormativa(WebDriver driver, String Normativa) {
		clickOnElement(BtnListaEditarNormativa);
		WebElement normativa = driver
				.findElement(By.xpath("//div[@role = 'listbox']//span[contains(text(),'" + Normativa + "')]"));
		normativa.click();

	}

	@Step
	public void ListaMulta(WebDriver driver, String Multa) {
		clickOnElement(BtnListaMulta);
		WebElement multa = driver
				.findElement(By.xpath("//div[@role = 'listbox']//span[contains(text(),'" + Multa + "')]"));
		multa.click();

	}

	@Step
	public void ListaDespleMulta(WebDriver driver, String Multa) {
		clickOnElement(BtnListaDespleMulta);
		WebElement multa = driver
				.findElement(By.xpath("//div[@role = 'listbox']//span[contains(text(),'" + Multa + "')]"));
		multa.click();

	}

	@Step
	public void ListaDebitoRegistral(WebDriver driver, String Registral) {
		clickOnElement(BtnListaDebitoRegistral);
		WebElement registral = driver
				.findElement(By.xpath("//div[@role = 'listbox']//span[contains(text(),'" + Registral + "')]"));
		registral.click();

	}

	@Step
	public void ListaConceptoDebito(String ConceptoDebito) {
		clickOnElement(BtnListaConceptoDebito);

		WebElement TipoConcepto = driver.findElement(
				By.xpath("//mat-option[@role = 'option']//span[contains(text(),'" + ConceptoDebito + "')]"));
		TipoConcepto.click();
		questions.impliciWait();
	}

	@Step
	public void ListaConceptoDebitoDos(String ConceptoDebito) {
		clickOnElement(BtnListaConceptoDebitoDos);

		WebElement TipoConcepto = driver.findElement(
				By.xpath("//mat-option[@role = 'option']//span[contains(text(),'" + ConceptoDebito + "')]"));
		TipoConcepto.click();
		questions.impliciWait();
	}

	@Step
	public void ListaMes(String Mes) {
		clickOnElement(BtnListaMes);
		WebElement mes = driver
				.findElement(By.xpath("//mat-option[@role = 'option']//span[contains(text(),'" + Mes + "')]"));
		mes.click();
		questions.impliciWait();
	}

	@Step
	public void ListaTipoPlacas(String TipoPlaca) {
		clickOnElement(BtnListaTipoPlacas);
		WebElement tipoPlaca = driver.findElement(By.xpath("//span[contains(text(),'" + TipoPlaca + "')]"));
		tipoPlaca.click();
		questions.impliciWait();

		WebElement modal = driver.findElement(By.xpath("//div[@role= 'listbox']"));
		modal.sendKeys(Keys.ESCAPE);

		questions.impliciWait();
	}

	@Step
	public void ListaTipoPlacasDos(String TipoPlaca) {
		clickOnElement(BtnListaTipoPlacasDos);
		questions.impliciWait();
		WebElement tipoPlaca = driver.findElement(By.xpath("//span[text()='" + TipoPlaca + "']"));
		questions.impliciWait();
		tipoPlaca.click();
		questions.impliciWait();
		WebElement modal = driver.findElement(By.xpath("//div[@role= 'listbox']"));
		modal.sendKeys(Keys.ESCAPE);

		questions.impliciWait();
	}

	@Step
	public void ListaPlacasTerminadas(String PlacaTerminada) {
		WebElement AsinarPlaca = driver.findElement(
				By.xpath("//mat-checkbox[@class='mat-checkbox mat-primary ng-star-inserted']//span[contains(text(),'"
						+ PlacaTerminada + "')]"));
		AsinarPlaca.click();
		questions.impliciWait();
	}

	@Step
	public void ListaPlacasTerminadasDos(String PlacaTerminada) {
		WebElement AsinarPlaca = driver.findElement(
				By.xpath("//label[@class='mat-checkbox-layout']//span[contains(text(),'" + PlacaTerminada + "')]"));
		AsinarPlaca.click();
		questions.impliciWait();
	}

	@Step
	public void BtnListaTipoTarifa(String Tarifa) {
		questions.tiempoSegundos(1);
		clickOnElement(BtnListaTipoTarifa);
		WebElement tarifa = driver.findElement(By.xpath("//mat-option//span[contains(text(),'" + Tarifa + "')]"));
		tarifa.click();
		questions.impliciWait();
	}

	@Step
	public void BtnListaModoCobroConcepto(String ConceptoBase) {
		questions.impliciWait();
		clickOnElement(BtnListaModoCobroConcepto);
		WebElement conceptoBase = driver
				.findElement(By.xpath("//mat-option//span[contains(text(),'" + ConceptoBase + "')]"));
		conceptoBase.click();
		questions.impliciWait();
	}

	@Step
	public void BtnListaModoCobroVehiculo(String ValorVehiculo) {
		questions.impliciWait();
		clickOnElement(BtnListaModoCobroVehiculo);
		WebElement valorVehiculo = driver
				.findElement(By.xpath("//mat-option//span[contains(text(),'" + ValorVehiculo + "')]"));
		valorVehiculo.click();
		questions.impliciWait();
	}

	@Step
	public void ListaTipoPlacasTres(String TipoPlaca) {
		clickOnElement(BtnListaTipoPlacasDos);
		questions.impliciWait();
		WebElement tipoPlaca = driver.findElement(By.xpath("//mat-option//span[contains(text(),'" + TipoPlaca + "')]"));
		questions.impliciWait();
		tipoPlaca.click();
		questions.impliciWait();
	}

	@Step
	public void BtnListaAsociarDepartamento(String Departamento) {
		clickOnElement(BtnListaAsociarDepartamento);
		questions.impliciWait();
		BtnListaAsociarDepartamento.sendKeys(Departamento);
		questions.impliciWait();
		WebElement selectDepartamento = driver.findElement(By.xpath("//div[@role = 'listbox']//mat-option"));
		questions.impliciWait();
		selectDepartamento.click();

	}

	@Step
	public void BtnListaAsociarMunicipio(String Municipio) {
		questions.impliciWait();
		clickOnElement(BtnListaAsociarMunicipio);
		questions.impliciWait();

		BtnListaAsociarDepartamento.sendKeys(Municipio);
		questions.impliciWait();
		WebElement selectMunicipio = driver.findElement(By.xpath("//div[@role = 'listbox']//mat-option"));
		questions.impliciWait();
		selectMunicipio.click();
		questions.impliciWait();
	}
}

package Sinap.Steps;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import net.thucydides.core.annotations.Step;

public class ElementosPages {
	
	private WebDriver driver;
	private Questions questions = new Questions(driver);

	@FindBy(how = How.XPATH, using = "//button[@class ='mat-focus-indicator mat-icon-button mat-button-base']")
	private WebElement BtnIconoCalendario;

	@FindBy(how = How.XPATH, using = "//button[@class ='mat-focus-indicator mat-calendar-next-button mat-icon-button mat-button-base']")
	private WebElement BtnNextMonth;

	@FindBy(how = How.XPATH, using = "//div[@class ='mat-calendar-body-cell-content mat-focus-indicator']")
	private WebElement BtnDay;

	@FindBy(how = How.XPATH, using = "//app-multa-crear//button[@class ='mat-focus-indicator mat-icon-button mat-button-base']")
	private WebElement BtnIconoCalendarioCrearMulta;
	
	public ElementosPages(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.questions = new Questions(driver);

	}

	// Metodo generico para dar clic a un elemento
	public void clickOnElement(WebElement element) {
		element.click();
	}

	@Step
	public void BtnCalendarioFin(WebDriver driver) {
		clickOnElement(BtnIconoCalendario);
		clickOnElement(BtnNextMonth);
		clickOnElement(BtnDay);
	}
	
	@Step
	public void BtnCalendarioInicio() {
		clickOnElement(BtnIconoCalendario);
		clickOnElement(BtnDay);
	}

	@Step
	public void CerrarVentana() {
		driver.close();
	}
	
	@Step
	public void scrollBajar(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		questions.tiempoSegundos(1);
	}



	@Step
	public void ScrollConcecptoDebitoFormulario() {

		WebElement scroll = driver.findElement(
				By.xpath("//mat-dialog-content[@class ='mat-dialog-content mat-typography custom-scrollbar']"));
		
		Actions scrolldown = new Actions(driver);
		List<WebElement> button = scroll.findElements(By.tagName("button"));
		scrolldown.moveToElement(button.get(3)).click().build().perform();

	}

	@Step
	public void ScrollConceptoDebito() {
		WebElement scroll = driver.findElement(
				By.xpath("//mat-dialog-content[@class ='mat-dialog-content mat-typography custom-scrollbar']"));
		Actions scrolldown = new Actions(driver);
		List<WebElement> article = scroll.findElements(By.tagName("button"));
		scrolldown.moveToElement(article.get(6)).click().build().perform();
	}
	
	@Step
	public void ScrollCalendarioPagos() {
		WebElement scroll = driver.findElement(
				By.xpath("//mat-dialog-content[@class ='mat-dialog-content ng-star-inserted']"));
		Actions scrolldown = new Actions(driver);
		List<WebElement> article = scroll.findElements(By.tagName("button"));
		scrolldown.moveToElement(article.get(3)).build().perform();
		questions.impliciWait();
	}
	
	@Step
	public void ScrollCalendarioPagosDos() {
		WebElement scroll = driver.findElement(
				By.xpath("//mat-dialog-content[@class ='mat-dialog-content mat-typography custom-scrollbar']"));
		Actions scrolldown = new Actions(driver);
		List<WebElement> article = scroll.findElements(By.tagName("button"));
		scrolldown.moveToElement(article.get(3)).build().perform();
		questions.impliciWait();
	}
	
	@Step
	public void ScrollCrearMulta() {
		WebElement scroll = driver.findElement(
				By.xpath("//mat-dialog-content[@class ='mat-dialog-content mat-typography custom-scrollbar']"));
		Actions scrolldown = new Actions(driver);
		List<WebElement> article = scroll.findElements(By.tagName("article"));
		scrolldown.moveToElement(article.get(6)).build().perform();
		questions.impliciWait();
	}
	@Step
	public void ScrollCrearMultaDos() {
		WebElement scroll = driver.findElement(
				By.xpath("//mat-dialog-content[@class ='mat-dialog-content mat-typography custom-scrollbar']"));
		Actions scrolldown = new Actions(driver);
		List<WebElement> article = scroll.findElements(By.tagName("article"));
		scrolldown.moveToElement(article.get(7)).build().perform();
		questions.impliciWait();
	}
	
	@Step
	public void ScrollCrearMultaTres() {
		WebElement scroll = driver.findElement(
				By.xpath("//mat-dialog-content[@class ='mat-dialog-content mat-typography custom-scrollbar']"));
		Actions scrolldown = new Actions(driver);
		List<WebElement> article = scroll.findElements(By.tagName("article"));
		scrolldown.moveToElement(article.get(8)).build().perform();
		questions.impliciWait();
	}
	
	@Step
	public void ScrollCrearMultaCuarto() {
		WebElement scroll = driver.findElement(
				By.xpath("//mat-dialog-content[@class ='mat-dialog-content mat-typography custom-scrollbar']"));
		Actions scrolldown = new Actions(driver);
		List<WebElement> article = scroll.findElements(By.tagName("article"));
		scrolldown.moveToElement(article.get(9)).build().perform();
		questions.impliciWait();
	}
	
	@Step
	public void BtnCalendarioCrearMultaFin() {
		clickOnElement(BtnIconoCalendarioCrearMulta);
		clickOnElement(BtnNextMonth);
		clickOnElement(BtnDay);
		questions.impliciWait();
	}
	
	@Step
	public void BtnCalendarioCrearMultaInicio() {
		clickOnElement(BtnIconoCalendarioCrearMulta);
		clickOnElement(BtnDay);
		questions.impliciWait();
	}
	
	@Step
	public void BtnCalendarioNormativaPublicacion() {
		List<WebElement> botones = driver.findElements(By.xpath("//mat-datepicker-toggle//button"));
		botones.get(0).click();
		clickOnElement(BtnDay);
		questions.impliciWait();
	}
	
	@Step
	public void BtnCalendarioNormativaInicio() {
		List<WebElement> botones = driver.findElements(By.xpath("//mat-datepicker-toggle//button"));
		botones.get(1).click();
		clickOnElement(BtnDay);		
	}
	
	@Step
	public void BtnCalendarioNormativaFin() {
		List<WebElement> botones = driver.findElements(By.xpath("//mat-datepicker-toggle//button"));
		botones.get(2).click();
		clickOnElement(BtnNextMonth);
		clickOnElement(BtnDay);
	}
	
	@Step
	public void ScrollEditarVigencia() {
		WebElement scroll = driver.findElement(
				By.xpath("//mat-dialog-container[@id='mat-dialog-3']/app-ventana-modal/mat-dialog-content/app-vigencias-editar/section/form/footer/button[2]"));
				scroll.click();
	}
	
	@Step
	public void MensajeEditarVigencia() {

		WebElement mensaje = driver.findElement(
				By.xpath("//article[contains(text(),'¿Está seguro que quiere modificar esta vigencia?')]"));
		mensaje.click();
	}
}

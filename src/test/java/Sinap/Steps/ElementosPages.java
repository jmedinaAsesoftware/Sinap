package Sinap.Steps;

import java.util.List;

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
		List<WebElement> article = scroll.findElements(By.tagName("article"));
		scrolldown.moveToElement(article.get(6)).click().build().perform();
	}
	
	@Step
	public void ScrollCalendarioPagos() {
		WebElement scroll = driver.findElement(
				By.xpath("//mat-dialog-content[@class ='mat-dialog-content ng-star-inserted']"));
		Actions scrolldown = new Actions(driver);
		List<WebElement> article = scroll.findElements(By.tagName("button"));
		System.out.println(article.size());
		scrolldown.moveToElement(article.get(3)).build().perform();
		questions.impliciWait();
	}
}

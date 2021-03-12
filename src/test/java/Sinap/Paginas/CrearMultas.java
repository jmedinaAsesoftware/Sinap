package Sinap.Paginas;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Sinap.Steps.Questions;
import net.thucydides.core.annotations.Step;

public class CrearMultas {

	private WebDriver driver;
	private Questions questions = new Questions();

	@FindBy(how = How.XPATH, using = "//nav[1]/a[1]")
	private WebElement BtnGestionParametros;

	@FindBy(how = How.XPATH, using = "//nav[1]/ul[2]/li[4]")
	private WebElement BtnConceptoDebito;
	
	public CrearMultas(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@Step
	public void CrearMulta(WebDriver driver) throws IOException {
		clickOnElement(BtnGestionParametros);
		questions.tiempoSegundos(1);
		clickOnElement(BtnConceptoDebito);
		questions.tiempoSegundos(1);
		questions.screenShot(driver);

	}

	// Metodo generico para dar clic a un elemento
	public void clickOnElement(WebElement element) {
		element.click();
	}

}

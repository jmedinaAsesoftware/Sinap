package Sinap.Steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import net.thucydides.core.annotations.Step;

public class LoginPage {

	private WebDriver driver;
	private Questions questions;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'usuario']")
	private WebElement usuario;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname = 'password']")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "/html/body/app-root/app-login/section/div/form/div/button/span[1]/span")
	private WebElement btnIngresar;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.questions = new Questions(driver);
		}
	
	// Metodo generico para dar clic a un elemento
		public void clickOnElement(WebElement element) {
			element.click();		
		}
		
		@Step
		public void Login() {
		
			questions.tiempoSegundos(3);
			usuario.sendKeys("CC1452144");
			password.sendKeys("nuevaClave1$");
			btnIngresar.click();
		}		
		
}

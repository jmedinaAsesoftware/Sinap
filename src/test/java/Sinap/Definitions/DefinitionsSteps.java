package Sinap.Definitions;

import org.openqa.selenium.WebDriver;
import Sinap.Steps.Conexion;
import cucumber.api.java.en.Given;


public class DefinitionsSteps {

	private WebDriver driver;
	private Conexion conexion = new Conexion();
	
//se realiza el llamado para ser interpetado por lenguaje gherkin
	@Given("^abrir el navegador e ingresar a la url$")
	public void abrir_navegador() {
		this.conexion = new Conexion();
		this.driver = this.conexion.abrirNavegador();

	}

}
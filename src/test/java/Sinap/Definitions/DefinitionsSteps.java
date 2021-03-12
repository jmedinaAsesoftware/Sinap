package Sinap.Definitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Sinap.Paginas.CrearMultas;
import Sinap.Steps.Conexion;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;


public class DefinitionsSteps {

	private WebDriver driver;
	private Conexion conexion = new Conexion();
	private CrearMultas crearMultas = new CrearMultas(driver);
	
//se realiza el llamado para ser interpetado por lenguaje gherkin
	@Given("^abrir el navegador e ingresar a la url$")
	public void abrir_navegador() {
		this.conexion = new Conexion();
		this.driver = this.conexion.abrirNavegador();

	}
	@And("^Al hacer clic en parametros$")
	public void crear_multas() throws IOException {
		this.crearMultas = new CrearMultas(driver);
		this.crearMultas.CrearMulta(driver);
		
	}

}
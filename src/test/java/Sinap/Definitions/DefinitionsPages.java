package Sinap.Definitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Sinap.Paginas.CalendarioPagosPage;
import Sinap.Paginas.ConceptoDebitoPage;
import Sinap.Paginas.CrearMultasPage;
import Sinap.Paginas.CrearVigenciasPage;
import Sinap.Paginas.PrescripcionesPage;
import Sinap.Steps.ElementosPages;
import Sinap.Steps.Conexion;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DefinitionsPages {

	private WebDriver driver;
	private Conexion conexion = new Conexion();
	private CrearVigenciasPage gestionParametrosPage = new CrearVigenciasPage(driver);
	private CrearMultasPage crearMultasPage = new CrearMultasPage(driver);
	private PrescripcionesPage prescripcionesPage = new PrescripcionesPage(driver);
	private ElementosPages calendario = new ElementosPages(driver);
	private ConceptoDebitoPage conceptoDebitoPage = new ConceptoDebitoPage(driver);
	private CalendarioPagosPage calendarioPagosPage = new CalendarioPagosPage(driver);

//se realiza el llamado para ser interpetado por lenguaje gherkin
	@Given("^abrir el navegador e ingresar a la url$")
	public void abrir_navegador() {
		this.conexion = new Conexion();
		this.driver = this.conexion.abrirNavegador();

	}

	@And("^Al hacer clic en parametros y calendario$")
	public void crear_vigencia() throws IOException {
		this.gestionParametrosPage = new CrearVigenciasPage(driver);
		this.gestionParametrosPage.CrearVigencia();

	}

	@When("^Al diligenciar el campo (.*) y (.*) las fechas (.*)$")
	public void Diligenciar_Formulario_Crear_Vigencia(String NombrePeriodo, String TipoPeriodo, String Concepto) {
		this.gestionParametrosPage = new CrearVigenciasPage(driver);
		this.gestionParametrosPage.DiligenciarFormularioVigencia(NombrePeriodo, TipoPeriodo, Concepto);

	}

	@Then("^la confirmacion de la creacion de la vigencia$")
	public void confirmacion() {
		this.gestionParametrosPage = new CrearVigenciasPage(driver);
		this.gestionParametrosPage.ConfirmarCrearVigencia();
	}

	@And("^cerrar el navegador$")
	public void CerrarNavegador() {
		this.calendario = new ElementosPages(driver);
		this.calendario.CerrarVentana();
	}

	@And("^Al hacer clic en parametros y multas$")
	public void crear_multas() throws IOException {
		this.crearMultasPage = new CrearMultasPage(driver);
		this.crearMultasPage.CrearMulta();

	}

	@When("^Al diligenciar el nombre de la multa (.*) seleccionar concepto de cobro (.*) departamento (.*) munucipio (.*)$")
	public void Diligenciar_Formulario_Crear_Multas(String NombreMulta, String ConceptoCobro, String Departamento,
			String Municipio) {
		this.crearMultasPage = new CrearMultasPage(driver);
		this.crearMultasPage.FormularioMultas(NombreMulta, ConceptoCobro, Departamento, Municipio);

	}

	@And("Seleccionar tipo placa (.*) tipo vehiculo (.*) modo cobro (.*) valor Min (.*) Valor Max (.*) periocidad (.*) cuotas (.*) valor (.*)")
	public void Diligenciar_Formulario_Crear_Multas_Segunda(String TipoPlaca, String TipoVehiculo, String ModoCobro,
			String ValorMinimo, String ValorMaximo, String Periocidad, String Cuota, String Valor) {
		this.crearMultasPage = new CrearMultasPage(driver);
		this.crearMultasPage.FormularioMultasSegunda(TipoPlaca, TipoVehiculo, ModoCobro, ValorMinimo, ValorMaximo,
				Periocidad, Cuota, Valor);
	}

	@And("^Al hacer clic en gestion de paramaetros y prescripcion$")
	public void Crear_Prescripcion() {

		this.prescripcionesPage = new PrescripcionesPage(driver);
		this.prescripcionesPage.CrearPrescripciones();

	}

	@When("^Al diligenciar formulario Nombre (.*) descripcion (.*) tipo concepto (.*) concepto (.*) periodo vigente (.*) periodo (.*)$")
	public void Formulario_Prescripcion(String Nombre, String Descripcion, String TipoConcepto, String Concepto,
			String PeriodoVigente, String Periodo) {
		this.prescripcionesPage = new PrescripcionesPage(driver);
		this.prescripcionesPage.DiligenciarFormularioPrescripcion(Nombre, Descripcion, TipoConcepto, Concepto,
				PeriodoVigente, Periodo);
	}

	@And("^inicio vigencia (.*) fin vigencia (.*) fecha aplicacion (.*)$")
	public void Formulario_Prescripcion_Segunda(String VigenciaInicio, String VigenciaFin, String FechaAplicacion) {
		this.prescripcionesPage = new PrescripcionesPage(driver);
		this.prescripcionesPage.DiligenciarFormularioPrescripcionSegunda(VigenciaInicio, VigenciaFin, FechaAplicacion);

	}

	@Then("^Se confirma la creación$")
	public void Confirmar_Creacion() {
		this.prescripcionesPage = new PrescripcionesPage(driver);
		this.prescripcionesPage.ConfirmarCrearPrescripcion();
	}

	@When("^Al seleccionar modificar muestra la informacion se modifica el nombre (.*) y (.*) observacion (.*) fecha fin (.*)$")
	public void modificarPrescripcion(String NombreBuscar, String Nombre, String Observacion, String VigenciaFin) {
		this.prescripcionesPage = new PrescripcionesPage(driver);
		this.prescripcionesPage.modificarPrescripcion(NombreBuscar, Nombre, Observacion, VigenciaFin);

	}

	@Then("^al confirmar la edicion de la prescripcion$")
	public void Comfirmar_Edicion() {
		this.prescripcionesPage = new PrescripcionesPage(driver);
		this.prescripcionesPage.ConfirmarEditarPrescripcion();
	}

	@And("^Al hacer clic en parametros y conceptos de debito$")
	public void crear_Concepto_Debito() {
		this.conceptoDebitoPage = new ConceptoDebitoPage(driver);
		this.conceptoDebitoPage.CrearConceptoDebito();
	}

	@When("^Al diligenciar los campos nombre (.*) y seleccionar normativa (.*) Descripcion (.*) multa (.*) codigo (.*) Debito registral (.*)$")
	public void Diligenciar_Formulario_Concepto_Debito(String NombreConcepto, String Normativa, String Descripcion,
			String Multa, String CodigoConcepto, String Registral) {
		this.conceptoDebitoPage = new ConceptoDebitoPage(driver);
		this.conceptoDebitoPage.FormularioConcetoDebito(NombreConcepto, Normativa, Descripcion, Multa, CodigoConcepto,
				Registral);
	}

	@Then("^al confirmar la creacion del concepto debito$")
	public void ConfirmarConceptoDebito() {
		this.conceptoDebitoPage = new ConceptoDebitoPage(driver);
		this.conceptoDebitoPage.ConfirmarConceptoDebito();
	}

	@When("^ingrese a modificar (.*) los campos (.*) lista (.*) descripcion (.*) multa (.*) codigo (.*) debito registral (.*)$")
	public void modificar(String NombreBuscar, String NombreConcepto, String Normativa, String Descripcion,
			String Multa, String CodigoConcepto, String Registral) {
		this.conceptoDebitoPage = new ConceptoDebitoPage(driver);
		this.conceptoDebitoPage.EditarConcepto(NombreBuscar, NombreConcepto, Normativa, Descripcion, Multa,
				CodigoConcepto, Registral);
	}

	@And("^observaciones (.*)$")
	public void modificarParteDos(String Observaciones) {
		this.conceptoDebitoPage = new ConceptoDebitoPage(driver);
		this.conceptoDebitoPage.EditarConceptoDos(Observaciones);
	}

	@And("^Al hacer clic en gestion parametros y Calendario de pagos$")
	public void ingresar_al_modulo() {
		this.calendarioPagosPage = new CalendarioPagosPage(driver);
		this.calendarioPagosPage.CrearCalendarioPagos();
	}

	@When("^Diligencie el campo Nombre (.*) selecciona concepto debito (.*) selecciona mes (.*) placa terminada (.*) tipo de placa (.*)$")
	public void Diligenciar_Formulario(String Nombre, String ConceptoDebito, String Mes, String PlacaTerminada,
			String TipoPlaca) {
		this.calendarioPagosPage = new CalendarioPagosPage(driver);
		this.calendarioPagosPage.CrearFormulario();
		this.calendarioPagosPage.DiligenciaFormulario(Nombre, ConceptoDebito, Mes, PlacaTerminada, TipoPlaca);
	}

	@Then("^se confirma la creacion del calendario de pago$")
	public void Confirman_Calendario() {
		this.calendarioPagosPage = new CalendarioPagosPage(driver);
		this.calendarioPagosPage.ConfirmarCalendarioPagos();
	}

	@When("^Editar los campos nombre a buscar (.*) Nombre (.*) selecciona concepto debito (.*) selecciona mes (.*) placa terminada (.*) tipo de placa (.*) observacion (.*)$")
	public void Editar_Formulario(String NombreBuscar, String Nombre, String ConceptoDebito, String Mes,
			String PlacaTerminada, String TipoPlaca, String Observaciones) {
		this.calendarioPagosPage = new CalendarioPagosPage(driver);
		this.calendarioPagosPage.EditarFormulario(NombreBuscar);
		this.calendarioPagosPage.EditarDiligenciaFormulario(Nombre, ConceptoDebito, Mes, PlacaTerminada, TipoPlaca,
				Observaciones);
	}
	@Then("^se confirma la edicion del calendario de pago$")
	public void Confirmar_Editar_Calendario() {
		this.calendarioPagosPage = new CalendarioPagosPage(driver);
		this.calendarioPagosPage.ConfirmarModificacionCalendarioPagos();
	}
}


package Sinap.Definitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import Sinap.Paginas.CalendarioPagosPage;
import Sinap.Paginas.ConceptoDebitoPage;
import Sinap.Paginas.CrearMultasPage;
import Sinap.Paginas.CrearNormativaPage;
import Sinap.Paginas.CrearVigenciasPage;
import Sinap.Paginas.PrescripcionesPage;
import Sinap.Steps.ElementosPages;
import Sinap.Steps.LoginPage;
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
	private CrearNormativaPage crearNormativaPage = new CrearNormativaPage(driver);
	

//se realiza el llamado para ser interpetado por lenguaje gherkin..
	@Given("^abrir el navegador e ingresar a la url$")
	public void abrir_navegador() {
		this.conexion = new Conexion();
		this.driver = this.conexion.abrirNavegador();

	}
	
	@And("^Al hacer clic en parametros y calendario$")
	public void crear_vigencia() throws IOException {
		this.gestionParametrosPage = new CrearVigenciasPage(driver);
		this.gestionParametrosPage.llegarVigenciaM();

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

	@When("^Al diligenciar el nombre de la multa (.*) descripcion (.*) seleccionar concepto de cobro (.*) tarifa aplicable (.*) modo cobro (.*) porcentaje (.*) concepto base (.*) valor Vehiculo (.*) valor (.*) valor minimo (.*) monto minimo (.*) valor maximo (.*)$")
	public void Diligenciar_Formulario_Crear_Multas(String NombreMulta, String Descripcion, String ConceptoCobro,
			String Tarifa, String ModoCobro, String Porcentaje, String ConceptoBase, String ValorVehiculo, String Valor,
			String ValorMinimo, String MontoMinimo, String ValorMaximo) {
		this.crearMultasPage = new CrearMultasPage(driver);
		this.crearMultasPage.FormularioMultas(NombreMulta, Descripcion, ConceptoCobro, Tarifa, ModoCobro, Porcentaje,
				ConceptoBase, ValorVehiculo, Valor, ValorMinimo, MontoMinimo, ValorMaximo);

	}

	@And("diligenciar periocidad (.*) cuota (.*) tipo vehiculo (.*) tipo placa (.*)")
	public void Diligenciar_Formulario_Crear_Multas_Segunda(String Periocidad, String Cuota, String TipoVehiculo, String TipoPlaca) {
		this.crearMultasPage = new CrearMultasPage(driver);
		this.crearMultasPage.FormularioMultasSegunda(Periocidad, Cuota, TipoVehiculo, TipoPlaca);
	}
	
	@And("^al asignar los municipios y selecciona el departamento (.*) y municipio (.*)$")
	public void Diligenciar_Formulario_Crear_Multas_Tercero(String Departamento, String Municipio) {
		this.crearMultasPage = new CrearMultasPage(driver);
		this.crearMultasPage.FormularioMultasTercero(Departamento, Municipio);
	}
	
	@Then("^Se confirma la creacion de la multa$")
	public void ConfirmarCreacionMulta() {
		this.crearMultasPage = new CrearMultasPage(driver);
		this.crearMultasPage.ConfirmarCreacion();
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

	@When("^Al diligenciar los campos nombre (.*) seleccionar normativa (.*) diligenciar la descripcion (.*) seleccionar si tiene multa (.*) seleccionar el concepto (.*) y seleccionar si es debito registral (.*)$")
	public void Diligenciar_Formulario_Concepto_Debito(String NombreConcepto, String Normativa, String Descripcion,
			String Multa, String Concepto, /*String TipoConcepto,*/ String Registral) {
		this.conceptoDebitoPage = new ConceptoDebitoPage(driver);
		this.conceptoDebitoPage.FormularioConceptoDebito(NombreConcepto, Normativa, Descripcion, Multa, Concepto, /*TipoConcepto,*/ Registral);
	}

	@Then("^al confirmar la creacion del concepto debito$")
	public void ConfirmarConceptoDebito() {
		this.conceptoDebitoPage = new ConceptoDebitoPage(driver);
		this.conceptoDebitoPage.ConfirmarConceptoDebito();
	}

	@When("^ingrese a modificar (.*) los campos lista (.*) descripcion (.*) multa (.*)$")
	public void modificar(String NombreBuscar, String Normativa, String Descripcion, String Multa) {
		this.conceptoDebitoPage = new ConceptoDebitoPage(driver);
		this.conceptoDebitoPage.EditarConcepto(NombreBuscar, Normativa, Descripcion, Multa);
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
	
	@And ("^Al hacer clic en gestion de parametros y normativas$")
	public void Crear_Normativa() {
		this.crearNormativaPage = new CrearNormativaPage(driver);
		this.crearNormativaPage.CrearNormativa();			
	}
	
	@When("^Al seleccionar el documento (.*) diligenciar nombre normativa (.*) descripcion (.*)$")
	public void Diligenciar_Formulario_Normativa(String Documento, String NombreNormativa, String DescripcionNormativa) {
		this.crearNormativaPage = new CrearNormativaPage(driver);
		this.crearNormativaPage.FormularioNormativa(Documento, NombreNormativa, DescripcionNormativa);
	}
	
	@Then ("^Se confirma la creacion de la normativa$")
	public void Confirmar_Crear_Normativa() {
		this.crearNormativaPage = new CrearNormativaPage(driver);
		this.crearNormativaPage.ConfirmarCreacion();
	}
	
	@When("^Ingrese a modificar (.*) los campos nombre normativa (.*) descripcion (.*) observaciones(.*)$")
	public void Editar_Formulario_Normativa(String NombreBuscar, String NombreNormativa, String DescripcionNormativa, String Observaciones) {
		this.crearNormativaPage = new CrearNormativaPage(driver);
		this.crearNormativaPage.EditarNormativa(NombreBuscar, NombreNormativa, DescripcionNormativa, Observaciones);
	}
	
	@Then ("^Se confirma la edicion de la normativa$")
	public void Confirmar_Editar_Normativa() {
		this.crearNormativaPage = new CrearNormativaPage(driver);
		this.crearNormativaPage.ConfirmarEdicion();
	}
	
	@When("^Ingrese a modificar (.*) los campos nombre periodo (.*) observaciones (.*)$")
	public void Editar_Formulario_Vigencia(String NombreBuscar, String NombrePeriodo, String Observaciones) {
		this.gestionParametrosPage = new CrearVigenciasPage(driver);
		this.gestionParametrosPage.EditarVigencia(NombreBuscar, NombrePeriodo, Observaciones);
	}
	
	@Then ("^Se confirma la edicion de la vigencia$")
	public void Confirmar_Editar_Vigencias() {
		this.gestionParametrosPage = new CrearVigenciasPage(driver);
		this.gestionParametrosPage.ConfirmarEdicion();
	}
}

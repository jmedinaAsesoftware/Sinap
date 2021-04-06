#Proyecto Sinap
#29/03/2021
#Jhonatan Medina Blanco
@Regresion
Feature: Debe permitir crear concepto de debito (HU_1.4.01)y debe permitir modificar concepto debito (HU_1.4.03)
Background: 
	Given abrir el navegador e ingresar a la url 
	And Al hacer clic en parametros y conceptos de debito 
	
Scenario Outline: : Crear concepto debito 

	When Al diligenciar los campos nombre <NombreConcepto> y seleccionar normativa <Normativa> Descripcion <Descripcion> multa <Multa> codigo <CodigoConcepto> Debito registral <Registral> 
	Then al confirmar la creacion del concepto debito 
	And cerrar el navegador 
	Examples: 
		|NombreConcepto		  		  |Normativa				|Descripcion		   |Multa|CodigoConcepto|Registral|
		|Pruebas Medio  dos	  		  |Registro Vehicula Acción |Pruebas automatizacion|Si	 |QA0876		|No		  |


Scenario Outline:: Modificar concepto debito
		When ingrese a modificar <NombreBuscar> los campos <NombreConcepto> lista <Normativa> descripcion <Descripcion> multa <Multa> codigo <CodigoConcepto> debito registral <Registral>
		And observaciones <Observaciones>
		Examples:
		|NombreBuscar	|NombreConcepto |Normativa				 |Descripcion |Multa|CodigoConcepto		|Registral  |Observaciones|
		|Automatizado	|Cambio			|Registro Vehicula Acción|cambio bueno|Si   |p89xrm0			|Si		 	| pruebas|
		
		
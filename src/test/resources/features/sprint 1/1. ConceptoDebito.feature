#Proyecto Sinap
#29/03/2021
#Jhonatan Medina Blanco
Feature: Debe permitir crear concepto de debito (HU_1.4.01)y debe permitir modificar concepto debito (HU_1.4.03)
Background: 
	Given abrir el navegador e ingresar a la url 
	And Al hacer clic en parametros y conceptos de debito 
@Regresion1	
Scenario Outline: : Crear concepto debito 

	When Al diligenciar los campos nombre <NombreConcepto> seleccionar normativa <Normativa> diligenciar la descripcion <Descripcion> seleccionar si tiene multa <Multa> seleccionar el concepto <Concepto> y seleccionar si es debito registral <Registral> 
	Then al confirmar la creacion del concepto debito 
	And cerrar el navegador 
	Examples: 
		|NombreConcepto  				 |Normativa							|Descripcion	  				|Multa |Concepto		      |Registral|
		|Concepto Auto  				 |194-2002 Pago Cancepto de Placa	|Concepto Creado Automatizado   |No	   |CAMBIO DE PROPIETARIO |Si  	    |
@Regresion1
Scenario Outline:: Modificar concepto debito
		When ingrese a modificar <NombreBuscar> los campos lista <Normativa> descripcion <Descripcion> multa <Multa>
		And observaciones <Observaciones>
		Examples:
		|NombreBuscar			|Normativa	 			 			 		 |Descripcion 								|Multa|Observaciones	|
		|Concepto Auto		    |Decreto No.112-2017 Prescripción de deuda	 |Edición concepto por pruebas automatizadas|Si   |Automatizacion	|
		
		
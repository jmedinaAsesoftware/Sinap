#Proyecto Sinap
#05/04/2021
#Jhonatan Medina Blanco
@CalendarioPagos
Feature: Debe permitir crear Calendario de pagos (HU_1.7.01) 
Scenario Outline: Crear una calendario de pagos vigente 
	And abrir el navegador e ingresar a la url
	And Al hacer clic en gestion parametros y Calendario de pagos
	When Diligencie el campo Nombre <Nombre> selecciona concepto debito <ConceptoDebito> selecciona mes <Mes> placa terminada <PlacaTerminada> tipo de placa <TipoPlaca>
	Then se confirma la creacion del calendario de pago
	Examples:
	|Nombre					    |ConceptoDebito |Mes	  	  |PlacaTerminada|TipoPlaca	 |
	|Automatizacio QA		 	|Prueba integral|JUNIO		  |7			 |A:ALQUILER |
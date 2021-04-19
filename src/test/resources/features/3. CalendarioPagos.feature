#Proyecto Sinap
#05/04/2021
#Jhonatan Medina Blanco
 @Regresion
Feature: Debe permitir crear Calendario de pagos (HU_1.7.01) 
Background: 
	And abrir el navegador e ingresar a la url 
	And Al hacer clic en gestion parametros y Calendario de pagos 
Scenario Outline: Crear una calendario de pagos vigente 

	When Diligencie el campo Nombre <Nombre> selecciona concepto debito <ConceptoDebito> selecciona mes <Mes> placa terminada <PlacaTerminada> tipo de placa <TipoPlaca> 
	Then se confirma la creacion del calendario de pago
	
	Examples: 
		|Nombre			|ConceptoDebito |Mes	  	  |PlacaTerminada|TipoPlaca	 |
		|Automatizacio 3|Prueba integral|OCTUBRE	  |9			 |A:ALQUILER |
		

Scenario Outline: Editar calendario de pagos vigente 
	When Editar los campos nombre a buscar <NombreBuscar> Nombre <Nombre> selecciona concepto debito <ConceptoDebito> selecciona mes <Mes> placa terminada <PlacaTerminada> tipo de placa <TipoPlaca> observacion <Observaciones>
	Then  se confirma la edicion del calendario de pago 
	Examples: 

		|NombreBuscar		 |Nombre			|ConceptoDebito |Mes	  	  |PlacaTerminada|TipoPlaca	  |Observaciones|
		|Automatizacio R	 |Automatizacio r	|Prueba integral|OCTUBRE	  |0			 |CARROS NACIO|Pruebas		|

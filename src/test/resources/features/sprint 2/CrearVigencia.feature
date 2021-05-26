#Proyecto Sinap
#15/03/2021
#Jhonatan Medina Blanco
@Regresion1
Feature: Ingresar a la pagina de Sinap y crear una vigencia 
Background:

	Given abrir el navegador e ingresar a la url 
	And Al hacer clic en parametros y calendario 
	
Scenario Outline: crear vigencia con periodo amnistia 

	When Al diligenciar el campo <NombrePeriodo> y <TipoPeriodo> las fechas <Concepto>
	Then la confirmacion de la creacion de la vigencia
	And cerrar el navegador
	
		Examples: 
		|NombrePeriodo			       |TipoPeriodo		   |Concepto|
		|Nueva Vigencia Automatizada 0 |Período de vigencia|    	|
	   #|Vigencia Automatizada 1 |Período de vigencia|        |
	   #|Vigencia Automatizada 2 |Período de amnistía|        |
		
#Scenario Outline: crear vigencia con periodo 
#
#	When Al diligenciar el campo <NombrePeriodo> y <TipoPeriodo> las fechas 
#	Then la confirmacion de la creacion de la vigencia
#	And cerrar el navegador
#	
#		Examples: 
#		|NombrePeriodo			 |TipoPeriodo   	 |
#		|Vigencia Automatizada 3 |Período de vigencia|
@Regresion1
Scenario Outline:: Consultar () y Modificar normativa ()
		When Ingrese a modificar <NombreBuscar> los campos nombre periodo <NombrePeriodo> observaciones <Observaciones>
		Then Se confirma la edicion de la vigencia
		And cerrar el navegador
		Examples:
		|NombreBuscar 				  	  |NombrePeriodo	 		    |Observaciones 					          |
		|Nueva Vigencia Automatizada 0    |Nombre editado vigencia  1	|Edición vigencia pruebas automatizadas 1 |
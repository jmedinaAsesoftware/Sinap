#Proyecto Sinap
#15/03/2021
#Jhonatan Medina Blanco
@Ejecucion1
Feature: Ingresar a la pagina de Sinap y crear una vigencia 
Background:

	Given abrir el navegador e ingresar a la url 
	And Al hacer clic en parametros y calendario 
	
Scenario Outline: crear vigencia con periodo amnistia 

	When Al diligenciar el campo <NombrePeriodo> y <TipoPeriodo> las fechas <Concepto>
	Then la confirmacion de la creacion de la vigencia
	And cerrar el navegador
	
		Examples: 
		|NombrePeriodo			|TipoPeriodo		|Concepto|
		|Jhonatan total	Q1		|Período de vigencia||
		#|Jhonatan total Q2		|Período de vigencia||
		#|Jhonatan total			|Período de amnistía|
		
#Scenario Outline: crear vigencia con periodo 
#
#	When Al diligenciar el campo <NombrePeriodo> y <TipoPeriodo> las fechas 
#	Then la confirmacion de la creacion de la vigencia
#	And cerrar el navegador
#	
#		Examples: 
#		|NombrePeriodo			|TipoPeriodo		|
#		|Jhonatan total			|Período de vigencia|
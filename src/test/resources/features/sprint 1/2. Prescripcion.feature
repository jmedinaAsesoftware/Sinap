#Proyecto Sinap
#19/03/2021
#Jhonatan Medina Blanco
@Regresion1
Feature: Debe permitir crear (HU_1.5.01) y modificar prescripcion (HU_1.5.03) 
Background: 
	Given abrir el navegador e ingresar a la url 
	And Al hacer clic en gestion de paramaetros y prescripcion 
	
Scenario Outline: : Creación de prescripciones 

	When Al diligenciar formulario Nombre <Nombre> descripcion <Descripcion> tipo concepto <TipoConcepto> concepto <Concepto> periodo vigente <PeriodoVigente> periodo <Periodo> 
	And inicio vigencia <VigenciaInicio> fin vigencia <VigenciaFin> fecha aplicacion <FechaAplicacion> 
	Then Se confirma la creación 
	And cerrar el navegador 
	Examples: 
		|Nombre	 	|Descripcion	 |TipoConcepto |Concepto			    |PeriodoVigente|Periodo |VigenciaInicio|VigenciaFin|FechaAplicacion|
		|Auto QA	|Automat final   |Débito	   |Cambio a Placa tipo II	|1			   |Meses   |2051/11/17	   |2051/12/30 |05/05		   |
	#	|Prescripcion	|Pruebas Automatizadas |Crédito		|Concepto test	|2			   |Bimestre|2021/03/23	   |2021/07/23 |12/21|
		
@Regresion1
Scenario Outline: Modificar prescripción 

	When Al seleccionar modificar muestra la informacion se modifica el nombre <NombreBuscar> y <Nombre> observacion <Observacion> fecha fin <VigenciaFin> 
	Then al confirmar la edicion de la prescripcion 
	And cerrar el navegador 
	Examples: 
		|NombreBuscar	|Nombre		  		|Observacion  |VigenciaFin|
		|Auto QA		|prescripcion final |Pruebas qa   |2052/01/21 |
		
		
		
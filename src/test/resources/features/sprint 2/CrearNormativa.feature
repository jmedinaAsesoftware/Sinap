#Proyecto Sinap
#29/04/2021
#Claudia Castro
Feature: Ingresar a la pagina de Sinap y crear una normativa 
Background:
	Given abrir el navegador e ingresar a la url 
	And Al hacer clic en gestion de parametros y normativas 
@Regresion1
Scenario Outline: : Creacion Normativa (127310)
	When Al seleccionar el documento <Documento> diligenciar nombre normativa <NombreNormativa> descripcion <DescripcionNormativa>
	Then Se confirma la creacion de la normativa
	And cerrar el navegador
	
	Examples: 
		|Documento	|NombreNormativa  		  	  |DescripcionNormativa				 |
		|Decreto	|Normativa test automation	  |Descripción pruebas automatizadas |
	
@Regresion1
Scenario Outline:: Consultar (127950) y Modificar normativa (130651)
		When Ingrese a modificar <NombreBuscar> los campos nombre normativa <NombreNormativa> descripcion <DescripcionNormativa> observaciones<Observaciones>
		Then Se confirma la edicion de la normativa
		And cerrar el navegador
		Examples:
		|NombreBuscar 				  	  |NombreNormativa	 		    |DescripcionNormativa 	 |Observaciones                           |
		|Normativa test automation        |Nombre normativa editado 	|Edicion normativa auto3 |Edición normativa pruebas automatizadas3|
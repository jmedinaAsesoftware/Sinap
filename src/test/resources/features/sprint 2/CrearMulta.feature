#Proyecto Sinap
#18/03/2021
#Jhonatan Medina Blanco
@Regresion1
	Feature: Ingresar a la pagina de Sinap y debe permitir crear multas 
	Scenario Outline: : Creación de multas 
		Given abrir el navegador e ingresar a la url 
		And Al hacer clic en parametros y multas 
		When Al diligenciar el nombre de la multa <NombreMulta>  descripcion <Descripcion> seleccionar concepto de cobro <ConceptoCobro> tarifa aplicable <Tarifa> modo cobro <ModoCobro> porcentaje <Porcentaje>
	#	And Seleccionar tipo placa <TipoPlaca> tipo vehiculo <TipoVehiculo> modo cobro <ModoCobro> valor Min <ValorMinimo> Valor Max <ValorMaximo> periocidad <Periocidad> cuotas <Cuota> valor <Valor> 
		
		Examples: 
			|NombreMulta	|Descripcion  |ConceptoCobro	|Tarifa									 |ModoCobro |Porcentaje|TipoPlaca |TipoVehiculo |ModoCobro	|ValorMinimo|ValorMaximo|Periocidad |Cuota|Valor|
			|Pruebas nombre |Pruebas descr|8-Concepto TUAV  | 1-Generar Tasa Anual Vehicular CCVH 	 |Porcentaje|9		   |Particular|Automóvil	|Moneda		|1000		|3000		|Anual		|3	  |200000|
#Proyecto Sinap
#26/03/2021
#Jhonatan Medina Blanco
@Regresion1
	Feature: Ingresar a la pagina de Sinap y debe permitir crear multas 
	Scenario Outline: : Creación de multas 
		Given abrir el navegador e ingresar a la url 
		And Al hacer clic en parametros y multas 
		When Al diligenciar el nombre de la multa <NombreMulta>  descripcion <Descripcion> seleccionar concepto de cobro <ConceptoCobro> tarifa aplicable <Tarifa> modo cobro <ModoCobro> porcentaje <Porcentaje> concepto base <ConceptoBase> valor Vehiculo <ValorVehiculo> valor <Valor>
		And diligenciar <ValorMinimo> 
		
		Examples: 
			|NombreMulta	    |Descripcion  |ConceptoCobro	|Tarifa									 |ModoCobro |Porcentaje|ConceptoBase	  |ValorVehiculo  |Valor|ValorMinimo|
		#	|Pruebas porcentaje |Pruebas descr|8-Concepto TUAV  | 1-Generar Tasa Anual Vehicular CCVH 	 |Porcentaje|9		   |Valor del vehículo|Mayor o igual a|78	|			  |
		#	|Pruebas porcentaje |Pruebas descr|8-Concepto TUAV  | 1-Generar Tasa Anual Vehicular CCVH 	 |Porcentaje|9		   |Valor del vehículo|Menor o igual a|78	|			  |
		#	|Pruebas porcentaje |Pruebas descr|8-Concepto TUAV  | 1-Generar Tasa Anual Vehicular CCVH 	 |Porcentaje|9		   |Salario mínimo	  |Mayor o igual a|78	|			  |
			|Pruebas nombre 	|Pruebas auto |8-Concepto TUAV  | 1-Generar Tasa Anual Vehicular CCVH 	 |Monto fijo|9		   |				  |				  |		|345|
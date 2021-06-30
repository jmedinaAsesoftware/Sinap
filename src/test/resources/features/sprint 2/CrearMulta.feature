#Proyecto Sinap
#26/03/2021
#Jhonatan Medina Blanco
Feature: Ingresar a la pagina de Sinap y debe permitir crear multas  
Background: 
	Given abrir el navegador e ingresar a la url 
	And Al hacer clic en parametros y multas 
	
@Regresion1
Scenario Outline: : Creación de multas Monto fijo Casos (124240)
	When Al diligenciar el nombre de la multa <NombreMulta>  descripcion <Descripcion> seleccionar concepto de cobro <ConceptoCobro> tarifa aplicable <Tarifa> modo cobro <ModoCobro> porcentaje <Porcentaje> concepto base <ConceptoBase> valor Vehiculo <ValorVehiculo> valor <Valor> valor minimo <ValorMinimo> monto minimo <MontoMinimo> valor maximo <ValorMaximo> 
	And diligenciar periocidad <Periocidad> cuota <Cuota> tipo vehiculo <TipoVehiculo> tipo placa <TipoPlaca>
	And al asignar los municipios y selecciona el departamento <Departamento> y municipio <Municipio>
	Then Se confirma la creacion de la multa
	And cerrar el navegador 
	
	Examples: 
		|NombreMulta	        |Descripcion  |ConceptoCobro	      |Tarifa				 |ModoCobro |ValorMinimo|ValorMaximo|Periocidad|Cuota|TipoVehiculo|TipoPlaca  |Departamento|Municipio|
		|Automatizadas QA DOS	|Pruebas auto |1-Tasa Vial Municipal  | TVM - Monto Fijo	 |Monto fijo|590		|3000		|Específico|590  |AUTOBUS	  | CRUZ ROJA | Valle 	   | Alianza |	

@Regresion1
Scenario Outline: : Creación de multas Porcentaje Casos(124500) (124470)

	When Al diligenciar el nombre de la multa <NombreMulta>  descripcion <Descripcion> seleccionar concepto de cobro <ConceptoCobro> tarifa aplicable <Tarifa> modo cobro <ModoCobro> porcentaje <Porcentaje> concepto base <ConceptoBase> valor Vehiculo <ValorVehiculo> valor <Valor> valor minimo <ValorMinimo> monto minimo <MontoMinimo> valor maximo <ValorMaximo>
	And diligenciar periocidad <Periocidad> cuota <Cuota> tipo vehiculo <TipoVehiculo> tipo placa <TipoPlaca>
	And al asignar los municipios y selecciona el departamento <Departamento> y municipio <Municipio>
	Then Se confirma la creacion de la multa
	And cerrar el navegador 
	Examples: 
		|NombreMulta	    |Descripcion  |ConceptoCobro				 |Tarifa						 |ModoCobro |Porcentaje|ConceptoBase	  |ValorVehiculo  |Valor |ValorMinimo|MontoMinimo|Periocidad|Cuota	 |TipoVehiculo|TipoPlaca  |Departamento|Municipio|
		|Pruebas porcentaje |Pruebas descr|1-Tasa Única Anual Vehicular  | TUAV - Porcentaje - Concepto 7|Porcentaje|9		   |Valor del vehículo|Mayor o igual a|78	 |20000		 |20000		 |Especifico|20000	 |AUTOBUS	  | CRUZ ROJA | Valle 	   | Alianza |
		#|Pruebas porcentaje |Pruebas descr|8-Concepto TUAV  | 1-Generar Tasa Anual Vehicular CCVH 	 |Porcentaje|9		   |Valor del vehículo|Menor o igual a|78	|1000000	|20000		|Especifico|23	 	 |AUTOBUS	  | CRUZ ROJA | Valle 	   | Alianza |
		#|Pruebas porcentaje |Pruebas descr|8-Concepto TUAV  | 1-Generar Tasa Anual Vehicular CCVH 	 |Porcentaje|9		   |Salario mínimo	  |Mayor o igual a|78	|1000000	|20000		|Especifico|23	 	 |AUTOBUS	  | CRUZ ROJA | Valle 	   | Alianza |
		
			
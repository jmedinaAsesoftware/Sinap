#Proyecto Sinap
#18/03/2021
#Jhonatan Medina Blanco
	@CrearMultas 
	Feature: Ingresar a la pagina de Sinap y debe permitir crear multas 
	Scenario Outline: : Creación de multas 
		Given abrir el navegador e ingresar a la url 
		And Al hacer clic en parametros y multas 
		When Al diligenciar el nombre de la multa <NombreMulta> seleccionar concepto de cobro <ConceptoCobro> departamento <Departamento> munucipio <Municipio> 
		And Seleccionar tipo placa <TipoPlaca> tipo vehiculo <TipoVehiculo> modo cobro <ModoCobro> valor Min <ValorMinimo> Valor Max <ValorMaximo> periocidad <Periocidad> cuotas <Cuota> valor <Valor> 
		
		Examples: 
			|NombreMulta	|ConceptoCobro		|Departamento|Municipio|TipoPlaca |TipoVehiculo |ModoCobro	|ValorMinimo|ValorMaximo|Periocidad |Cuota|Valor|
		|Pruebas nombre|Inscripción tardía	|Paraíso	 |DANLI	   |Particular|Automóvil	|Moneda		|1000		|3000		|Anual		|3	  |200000|
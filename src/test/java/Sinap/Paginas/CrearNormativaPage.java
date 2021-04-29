package Sinap.Paginas;


import Sinap.Steps.Questions;
import net.thucydides.core.annotations.Step;

public class CrearNormativaPage {

	private BotonesPages botonespages;
	private Questions questions;

@Step
public void CrearNormativa () {
	
	botonespages.BtnGestionParametros();
	questions.impliciWait();
	
	
}
}

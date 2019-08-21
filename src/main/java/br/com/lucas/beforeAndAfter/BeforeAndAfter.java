package br.com.lucas.beforeAndAfter;

import br.com.lucas.Utils.Utils;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAndAfter extends Utils{

	@Before
	public void inicializa() {
		System.out.println("iniciando");
		inicializaGoogleChrome();
	}
	
	@After
	public void finaliza() {
		System.out.println("fechando");
		//String cenario = "lucas";
		//System.out.println(this.getClass().getSimpleName());
		screenshot("CenarioGoogle");
		encerra();
	}
}

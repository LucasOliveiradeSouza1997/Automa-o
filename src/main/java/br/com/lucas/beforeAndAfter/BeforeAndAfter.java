package br.com.lucas.beforeAndAfter;

import br.com.lucas.Utils.Utils;
import br.com.lucas.driverFactory.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAndAfter extends Utils{

	@Before
	public void inicializa() {
		DriverFactory.getInstance();
	}
	
	@After
	public void finaliza() {
		//String cenario = "lucas";
		//System.out.println(this.getClass().getSimpleName());
//		screenshot("CenarioGoogle");
		encerra();
	}
}

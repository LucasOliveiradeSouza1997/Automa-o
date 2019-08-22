package br.com.lucas.beforeAndAfter;

import br.com.lucas.Utils.Utils;
import br.com.lucas.driverFactory.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAndAfter extends Utils {
	
	private static String nomeDoCenario;

	@Before
	public void inicializa(Scenario scenario) {
		nomeDoCenario = scenario.getName().trim().replaceAll(" ", "");
		DriverFactory.getInstance();

	}

	@After
	public void finaliza(Scenario scenario) {
		String status = scenario.getStatus();
		screenshot(nomeDoCenario,status);
		encerra();
	}
}

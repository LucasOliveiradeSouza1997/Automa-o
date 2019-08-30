package br.com.lucas.beforeAndAfter;

import br.com.lucas.Utils.Utils;
import br.com.lucas.driverFactory.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BeforeAndAfter extends Utils {
	
	private static String nomeDoCenario;
	private static String data;
	private static String hora;
	
	public static String getNomeDoCenario() {
		return nomeDoCenario;
	}
	
	public static String getData() {
		return data;
	}
	
	public static String getHora() {
		return hora;
	}

	@Before
	public void inicializa(Scenario scenario) {
		nomeDoCenario = scenario.getName().trim().replaceAll(" ", "");
		data = getDataYYYYMMDD().replaceAll("/", "-");
		hora = getHoraAtual().replaceAll(":", "-");
	}

	@After
	public void finaliza(Scenario scenario) {
		String status = scenario.getStatus();
		screenshot(status);
		encerra();
	}
}

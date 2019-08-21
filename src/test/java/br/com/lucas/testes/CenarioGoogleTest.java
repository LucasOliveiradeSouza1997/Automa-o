package br.com.lucas.testes;

import org.junit.Test;
import org.openqa.selenium.By;

import br.com.lucas.Utils.Utils;
import br.com.lucas.mapeamento.CenarioGoogleMapeamento;

public class CenarioGoogleTest extends Utils{
	
	@Test
	public void loginCenarioGoogle() {
		inicializaGoogleChrome();
		navega("https://www.google.com.br");
		limpaEInsereTextoWait("google", CenarioGoogleMapeamento.getCampoPesquisar());
		clicaWait(CenarioGoogleMapeamento.getBotaoPesquisarGoogle());
		validoMensagemWait("Aproximadamente");
		screenshot("CenarioGoogleTest");
		encerra();
	}
}
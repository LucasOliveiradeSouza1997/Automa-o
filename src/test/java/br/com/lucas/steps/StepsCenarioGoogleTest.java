package br.com.lucas.steps;

import br.com.lucas.telas.TelaGoogle;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepsCenarioGoogleTest {
		
		private static TelaGoogle telaGoogle;
		
		public StepsCenarioGoogleTest() {
			telaGoogle = new TelaGoogle();
		}

		@Given("^acesso o site do google$")
		public void acesso_o_site_do_google() throws Throwable {
			telaGoogle.acessoOSiteDoGoogle();
		}

		@And("^digito \"([^\"]*)\" na barra de Pesquisa$")
		public void digito_na_barra_de_Pesuisa(String pesquisa) throws Throwable {
			telaGoogle.digitoNaBarraDePesquisa(pesquisa);
		}

		@And("^clico no botao Pesquisar$")
		public void clico_no_botao_Pesquisar() throws Throwable {
			telaGoogle.clicoNoBotaoPesquisar();
		}

		@Then("^valido a mensagem \"([^\"]*)\"$")
		public void valido_a_mensagem(String mensagem) throws Throwable {
			telaGoogle.validoAMensagem(mensagem);
		}
}

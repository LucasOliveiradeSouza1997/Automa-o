package br.com.lucas.steps;

import br.com.lucas.Utils.Utils;
import br.com.lucas.telas.TelaGoogle;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class StepsPesquisaNoGoogle {
		
		private static TelaGoogle telaGoogle;
		private static Utils utils;
		
		public StepsPesquisaNoGoogle() {
			telaGoogle = new TelaGoogle();
			utils = new Utils();
			
		}

		@Given("^acesso o site do google$")
		public void acesso_o_site_do_google() throws Throwable {
			telaGoogle.acessoOSiteDoGoogle();
			utils.screenshot();
		}

		@And("^digito \"([^\"]*)\" na barra de Pesquisa$")
		public void digito_na_barra_de_Pesuisa(String pesquisa) throws Throwable {
			telaGoogle.digitoNaBarraDePesquisa(pesquisa);
			utils.screenshot();
		}

		@And("^clico no botao Pesquisar$")
		public void clico_no_botao_Pesquisar() throws Throwable {
			telaGoogle.clicoNoBotaoPesquisar();
			utils.screenshot();
		}

		@Then("^valido a mensagem \"([^\"]*)\"$")
		public void valido_a_mensagem(String mensagem) throws Throwable {
			telaGoogle.validoAMensagem(mensagem);
			utils.screenshot();
		}
}

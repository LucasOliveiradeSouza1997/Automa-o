package br.com.lucas.telas;

import br.com.lucas.Utils.Utils;
import br.com.lucas.mapeamento.CenarioGoogleMapeamento;

public class TelaGoogle extends Utils{

	public void acessoOSiteDoGoogle() {
		navega("https://www.google.com.br");
	}

	public void digitoNaBarraDePesquisa(String pesquisa) {
		limpaEInsereTextoWait("google", CenarioGoogleMapeamento.getCampoPesquisar());
	}

	public void clicoNoBotaoPesquisar() {
		clicaWait(CenarioGoogleMapeamento.getBotaoPesquisarGoogle());;
	}

	public void validoAMensagem(String mensagem) {
		validoMensagemWait("Aproximadamente");
	}
}

package br.com.lucas.telas;

import br.com.lucas.Utils.Utils;
import br.com.lucas.mapeamento.MapeamentoPesquisaNoGoogle;

public class TelaGoogle extends Utils{

	public void acessoOSiteDoGoogle() {
		navega("https://www.google.com.br");
	}

	public void digitoNaBarraDePesquisa(String pesquisa) {
		limpaEInsereTextoWait(pesquisa, MapeamentoPesquisaNoGoogle.getCampoPesquisar());
	}

	public void clicoNoBotaoPesquisar() {
		clicaWait(MapeamentoPesquisaNoGoogle.getBotaoPesquisarGoogle());;
	}

	public void validoAMensagem(String mensagem) {
		validoMensagemWait(mensagem);
	}
}

package br.com.lucas.mapeamento;

import org.openqa.selenium.By;

public final class CenarioGoogleMapeamento {
	
	private static By campoPesquisar = By.xpath("//*[@title='Pesquisar']");
	private static By botaoPesquisarGoogle = By.xpath("(//input[@value='Pesquisa Google'])[1]");
	
	public static  By getCampoPesquisar() {
		return campoPesquisar;
	}
	public static By getBotaoPesquisarGoogle() {
		return botaoPesquisarGoogle;
	}
}

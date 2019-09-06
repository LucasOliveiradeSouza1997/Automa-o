package br.com.lucas.main;

import br.com.lucas.Utils.Utils;

public class CriarPastaComNomeDoArquivo {
	private static String caminho = "C:\\DEV\\Lucas\\Framework_Automacao\\src\\main\\java\\br\\com\\lucas\\main";
	private static String caminhoSaida= "C:\\Users\\lucas.souza\\Desktop\\saida\\%s\\%s";
	
	public static void main(String[] args)  {
		
		Utils u = new Utils();
		u.criaPastasParaUmDiretorioEspecifico(caminho, caminhoSaida);
	}
}

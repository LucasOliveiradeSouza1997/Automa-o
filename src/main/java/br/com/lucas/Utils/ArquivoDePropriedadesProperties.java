package br.com.lucas.Utils;

import java.io.File;
import java.util.Properties;

public class ArquivoDePropriedadesProperties {
	private static String pathFile;
	private static ArquivoDePropriedadesProperties arquivoDePropriedadesProperties;
	private String automatizador,navegador;
	private boolean seleniumGrid;
	
	public static void setPathFile(String pathFile) {
		arquivoDePropriedadesProperties.pathFile = pathFile;
	}
	
	public static void setDefaultPathFile() {
		arquivoDePropriedadesProperties.pathFile = "./Properties/arquivoDePropriedades.properties";
	}
	public static String getPathFile() {
		if(pathFile == null) {
			setDefaultPathFile();
		}
		return ArquivoDePropriedadesProperties.pathFile;		
	}
	
	public static synchronized ArquivoDePropriedadesProperties getInstanceArquivoDePropriedadesProperties() {
		if(arquivoDePropriedadesProperties == null) {
			arquivoDePropriedadesProperties = new ArquivoDePropriedadesProperties();
			Properties properties = new PropertyUtil().loadProperties(new File(getPathFile()).getAbsolutePath());
			arquivoDePropriedadesProperties.seleniumGrid = properties.getProperty("seleniumGrid").equals(true) ? true:false;
			arquivoDePropriedadesProperties.navegador = properties.getProperty("navegador");
			arquivoDePropriedadesProperties.automatizador = properties.getProperty("automatizador");
			arquivoDePropriedadesProperties.imprimePropriedades();
		}
		return arquivoDePropriedadesProperties;
	}
	
	public String getAutomatizador() {
		return automatizador;
	}

	public String getNavegador() {
		return navegador;
	}

	public boolean isSeleniumGrid() {
		return seleniumGrid;
	}
	
	public void imprimePropriedades() {
		System.out.println("-------- PROPRIEDADES --------");
		System.out.println("Automatizador: " + arquivoDePropriedadesProperties.automatizador);
		System.out.println("Navegador : " + arquivoDePropriedadesProperties.navegador);
		System.out.println("SeleniumGrid: " + arquivoDePropriedadesProperties.seleniumGrid);
		System.out.println("------------------------------");
	}
}

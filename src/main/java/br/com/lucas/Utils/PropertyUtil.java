package br.com.lucas.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import br.com.lucas.Exception.AutomacaoException;

public class PropertyUtil {

	public Properties loadProperties(String caminhoArquivoDePropriedades){
		Properties properties = new Properties();
		try(InputStream inputStream = new FileInputStream(new File(caminhoArquivoDePropriedades))) {
			properties.load(inputStream);
			return properties;
		} catch (Exception e) {
			String erro = "Erro na leitura da Propriedade : " + caminhoArquivoDePropriedades;
			throw new AutomacaoException(erro,e);
		}
	}
}

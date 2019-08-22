package br.com.lucas.Utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.lucas.driverFactory.DriverFactory;

public class Utils extends DriverFactory{
	
	WebElement elemento;
	private final String stringPassed = "\\Passou";
	private final String stringFailed = "\\Falhou";
	
	public void limpaEInsereTextoWait(String texto, By campo) {
		DriverFactory.getInstanceWait().until(ExpectedConditions.elementToBeClickable(campo));
		elemento = DriverFactory.getInstance().findElement(campo);
		elemento.clear();
		elemento.sendKeys(texto);
	}
	
	public void clicaWait(By campo) {
		DriverFactory.getInstanceWait().until(ExpectedConditions.elementToBeClickable(campo));
		elemento = DriverFactory.getInstance().findElement(campo);
		elemento.click();
	}
	
	public void validoMensagemWait(String mensagem) {
		try {
			By byMensagem = By.xpath("//*[contains(text(),'"+mensagem+"')]");
			DriverFactory.getInstanceWait().until(ExpectedConditions.elementToBeClickable(byMensagem));
			System.out.println("Mensagem Validada com sucesso: " + mensagem);
		} catch (Exception e) {
			System.out.println("Erro na validacao da mensagem: " + mensagem);
			Assert.assertTrue(false);
		}
	}
	
	public void screenshot(String nomeTeste, String status) {
		logStatusDoTeste(nomeTeste,status);
		String stringStatus = status.equals("passed")? stringPassed : stringFailed;
		//falta fazer para os outros status
		try {
			String pasta = System.getProperty("user.dir").concat("\\output");
			TakesScreenshot source = (TakesScreenshot) DriverFactory.getInstance();
			File scr = source.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr, new File(pasta+stringStatus+"\\Teste_"+ nomeTeste+".png"));
		} catch(Exception ex){
			System.out.println("Erro na Escrita de arquivo.");
		}
	}
	
	private void logStatusDoTeste(String nomeTeste,String status) {
		if(status.equals("undefined")) {
			System.out.println(nomeTeste + " undefined" );
		}else if(status.equals("pending")) {
			System.out.println(nomeTeste + " pending" );
		}else if(status.equals("skipped")) {
			System.out.println(nomeTeste + " skipped" );
		}else if(status.equals("failed")) {
			System.out.println(nomeTeste + " failed" );
		}else if(status.equals("passed")) {
			System.out.println(nomeTeste + " passed" );
		}
	}	
}

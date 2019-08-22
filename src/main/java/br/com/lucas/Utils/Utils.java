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
	
	public void screenshot(String nomeTeste) {
		try {
			String pasta = System.getProperty("user.dir").concat("\\output");
			TakesScreenshot source = (TakesScreenshot) DriverFactory.getInstance();
			File scr = source.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scr, new File(pasta+"\\Teste_"+ nomeTeste+".png"));
		} catch(Exception ex){
			System.out.println("Erro na Escrita de arquivo.");
		}
	}	
}

package br.com.lucas.Utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import br.com.lucas.beforeAndAfter.BeforeAndAfter;
import br.com.lucas.driverFactory.DriverFactory;

public class Utils extends DriverFactory {

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
			By byMensagem = By.xpath("//*[contains(text(),'" + mensagem + "')]");
			DriverFactory.getInstanceWait().until(ExpectedConditions.elementToBeClickable(byMensagem));
			System.out.println("Mensagem Validada com sucesso: " + mensagem);
		} catch (Exception e) {
			System.out.println("Erro na validacao da mensagem: " + mensagem);
			Assert.assertTrue(false);
		}
	}

	public void screenshot(String status) {
		String nomeTeste = BeforeAndAfter.getNomeDoCenario();
		String stringStatus = status.equals("passed") ? stringPassed : stringFailed;
		String file = System.getProperty("user.dir").concat("\\evidencias\\").concat(BeforeAndAfter.getData())
				.concat(stringStatus).concat("\\").concat(nomeTeste).concat("_")
				.concat(BeforeAndAfter.getHora().concat("\\").concat(nomeTeste)).concat(".png");

		if (logStatusDoTeste(nomeTeste, status)) {
			try {
				TakesScreenshot source = (TakesScreenshot) DriverFactory.getInstance();
				File scr = source.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scr, new File(file));
			} catch (Exception ex) {
				System.out.println("Erro na Escrita de arquivo.");
			}
		}
	}

	private boolean logStatusDoTeste(String nomeTeste, String status) {
		boolean evidencia = false;
		if (status.equals("undefined")) {
			System.out.println(nomeTeste + " undefined");
		} else if (status.equals("pending")) {
			System.out.println(nomeTeste + " pending");
		} else if (status.equals("skipped")) {
			System.out.println(nomeTeste + " skipped");
		} else if (status.equals("failed")) {
			System.out.println(nomeTeste + " failed");
			evidencia = true;
		} else if (status.equals("passed")) {
			System.out.println(nomeTeste + " passed");
			evidencia = true;
		}
		return evidencia;
	}

	public String getDataYYYYMMDD() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		return dateFormat.format(date);
	}

	public String getHoraAtual() {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		return dateFormat.format(date);
	}

}

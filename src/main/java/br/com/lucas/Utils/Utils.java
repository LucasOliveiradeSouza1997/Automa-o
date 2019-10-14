package br.com.lucas.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.pdf.PdfWriter;

import br.com.lucas.Exception.AutomacaoException;
import br.com.lucas.beforeAndAfter.BeforeAndAfter;
import br.com.lucas.driverFactory.DriverFactory;

public class Utils extends DriverFactory {

	WebElement elemento;
	private final String stringPassed = "\\Passou";
	private final String stringFailed = "\\Falhou";
	private final String AUTHOR = "Lucas Oliveira de Souza";
	private static List<File> evidencias;

	public static List<File> getInstanceListEvidencias() {
		if (evidencias == null) {
			evidencias = new ArrayList<File>();
		}
		return evidencias;
	}

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

	public void screenshot() {
		try {
			TakesScreenshot source = (TakesScreenshot) DriverFactory.getInstance();
			File scr = source.getScreenshotAs(OutputType.FILE);
			getInstanceListEvidencias().add(scr);
		} catch (Exception ex) {
			System.out.println("Erro Geração de Evidencias.");
		}
	}

	public void screenshot(String status) {
		if (BeforeAndAfter.getData() != null && BeforeAndAfter.getHora() != null && BeforeAndAfter.getNomeDoCenario() != null) {
			String nomeTeste = BeforeAndAfter.getNomeDoCenario();
			String stringStatus = status.equals("passed") ? stringPassed : stringFailed;
			String file = System.getProperty("user.dir").concat("\\evidencias\\").concat(BeforeAndAfter.getData())
					.concat(stringStatus).concat("\\").concat(nomeTeste).concat("_").concat(BeforeAndAfter.getHora())
					.concat("\\").concat(nomeTeste).concat("_").concat("%02d").concat(".png");

			if (logStatusDoTeste(nomeTeste, status)) {
				int i = 1;
				for (File scr : getInstanceListEvidencias()) {
					try {
						File evidencia = new File(String.format(file, i++));
						FileUtils.copyFile(scr, evidencia);
					} catch (Exception ex) {
						System.out.println("Erro na Escrita de arquivo.");
					}
				}
				gravaNoDocumento(nomeTeste, getInstanceListEvidencias());
			}
		}
		evidencias = null;
	}

	private void gravaNoDocumento(String nomeDoTeste, List<File> list){
		try {
			Document document = new Document( PageSize.A4, 30,30,30,30 );
		    PdfWriter.getInstance(document, new FileOutputStream(System.getProperty("user.dir").concat("\\relatorios\\").concat(nomeDoTeste).concat(".pdf")));
		    document.open();
//		    document.addAuthor(AUTHOR);
//		    document.addTitle("Framework Automacao");
		    document.addCreationDate();
		    Chunk string = new Chunk(nomeDoTeste);
		    Font fonte = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
		    string.setFont(fonte);
		    document.add(string); 
		    Image png;
			try {
				for (File evid : list) {
					png = Image.getInstance(evid.getCanonicalPath());
					png.scaleAbsolute(500, 300);
//				    png.setAlignment(Image.LEFT | Image.TEXTWRAP);  
				    document.add(png);
				}
			} catch (IOException e) {
				System.out.println("Erro na gravacao das evidencias");
				e.printStackTrace();
			}
		    
		    document.close();
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (DocumentException e) {
		    e.printStackTrace();
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

	public void copy(File src, File dst) throws IOException {
		InputStream in = new FileInputStream(src);
		OutputStream out = new FileOutputStream(dst); // Transferindo bytes de entrada para saída
		byte[] buf = new byte[1024];
		int len;
		while ((len = in.read(buf)) > 0) {
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}
	
	public void criaPastasParaUmDiretorioEspecifico(String caminhoDosArquivos, String caminhoSaida) {
		File diretorio = new File(caminhoDosArquivos);
		File[] arquivos = diretorio.listFiles();
		for (File file : arquivos) {
			try {
				String nome = (file.getName().split("[.]")[0]);
				if(nome.equals("")) {
					throw new AutomacaoException("Nome vazio");
				}
				File arquivoCopiado = new File(String.format("%s\\%s\\%s", caminhoSaida,nome,file.getName()));
				FileUtils.copyFile(file, arquivoCopiado);
				System.out.println("Criado Pasta para: " + nome);
			} catch (Exception e) {
				System.out.println("Falhou: " + file.getName());
			}
		}
		System.out.println("Finalizado!");
	}
}

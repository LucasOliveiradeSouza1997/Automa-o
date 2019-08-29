package br.com.lucas.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.lucas.Enum.Navegadores;
import br.com.lucas.Exception.AutomacaoException;
import br.com.lucas.Utils.ArquivoDePropriedadesProperties;

public class DriverFactory {
	protected static WebDriver driver;
	protected static WebDriverWait wait;
	private static ArquivoDePropriedadesProperties arquivoDePropriedadesProperties = ArquivoDePropriedadesProperties
			.getInstanceArquivoDePropriedadesProperties();

	public static WebDriver getInstance() {
		if (!driverEstaInicializado()) {
			String navegador = arquivoDePropriedadesProperties.getNavegador();
			inicializaNavegador(navegador);
			wait = new WebDriverWait(driver, 15);
			driver.manage().window().maximize();
		}
		return driver;
	}

	private static void inicializaNavegador(String navegador) {
		navegador = navegador.toUpperCase();
		if (Navegadores.CHROME.name().equals(navegador)) {
			inicializaNavegadorChrome();
		} else if (Navegadores.FIREFOX.name().equals(navegador)) {
			inicializaNavegorFirefox();
		}else {
			throw new AutomacaoException("Opcao invalida para o Navegador");
		}
	}

	private static void inicializaNavegorFirefox() {
		String pathDriverFirefox = System.getProperty("user.dir") + "\\drivers\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", pathDriverFirefox);
		driver = new FirefoxDriver();
	}

	private static void inicializaNavegadorChrome() {
		String pathDriverChrome = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", pathDriverChrome);
		driver = new ChromeDriver();
	}

	public static WebDriverWait getInstanceWait() {
		if (!waitEstaInicializado()) {
			wait = new WebDriverWait(DriverFactory.getInstance(), 15);
		}
		return wait;
	}

	public void navega(String url) {
		if (driverEstaInicializado()) {
			DriverFactory.getInstance().get(url);
		} else {
			System.out.println("driver nao inicializado");
		}
	}

	public void encerra() {
		if (driverEstaInicializado()) {
			DriverFactory.getInstance().quit();
			driver = null;
		}
	}

	private static boolean driverEstaInicializado() {
		return (driver != null);
	}

	private static boolean waitEstaInicializado() {
		return (wait != null);
	}
}

package br.com.lucas.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
	private static WebDriver driver;
	private static WebDriverWait wait;

	public void inicializaGoogleChrome() {
		if (! driverEstaInicializado()) {
			String pathDriverChrome = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", pathDriverChrome);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}else {
			System.out.println("Driver ja inicializado");
		}

	}
	
	public WebDriver getDriver() {
		if(driverEstaInicializado()) {
			return driver;
		}else {
			System.out.println("Nao encontrou o driver inicializado");
			return null;
		}
	}
	
	public WebDriverWait getWebDriverWait() {
		if(wait == null) {
			wait = new WebDriverWait(getDriver(),15);
		}
		return wait;
	}

	public void navega(String url) {
		if(driverEstaInicializado()) {
			driver.get(url);
		}
	}

	public void encerra() {
		if (driverEstaInicializado()) {
			driver.quit();
			driver = null;
		}else {
			System.out.println("Nao encontrou o driver inicializado");
		}

	}
	
	private boolean driverEstaInicializado() {
		return(driver != null);
	}
}

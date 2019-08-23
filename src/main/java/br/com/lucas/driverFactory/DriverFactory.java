package br.com.lucas.driverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
	protected  static WebDriver driver;
	protected  static WebDriverWait wait;

	public static WebDriver getInstance() {
		if (!driverEstaInicializado()) {
			String pathDriverChrome = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", pathDriverChrome);
			driver = new ChromeDriver();
			wait = new WebDriverWait(driver,15);
			driver.manage().window().maximize();
		}	
		return driver;
	   }

	public static WebDriverWait getInstanceWait() {
		if (!waitEstaInicializado()) {
			wait = new WebDriverWait(DriverFactory.getInstance(),15);
		}
		return wait;
	}

	public void navega(String url) {
		if(driverEstaInicializado()) {
			DriverFactory.getInstance().get(url);
		}else {
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
		return(driver != null);
	}
	
	private static boolean waitEstaInicializado() {
		return(wait != null);
	}
}

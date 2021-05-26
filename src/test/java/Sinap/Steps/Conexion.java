package Sinap.Steps;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Step;

public class Conexion {

	private WebDriver driver;

	@Before
	@Step
	public WebDriver abrirNavegador() {
		// driver de chrome para su ejecución
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver2.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://10.45.22.124:8000/Aplicaciones/sinap-web");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return this.driver;
		
	}
}

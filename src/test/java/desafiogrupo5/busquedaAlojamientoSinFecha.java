package desafiogrupo5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.awt.HKSCS;

public class busquedaAlojamientoSinFecha {
    WebDriver driver;
    By botonAlojamiento = By.xpath("//*[contains(@class, 'shifu-3-button-circle HOTELS ')]");
    By imputDestino = By.xpath("//*[contains(@class, 'sbox-destination sbox-primary ')]");

    @BeforeClass
    public static void init() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies(); //Borrando Cookies
        driver.manage().window().maximize();

    }
    @Test
    public void atc05() throws InterruptedException {
        driver.get("https://www.viajesfalabella.cl");
        System.out.println("Se abre URL");
        Thread.sleep(2000);
        Assert.assertEquals("https://www.viajesfalabella.cl/", driver.getCurrentUrl());
        driver.findElement(botonAlojamiento)
                .click();
        Thread.sleep(2000);
        driver.findElement(imputDestino).sendKeys("Bari");
        Thread.sleep(2000);
        driver.findElement(imputDestino).sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WebElement check_box = driver.findElement(By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[5]/label[1]/i[1]"));
        check_box.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//body/app-root[1]/app-searchbox-container[1]/div[1]/app-searchbox[1]/div[4]/div[1]/div[1]/div[3]/div[2]/div[4]/div[1]/a[1]/i[1]"))
                .click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.getCurrentUrl().contains("hoteles-en-san+carlos+de+bariloche?"));
    }
    @After
    public void close(){
        System.out.println("After");
        if(driver != null);
                driver.close();
    }
}

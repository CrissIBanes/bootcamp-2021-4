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
    By fechaEntrada = By.xpath("//*[contains(@class, 'sbox-checkin-date-container')]");
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
    @Test
    public void atc06() throws InterruptedException {
        driver.get("https://www.viajesfalabella.cl/hoteles/hl/901/i1/hoteles-en-san+carlos+de+bariloche?from=SB&encodedProps=cGFnZT0xJnZpZXdNb2RlPWxpc3Q=#page=1&view=list");
        System.out.println("Se abre URL");
        Thread.sleep(500);
        driver.findElement(fechaEntrada)
                .click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[4]/span[10]"))
                .click();
        Thread.sleep(500);
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[1]/div[4]/span[17]/span[1]"))
                .click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//body/div[1]/div[1]/div[6]/div[2]/button[2]"))
                .click();
        Thread.sleep(2000);
        WebElement check_box = driver.findElement(By.xpath("//body/div[@id='header']/div[@id='mainContainer']/div[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[1]/ul[1]/li[1]/span[1]/span[1]/span[1]"));
        check_box.click();
        Thread.sleep(2000);
        WebElement check_box2 = driver.findElement(By.xpath("//body/div[@id='header']/div[@id='mainContainer']/div[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[3]/ul[2]/li[1]/ul[1]/li[2]/span[1]/span[1]/span[1]/label[1]/i[1]"));
        check_box2.click();
        Thread.sleep(2000);
        WebElement check_box3 = driver.findElement(By.xpath("//body/div[@id='header']/div[@id='mainContainer']/div[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[3]/ul[2]/li[1]/ul[1]/li[3]/span[1]/span[1]/span[1]/label[1]/i[1]"));
        check_box3.click();
        Thread.sleep(2000);
        WebElement check_box4 = driver.findElement(By.xpath("//body/div[@id='header']/div[@id='mainContainer']/div[1]/div[2]/div[4]/div[2]/div[1]/div[1]/div[3]/ul[2]/li[1]/ul[1]/li[5]/span[1]/span[1]/span[1]/label[1]/i[1]"));
        check_box4.click();
        Thread.sleep(2000);
    }
    @After
    public void close(){
        System.out.println("After");
        if(driver != null);
                //driver.close();
    }
}

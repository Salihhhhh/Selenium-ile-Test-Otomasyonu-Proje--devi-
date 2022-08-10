package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLogger.class)
public class BaseTest {
    protected WebDriver driver;
    HomePage homePage;

    @BeforeAll
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.kitapyurdu.com/");
        System.out.println("Test initiatted.");
        Thread.sleep(3000);
        driver.manage().window().maximize();
        homePage=new HomePage(driver);


    }

    @AfterAll
   public void tearDown() {


   }
}

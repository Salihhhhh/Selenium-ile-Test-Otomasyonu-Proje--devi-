package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class HomePage {

    private WebDriver driver;
    private  By gelen=By.id("search-input");

    public HomePage(WebDriver driver) {
        this.driver=driver;
    }


    public void setInput(String ss) throws InterruptedException {
        WebElement buton = driver.findElement(By.id("search-input"));
        buton.click();
        Thread.sleep(2000);
        WebElement giris=driver.findElement(gelen);
        giris.click();
        giris.sendKeys(ss);
        WebElement ara= driver.findElement(By.className("button-search"));
        ara.click();


    }

}

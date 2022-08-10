package tests;
import org.junit.jupiter.api.Order;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import java.io.*;
import java.util.List;
import java.util.Random;


public class test1 extends BaseTest {
    WebElement input;

    @Test
    @Order(1)
    public void anasayfaKontrol() {

        WebElement gelen = driver.findElement(By.xpath("//*[@id='desktop-sw-cr']/div/div[2]/a/img"));
        Assertions.assertTrue(gelen.isDisplayed());
        if (gelen.isDisplayed()) {
            System.out.println("anasayfa başarılı bir şekilde yürütülüyor.");
        }
    }

    @Test
    @Order(2)
    public void inputDoldur() throws IOException, InterruptedException {
        File file = new File("proje.csv");
        if (!file.exists()) {
            file.createNewFile();
        }
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        homePage.setInput(line);

    }

    @Test
   @Order(3)
    public void ürünSirala() throws InterruptedException {
        List<WebElement> liste = driver.findElements(By.className("product-cr"));
        Random r = new Random();
        int i = r.nextInt(liste.size());
        Thread.sleep(3000);
        liste.get(1).click();
        Thread.sleep(3000);
    }

    @Test
  @Order(4)
    public void sepetEkle() throws InterruptedException {
        WebElement gelen= driver.findElement(By.className("add-to-cart"));
        gelen.click();
        Thread.sleep(5000);

        String sayıcı = driver.findElement(By.id("cart-items")).getText();
        int sayı = Integer.parseInt(sayıcı);
        Thread.sleep(3000);

        if (sayı > 0) {

            //////////////// Sepete Git işlemleri Yapıldı //////////////////

            driver.findElement(By.id("cart-items")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("js-cart")).click();
            Thread.sleep(3000);
        }else {
            System.out.println("Sepet boşşşşşşşşşş liütfen ekleyelimmmmmmmmm");
        }

    }

    @Test
    @Order(5)
    public void Arttir_Güncelle() throws InterruptedException {
        Thread.sleep(2000);
        WebElement deg = driver.findElement(By.xpath("//*[@id='cart_module']/div[1]/table/tbody/tr/td[4]/form/input[1]"));
        System.out.println("konttttttttttttttttrooooooooool " + deg);
        System.out.println("konttttttttttttttttrooooooooool " + deg.getAttribute("value"));
        String degg = deg.getAttribute("value");
        int gelenDeger = Integer.parseInt(degg);
        gelenDeger++;
        String ff = String.valueOf(gelenDeger);
        Thread.sleep(2000);
        WebElement dd = driver.findElement(new By.ByCssSelector("input[maxLength]"));
        dd.clear();
        dd.sendKeys(ff);
        ///////////////  Güncellemee yapıldı/////////////////
        driver.findElement(new By.ByCssSelector("i[onClick]")).click();
        Thread.sleep(2000);

        /////////////// Güncelleme Kotrol ////////////////////
        input = driver.findElement(By.xpath("//*[@id='swal2-title']"));
        String ee = input.getText();
        String yazı = "Sepetiniz güncelleniyor!";
        Assertions.assertEquals(ee, yazı);
        Thread.sleep(3000);

        /////////////////Sepeti Boşalt///////////////
        WebElement af;
        af = driver.findElement(By.xpath("//i[@class='fa fa-times red-icon']"));
        System.out.println("pppppppppppppppppppppp " + af.getAttribute("title"));
        af.click();
        Thread.sleep(2000);

    }

    @Test
    @Order(6)
    public void SonTesti() throws InterruptedException {
        Thread.sleep(3000);
        WebElement silmeKontrol= driver.findElement(new By.ByCssSelector("#cart_module > div.buttons > div > a"));
        Assertions.assertTrue(silmeKontrol.isDisplayed());

        }


    @Test
    @Order(7)
    public void sonn() throws InterruptedException {

        Thread.sleep(2000);
    }


}




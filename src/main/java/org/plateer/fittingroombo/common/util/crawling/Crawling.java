package org.plateer.fittingroomclient.common.util.crawling;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Crawling {

    public static void main(String[] args)throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\DevTool\\ChromeDriver\\110.0.5481.77\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Deleting all the cookies
        driver.manage().deleteAllCookies();

        //Specifiying pageLoadTimeout and Implicit wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //launching the specified URL
        driver.get("https://www.musinsa.com/categories/item/001006?d_cat_cd=001006&brand=&list_kind=big&sort=pop_category&sub_sort=&page=1&display_cnt=90&group_sale=&exclusive_yn=&sale_goods=&timesale_yn=&ex_soldout=&kids=&color=&price1=&price2=&shoeSizeOption=&tags=&campaign_id=&includeKeywords=&measure=");
        Thread.sleep(2000);

//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("window.scrollBy(0000,1000)", "");
//        Thread.sleep(2000);

        int temp = 0;
        while ( temp < 17 ) {
            new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(200);
            temp++;
        }

        //Locating the elements using name locator for the text box
        //driver.findElement(By.name("q")).sendKeys("YouTube");
        List<WebElement> elements =  driver.findElements(By.cssSelector("#searchList .li_inner"));
        //System.out.println(elements.size());

        elements.forEach(webElement ->  {
            WebElement img = webElement.findElement(By.cssSelector("img"));
            String fileName = img.getAttribute("alt");
            String fileURL = img.getAttribute("src");

            System.out.println(fileURL);

            try {
                URL url = new URL(fileURL);
                InputStream in = url.openStream();
                FileOutputStream fos= new FileOutputStream("C:\\upload\\" + fileName + ".jpg");
                byte[] buffer = new byte[4096*8];


                while(true){
                    int count = in.read(buffer);
                    if(count == -1){ break; }
                    fos.write(buffer,0,count);
                }

                fos.close();
                in.close();
            }catch(Exception e){

            }
        });

        driver.close();
    }
}

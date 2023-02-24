package org.plateer.fittingroombo.common.util.crawling;

import lombok.extern.log4j.Log4j2;
import net.coobird.thumbnailator.Thumbnails;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;


@Log4j2
public class Crawling {
    public static final String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static final String WEB_DRIVER_PATH = "D:/DevTool/ChromeDriver/110.0.5481.77/chromedriver.exe";


    public static void main(String[] args) throws Exception {
        roomCrawling("D:\\DEV\\Plateer\\MainProject\\images\\room", "https://www.shutterstock.com/ko/search/%ec%98%b7%eb%a3%b8?c3apidt=p67951739674&cr=ec&gclid=Cj0KCQiAutyfBhCMARIsAMgcRJQIF6oh4FAR0Kftt6E1kRmTtBt7jIphAxvks5TZeBWzKjn9EoNSU30aAgcgEALw_wcB&gclsrc=aw.ds&kw=%EC%9D%B4%EB%AF%B8%EC%A7%80%20%EC%82%AC%EC%9D%B4%ED%8A%B8&pl=PPC_GOO_KR_IG-645111431008&image_type=photo&mreleased=false");
//        productCrawling("D:\\DEV\\Plateer\\MainProject\\images\\product", "https://www.musinsa.com/categories/item/001006?d_cat_cd=001006&brand=&list_kind=big&sort=pop_category&sub_sort=&page=1&display_cnt=90&group_sale=&exclusive_yn=&sale_goods=&timesale_yn=&ex_soldout=&kids=&color=&price1=&price2=&shoeSizeOption=&tags=&campaign_id=&includeKeywords=&measure=");
    }






    public static WebDriver initDriver () {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Deleting all the cookies
        driver.manage().deleteAllCookies();

        //Specifiying pageLoadTimeout and Implicit wait
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;
    }

    public static void initFolder ( String folderPath ) {
        File folder = new File(folderPath);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    public static String initFileName ( String orginalName ) {
        String fileName = "";
        fileName += orginalName.replaceAll("-", "").replaceAll("_", "").replaceAll("\\p{Z}", "");
        fileName += ("_" + UUID.randomUUID() + ".jpg");

        return fileName;
    }






    public static void roomCrawling(String folderPath, String targetUrl) throws Exception {
        WebDriver driver = initDriver();

        driver.get(targetUrl);
        Thread.sleep(2000);

        int temp = 0;
        while ( temp < 10 ) {
            new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(200);
            temp++;
        }

        List<WebElement> elements =  driver.findElements(By.cssSelector(".mui-1nl4cpc-gridContainer-root .mui-16jc9cy-letterboxingWrapper"));

        System.out.println("###################################");
        System.out.println(elements.size());
        System.out.println("###################################");

        initFolder(folderPath);
        elements.forEach(webElement ->  {
            WebElement img = webElement.findElement(By.cssSelector("img"));
            String fileName = initFileName(img.getAttribute("alt"));
            String fileURL = img.getAttribute("src");

            try {
                URL url = new URL(fileURL);
                InputStream in = url.openStream();
                FileOutputStream fos= new FileOutputStream( folderPath + "\\" + fileName );
                byte[] buffer = new byte[4096*8];

                while(true){
                    int count = in.read(buffer);
                    if(count == -1){ break; }
                    fos.write(buffer,0,count);
                }

                Thumbnails.of(new File(folderPath + "/" + fileName))
                        .forceSize(160, 160)
                        .toFile(new File(folderPath + "/s_" + fileName));

                fos.close();
                in.close();
            } catch( Exception e ) {

            }
        });
        driver.close();
    }



    public static void productCrawling(String folderPath, String targetUrl) throws Exception {
        WebDriver driver = initDriver();

        driver.get(targetUrl);
        Thread.sleep(2000);

        int temp = 0;
        while ( temp < 17 ) {
            new Actions(driver).sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(200);
            temp++;
        }

        List<WebElement> elements =  driver.findElements(By.cssSelector("#searchList .li_inner"));

        initFolder(folderPath);
        elements.forEach(webElement ->  {
            WebElement img = webElement.findElement(By.cssSelector("img"));
            String fileName = initFileName( img.getAttribute("alt") );
            String fileURL = img.getAttribute("src");

            try {
                URL url = new URL(fileURL);
                InputStream in = url.openStream();
                FileOutputStream fos= new FileOutputStream( folderPath + "\\" + fileName );
                byte[] buffer = new byte[4096*8];

                while(true){
                    int count = in.read(buffer);
                    if(count == -1){ break; }
                    fos.write(buffer,0,count);
                }

                Thumbnails.of(new File(folderPath + "/" + fileName))
                        .forceSize(160, 160)
                        .toFile(new File(folderPath + "/s_" + fileName));

                fos.close();
                in.close();
            } catch( Exception e ) {

            }
        });
        driver.close();
    }
}

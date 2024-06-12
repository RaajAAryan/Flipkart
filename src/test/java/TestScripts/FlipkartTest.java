package TestScripts;

import com.BaseClass;

import Page.FlipkartPage;
import io.appium.java_client.clipboard.HasClipboard;

import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.TreeSet;

public class FlipkartTest extends BaseClass {

 @Test
 public void searchAndPrintPrices() throws MalformedURLException, InterruptedException {
     FlipkartPage flipkartPage = new FlipkartPage(driver);
     ///////////Download
     flipkartPage.openHomePage();
     flipkartPage.searchForProduct("iPhone 15");
     TreeSet<String> sortedProducts = flipkartPage.getProductList();
     flipkartPage.printProductPrices(sortedProducts);
 }
 }

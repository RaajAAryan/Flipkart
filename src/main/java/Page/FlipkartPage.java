package Page;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.TreeSet;

public class FlipkartPage {
    private AndroidDriver driver;

    @FindBy(xpath = "//div[text()='Search for Products, Brands and More']")
    private WebElement searchBar;

    @FindBy(xpath = "//input[@placeholder='Search for Products, Brands and More']")
    private WebElement searchInput;

    @FindBy(xpath = "//div[contains(text(),'Apple iPhone 15')]")
    private List<WebElement> productList;

    public FlipkartPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openHomePage() {
        driver.get("https://www.flipkart.com");
    }

    public void searchForProduct(String product) throws InterruptedException {
        searchBar.click();
        Thread.sleep(4000);
        searchInput.sendKeys(product + Keys.ENTER);
        Thread.sleep(4000);
    }

    public TreeSet<String> getProductList() throws InterruptedException {
        Thread.sleep(3000);
        TreeSet<String> sortedProducts = new TreeSet<>();
        for (WebElement product : productList) {
            String productText = product.getText();
            sortedProducts.add(productText);
        }
        return sortedProducts;
    }

    public void printProductPrices(TreeSet<String> products) {
        for (String product : products) {
            System.out.println(product);
            WebElement priceElement = driver.findElement(By.xpath("//div[contains(text(),'" + product + "')]/../following-sibling::div//div/div[contains(text(),'₹')]"));
            System.out.println(priceElement.getText());
        }
    }
}

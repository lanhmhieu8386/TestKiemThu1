import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class VitimexTest {

    WebDriver driver;
    WebDriverWait wait;

    String email = "test" + System.currentTimeMillis() + "@gmail.com";
    String password = "123456Aa@";

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        //  driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test(priority = 1)
    public void register() {

        driver.get("https://vitimex.com.vn/account/register");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[last_name]")))
                .sendKeys("Nguyen");

        driver.findElement(By.name("customer[first_name]")).sendKeys("Test");

        // Chọn giới tính Nam
        driver.findElement(By.xpath("//label[contains(text(),'Nam')]/preceding-sibling::input"))
                .click();

        driver.findElement(By.name("customer[birthday]")).sendKeys("01/01/2000");
        driver.findElement(By.name("customer[birthday]")).sendKeys(Keys.TAB);

        driver.findElement(By.name("customer[email]")).sendKeys(email);

        driver.findElement(By.name("customer[password]")).sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[type='submit']")
        )).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 2)
    public void login() {

        driver.get("https://vitimex.com.vn/account/login");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("customer[email]")))
                .sendKeys(email);

        driver.findElement(By.name("customer[password]")).sendKeys(password);

        wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[type='submit']")
        )).click();
        wait.until(ExpectedConditions.urlContains("account"));
        System.out.println("Login thành công với email: " + email);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
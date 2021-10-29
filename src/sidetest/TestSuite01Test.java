package sidetest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import java.util.*;

public class TestSuite01Test {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","resources/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testCase01() {
        driver.get("https://www.selenium.dev/selenium-ide/");
        driver.findElement(By.xpath("/html/body/div[2]/footer/section[1]/div[1]/a[1]")).click();
        assertThat(driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div[1]/header/h1")).getText(), is("Getting Started"));
    }
    @Test
    public void testCase02() {
        driver.get("https://sahitest.com/demo/training/login.htm");
        driver.findElement(By.xpath("/html/body/center/div/form/table/tbody/tr[1]/td[2]/input")).sendKeys("test");
        driver.findElement(By.xpath("/html/body/center/div/form/table/tbody/tr[2]/td[2]/input")).sendKeys("secret");
        driver.findElement(By.xpath("/html/body/center/div/form/table/tbody/tr[3]/td[2]/input")).click();
        assertThat(driver.findElement(By.xpath("/html/body/center/form/div/h2")).getText(), is("All available books"));
    }
}

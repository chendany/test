import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class TestingTest {
    private WebDriver driver;

    @BeforeClass
    public static void beforeClassTest(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
    }

    @Before
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }
    
    @Test
    public void testSearch() {
        driver.get("https://www.sogou.com");
        WebElement element = driver.findElement(By.id("stb"));
        element.clear();
        element.sendKeys("软件测试");
        element.submit();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(element.getText(),"软件测试");
    }

    @Test
    public void testNews(){
        driver.get("https://www.sogou.com");
        WebElement element = driver.findElement(By.cssSelector("#stb"));
        element.clear();
        element.sendKeys(" ");
        element.submit();
        assertNotNull("is null",element.getText());
    }

    @Test
    public void testQuestion(){
        driver.get("https://www.sogou.com");
        WebElement element = driver.findElement(By.linkText("问问"));
        element.click();
        assertTrue("true",element.getText().equals("问问"));
    }
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }


}
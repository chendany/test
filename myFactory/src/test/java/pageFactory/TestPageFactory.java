package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPageFactory {

    WebDriver driver;
    Login objLogin;
    Home objHomePage;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.testfire.net/login.jsp/");
    }

    @Test(priority=0)
    public void test_Home_Page_Appear_Correct(){
        objLogin = new Login(driver);
        //获取登录的网站名
        String loginPageTitle = objLogin.getLoginTitle();
        //检验网站名是否为"Altoro Mutual"
        Assert.assertTrue(loginPageTitle.toLowerCase().contains("Altoro Mutual"));
        //输入用户名"admin"和密码"admin"登录
        objLogin.loginTo("admin", "admin");
        driver.get("https://www.testfire.net/");
        objHomePage = new Home(driver);
        //检验获取的文本是否是"Congratulations!"
        Assert.assertTrue(objHomePage.getHome().toLowerCase().contains("Congratulations!"));
    }
    @AfterTest
    public void close(){
        driver.quit();
    }
}

package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
    WebDriver driver;
    @FindBy(xpath="//*[@id=\"_ctl0__ctl0_Content_Main_promo\"]/table/tbody/tr[1]/td/h2")
    WebElement homePage;

    public Home(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //获取登录成功后主页文本Congratulation！
    public String getHomePage(){
        return	homePage.getText();
    }
}

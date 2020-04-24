package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    WebDriver driver;
   //用户名框
    @FindBy(name="uid")
    WebElement userName;
    //密码框
    @FindBy(name="passw")
    WebElement password;
    //网站名
    @FindBy(xpath="/html/head/title")
    WebElement titleText;
    //登录按钮
    @FindBy(name="btnSubmit")
    WebElement login;
    
    public Login(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //输入用户名
    public void setUserName(String strUserName){
        userName.sendKeys(strUserName);

    }
    //输入密码 
    public void setPassword(String strPassword){
        password.sendKeys(strPassword);
    }
    //点击登录
    public void clickLogin(){
        login.click();
    }
    //获取网站名
    public String getLoginTitle(){
        return	titleText.getText();
    }
    //登录
    public void loginTo(String strUserName,String strPasword){
        //Fill user name
        this.setUserName(strUserName);
        //Fill password
        this.setPassword(strPasword);
        //Click Login button
        this.clickLogin();
    }
}

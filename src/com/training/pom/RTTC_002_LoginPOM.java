package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RTTC_002_LoginPOM {
	private WebDriver driver; 
	
	public RTTC_002_LoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-user-o']")
    private WebElement AccountIcon;
	
	@FindBy(xpath="//li[@class='tb_link tb_menu_system_account_login']")
	private WebElement LoginRegisterdropdown;
	
    @FindBy(id="input-email")
	private WebElement username; 
	
	@FindBy(id="input-password")
	private WebElement password;

	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn; 	
	
	@FindBy(xpath="//div[@class='alert alert-danger']")
	private WebElement Alertmessage; 
	
	@FindBy(xpath="//a[contains(text(),'Forgotten Password')]")
	private WebElement ForgotPass; 
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueforgot; 

	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement Success; 
	
 public void LoginRegister() throws InterruptedException {
	 Actions Act = new Actions(driver);
	 Act.moveToElement(AccountIcon).perform();
	 Act.moveToElement(LoginRegisterdropdown).click().perform();
	
 }
	
 public void login() throws InterruptedException {
	 LoginRegister();
	 Thread.sleep(3000);
	 this.username.sendKeys("antchris15@gmail.com");
	 this.password.sendKeys("manzoor1");
	 this.loginBtn.click();
 }
 
 public void forgotpassword() throws InterruptedException {
	 LoginRegister();
	 Thread.sleep(3000);
	 this.username.sendKeys("antchris15@");
	 this.password.sendKeys("ytyutyt");
	 this.loginBtn.click();
	 Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", Alertmessage.getText());
	 this.ForgotPass.click();
	 this.username.sendKeys("antchris15@gmail.com");
	 this.continueforgot.click();
	 Assert.assertEquals("An email with a confirmation link has been sent your email address.", Success.getText());
 }
 }
	

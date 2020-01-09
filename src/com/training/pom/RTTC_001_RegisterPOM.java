package com.training.pom;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RTTC_001_RegisterPOM {
	private WebDriver driver; 
	
	public RTTC_001_RegisterPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//i[@class='fa fa-user-o']")
    private WebElement AccountIcon;
	
	@FindBy(xpath="//li[@class='tb_link tb_menu_system_account_login']")
	private WebElement LoginRegisterdropdown;
	
	@FindBy(linkText="Register")
	private WebElement Registerbutton;
	
	@FindBy(id="input-firstname")
    private WebElement FirstName;
	
	@FindBy(id="input-lastname")
    private WebElement LastName;
	
	@FindBy(id="input-email")
    private WebElement Email;
	
	@FindBy(id="input-telephone")
    private WebElement Telephone;
	
	@FindBy(id="input-address-1")
    private WebElement Addressline1;
	
	@FindBy(id="input-address-2")
    private WebElement Addressline2;
	
	@FindBy(id="input-city")
    private WebElement City;
	
	@FindBy(id="input-postcode")
    private WebElement Postcode;
	
	@FindBy(id="input-country")
    private WebElement Country;
	
	@FindBy(id="input-zone")
    private WebElement State;
	
	@FindBy(name="password")
    private WebElement Password1;
	
	@FindBy(name="confirm")
    private WebElement ConfirmPass1;
	
	@FindBy(name="newsletter")
    private WebElement SubscriberadioNo1;
	
	@FindBy(name="agree")
    private WebElement PrivatePolicy;
	
	@FindBy(xpath="//input[@type='submit']")
    private WebElement ContinueButton;
	
	@FindBy(xpath="//*[@id=\"System_nyHsmShk\"]/div[1]/p[1]")
    private WebElement Congratsmessage;
	
	public void Registration() throws InterruptedException {
		LoginRegister();
		Thread.sleep(3000);
		this.Registerbutton.click();
		this.FirstName.sendKeys("manzoor");
		this.LastName.sendKeys("mehadi");
		this.Email.sendKeys("Joseindia@gmail.com");
		this.Telephone.sendKeys("9876543210");
		this.Addressline1.sendKeys("yeshwanthapur");
		this.Addressline2.sendKeys("bangalore");
		this.City.sendKeys("bangalore");
		this.Postcode.sendKeys("560022");
		Select country=new Select(this.Country);
		country.selectByValue("99");
		Select state=new Select(this.State);
		state.selectByValue("1489");
		this.Password1.sendKeys("manzoor1");
		this.ConfirmPass1.sendKeys("manzoor1");
		this.SubscriberadioNo1.click();
		this.PrivatePolicy.click();
		this.ContinueButton.click();
		Assert.assertEquals("Congratulations! Your new account has been successfully created!", Congratsmessage.getText());
			
	}
	 public void LoginRegister() throws InterruptedException {
		 Actions Act = new Actions(driver);
		 Act.moveToElement(AccountIcon).perform();
		 Act.moveToElement(LoginRegisterdropdown).click().perform();
}
}



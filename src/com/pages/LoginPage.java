package com.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(name ="username")
	WebElement username;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(xpath ="//button[text()='Login']")
	WebElement login;
	
	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	//Verify Title
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	//Login 
	public DashboardPage login(String user , String pass) {
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		username.sendKeys(user);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		password.sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		login.click();
		return new DashboardPage();
		
	}
	

}

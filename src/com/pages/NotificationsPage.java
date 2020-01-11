package com.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;

public class NotificationsPage extends TestBase {
	
	@FindBy(xpath="//button[contains(text(),'SEND NOTIFICATION')]")
	WebElement sendNotificaton;
	
	// Initializing the Page Objects:
			 public NotificationsPage() {
				PageFactory.initElements(driver, this);
			}
			 
	public CreatePostPage clickOnSendNotification(){
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		sendNotificaton.click();
		return new CreatePostPage();
		
	}

}

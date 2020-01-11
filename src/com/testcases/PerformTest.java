package com.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.NotificationsPage;
import com.pages.LoginPage;
import com.pages.CreatePostPage;
import com.pages.DashboardPage;

public class PerformTest extends TestBase {
	
	LoginPage loginpage;
	DashboardPage dashboardpage;
	NotificationsPage notificationpage;
	CreatePostPage createpostpage;
	
	public PerformTest() {
		super();
	}
	
	@BeforeMethod
public void setup() {
		initialization();
		loginpage=new LoginPage();
	}
	
	@Test
	public void CreateNotification() throws InterruptedException {
		dashboardpage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
			Thread.sleep(15000);
			notificationpage=dashboardpage.clickOnNotificationCentre();
			Thread.sleep(15000);
		createpostpage=notificationpage.clickOnSendNotification();
		createpostpage.cretenotification();
		
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}

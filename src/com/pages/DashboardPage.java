package com.pages;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.base.TestBase;

public class DashboardPage extends TestBase {
	Robot robot=null;
	@FindBy(xpath="//a[contains(text(),'COMMUNICATION')]")
	WebElement communication;
	
	@FindBy(xpath="//a[contains(text(),'Notification centre')]")
	WebElement notificationCentre;
	

	// Initializing the Page Objects:
		public DashboardPage() {
			PageFactory.initElements(driver, this);
		}
		
		public NotificationsPage clickOnNotificationCentre() {
			
			driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
			handleBrowserPopUp();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			communication.click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			notificationCentre.click();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			return new NotificationsPage();
		}
			
		public void handleBrowserPopUp() {
			try {
				Thread.sleep(5000);
				robot = new Robot();
				robot.delay(5000);
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyPress(KeyEvent.VK_ENTER);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Unable to Handle the browser POPUP");
			}
			
			
		}
		
		

		
}

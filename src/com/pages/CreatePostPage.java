package com.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class CreatePostPage extends TestBase {

	@FindBy(name = "title")
	WebElement title;

	@FindBy(name = "body")
	WebElement body;

	@FindBy(xpath = "//label[contains(text(),'All tiers')]")
	WebElement alltiers;

	@FindBy(xpath = "//input[@name='date']")
	WebElement date;

	@FindBy(xpath = "//input[@name='posted_time']")
	WebElement postedTime;

	@FindBy(xpath = "//button[text()='CREATE']")
	WebElement create;

	@FindBy(xpath = "//span[contains(text(),'Tiers')]")
	WebElement tiers;

	@FindBy(xpath = "//label[contains(text(),'All tiers')]")
	WebElement allTiers;

	@FindBys(@FindBy(xpath = "//span[contains(@class,'cell day') ]"))
	List<WebElement> capturedates;

	// Initializing the Page Objects:
	public CreatePostPage() {
		PageFactory.initElements(driver, this);
	}

	public void cretenotification() {
		try {
			Thread.sleep(5000);
			title.sendKeys("Keubik notification");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			date.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			selectDate("29" , "DEC 2019");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			body.sendKeys("Contains all the body for the notification");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			entertime("05", "30");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			tiers.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			allTiers.click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			create.click();
			Thread.sleep(10000);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void entertime(String hour, String min) {
		postedTime.click();
		postedTime.sendKeys(hour);
		postedTime.sendKeys(min);
		postedTime.sendKeys(Keys.ARROW_UP);
	}

	public void selectDate(String selectDate, String Monthyear) {

		String mmyy = "";
		String st = Monthyear;
		mmyy = driver.findElement(By.xpath("//span[contains(@class,'day__month_btn up') ]")).getText();
		while (!st.equals(mmyy)) {
			driver.findElement(By.xpath("//span[contains(@class,'next') ]")).click();
			mmyy = driver.findElement(By.xpath("//span[contains(@class,'day__month_btn up') ]")).getText();
			System.out.println(mmyy.toLowerCase());
		}
		List<WebElement> allDates = capturedates;

		for (WebElement ele : allDates) {

			String date = ele.getText();

			if (date.equalsIgnoreCase(selectDate)) {
				ele.click();
				break;
			}

		}
	}

}

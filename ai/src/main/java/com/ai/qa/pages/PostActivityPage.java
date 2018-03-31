package com.ai.qa.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ai.qa.base.TestBase;

public class PostActivityPage extends TestBase{
	private static Logger log = LogManager.getLogger(PostActivityPage.class.getName());
	@FindBy(id="title")
	WebElement activitytitle;
	@FindBy(id="tinymce")
	WebElement activitydescription;
	//@FindBy(xpath="//ul[@class='select2-selection__rendered']//parent::span[@aria-owns='select2-team_members_id-results']//child::ul")
	@FindBy(xpath="//select[@id='team_members_id']")
	WebElement teammembers;
	@FindBy(xpath="//div[@class='add-link']/a/span[@class='add-link-count']")
	WebElement addlink;
	@FindBy(xpath="//a[@class='popup-close']")
	WebElement popupclose;
	@FindBy(id="anonymous_master_id")
	WebElement anonymousid;
	WebElement keywords;
	@FindBy(xpath="//button[contains(text(),'Publish')]")
	WebElement publish;
	public PostActivityPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setActivityTitle(String title)
	{
		activitytitle.sendKeys(title);
	}
	public void setActivityDescription(String desc)
	{   log.debug("Trying to switch to frame ");
		driver.switchTo().frame("description_ifr");
		log.debug("Switch to frame successful ");
		activitydescription.sendKeys(desc);
		log.debug("activity description is entered ");
		driver.switchTo().defaultContent();
		log.debug("Switched back to default window");
	}
	public void setTeamMember(int index)
	{
		JavascriptExecutor js = ((JavascriptExecutor)driver);
        js.executeScript("window.scrollTo(0,450)");
		Select dropdown = new Select(teammembers);
		dropdown.selectByIndex(index);
		log.debug("Window is scrolled and team member is selected");
		}
	public void setSetLink(String linkurl,String linkcode)
	{
		addlink.click();
		popupclose.click();
		log.debug("Link is clicked and link Url is entered");
		
	}
	public void setAnonymousId(String id)
	{
		Select dropdown = new Select(anonymousid);
		dropdown.selectByVisibleText(id);
		log.debug("Anonymous Id is set");
	}
	public void setKeywords(int keyword1,int keyword2,int keyword3)
	{
		Select dropdown= new Select(keywords);
		dropdown.selectByIndex(keyword1);
		System.out.println("Keyword 1 selected");
		dropdown.selectByIndex(keyword2);
		System.out.println("Keyword 2 selected");
		dropdown.selectByIndex(keyword3);
		System.out.println("Keyword 3 selected");
		log.debug("Keywords are selected ");
	}
	public MyActivities submitPublish()
	{
		publish.click();
		log.debug("Publish activity is clicked");
		return new MyActivities();
	}
}

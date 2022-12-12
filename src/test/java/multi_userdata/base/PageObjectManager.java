package multi_userdata.base;

import org.openqa.selenium.WebDriver;

import multi_userdata.appPages.ParaHomePagePO;
import multi_userdata.appPages.ParaNewUserPagePO;
import multi_userdata.appPages.SearchPage;
import multi_userdata.appPages.SearchResultPage;

public class PageObjectManager {
	private WebDriver driver;
	
	private SearchPage searchPage;
	private SearchResultPage resultPage;
	private ParaHomePagePO paraHome;
	private ParaNewUserPagePO paraNewUser;

	public PageObjectManager(WebDriver driver) throws Exception {
		this.driver = driver;
	}
	
	
	public SearchPage search_page(){
		return (searchPage == null) ? searchPage = new SearchPage(driver): searchPage;
	}
	
	public SearchResultPage result_page(){
		return (resultPage == null) ? resultPage = new SearchResultPage(driver): resultPage;
	}

	public ParaHomePagePO paraHomePage(){
		return (paraHome == null) ? paraHome = new ParaHomePagePO(driver) : paraHome; 
	}

	public ParaNewUserPagePO paraNewUserPage(){
		return (paraNewUser == null) ? paraNewUser = new ParaNewUserPagePO(driver) : paraNewUser; 
	}
	
}
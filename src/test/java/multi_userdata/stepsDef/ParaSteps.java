package multi_userdata.stepsDef;

import java.time.Duration;

import org.testng.Assert;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import multi_userdata.appPages.ParaHomePagePO;
import multi_userdata.appPages.ParaNewUserPagePO;


public class ParaSteps {
	
	Hooks testContext;
	ParaHomePagePO paraHomePage;
	ParaNewUserPagePO paraNewUserPage;
	
	public ParaSteps(Hooks context) {
		testContext = context;
		paraHomePage = testContext.getPageObjectManager().paraHomePage();
		paraNewUserPage =testContext.getPageObjectManager().paraNewUserPage();
	}
	
	@Given("on parabank home page")
	public void parabankHomePage() {
		paraHomePage.get();
	}
    @When("click on register")
    public void click_register() {
    	paraNewUserPage = paraHomePage.newuserAccount();
    }
    
    
    @Then("new user page is open")
    public void new_user_page() {
    	
    	Assert.assertEquals(paraNewUserPage.NewUserPageTitle.getText(),"Signing up is easy!");
    	
    	//paraNewUserPage.CreateNewUser();
    }
    
    @And("wait for {int}s")
    public void waitfor_step(long wait) {
		long  waitInMilli = wait*1000;
    	try { Thread.sleep(waitInMilli); } 
    	catch (InterruptedException e) { e.printStackTrace(); 	}
    }

	@And("refresh browser page")
	public void f1() throws Exception{
		testContext.getWebDriverManager().navigate().refresh();
	}
    
	

}

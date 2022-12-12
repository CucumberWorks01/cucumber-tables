package multi_userdata.stepsDef;


import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import multi_userdata.appPages.SearchResultPage;
import multi_userdata.base.Context;
import multi_userdata.stepsDef.Hooks;;


public class ResultSteps {
    
    Hooks testContext;
	SearchResultPage resultPage;
	String resultStat;
	
	public ResultSteps(Hooks context) {
		testContext = context;
		resultPage = testContext.getPageObjectManager().result_page();
	}

  @Then("verify result stat")
  public void f1(){
	System.out.println("resultPage:" +resultPage.getResultStat());
	System.out.println("searchPage:"+testContext.scenarioContext.getContext(Context.APP_DATA));

	Assert.assertEquals(resultPage.getResultStat(), testContext.scenarioContext.getContext(Context.APP_DATA));
     
  }

  @When("print shared data")
  public void f2(){
	System.out.println(testContext.scenarioContext.getContext(Context.APP_DATA));
  }
  
  @When("click on result link")
  public void f3(){
	resultPage.searchLinks.get(1).click();
	try { Thread.sleep(4000);  } 
	catch (InterruptedException e) { e.printStackTrace();  }
  }


}

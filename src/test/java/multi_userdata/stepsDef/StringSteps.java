package multi_userdata.stepsDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StringSteps {

    @Given("(?i)^perform get request \"([^\"]*)\"$")
    public void performGetRequest(String url) throws Throwable {
       System.out.println("String url:"+url);
    }
    
    @Given("^we have to wait for (.*) (secs|seconds)?")
    public void test_or_conditions(int waitTime,String cond){
        System.out.println(String.format("user wait for %d %s",waitTime,cond));
    }

    @When("^I search (.*) (IND|USA)? in Database$")
    public void searchInDatabase(String name, String country){
        System.out.println("user passed country as :"+country);
    }

    @Then("^Something is (not )?counted$")
    public void somethingCounted(String optional) {
        System.out.println("This will works for both: 'Something is not counted' and 'Something is counted'");
    }

    // @When("^(.+) has a value ((?!true|false).+)$")
    @When("^(.+) has a value (false|true)$")
    public void addValues(String key, String value) {
        System.out.println("the bulb is "+key+" so boolean value is: "+value);
    }
}

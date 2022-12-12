package multi_userdata;

import org.testng.annotations.AfterClass;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions( plugin = { "pretty",
                             "html:target/cucumber-report.html", //create a folder called cucumber
                             "json:target/cucumber.json" ,
                             "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
                           },
		         glue = "multi_userdata.stepsDef", 
                   features = "src/test/java/multi_userdata/features"
                  ,tags= "@stringtests" //"@wip"
                )
public class TestRunner  extends AbstractTestNGCucumberTests {
     
     @AfterClass
     public void finsihTest(){
     
     }
}


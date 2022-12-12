package multi_userdata.stepsDef;

import java.util.Locale;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import multi_userdata.appPages.ParaNewUserPagePO;
import com.github.javafaker.Faker;;


public class TableSteps {

    Hooks testContext;
	ParaNewUserPagePO paraNewUserPage;
    Faker fake ;
    ;
	
	public TableSteps(Hooks context) {
		testContext = context;
		paraNewUserPage = testContext.getPageObjectManager().paraNewUserPage();
	}

    @When("enter data in form feilds as map")
    public void f1(DataTable dt01){

        List<Map<String,String>> newUserData = dt01.asMaps(String.class,String.class);
        paraNewUserPage.FirstName.sendKeys(newUserData.get(0).get("FirstName"));
        paraNewUserPage.LastName.sendKeys(newUserData.get(0).get("LastName"));
        paraNewUserPage.City.sendKeys(newUserData.get(0).get("City"));
    }
    

    @When("enter data in form feilds as faker")
    public void f2(DataTable rawTable01){
        List<String> table1 = rawTable01.asList();
        try{
             for(String head: table1){
                 System.out.println("Table Head: "+head);
             }
        }catch(Exception e){
            e.printStackTrace();
        }
    }


    @When("convert data table to list")
    public void f3(DataTable tableAsList){
        
        System.out.println("Method-1 to table to list");
        List<String>   tableAsList01 = tableAsList.asList();
        for(String data: tableAsList01){
            System.out.println("Vertical table cell data: "+data);
        }
                
    }

    
    @When("convert horizointal single cell data table to list")
    public void f4(DataTable horizointalCellTableToList){

        System.out.println("Method to transpose horizointal cell table to list");
        List<String>   tableAsList01 = horizointalCellTableToList.row(0);
        for(String data: tableAsList01){
            System.out.println("Horizointal table cell data: "+data);
        }

        System.out.println("");
        System.out.println("Method-2 to transpose table to list");
        List<String>   tableAsList02 = horizointalCellTableToList.transpose().asList();
        for(String data: tableAsList02){
            System.out.println("Vertical table cell data: "+data);
        }
    }


    @When("take screenshot of desired element")
    public void f5() throws WebDriverException, Exception{
        
        WebElement ele = testContext.getWebDriverManager().findElement(By.id("customerForm"));
        //// Get entire page screenshot
        File screenshot = ele.getScreenshotAs(OutputType.FILE);
        //// Copy the element screenshot to disk
        File screenshotLocation = new File("./shot1.png");
        FileUtils.copyFile(screenshot, screenshotLocation);
        Allure.addAttachment("Attached Step Msg:","Hello world!!!");
    }

    
    @And("attach screenshot {string}")
    public void attach_screenshot(String screenShotName) throws WebDriverException, Exception{
        Allure.addAttachment(screenShotName, new ByteArrayInputStream(((TakesScreenshot) testContext.getWebDriverManager()).getScreenshotAs(OutputType.BYTES)));
    }

    @Attachment(value = "{0}", type = "text/plain")
	private static String saveTextLog(String message) {
	    return message;
	}
	
	
	@Attachment(value = "Web Page Screenshot", type = "image/png")
	private byte[] takeScreenshot() throws WebDriverException, Exception {
			// Take a screenshot as byte array and return
			return ((TakesScreenshot)testContext.getWebDriverManager()).getScreenshotAs(OutputType.BYTES);
	}
    
    public void enter_form_feild_data(){
        
		 fake = new Faker(new Locale("en_US"));
		
		String firstname1 = fake.name().firstName();
		String lastname1=fake.name().lastName();
		String address1=fake.address().fullAddress();
		String city1=fake.address().city();
		String state1=fake.address().state();
		String zip1=fake.address().zipCode();
		String phone1=fake.phoneNumber().phoneNumber();
		Random rand1 = new Random();
		String ssn1 ="5"+String.format("%09d", rand1.nextInt(10000000)); //856-45-6789
		
		System.out.println(firstname1+"=="+lastname1+"=="+address1+"=="+city1+"=="+state1+"=="+zip1+"=="+phone1+"=="+ssn1);
    }


}

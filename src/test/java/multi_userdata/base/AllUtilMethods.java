package multi_userdata.base;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class AllUtilMethods {

	WebDriver driver;
	
    /*=========== File Utility Methods ======================*/
	public boolean makeFile() {
	 boolean b=true;
	 String fname = CreateDir();
	 try {
	  File yourFile = new File("D:/File-Op-Demo/"+fname);
	  if(!yourFile.exists()) {
			
			    yourFile.createNewFile();
			}
			FileOutputStream oFile = new FileOutputStream(yourFile, false);
		}
	    catch(Exception e)
		{
	    	e.printStackTrace();
	    	b= false;
		}
	    return b;
	}


	public static Object[] makefiless()
	{
		Object[] objects = new Object[2];
		boolean b=true;
		String fname = CreateDir();
		File yourFile=null;
		
		try
		{
			yourFile = new File("D:/File-Op-Demo/"+fname+".log");
			if(!yourFile.exists()) 
			{
			    yourFile.createNewFile();
			}
//			oFile = new FileOutputStream(yourFile, false);
//			oFile.close();
		}
	    catch(Exception e)
		{
	    	e.printStackTrace();
	    	b= false;
		}
		objects[0]=b;
		objects[1]=yourFile;
		
	    return objects;
		
	}

	public static void write2file(String data) throws IOException
	{
		Object[] obj = makefiless();
		boolean b= (boolean) obj[0];
		File oFile= (File) obj[1];
		
		if (b==true ) 
		{
			FileWriter fw = new FileWriter(oFile.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(data);
			bw.newLine();
			bw.close();
	     	System.out.println("Done");
		}
	}


	public static void write2file(String path,String data) throws IOException
	{
//		Object[] obj = makefiless();
//		boolean b= (boolean) obj[0];
//		File oFile= (File) obj[1];
	//	
//		if (b==true ) 
//		{
			FileWriter fw = new FileWriter(path,true); //.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.newLine();
			bw.write(data);
			bw.close();
	     	System.out.println("Done");
//		}
	}




	public static String CreateDir()
	{
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter= new SimpleDateFormat("MMM_dd_HH_mm_ss"); //format it as per your requirement
	    String dateNow = formatter.format(currentDate.getTime());
	    System.out.println("Now the date is :=>  " + dateNow);
	    File dir = new File(dateNow);
	    dir.mkdir();
	    return dateNow;
	    
	    
	}

	public static void fileAppend(String source)
	{
		 try {
	         FileWriter f2 = new FileWriter("D:/File-Op-Demo/log.log", true);
	         f2.write(source);
	         f2.close();
	         //fnew.renameTo(fold);
	         //fold.renameTo(temp);
	         //temp.deleteOnExit();

	     } catch (IOException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	 }           

	}

	public static void printwriterMethod(String source) throws FileNotFoundException, UnsupportedEncodingException
	{
		PrintWriter printWriter = new PrintWriter ("D:/File-Op-Demo/log1.log");
	    printWriter.println(source);
	    printWriter.close ();       
	}

	public static void fileread(String file) throws FileNotFoundException
	{
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		try
		{
		  for(String line; (line = br.readLine()) != null; ) 
		   {System.out.println(line); }
		    // line is not visible here.
		}
		catch(Exception e)
		{e.printStackTrace();}
	}

	public static void searchWord() throws FileNotFoundException
	{
		 String word = ""; int val = 0;
		    while(!word.matches("quit"))
		    {
		        System.out.println("Enter the word to be searched for");
		        Scanner input = new Scanner(System.in);
		        word = input.next();
		        Scanner file = new Scanner(new File("newFile.txt"));

		        while(file.hasNextLine())           
		        {
		            String line = file.nextLine();
		            if(line.indexOf(word) != -1)
		            {
		                System.out.println("Word EXISTS in the file");
		                val = 1;
		                break;
		            }
		            else
		            {
		                val = 0;
		                continue;
		            }
		        }
		        if(val == 0)
		        {
		            System.out.println("Word does not exist");
		        }
		        System.out.println("-------continue or quit--- enter continue or quit");
		        word = input.next();        
		    }   
	}

	public static void searchWordReturnFrequency()
	{
		String text = "Question : how to search for a particular word in a " +
		        "text file containing texts of words and return its " +
		        "frequency or occurrences ?";

		String word = "a";

		int totalCount = 0;
		int wordCount = 0;
		Scanner s = new Scanner(text);
		while (s.hasNext()) {
		    totalCount++;
		    if (s.next().equals(word)) wordCount++;
		}

		System.out.println("Word count:  " + wordCount);
		System.out.println("Total count: " + totalCount);
		System.out.printf("Frequency:   %.2f", (double) wordCount / totalCount);
	}


	public static void pattrenMatch()
	{
		String line = "001 John Smith";
		String regex = "(\\d)+ (\\w)+ (\\w)+";
		 
		 
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		while(matcher.find()){
		     
		    String [] group = matcher.group().split("\\s");
		    System.out.println("First Name "+group[1]);
		    System.out.println("Last Name " +group[2]);
		     
		}
	}//method
	
	
	public static void cleanupImages() {
        final String dir = "./ScreenShoot/";
        System.out.println("current dir = " + dir);

        String directory = dir ;//+ "/openwave-automation/screenshots/";

        // Let's start clean and delete old images
        File deleteImagesDirectory = new File(directory);
        deleteFilesInDirectory(deleteImagesDirectory);
    }

    public static void deleteFilesInDirectory(File dir) {
        if (dir.isDirectory()) {
            String[] _file = dir.list();
            for (int i = 0; i < _file.length; i++) {
                deleteFilesInDirectory(new File(dir, _file[i]));
            }
        } else { dir.delete();  }
    }
    
public static void ReaderItr() throws IOException {
	    
	    Pattern patt = Pattern.compile("[A-Za-z][a-z]+"); // The RE pattern
	    BufferedReader r = new BufferedReader(new FileReader("ReaderIter.java")); 
    
	    String line;
	    while ((line = r.readLine()) != null) {  // For each line of input, try matching in it.
         Matcher m = patt.matcher(line); // For each match in the line, extract and print it.
	      while (m.find()) {
	        // Simplest method:
	        // System.out.println(m.group(0));
       
	        int start = m.start(0);// Get the starting position of the text
	        int end = m.end(0);// Get ending position
	        // Print whatever matched.
	        // Use CharacterIterator.substring(offset, end);
	        System.out.println(line.substring(start, end));
	      }
	    }
	  }//end


public static String Token()
{
  Random rand = new Random();
  int num = rand.nextInt(10000000);
  return (""+num+"");
}

public static String GetNumber(int listSize)
{
	Random rand = new Random();
	int mynum = rand.nextInt(listSize);
   return (""+mynum+"");
}

//providing dynamic value to property file
public String GetEle(String propKey,String Dparam)
{
	 String pVal="";
	 try
	 {
		 Properties p = new Properties();
		 FileInputStream p1 = new FileInputStream(new File(""));
  	     p.load(p1);
  	     String OrigpropVal =  p.getProperty(propKey.trim());
  	     System.out.println(OrigpropVal);
  	     pVal = MessageFormat.format(OrigpropVal, Dparam);
  	     System.out.println(pVal);
   	     //Pval =p.getProperty(pKey);
		 
	 }
	 catch(Exception e) { e.printStackTrace(); }
	 return pVal;  
	   
}

/**
 * This does the equivalent of "rm -r" 
 * @param path Root File Path 
 * @return true if the file and all sub files/directories have been removed 
 * @throws FileNotFoundException 
 */ 
public static boolean deleteRecursive(File path) throws FileNotFoundException{ 
    if (!path.exists()) throw new FileNotFoundException(path.getAbsolutePath()); 
    boolean ret = true; 
    if (path.isDirectory()){ 
        for (File f : path.listFiles()){ 
            ret = ret && deleteRecursive(f); 
        } 
    } 
    return ret && path.delete(); 
} 



public void Runbat() throws IOException
{
	Runtime.getRuntime().exec("cmd /c start C:\\ADT-Bundle\\Start-Server.bat");	

}




	public static void WaitForPageLoad(WebDriver d,By by)
	{
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>( d )
                         .withTimeout(Duration.ofSeconds(40))
                         .pollingEvery(Duration.ofSeconds(5))
                         .ignoring( NoSuchElementException.class ) 
                         .ignoring( StaleElementReferenceException.class ) ;
        wait.until( ExpectedConditions.presenceOfElementLocated( by ));
			// By.cssSelector("body form#webDriverUnitiFrame1TestFormID h1") ) );
	}	
	
	public static void HighlightElement(WebDriver d,WebElement element)
	{
		   JavascriptExecutor js = (JavascriptExecutor)d;
		   String oldStyle = element.getAttribute("style");
		   String args = "arguments[0].setAttribute('style', arguments[1]);";
		   js.executeScript(args, element, "border: 4px solid yellow;display:block;");
		   //takeScreenshot(priority, element, d);
		   js.executeScript(args, element, oldStyle);
	}
	
	public static void elementHighlight(WebDriver d,WebElement element) 
	{
	  for (int i = 0; i < 2; i++) 
	  {
		JavascriptExecutor js = (JavascriptExecutor) d;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "color: red; border: 3px solid red;");
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);",element, "");
	  }
	}
	
	public static void flash(WebElement element, WebDriver driver) {
	     JavascriptExecutor js = ((JavascriptExecutor) driver);
	     String bgcolor  = element.getCssValue("backgroundColor");
	     for (int i = 0; i <  3; i++) {
	         changeColor("rgb(0,200,0)", element, js);
	         changeColor(bgcolor, element, js);
	     }
	 }
	 private static void changeColor(String color, WebElement element,  JavascriptExecutor js) {
	     js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

	     try {
	         Thread.sleep(120);
	     }  catch (InterruptedException e) {
	     }
	  }
	
	
	
	
	
//	public static void waitElementToShow(int tryTimes, int interval, String xpath)
//    {
//		List<WebElement> targetList = driver.findElements(By.xpath(xpath));
//		while(tryTimes-- > 0)
//		{
//			if(0 == targetList.size())
//			{
//				try{ TimeUnit.SECONDS.sleep(interval); 	}
//				catch(InterruptedException e) { e.printStackTrace(); }
//			}
//			else 
//			{ break; }
//			targetList = driver.findElements(By.xpath(xpath));
//		}
//		
//		try { TimeUnit.SECONDS.sleep(3); 	} 
//		catch (InterruptedException e) { e.printStackTrace(); }
//		if(0 != targetList.size()) 
//		{ 
//			System.out.println("[INFO] Find element");
//		}
//		else
//		{
//			System.out.println("[INFO] Can't find element");
//			throw new NoSuchElementException("Can't find element locate on " + xpath);
//		}
//		
//		
//	}
	
//	public static void adjustPage(WebElement target)
//	{
//		JavascriptExecutor executor = (JavascriptExecutor)driver;
//		executor.executeScript("arguments[0].scrollIntoView(true);", target);
//		try { TimeUnit.SECONDS.sleep(3); 	} 
//		catch (InterruptedException e) {e.printStackTrace(); }
//	}
//	
	public static void UserKeyInput(WebDriver driver,String str) throws InterruptedException
	{
		driver.findElement(By.id("keyword")).sendKeys(new  CharSequence[] {str});
		Thread.sleep(2000);		
		
	}
	
	// Another approach, after everything I have learned, that might also be effective. With this method, a wait timeout occurs 3
	// times within the 90 second limit. So, the method will run between 15-90 seconds, depending on the situation of failure.
	public static WebElement getElementByLocator( WebDriver driver,final By locator ) {
		     System.out.println( "Get element by locator: " + locator.toString() );
		     final long startTime = System.currentTimeMillis();
		     
		     Wait<WebDriver> wait = new FluentWait<WebDriver>( driver )
		                                .withTimeout(Duration.ofSeconds(30))
		                                .pollingEvery(Duration.ofSeconds(5))
		                                .ignoring( StaleElementReferenceException.class ) ;
		     int tries = 0;
		     boolean found = false;
		     WebElement we = null;
		      
		     while ( (System.currentTimeMillis() - startTime) < 91000 ) {
			          System.out.println( "Searching for element. Try number " + (tries++) );
		              try {
		                   we = wait.until( ExpectedConditions.presenceOfElementLocated( locator ) );
		                   found = true;
		                   break;
		                  } 
		              catch ( StaleElementReferenceException e ) {
			          System.out.println( "Stale element: \n" + e.getMessage() + "\n");
		              }
		     }
		     long endTime = System.currentTimeMillis();
		     long totalTime = endTime - startTime;
		     if ( found ) { System.out.println("Found element after waiting for " + totalTime + " milliseconds." ); } 
		     else { System.out.println( "Failed to find element after " + totalTime + " milliseconds." ); }
		     return we;
	}
	
	
	private boolean directoryExist(String dirPath)
	{
		boolean b=true; 
		try
		{
			   File f = new File(dirPath);
			   if (f.exists()==true && f.isDirectory()==true) 
			   { System.out.println("Directory Exists"); }
			   else
			   {
				   System.out.println("Directory not exists");
				   System.out.println("creating directory...");
				   f.mkdir();
				   if (f.isDirectory()==true){System.out.println("Directory on path: "+f.getAbsolutePath()+" created");}
			   }
		}
		catch(Exception e){
			e.printStackTrace();
			b=false;
		}
		return b;
	}
		
	public void getElementSnap(WebDriver d,WebElement ele, String filePath, String fname) throws IOException
	{
		if(directoryExist(filePath)==true) {
		    File screenshot = ((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		    BufferedImage  fullImg = ImageIO.read(screenshot);

		    Point point = ele.getLocation();
		    int eleWidth = ele.getSize().getWidth();
		    int eleHeight = ele.getSize().getHeight();
		       
		    System.out.println("x:"+point.getX()+" y:"+point.getY()+" ele width:"+eleWidth+" ele height:"+eleHeight);
		    BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), eleWidth-point.getX(), eleHeight-point.getY());
//		    BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(), point.getX(), point.getY());
		    ImageIO.write(eleScreenshot, "png", screenshot);
		       
		    //FileUtils.copyFile(screenshot, new File(filePath+"/"+fname+".png"));
		    FileUtils.copyFile(screenshot, new File(filePath+"/"+fname+".png"));
	    }
	}
	
	public void forceStopPageLoad(WebDriver driver)
	{
	    //for (int i = 0; i < 10; i++) {
	    try {
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	    	js.executeScript("window.stop();");
	    } catch (org.openqa.selenium.TimeoutException te) {}
	      catch (UnhandledAlertException uae) {   }
	    	 //}
	}
	
		//appiled on whole html page: WebElement html = driver.findElement(By.tagName("html"));
	public static void setZoomLevel(String zoomLevel,WebElement e)
	{
			HashMap<String,Integer> zoom = new HashMap<String,Integer>(); 
			zoom.put("90%",0);
			zoom.put("80%",1);
			zoom.put("67%",2);
			zoom.put("50%",3);
			zoom.put("30%",4);

		    if(zoomLevel=="90%"){
		    System.out.println("zoom set at: "+zoomLevel);
		     e.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));  
		    }
		    
		    if(zoomLevel=="80%"){
		        System.out.println("zoom set at: "+zoomLevel);
		        for(int i=0;i<2;i++) 
		        e.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));  
		       }
		    
		    if(zoomLevel=="67%"){
		        System.out.println("zoom set at: "+zoomLevel);
		        for(int i=0;i<3;i++) 
		        e.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));  
		       }
		    
		    if(zoomLevel=="50%"){
		        System.out.println("zoom set at: "+zoomLevel);
		        for(int i=0;i<4;i++) 
		        e.sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));  
		       }
		}
		
		
		private boolean isWebElementVisibleOnScreen(WebDriver driver,WebElement w) {
		    Dimension weD = w.getSize();
		    Point weP = w.getLocation();
		    Dimension d = driver.manage().window().getSize();

		    int x = d.getWidth();
		    int y = d.getHeight();
		    int x2 = weD.getWidth() + weP.getX();
		    int y2 = weD.getHeight() + weP.getY();

		    return x2 <= x && y2 <= y;
		  }
		
/**
 * @desc: If pop-up window doesn't have no name
 * @param driver
 * @param link
 * @return
 */
public String getPopupWindowHandle(WebDriver driver, WebElement link) {
		    
	Set<String> beforePopup = driver.getWindowHandles(); // get all the window handles before the popup window appears
	link.click(); // click the link which creates the popup window
	Set<String> afterPopup = driver.getWindowHandles();// get all the window handles after the popup window appears
	afterPopup.removeAll(beforePopup);  // remove all the handles from before the popup window appears
	if(afterPopup.size() == 1) // there should be only one window handle left
	{ return (String)afterPopup.toArray()[0]; }
 	  return null;
	}
		
public static void TakeScreenShot(WebDriver driver){
	try{
			  
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File scrnshot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnshot, new File("./logger/Failscreenshot/"+"_"+formater.format(calendar.getTime())+".png"));
	}catch(Exception e){ }
}
		
		public static void SendKeysByLabel(WebDriver driver, String fieldname, String fieldvalue)
		{
		 try
		 {
		   WebElement ele = driver.findElement(By.xpath("//label[contains(text(),'" + fieldname + "')]//following::input[1]"));
		   ele.sendKeys(fieldvalue);
		 }
		 catch(Exception e)	{  }
		}

		//overload
		public static void SendKeysByLabel(WebDriver d,int i, String fieldname, String fieldvalue)
		{
		 try
		 {
		   WebElement ele = d.findElement(By.xpath("//label[contains(text(),'" + fieldname + "')]//following::input["+i+"]"));
		   ele.sendKeys(fieldvalue);
		 }
		 catch(Exception e)	{  }
		}
		
		public static void ClickButtonByText(WebDriver driver, String text)
		{
		 try
		  {
		    WebElement ele = driver.findElement(By.xpath("//button[contains(text(),'"+text+"']"));
		    ele.click();
		  }
		 catch(Exception ex){ }
		}
		
		public static void SelectByLabel(WebDriver driver, String fieldname, String fieldvalue)
		{
		 try
		 {
			 WebElement selectElement = driver.findElement(By.xpath("//label[contains(text(),'" + fieldname + "')]//following::select[1]"));
			 selectElement.findElement(By.xpath("//option[contains(text(), '" + fieldvalue + "')]")).click();  
			 
		 }
		 catch(Exception e)	{  }
		}
		
		
/*============== WebDriver Utility =========================*/
}

package BaseMethods;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Utilities.ExtentReportManager;
import Utilities.ScreenshotUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseMethods {

    public WebDriver driver; // Accessible everywhere in this project

    public static ExtentReports extent;

    public static ExtentTest test;

    @BeforeSuite
    public void startReport() {

        extent = ExtentReportManager.getReportInstance();

        System.out.println("----------- Extent Report Started ----------");
    }

    
 // open browser
    
    @BeforeMethod
    @Parameters({"browser","Url","environment"})
    
    public void openApp(Method method,String browser,String Url,String environment) {

    	 test = extent.createTest(method.getName()); 
    	 System.out.println("Method Name : " + method.getName());
    	 
        if(browser.equalsIgnoreCase("Chrome")) {

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }
        else if(browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }
        else if(browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }

        driver.manage().window().maximize();

        driver.get(Url);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        test.info("Browser Launched");
        test.info("Application URL : " + Url);

        System.out.println("Browser Opened");
    }

    @AfterMethod
    public void closeApp(ITestResult result) {
    	 
        if(result.getStatus()==ITestResult.SUCCESS) {

            test.pass("Test Passed Successfully");

        }

        else if(result.getStatus()==ITestResult.FAILURE) {

            String path = ScreenshotUtil.captureScreenshot(driver, result.getName());

            test.fail(result.getThrowable());

            try {

                test.fail("Failure Screenshot",
                        MediaEntityBuilder.createScreenCaptureFromPath(path).build());

            } catch (Exception e) {

                e.printStackTrace();

            }

        }

        else {

            test.skip("Test Skipped");

        }

        driver.quit();

        System.out.println("--------------Browser Closed----------------");

    }
   
    @AfterSuite
    public void endReport() {

        extent.flush();

        System.out.println("------------- Extent Report Generated ----------");

    }

}
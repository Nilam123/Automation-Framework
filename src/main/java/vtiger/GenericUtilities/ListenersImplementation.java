package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class contains implementation of Listeners
 * @author Nilam
 *
 */
public class ListenersImplementation implements ITestListener {

	 ExtentReports report;
	 ExtentTest test;
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		Class<? extends ITestResult> clas = result.getClass();
		
		System.out.println("class name>>>>>>>>>>>>>>>>>>>>>>>>>>>"+clas);
		test=report.createTest(methodName);
		System.out.println("sample1()--------"+methodName);
		System.out.println("ListenersImplementationClass onTestStart-------"+methodName+ "------------Execution Started");

	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println("ListenersImplementationClass onTestSuccess-------"+methodName+ "----PASS");
		
		test.log(Status.PASS, methodName+"----PASS");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebDriverUtility wUtil=new WebDriverUtility();
        JavaUtility jUtil =new JavaUtility();
		String methodName = result.getMethod().getMethodName();
		String screenShotName = methodName+"-"+jUtil.getSystemDateInFormate();
		
		test.log(Status.FAIL, methodName+"----FAIL");
        test.log(Status.INFO, result.getThrowable());
		
		try {
			String path = wUtil.takeScreenShot(BaseClass.sDriver, screenShotName);

			System.out.println("onTestFailure>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("onTestFailure"+path );
			test.addScreenCaptureFromBase64String(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("IOException +onTestFailure>>>>>>>>>>>>>>>>>>>>>>");

			//System.out.println(e.printStackTrace());

		}
		System.out.println("ListenersImplementationClass onTestFailure-------"+methodName+ "----FAIL");

	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("ListenersImplementationClass-------"+methodName+ "----SKIPPED");
		
		test.log(Status.SKIP, methodName+"----SKIP");
		test.log(Status.INFO, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("\"ListenersImplementationClass------Suite execution started");
		ExtentSparkReporter htmlReport=new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormate()+".html");
		htmlReport.config().setDocumentTitle("Vtiger execution Reports");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("VTIGER EXECUTION REPORT");
		
		report=new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base URL", "https://localhost:8888");
		report.setSystemInfo("Browser","FireFox");
		report.setSystemInfo("Author","Nilam");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stu
		
		System.out.println("ListenersImplementationClass-------Suite execution finished");
		report.flush();

	}

}

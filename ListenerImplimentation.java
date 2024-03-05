package CommonUtils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplimentation implements ITestListener {
	ExtentReports report;

	public static void main(String[] args) {

	}

	@Override
	public void onTestStart(ITestResult result) {
		
		String methodName= result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution start", true);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName= result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is pass", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		
		String message= result.getThrowable().toString();
		String methodName= result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is fail"+message, true);

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		String methodName= result.getMethod().getMethodName();
		Reporter.log(methodName+"Testscript execution is skip", true);

	}

	@Override
	public void onStart(ITestContext context) {
		
	//	String methodName= result.getMethod().getMethodName();
		Reporter.log(" execution start", true);
		
		JavaUtil jutil= new JavaUtil();
		// use Extentreporter class just to configure extent report
		ExtentSparkReporter reporter= new ExtentSparkReporter ("./extentreport/report"+jutil.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vtigercrm");
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setReportName("Pune");
		
		//use ExtentReport class to generate extentreport
		 report= new ExtentReports();
		
		//this method is use to attache the configuration mentione above to your extent reports.
		report.attachReporter(reporter);
		report.setSystemInfo("OS","Windows");
		report.setSystemInfo("Browser","Chrome");
		report.setSystemInfo("Browser version","122");
		report.setSystemInfo("Auther","Vaishnavi");
	}
	

	@Override
	public void onFinish(ITestContext context) {
		
	//	String methodName= result.getMethod().getMethodName();
	//	Reporter.log(" execution finish", true);
		report.flush();
		
		
	}

	}



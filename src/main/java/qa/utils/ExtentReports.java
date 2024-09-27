package qa.utils;

import java.io.File;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReports {

	public static void generateExtentReport() {
		
		ExtentReports extentReport = new ExtentReports();
		//*****2)https://extentreports.com/->DOCS->Version5->Java->gettingStarted->Reporters(these are diff type of report we use sparkrepoter)->copy code of ExtentSparkReporter->to add theam,Report name,doc name,date
				File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");//ye path likha hi folder banjayega wahape
				ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);//give path of report
		//*****3)config->set configration->like Theme, ReportName,DocumentTitle,Timestamp,ApplicationURL,BrowserName,OS,userName,javaVersion,Email Address,Password
				sparkReporter.config().setTheme(Theme.DARK);
				sparkReporter.config().setReportName("TutorialNinja Test Automation Results");
				sparkReporter.config().setDocumentTitle("TN Automation Report");
				sparkReporter.config().setTimeStampFormat("dd/MM/yyyy  hh:mm:ss");
				
				
				
	}
}

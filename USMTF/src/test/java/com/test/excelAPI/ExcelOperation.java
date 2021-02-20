package com.test.excelAPI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.net.Inet4Address;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import com.test.testData.LoginTestData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.test.controller.FlowMethods;
import com.test.controller.Runner;
import com.test.testData.ApplicationAdministrativeToolData;
import com.test.testData.DevelopInterfaceChangeProposalData;
import com.test.testData.EditViewExistingInterfaceChangeData;
import com.test.utils.Constant;
import com.test.utils.ModuleTestData;




public class ExcelOperation {

	public static Connection connection = null;
	public static Recordset recordset = null;
	public static String noOfThreds;
	public static String country;
	public static String modules;
	public static String sleepTimeout;
	public static String loadingTimeout;
	public static String globalMaxTimeout;
	public static String listOfFailedMethods;
	public static String bulkImportPaymentsStatus="";
	public static String testSuiteJourneyID;
	public  static String testSuiteModuleName="";
	public  static String testSuiteReportingModuleName="";
	public  static String testSuiteSubModuleName="";
	public  String testSuiteJourneyFlowID;
	public static String previousJourneyID="";
	public static String previousBrowserType="";
	public static List<String> passedJourneysList = new ArrayList<String>();
	public static List<String> executedJourneys = new ArrayList<String>();
	public static List<String> failedJourneys = new ArrayList<String>();
	public static List<String> failedJourneyswithTimeStamp = new ArrayList<String>();
	public static List<String> skippedJourneys = new ArrayList<String>();
	public static List<String> somethingWentWrongJourneys = new ArrayList<String>();
	public static List<String> correlationsList = new ArrayList<String>();
	public static List<String> moduleList_Reporting = new ArrayList<String>();
	public static HashMap<String,String> journey_LinkRef = null;
	public static String executionStartTime = "";
	public static String executionEndTime = "";
	public static String userNameDetails = "";
	public static String exceptionCaptured = "";
	public static String almCaseName = "";
	public static String developer = "";
	public static String owner = "";
	public static String testDataClassName = "";
	public static Boolean testEligibleToSkip = false;

	public static List<String> exclusivejourneys = new ArrayList<String>();

	public static Fillo fillo = new Fillo();
	public static Properties Config = new Properties();;
	static Logger log = LogManager.getLogger(ExcelOperation.class);
	public static String vascoStatus="";
	public static String subModuleName="";
	

	public static void readExecutionVariables(int currentIteration) {

		Connection	executionvariablesConnection = null;
		Recordset executionvariablesRecordset = null;
		
		try 
		{
			String completeIpAddress = Inet4Address.getLocalHost().getHostAddress();
			String[] ipAddress = completeIpAddress.split("\\.");
			String machine = ipAddress[ipAddress.length-1];
			
			if(Constant.Path_TestData.isEmpty())
			{
				FileInputStream fileInputStream = new FileInputStream("./Config.properties");
				Config.load(fileInputStream);
				Constant.Path_TestData=Config.getProperty("Path_TestData").replace("':'", ":");
			}
			
			executionvariablesConnection = fillo.getConnection(Constant.Path_TestData);
			String strQuery = "Select * from Settings";
			executionvariablesRecordset = executionvariablesConnection.executeQuery(strQuery);
			while (executionvariablesRecordset.next()) 
			{
				Constant.environment = (executionvariablesRecordset.getField("Environment"));
				Constant.URL = (executionvariablesRecordset.getField("ApplicationURL"));
				country = (executionvariablesRecordset.getField("Country"));
				modules = (executionvariablesRecordset.getField("Modules"));
				Constant.screenshot_path = (executionvariablesRecordset.getField("PathOfScreenshot"));
				//Constant.screenshot_path = System.getProperty("user.dir")+"//src//test//resources//reportsScreenshots//";
				Constant.driverPath_chrome = (executionvariablesRecordset.getField("DriverPath_chrome"));
				//Constant.driverPath_chrome = System.getProperty("user.dir")+"//lib//chromedriver.exe";
				Constant.download_dir = (executionvariablesRecordset.getField("Download_dir"));
				globalMaxTimeout = (executionvariablesRecordset.getField("GLOBAL_MAX_TIMEOUT"));
				sleepTimeout = (executionvariablesRecordset.getField("SLEEP"));
				loadingTimeout = (executionvariablesRecordset.getField("LOADING_TIMEOUT"));
			    Constant.pathOfReport = (executionvariablesRecordset.getField("PathOfReport"));
				//Constant.pathOfReport = System.getProperty("user.dir")+"//src//test//resources//reports//";
				Constant.extentReportConfigFile = (executionvariablesRecordset.getField("ExtentReportConfigFile"));
				Constant.GLOBAL_MAX_TIMEOUT=Integer.parseInt(globalMaxTimeout);
				Constant.SLEEP=Integer.parseInt(sleepTimeout);
				Constant.LOADING_TIMEOUT=Integer.parseInt(loadingTimeout);
				Constant.reRun=Integer.parseInt((executionvariablesRecordset.getField("RERUN")));
				log.info("Initialize Extent Report");

				if(currentIteration==0)
				{
					//Create Folder Structure for current execution - Relative Screen prints
					String currentTimeStamp = getCurrentTimeStamp();
					String correspondingMachineName = currentTimeStamp;					
					correspondingMachineName = correspondingMachineName + "-" + machine;
					Constant.pathOfFailedCasesScreePrints = Constant.pathOfReport + correspondingMachineName + "\\" + "ScreenshotsFailed" + "_Run_" + String.valueOf(currentIteration);
					Constant.pathOfPassedCasesScreePrints = Constant.pathOfReport + correspondingMachineName + "\\" + "ScreenshotsPassed" + "_Run_" + String.valueOf(currentIteration);
					Constant.packagePath = Constant.pathOfReport + correspondingMachineName + "\\";
					new File(Constant.pathOfFailedCasesScreePrints).mkdirs();
					new File(Constant.pathOfPassedCasesScreePrints).mkdirs();
					Constant.reportPath = Constant.pathOfReport + correspondingMachineName + "\\" +("Report_" + currentTimeStamp + "_Run_" + String.valueOf(currentIteration) + ".html");
					Constant.pathOfFailedCasesScreePrints = Constant.pathOfFailedCasesScreePrints + "\\";
					Constant.pathOfPassedCasesScreePrints = Constant.pathOfPassedCasesScreePrints +"\\";
				}
				else
				{
					log.info(Constant.reportPath.replace("_Run_" + (currentIteration-1), "_Run_" + currentIteration));
					Constant.reportPath = Constant.reportPath.replace("_Run_" + (currentIteration-1), "_Run_" + currentIteration);
					Constant.pathOfFailedCasesScreePrints = Constant.pathOfFailedCasesScreePrints.replace("_Run_" + (currentIteration-1), "_Run_" + currentIteration);
					Constant.pathOfPassedCasesScreePrints = Constant.pathOfPassedCasesScreePrints.replace("_Run_" + (currentIteration-1), "_Run_" + currentIteration);
					new File(Constant.pathOfFailedCasesScreePrints).mkdirs();
					new File(Constant.pathOfPassedCasesScreePrints).mkdirs();
				}

				Constant.extentReporter = new ExtentReports(Constant.reportPath, true,DisplayOrder.OLDEST_FIRST );
				Constant.extentReporter.addSystemInfo("Environment", Constant.environment);
				Constant.extentReporter.addSystemInfo("ApplicationURL", Constant.URL);
				Constant.extentReporter.addSystemInfo("Test Data","<a href="+Constant.Path_TestData+"><span class='label info'>Test Data</span></a>" );
				Constant.extentReporter.addSystemInfo("Country", country);
				Constant.extentReporter.addSystemInfo("Browser", Constant.browser);
				Constant.extentReporter.addSystemInfo("Global Max Timeout", Constant.GLOBAL_MAX_TIMEOUT +" sec");
				Constant.extentReporter.addSystemInfo("Loading Timeout", Constant.LOADING_TIMEOUT +" sec");
				Constant.extentReporter.addSystemInfo("Sleep Timeout", Constant.SLEEP +" sec");
				Constant.extentReporter.loadConfig(new File(Constant.extentReportConfigFile));
			}
		} catch (Exception e) {
			log.error("Failed to execute step", e);
		} finally {
			if(executionvariablesConnection!=null) {
				executionvariablesConnection.close();
			} else{
				log.error("Unable to create connection with Test Data sheet.");
			}
			if(executionvariablesRecordset!=null){
				executionvariablesRecordset.close();
			}
		}
	}


	public  void readTestSuite() 
	{		
		String testcaseDescription = null;		
		try {
			testSuiteJourneyID = "";
			testSuiteModuleName="";
			testSuiteSubModuleName="";
			testSuiteJourneyFlowID="";
			ArrayList<String> journeysList = new ArrayList<String>();

			//Dummy conditional block - Just To restrict connection object scope
			if(true)
			{
				Connection readTestSuiteConnection = null;
				Recordset readTestSuiteRecordset = null;
				//To define the scope of Connection and Record Set objects
				readTestSuiteConnection = fillo.getConnection(Constant.Path_TestData);
				log.info("connection to test data established");
				String strQuery = "Select * from TestSuite where Execution_Status='Yes'";
				log.info("Test Suite Query =" + strQuery);
				readTestSuiteRecordset = readTestSuiteConnection.executeQuery(strQuery);

				//Fetch List of "Yes" Marked Cases from excel
				while (readTestSuiteRecordset.next()) 
				{
					journeysList.add(readTestSuiteRecordset.getField("Journey_ID") + "~" + readTestSuiteRecordset.getField("Module_Name") + "~" + readTestSuiteRecordset.getField("FlowMethods"));
				}
				
				readTestSuiteConnection.close();
				readTestSuiteRecordset.close();	
			}

			ListIterator<String> valuesIterator = journeysList.listIterator(); 

			while(valuesIterator.hasNext()) 
			{
				String value=valuesIterator.next();
				String[] journeysArray = value.split("~");

				log.info("*****************************Start of Tessuite =  "+ testSuiteJourneyID +"*****************************");				
				testSuiteJourneyID = journeysArray[0];
				testSuiteModuleName = journeysArray[1];
				//testSuiteSubModuleName = journeysArray[2];
				testSuiteJourneyFlowID = journeysArray[2];

				if(testSuiteModuleName.equalsIgnoreCase("Login")) {
					populateLoginModuleTestData(testSuiteModuleName, testSuiteJourneyID);
					testcaseDescription = ModuleTestData.TEST_DESCRIPTION;

				}
				else if(testSuiteModuleName.equalsIgnoreCase("DevelopInterfaceChangeProposal")) {
					populateDevelopInterfaceChangeProposalTestData(testSuiteModuleName, testSuiteJourneyID);
					testcaseDescription = ModuleTestData.TEST_DESCRIPTION;
                    LoginTestData.LOGIN_DETAILS=DevelopInterfaceChangeProposalData.LOGIN_DETAILS;
				}
				
				else if(testSuiteModuleName.equalsIgnoreCase("ApplicationAdministrativeTool")) {
					populateApplicationAdministrativeToolData(testSuiteModuleName, testSuiteJourneyID);
					testcaseDescription = ModuleTestData.TEST_DESCRIPTION;
                    LoginTestData.LOGIN_DETAILS=ApplicationAdministrativeToolData.LOGIN_DETAILS;
				}
				
				else if(testSuiteModuleName.equalsIgnoreCase("EditViewExistingInterfaceChange")) {
					populateEditViewExistingInterfaceChangeData(testSuiteModuleName, testSuiteJourneyID);
					testcaseDescription = ModuleTestData.TEST_DESCRIPTION;
                    LoginTestData.LOGIN_DETAILS=EditViewExistingInterfaceChangeData.LOGIN_DETAILS;
				}
				
				
				
				Constant.extentTest = Constant.extentReporter.startTest(testSuiteJourneyID, testcaseDescription);  
				Constant.extentTest.assignAuthor(System.getProperty("user.name"));				
				if(testSuiteSubModuleName.equalsIgnoreCase(testSuiteModuleName))
					Constant.extentTest.assignCategory(testSuiteModuleName);
				else 
				{
					Constant.extentTest.assignCategory(testSuiteSubModuleName+" ["+testSuiteModuleName+"]");
				}
				executeFlowMethods(testSuiteModuleName, testSuiteJourneyFlowID);
				Constant.extentReporter.endTest(Constant.extentTest);

				log.info("*****************************End of Tessuite =  " +testSuiteJourneyID+Constant.browser+ "*****************************");
			}
			//clearTestDataFromVariables();

		} 
		catch (Exception e) 
		{
			log.error("Failed to execute step", e);
		} 
	}

	public void updateReferencevalue(String moduleName, String referenceValue, String linkRef) {

		Connection	updateReferencevalueConnection = null;
		try {
			updateReferencevalueConnection = fillo.getConnection(Constant.Path_TestData);
			String strQuery = "Update "+moduleName+" Set indicatorName='"+referenceValue+"'where LINK_REF='"+linkRef+"'";
			updateReferencevalueConnection.executeUpdate(strQuery);
			log.info("Test data Sheet updated for LINK_REF=" +linkRef + "& with REFERENCE_VALUE =" +referenceValue);
		} catch (Exception e) {
			log.error("Failed to execute step", e);
		}  finally {
			if(updateReferencevalueConnection!=null) {
				updateReferencevalueConnection.close();
			}
		}
	}

	public void populateLoginModuleTestData(String ModuleName, String JourneyID) {

		Connection moduleTestDataConnection = null;
		Recordset moduleTestDataRecordset = null;
		try {
			moduleTestDataConnection = fillo.getConnection(Constant.Path_TestData);
			String strQuery = "Select * from "+ ModuleName +" where Journey_ID='"+JourneyID+"'";
			moduleTestDataRecordset = moduleTestDataConnection.executeQuery(strQuery);
			while (moduleTestDataRecordset.next()) {
				LoginTestData.JOURNEY_ID = (moduleTestDataRecordset.getField("Journey_ID"));
				LoginTestData.LOGIN_DETAILS = (moduleTestDataRecordset.getField("LoginDetails"));
				LoginTestData.TEST_DESCRIPTION = (moduleTestDataRecordset.getField("TEST_CASE_DESCRIPTION"));
				LoginTestData.USERNAME = (moduleTestDataRecordset.getField("UserName"));
				LoginTestData.PASSWORD = (moduleTestDataRecordset.getField("Password"));
				
			}
		}catch (Exception e) {
			log.error("Failed to execute step", e);
		} finally {
			if(moduleTestDataConnection!=null) {
				moduleTestDataConnection.close();
			} else {
				log.error("Unable to create connection with Test Data sheet.");
			}
			if(moduleTestDataRecordset!=null){
				moduleTestDataRecordset.close();
			}
		}
	}
	
	
	public void populateDevelopInterfaceChangeProposalTestData(String ModuleName, String JourneyID) {

		Connection moduleTestDataConnection = null;
		Recordset moduleTestDataRecordset = null;
		try {
			moduleTestDataConnection = fillo.getConnection(Constant.Path_TestData);
			String strQuery = "Select * from "+ ModuleName +" where Journey_ID='"+JourneyID+"'";
			moduleTestDataRecordset = moduleTestDataConnection.executeQuery(strQuery);
			while (moduleTestDataRecordset.next()) {
				DevelopInterfaceChangeProposalData.JOURNEY_ID = (moduleTestDataRecordset.getField("Journey_ID"));
				DevelopInterfaceChangeProposalData.LOGIN_DETAILS = (moduleTestDataRecordset.getField("LoginDetails"));
				DevelopInterfaceChangeProposalData.TEST_DESCRIPTION = (moduleTestDataRecordset.getField("TEST_CASE_DESCRIPTION"));
				DevelopInterfaceChangeProposalData.SEARCHSET= (moduleTestDataRecordset.getField("SearchSet"));
				DevelopInterfaceChangeProposalData.ICPTITLE= (moduleTestDataRecordset.getField("ICPTitle"));
				DevelopInterfaceChangeProposalData.AGENCY= (moduleTestDataRecordset.getField("Agency"));
				DevelopInterfaceChangeProposalData.MINOCC=(moduleTestDataRecordset.getField("MinOcc"));
				DevelopInterfaceChangeProposalData.MAXOCC=(moduleTestDataRecordset.getField("MaxOcc"));
				
				//InfoAboutYouTestData.ACTION = (moduleTestDataRecordset.getField("Action"));
			}
		}catch (Exception e) {
			log.error("Failed to execute step", e);
		} finally {
			if(moduleTestDataConnection!=null) {
				moduleTestDataConnection.close();
			} else {
				log.error("Unable to create connection with Test Data sheet.");
			}
			if(moduleTestDataRecordset!=null){
				moduleTestDataRecordset.close();
			}
		}
	}
	
	public void populateApplicationAdministrativeToolData(String ModuleName, String JourneyID) {

		Connection moduleTestDataConnection = null;
		Recordset moduleTestDataRecordset = null;
		try {
			moduleTestDataConnection = fillo.getConnection(Constant.Path_TestData);
			String strQuery = "Select * from "+ ModuleName +" where Journey_ID='"+JourneyID+"'";
			moduleTestDataRecordset = moduleTestDataConnection.executeQuery(strQuery);
			while (moduleTestDataRecordset.next()) {
				ApplicationAdministrativeToolData.JOURNEY_ID = (moduleTestDataRecordset.getField("Journey_ID"));
				ApplicationAdministrativeToolData.LOGIN_DETAILS = (moduleTestDataRecordset.getField("LoginDetails"));
				ApplicationAdministrativeToolData.TEST_DESCRIPTION = (moduleTestDataRecordset.getField("TEST_CASE_DESCRIPTION"));
				ApplicationAdministrativeToolData.GENERATESCHEMASMASSAGE = (moduleTestDataRecordset.getField("GenerateSchemasMassage"));

			}
		}catch (Exception e) {
			log.error("Failed to execute step", e);
		} finally {
			if(moduleTestDataConnection!=null) {
				moduleTestDataConnection.close();
			} else {
				log.error("Unable to create connection with Test Data sheet.");
			}
			if(moduleTestDataRecordset!=null){
				moduleTestDataRecordset.close();
			}
		}
	}
	
	public void populateEditViewExistingInterfaceChangeData(String ModuleName, String JourneyID) {

		Connection moduleTestDataConnection = null;
		Recordset moduleTestDataRecordset = null;
		try {
			moduleTestDataConnection = fillo.getConnection(Constant.Path_TestData);
			String strQuery = "Select * from "+ ModuleName +" where Journey_ID='"+JourneyID+"'";
			moduleTestDataRecordset = moduleTestDataConnection.executeQuery(strQuery);
			while (moduleTestDataRecordset.next()) {
				EditViewExistingInterfaceChangeData.JOURNEY_ID = (moduleTestDataRecordset.getField("Journey_ID"));
				EditViewExistingInterfaceChangeData.LOGIN_DETAILS = (moduleTestDataRecordset.getField("LoginDetails"));
				EditViewExistingInterfaceChangeData.TEST_DESCRIPTION = (moduleTestDataRecordset.getField("TEST_CASE_DESCRIPTION"));
				EditViewExistingInterfaceChangeData.SEARCHALL = (moduleTestDataRecordset.getField("SearchAll"));
				EditViewExistingInterfaceChangeData.FACETPATTERN = (moduleTestDataRecordset.getField("FacetPattern"));

			}
		}catch (Exception e) {
			log.error("Failed to execute step", e);
		} finally {
			if(moduleTestDataConnection!=null) {
				moduleTestDataConnection.close();
			} else {
				log.error("Unable to create connection with Test Data sheet.");
			}
			if(moduleTestDataRecordset!=null){
				moduleTestDataRecordset.close();
			}
		}
	}
		
	
	
	
	
	
	
	
	
	

	public void executeFlowMethods(String testSuiteModuleName, String testSuiteJourneyFlowID) {
		try {
			testEligibleToSkip = false;
			String[] flowMethodDetails = testSuiteJourneyFlowID.split(",");
			for(int flowIndex=0; flowIndex<flowMethodDetails.length;flowIndex++) {
				if(!testEligibleToSkip)
				{
					String[] flowMetodsWithFlags = flowMethodDetails[flowIndex].split("\\|\\|");
					log.info("flowID= " + flowMetodsWithFlags[0]);

					if(flowIndex>0 && FlowMethods.driver==null)
						break;
					Runner.execute_Actions(flowMetodsWithFlags[0], testSuiteModuleName);
				}
			}
		} catch (Exception e) {
			log.error("Failed to execute step", e);
		}
	}

	public static String getCurrentTimeStamp() 
	{
		String currentTime = "";
		try
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MMMM-dd-HH-mm-a");
			Date date = new Date();
			currentTime = dateFormat.format(date);			
		}
		catch (Exception e) 
		{
			System.out.println("Error Occured whhile Fetchiing Time Stamp");
		}		
		return currentTime;
	}
	
		
	public static String fetchElementFromRecordSet(Recordset executionvariablesRecordset, String columnName)
	{
		String currentColumnValue = "";
		try
		{
			currentColumnValue = executionvariablesRecordset.getField(columnName);
		}
		catch(Exception e)
		{
			log.error("Column Missing in Excel : " + columnName, e);
		}	
		return currentColumnValue;
	}

    
}




	
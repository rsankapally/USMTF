package com.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.test.controller.ActionMethods;
import com.test.controller.FlowMethods;
import com.test.controller.Report;
import com.test.excelAPI.ExcelOperation;
import com.test.testData.ApplicationAdministrativeToolData;
import com.test.testData.DevelopInterfaceChangeProposalData;

import com.test.utils.Constant;

public class ApplicationAdministrativeTools extends FlowMethods {

	Logger log = LogManager.getLogger(ActionMethods.class);
	ActionMethods actionMethods = new ActionMethods();
	ExcelOperation excelOperation = new ExcelOperation();

	public void nagivateToApplicationAdministrativeToolslLink() throws Exception {

		String locator,status="";
		try {
			
			//locator = objectRepo.getProperty("ApplicationAdministrativeTools.link");
			//actionMethods.scrollToElement(locator);
			Thread.sleep(5000);	
			locator = objectRepo.getProperty("ApplicationAdministrativeTools.link");
			actionMethods.click(locator);
			Thread.sleep(5000);	
			
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
					Constant.statusFlag + status, driver);
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag, driver);
			throw e;
		}
	}
	
	public void nagivateToBaseLineSetVersionslLink() throws Exception {

		String locator,status="";
		try {
			locator = objectRepo.getProperty("ApplicationAdministrativeTools.Baseline");
			actionMethods.click(locator);
			Thread.sleep(5000);
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
					Constant.statusFlag + status, driver);
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag, driver);
			throw e;
		}
	}
	
	public void selectBaselineApproveICPs() throws Exception {

		String locator,status="";
		try {
			locator = objectRepo.getProperty("ApplicationAdministrativeTools.BaselineApproveIcps");
			actionMethods.click(locator);
			Thread.sleep(5000);
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
					Constant.statusFlag + status, driver);
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag, driver);
			throw e;
		}
	}
	
	public void verifyBaselineApproveICPsLogs() throws Exception {

		String locator,status="";
		try {
			locator = objectRepo.getProperty("ApplicationAdministrativeTools.BaselineLogInfo");
			actionMethods.isElementPresent(locator);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.BackMainPage");
			actionMethods.click(locator);
			
			Thread.sleep(5000);
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
					Constant.statusFlag + status, driver);
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag, driver);
			throw e;
		}
	}
	
	public void generateSchemas() throws Exception {
		
		String locator, status = "";
		try {
			locator = objectRepo.getProperty("ApplicationAdministrativeTools.GenerateSehemas");
			actionMethods.click(locator);
			Thread.sleep(2000);
			locator = objectRepo.getProperty("ApplicationAdministrativeTools.GenerateSehemasDropdown");
			actionMethods.click(locator);
			Thread.sleep(2000);
			locator = objectRepo.getProperty("ApplicationAdministrativeTools.GenerateSehemasDropdown1");
			actionMethods.selectDropDownData(locator, ApplicationAdministrativeToolData.GENERATESCHEMASMASSAGE);
			
			//locator = objectRepo.getProperty("ApplicationAdministrativeTools.SehemasMassege_select");
			//actionMethods.click(locator);
			locator = objectRepo.getProperty("ApplicationAdministrativeTools.GenerateSehemasDownload");
			actionMethods.click(locator);			
			Thread.sleep(2000);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.BackMainPage");
			actionMethods.click(locator);	
			
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
			Constant.statusFlag + status, driver);
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag, driver);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

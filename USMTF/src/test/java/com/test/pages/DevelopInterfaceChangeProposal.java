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
import com.test.testData.DevelopInterfaceChangeProposalData;

import com.test.utils.Constant;

public class DevelopInterfaceChangeProposal extends FlowMethods {

	Logger log = LogManager.getLogger(ActionMethods.class);
	ActionMethods actionMethods = new ActionMethods();
	ExcelOperation excelOperation = new ExcelOperation();

	public void nagivateToDevelopInterfaceChangeProposalLink() throws Exception {

		String locator,status="";
		try {
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.DevelopInterfaceChangeProposal.Link");
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
	
	public void nagivateToModifyExistingFormatLinkLink() throws Exception {

		String locator,status="";
		try {
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.ModifyExistingFormatLink");
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
	
	
	public void selectSearchSetFromTable() throws Exception {

		String locator,status="";
		try {
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.DevelopInterfaceChangeProposal.Link");
			actionMethods.click(locator);
			Thread.sleep(5000);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.ModifyExistingFormatLink");
			actionMethods.click(locator);
			Thread.sleep(5000);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.SearchSetsLink");									
			actionMethods.click(locator);
			Thread.sleep(5000);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.SearchSetsInput");
			actionMethods.enterInputMandatoryFiled(locator, DevelopInterfaceChangeProposalData.SEARCHSET);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.SearchSetsSubmitbutton");
			actionMethods.click(locator);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.ShortNameClick");
			actionMethods.click(locator);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.DevelopICPButton");
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
	
	
	public void searchMessagesFromTable() throws Exception {

		String locator,status="";
		try {
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.DevelopInterfaceChangeProposal.Link");
			actionMethods.click(locator);
			Thread.sleep(5000);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.ModifyExistingFormatLink");
			actionMethods.click(locator);
			Thread.sleep(5000);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.SearchMessagesLink");									
			actionMethods.click(locator);
			Thread.sleep(5000);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.SearchSetsInput");
			actionMethods.enterInputMandatoryFiled(locator, DevelopInterfaceChangeProposalData.SEARCHSET);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.SearchSetsSubmitbutton");
			actionMethods.click(locator);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.ShortNameClickSearchMessage");
			actionMethods.click(locator);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.DevelopICPButton");
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void insertICPNumber() throws Exception {

		String locator,status="";
		try {
			
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.ICPTitle");
			actionMethods.isElementPresent(locator);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.AgencyTitle");
			actionMethods.isElementPresent(locator);	
			Thread.sleep(2000);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.ICPTitleInput");
			actionMethods.enterInputMandatoryFiled(locator, DevelopInterfaceChangeProposalData.ICPTITLE);	
			
			//locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.AgencyDropdown");
			//actionMethods.selectDropDownData(locator, DevelopInterfaceChangeProposalData.AGENCY);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.AgencyDropdown");
			actionMethods.click(locator);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.AgencyDropdown_select");
			actionMethods.click(locator.replace("DUMMY", DevelopInterfaceChangeProposalData.AGENCY));
			
				
			actionMethods.selectDropDown(locator, DevelopInterfaceChangeProposalData.AGENCY.trim());
			
			
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.ICPsubmit");
			actionMethods.click(locator);												
					
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
					Constant.statusFlag + status, driver);
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag+e.getMessage(), driver);
			throw e;
		}
	}
		
	public void editSetStructure() throws Exception {

		String locator,status="";
		try {
			
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.Set");
			actionMethods.mouseHoverAction(locator);
			
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.EditSetStructure");
			actionMethods.click(locator);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.DataEntryButton");
			actionMethods.click(locator);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.MinOcc");
			actionMethods.scrollToElement(locator);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.MinOcc");
			actionMethods.enterInputMandatoryFiled(locator, DevelopInterfaceChangeProposalData.MINOCC);	
			
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.MaxOcc");
			actionMethods.enterInputMandatoryFiled(locator, DevelopInterfaceChangeProposalData.MAXOCC);	
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.OccSave");
			actionMethods.click(locator);
			
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.NavigateManu");
			actionMethods.mouseHoverAction(locator);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.NavigateSetView");
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
	
	
	public void selectNavigateManueForEditSetStructureApprovalStatus() throws Exception {

		String locator,status="";
		try {						
			
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.NavigateManu");
			actionMethods.mouseHoverAction(locator);
			
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.NavigateICPList");
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
	
	public void selectEditSetStructureApprovalStatus() throws Exception {

		String locator,status="";
		try {								
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.SelectDraft");
			actionMethods.click(locator);	
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.OptionApprove");
			actionMethods.click(locator);	
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.OkButton");
			actionMethods.click(locator);
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

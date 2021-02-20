package com.test.pages;

import java.util.Hashtable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.test.controller.ActionMethods;
import com.test.controller.FlowMethods;
import com.test.controller.Report;
import com.test.excelAPI.ExcelOperation;
import com.test.testData.DevelopInterfaceChangeProposalData;
import com.test.testData.EditViewExistingInterfaceChangeData;
import com.test.utils.Constant;

import junit.framework.Assert;

public class EditViewExistingInterfaceChangeProposal extends FlowMethods {

	Logger log = LogManager.getLogger(ActionMethods.class);
	ActionMethods actionMethods = new ActionMethods();
	ExcelOperation excelOperation = new ExcelOperation();

	public void nagivateToExistingInterfaceChangeProposalslLink() throws Exception {

		String locator, status = "";
		try {
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.link");
			actionMethods.click(locator);
			Thread.sleep(5000);
			Report.getInstance().generateReport(
					Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
					Constant.statusFlag + status, driver);
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag, driver);
			throw e;
		}
	}

	public void verifyTheTextIncorporated() throws Exception {

		String locator, status = "";
		try {
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.TextVerify");
			actionMethods.isElementPresent(locator);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.BackMainPage");
			actionMethods.click(locator);

			Report.getInstance().generateReport(
					Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
					Constant.statusFlag + status, driver);
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag, driver);
			throw e;
		}
	}

	public void nagivateEditField() throws Exception {

		String locator, status = "";
		try {
			
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.link");
			
			if(actionMethods.isElementPresentOptional(locator)) {
				actionMethods.click(locator);
			}else {
				locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.BackMainPage");
				actionMethods.click(locator);
				Thread.sleep(2000);
				locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.link");
				actionMethods.click(locator);
			}
			
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.SearchAll");
			actionMethods.click(locator);
			// Thread.sleep(5000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.SearchAll");
			actionMethods.enterInputMandatoryFiled(locator, EditViewExistingInterfaceChangeData.SEARCHALL);
			Thread.sleep(5000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.SearchAll");
			actionMethods.press_enterInputMandatoryFiled(locator);
			// Thread.sleep(5000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.NumberDescription");
			actionMethods.click(locator);

			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.Rptid");
			actionMethods.click(locator);

			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.REPORTTITLE");
			actionMethods.click(locator);

			Thread.sleep(5000);

			Report.getInstance().generateReport(
					Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
					Constant.statusFlag + status, driver);
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag, driver);
			throw e;
		}
	}
	

	public void nagivateEditFieldMeaasgeSearch() throws Exception {

		String locator, status = "";
		try {
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.link");
			actionMethods.click(locator);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.SearchAll");
			actionMethods.click(locator);
			// Thread.sleep(5000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.SearchAll");
			actionMethods.enterInputMandatoryFiled(locator, EditViewExistingInterfaceChangeData.SEARCHALL);
			Thread.sleep(5000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.SearchAll");
			actionMethods.press_enterInputMandatoryFiled(locator);
			// Thread.sleep(5000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.NumberDescription");
			actionMethods.click(locator);

			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.ViewMassegeAxer");
			actionMethods.click(locator);
			
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.ViewSetLink");
			actionMethods.click(locator);
			
			Report.getInstance().generateReport(
					Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
					Constant.statusFlag + status, driver);
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag, driver);
			throw e;
		}
	}

	
	public void verifyErrorMessegeHasGenerate() throws Exception {

		String locator, status = "";
		try {
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.FacetPatternTextBox");
			actionMethods.scrollToElement(locator);
			Thread.sleep(10000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.FacetPatternTextBox");
			actionMethods.click(locator);
			Thread.sleep(2000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.FacetPatternTextBox");
			actionMethods.enterInputMandatoryFiled(locator, EditViewExistingInterfaceChangeData.FACETPATTERN);
			Thread.sleep(2000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.FacetPatternTextBox");
			actionMethods.press_enterInputMandatoryFiled(locator);
			Thread.sleep(2000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.ErrorMassege");
			actionMethods.isElementPresent(locator);

			Report.getInstance().generateReport(
					Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
					Constant.statusFlag + status, driver);
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag, driver);
			throw e;
		}
	}

	public void verifyErrorMessegeHasNotGenerate() throws Exception {

		String locator, status = "";
		try {
			// locator =
			// objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.FacetPatternTextBox");
			// actionMethods.scrollToElement(locator);

			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.ExtendedCharacters");
			actionMethods.click(locator);
			Thread.sleep(2000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.SaveField");
			actionMethods.click(locator);
			Thread.sleep(2000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.FacetPatternTextBox");
			actionMethods.scrollToElement(locator);

			Thread.sleep(2000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.ErrorMassege");
			if (locator.isEmpty());
			status = "Error Messege does not exist";
			// Assert.assertNull(locator);
			Report.getInstance().generateReport(
					Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
					Constant.statusFlag + status, driver);
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag, driver);
			throw e;
		}
	}

	public void verifyExtendedCharactersAreEqualFacetPatternExtendedCharacters(String charecter) throws Exception {

		String locator, status = "";
		try {
			// locator =
			// objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.FacetPatternTextBox");
			// actionMethods.scrollToElement(locator);

			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.ExtendedCharacters");
			actionMethods.click(locator);
			Thread.sleep(2000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.SaveField");
			actionMethods.click(locator);
			Thread.sleep(2000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.FacetPatternTextBox");
			actionMethods.scrollToElement(locator);

			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.FacetPatternTextBox");
			String getattributeValue = actionMethods.getAttributeValue(locator, "value");

			StringBuilder sb = new StringBuilder(getattributeValue);
			sb.deleteCharAt(getattributeValue.length() - 1);
			StringBuilder s = sb.deleteCharAt(0);
			String getattributeValue1 = s.toString();
			// System.out.println(A);

			// String loginToken = "[wdsd34svdf]";
			// String loginToken= getattributeValue.substring( 1, getattributeValue.length()
			// - 1 );

			// String loginToken1="!@#$%^&*=_+[]{}\\\";<>~`|'";
			// if(loginToken.equalsIgnoreCase(loginToken1)) {

			// Constant.statusFlag = "Passed";
			//locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.FacetPatternTextBox");
			//if(actionMethods.validateData(locator, testData);)
			
			
			if (getattributeValue1.equalsIgnoreCase(charecter)) {
				// System.out.println(getattributeValue.contains("!@#$%^&*=_+[]{}\";<>~`|'"));
				//Constant.statusFlag = "Passed";
				status = "ExtendedCharactersAreEqualFacetPatternExtendedCharacters";
				
				Report.getInstance().generateReport(
						Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
						Constant.statusFlag + status, driver);
			} else {
								
				Constant.statusFlag = "Failed";
				status = "ExtendedCharactersAreNotEqualFacetPatternExtendedCharacters";
				Report.getInstance().generateReport(
						Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
						Constant.statusFlag + status, driver);
				
				throw new java.io.IOException("ExtendedCharactersAreNotEqualFacetPatternExtendedCharacters");
			}
			
			Thread.sleep(2000);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.NavigateManu");
			actionMethods.mouseHoverAction(locator);
			Thread.sleep(2000);
			locator = objectRepo.getProperty("DevelopInterfaceChangeProposal.BackMainPageFormMenu");
			actionMethods.click(locator);


			Report.getInstance().generateReport(
					Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
					Constant.statusFlag + status, driver);
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag + e.getMessage(), driver);
			throw e;
		}
	}

	public void navigateEditStructureNotationPage() throws Exception {

		String locator, status = "";
		try {
									
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.link");
			actionMethods.click(locator);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.SearchAll");
			actionMethods.click(locator);
			 Thread.sleep(5000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.SearchAll");
			actionMethods.enterInputMandatoryFiled(locator, EditViewExistingInterfaceChangeData.SEARCHALL);
			Thread.sleep(5000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.SearchAll");
			actionMethods.press_enterInputMandatoryFiled(locator);
			 Thread.sleep(5000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.NumberDescription");
			actionMethods.click(locator);
			
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.MessageModule");
			actionMethods.mouseHoverAction(locator);
			Thread.sleep(2000);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.EditStructuralNotation");
			actionMethods.click(locator);
			
			Report.getInstance().generateReport(
					Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
					Constant.statusFlag + status, driver);
			
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag, driver);
			throw e;
		}
	}

	
	public void deleteExistingStructureNotation() throws Exception {

		String locator, status = "";
		try {
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.EditstructureNotationValue");
			actionMethods.click(locator);
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.EditstructureNotationValue");
			String getattributeValue = driver.findElement(By.xpath("//div[@id='ctl00_ContentHere_box']/descendant::li")).getAttribute("star");
			
			if (getattributeValue.equalsIgnoreCase("true")) {
				// System.out.println(getattributeValue.contains("!@#$%^&*=_+[]{}\";<>~`|'"));
				//Constant.statusFlag = "Passed";
				status = "Element is highlights";
				
				Report.getInstance().generateReport(
						Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
						Constant.statusFlag + status, driver);
			} else {
								
				Constant.statusFlag = "Failed";
				status = "Element is not highlights";
				Report.getInstance().generateReport(
						Thread.currentThread().getStackTrace()[1].getMethodName() + "getScreenShot",
						Constant.statusFlag + status, driver);
				
				throw new java.io.IOException("Element is not highlights");
			}
			
			locator = objectRepo.getProperty("EditViewExistingInterfaceChangeProposals.Delete");
			actionMethods.click(locator);
			Thread.sleep(2000);
			if(driver.getPageSource().contains("Field 1 in MSGID (Set 3) is assigned the value \"ABSTAT\".")){
				System.out.println("Text is present");
				}else{
				System.out.println("Text is absent");
				}
					
		} catch (Exception e) {
			log.error("Exception Occurred at submitting ClaimForm  : " + e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),
					Constant.statusFlag, driver);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

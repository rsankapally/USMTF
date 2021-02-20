package com.test.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.test.controller.ActionMethods;
import com.test.controller.FlowMethods;
import com.test.controller.Report;
import com.test.excelAPI.ExcelOperation;
import com.test.utils.Constant;


public class LoginPage extends FlowMethods {


	Logger log = LogManager.getLogger(ActionMethods.class);	
	ActionMethods actionMethods = new ActionMethods();
	ExcelOperation excelOperation = new ExcelOperation();

	/*public void launchURL() throws Exception {
		try {
			ActionMethods actionMethods = new ActionMethods();
			actionMethods.launchURL();
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag+" Execution started on :"+Constant.browser, driver);
		} catch (Exception e) {
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
			throw e;
		}
	}*/

	public void LoginIntoTheApplication(String userName, String password)
	{
		String locator;
		try
		{
			//locator = objectRepo.getProperty("Login.AcceptBtn");
			//actionMethods.click(locator);

			locator = objectRepo.getProperty("Login.UserName");
			actionMethods.enterInputMandatoryFiled(locator,userName);

			locator = objectRepo.getProperty("Login.Password");
			actionMethods.enterInputMandatoryFiled(locator,password);
			
			locator = objectRepo.getProperty("Login.Submit");
			actionMethods.click(locator);
			
			//locator = objectRepo.getProperty("Login.YesBtn");
			//actionMethods.click(locator);

			
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"user login with: "+userName+","+password, driver);
		} catch (Exception e)
		{
			log.error("Exception Occurred at submitting ClaimForm  : "+e.getMessage());
			Constant.statusFlag = "Failed";
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(),Constant.statusFlag, driver);
			throw e;
		}
	}



}
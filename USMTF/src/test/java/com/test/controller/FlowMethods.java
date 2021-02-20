package com.test.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;


import com.test.testData.LoginTestData;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.test.pages.ApplicationAdministrativeTools;
import com.test.pages.DevelopInterfaceChangeProposal;
import com.test.pages.EditViewExistingInterfaceChangeProposal;
import com.test.pages.LoginPage;

import com.test.utils.Constant;

public class FlowMethods {

	public static WebDriver driver;
	static  LoginPage login = new LoginPage();
	static ActionMethods actionMethod = new ActionMethods();
	public static Properties objectRepo = new Properties();
	//public YourHistory history = new YourHistory();
    
	
	static
	{
		File src = new File("./ObjectRepo.properties");
		try
		{
			FileInputStream stream = new FileInputStream(src);
		    objectRepo.load(stream);
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void login(String moduleName) throws Exception
	{
		try
		{
			//boolean Do_you_wantRunOn_SingleBroser = true;
			if(driver==null)
			{
				//DesiredCapabilities dc=new DesiredCapabilities();
			    //dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			
				driver = actionMethod.openBrowser();
				actionMethod.launchURL(Constant.URL);								
				//String loginDetails = LoginTestData.LOGIN_DETAILS;
				actionMethod.waitFor();
			     login.LoginIntoTheApplication(LoginTestData.LOGIN_DETAILS.split("/")[0],LoginTestData.LOGIN_DETAILS.split("/")[1]);
			}else {
				
				actionMethod.nagivateToHomeScreen();
								
			}
			//Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName()+"getScreenShot", Constant.statusFlag, driver);
		} catch (Exception e) {
			actionMethod.nagivateToHomeScreen();
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
		
	}

	public void loginintotheapplication(String moduleName) throws Exception {
		try
		{
			login(moduleName);
            login.LoginIntoTheApplication(LoginTestData.USERNAME,LoginTestData.PASSWORD);

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	public void SelectSearchSetFromTable(String moduleName) throws Exception {
		DevelopInterfaceChangeProposal info=new DevelopInterfaceChangeProposal();
		try
		{
			info.selectSearchSetFromTable();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	
	public void SelectSearchMessageFromTable(String moduleName) throws Exception {
		DevelopInterfaceChangeProposal info=new DevelopInterfaceChangeProposal();
		try
		{
			info.searchMessagesFromTable();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	
	
	
		
	public void InsertICPNumber(String moduleName) throws Exception {
		DevelopInterfaceChangeProposal info=new DevelopInterfaceChangeProposal();
		try
		{
			info.insertICPNumber();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	
	public void EditStructure(String moduleName) throws Exception {
		DevelopInterfaceChangeProposal info=new DevelopInterfaceChangeProposal();
		try
		{
			info.editSetStructure();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	
	
	public void SelectEditSetStructureApprovalStatus(String moduleName) throws Exception {
		DevelopInterfaceChangeProposal info=new DevelopInterfaceChangeProposal();
		try
		{
			info.selectNavigateManueForEditSetStructureApprovalStatus();
			info.selectEditSetStructureApprovalStatus();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	
	
	public void SelectBaselineApproveICPs(String moduleName) throws Exception {
		ApplicationAdministrativeTools info=new ApplicationAdministrativeTools();
		try
		{
			info.nagivateToApplicationAdministrativeToolslLink();
			Thread.sleep(5000);
			info.nagivateToBaseLineSetVersionslLink();
			Thread.sleep(2000);
			info.selectBaselineApproveICPs();
			Thread.sleep(2000);
			info.verifyBaselineApproveICPsLogs();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	
	public void VerifyTheTextIncorporated(String moduleName) throws Exception {
		EditViewExistingInterfaceChangeProposal info=new EditViewExistingInterfaceChangeProposal();
		try
		{
			Thread.sleep(5000);
			info.nagivateToExistingInterfaceChangeProposalslLink();			
			info.verifyTheTextIncorporated();
			

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	
	public void GenerateSchemas(String moduleName) throws Exception {
		ApplicationAdministrativeTools info=new ApplicationAdministrativeTools();
		try
		{
			info.nagivateToApplicationAdministrativeToolslLink();
			Thread.sleep(5000);
			info.generateSchemas();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	
	public void NagivateEditField(String moduleName) throws Exception {
		EditViewExistingInterfaceChangeProposal info=new EditViewExistingInterfaceChangeProposal();
		try
		{
			info.nagivateEditField();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	
	public void NagivateEditFieldMessageSearch(String moduleName) throws Exception {
		EditViewExistingInterfaceChangeProposal info=new EditViewExistingInterfaceChangeProposal();
		try
		{
			info.nagivateEditFieldMeaasgeSearch();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	
	
	
	
	public void VerifyErrorMessegeHasGenerate(String moduleName) throws Exception {
		EditViewExistingInterfaceChangeProposal info=new EditViewExistingInterfaceChangeProposal();
		try
		{
			info.verifyErrorMessegeHasGenerate();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	public void VerifyErrorMessegeHasNotGenerate(String moduleName) throws Exception {
		EditViewExistingInterfaceChangeProposal info=new EditViewExistingInterfaceChangeProposal();
		try
		{
			info.verifyErrorMessegeHasNotGenerate();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	
	public void VerifyExtendedCharactersAreEqualFacetPatternExtendedCharacters(String moduleName) throws Exception {
		EditViewExistingInterfaceChangeProposal info=new EditViewExistingInterfaceChangeProposal();
		try
		{
			info.verifyExtendedCharactersAreEqualFacetPatternExtendedCharacters("!@#$%\\^&amp;\\*=_\\+\\[\\]\\{\\}\\\\&quot;';&gt;&lt;~`\\|");
			                                                                     
			
			
		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	public void NavigateEditStructureNotationPage(String moduleName) throws Exception {
		EditViewExistingInterfaceChangeProposal info=new EditViewExistingInterfaceChangeProposal();
		try
		{
            info.navigateEditStructureNotationPage();
		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	
	public void DeleteExistingStructureNotationPage(String moduleName) throws Exception {
		EditViewExistingInterfaceChangeProposal info=new EditViewExistingInterfaceChangeProposal();
		try
		{
            info.deleteExistingStructureNotation();
		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void VerifyOtherNameUsedQuestionText(String moduleName) throws Exception {
		InformationAboutYou info=new InformationAboutYou();
		try
		{
			info.nagivateToOtherNameUsedLink();
			

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}*/
	
	/*public void EnterOtherNameUsedFullName(String moduleName) throws Exception {
		InformationAboutYou info=new InformationAboutYou();
		try
		{
			info.othernameusedFullNameDetails();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}*/
	/*public void AnswerMadinNameQuestion(String moduleName) throws Exception {
		InformationAboutYou info=new InformationAboutYou();
		try
		{
			info.selectMaidenName();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}*/
	
	/*public void InsertDateForONU(String moduleName) throws Exception {
		InformationAboutYou info=new InformationAboutYou();
		try
		{
			info.insertDate();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}*/
	
	/*public void ReasonForNameChange(String moduleName) throws Exception {
		InformationAboutYou info=new InformationAboutYou();
		try
		{
			info.inserTheReasonForNameChange();

		} catch (Exception e)
		{
			Report.getInstance().generateReport(Thread.currentThread().getStackTrace()[1].getMethodName(), Constant.statusFlag+"getScreenShot", driver);
			throw e;
		}
	}*/
	
	
	
	
	
	
	
	
}

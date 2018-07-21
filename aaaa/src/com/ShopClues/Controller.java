/* ***************************************************************************************
 * Script-Name:	com.ShopClues/Controller.java
 * Description:	Driver script which initiates the execution of automation 
 * test-suite as per the specified conditions (example; platform, version, iterations, etc.)
 * Author:		Automators
 * Dated:		16Mar2015
 * Notes:	
 *  
 *************************************************************************************** */

//	List of packages to be included for Controller.java
package com.ShopClues;						

// List of packages to be imported for Controller.java
import java.util.ArrayList;
import session.PlatFormEnvSet;
import session.TestCase;
import testCaseReporting.SuiteReporting;
import utilities.GlobalVar;
import utilities.Utility;
import applicationComponent.APIExecuter;

import applicationComponent.AndroidAppAc;
import applicationComponent.AndroidWebAc;
import applicationComponent.BackEndWebAC;
import applicationComponent.WebAC;

// 'Controller' class defined to initiate automation-suite execution
public class Controller 
{
	TestCase testCase = new TestCase();							// Object, defined for TestCase class
	static SuiteReporting suitreporting = new SuiteReporting("Suite"); // Object, defined for SuiteReporting class

	// To iterate the list of test-cases to be executed from Suite.ods
	public void suitExecuter( ArrayList<PlatFormEnvSet> totalTestCases ) 
	{
		// To define variables
		Object oAppComponent = null;								// Object, defined for application component
		
		// 'try-catch' block to handle predefined exceptions
		try 
		{
			for ( PlatFormEnvSet platFormEnv : totalTestCases ) 
			{
				
				// Case; when test-script to be executed on Desktop| Web-Browser environment
				if ( platFormEnv.isDesktopWeb() ) 
				{
					GlobalVar.CURRENT_EXECUTION_MODE = "DesktopWeb";
					oAppComponent = new WebAC();
					System.out.println( "Test-Script in Execution:" + platFormEnv.getTestCaseName() );
					testCase.testCaseExecuter(oAppComponent, platFormEnv);
				}
				
				// Case; when test-script to be executed on Mobile| Android WAP environment 
				if ( platFormEnv.isAndroidWeb() ) 
				{
					GlobalVar.CURRENT_EXECUTION_MODE = "androidWeb";
					oAppComponent = new AndroidWebAc();
					System.out.println( "Test-Script in Execution:" + platFormEnv.getTestCaseName() );
					testCase.testCaseExecuter( oAppComponent, platFormEnv );
				}
				
				// Case; when test-script to be executed on Mobile| Android APP environment 
			    if ( platFormEnv.isAndroidApp() ) 
			    {
					GlobalVar.CURRENT_EXECUTION_MODE = "androidApp";
					oAppComponent = new AndroidAppAc();
					System.out.println( "Test-Script in Execution:" + platFormEnv.getTestCaseName() );
					testCase.testCaseExecuter( oAppComponent, platFormEnv );
				}
			    
			    // Case; when test-script to be executed via APIs 
			    if ( platFormEnv.isAPIStatus() )
			    {
			    	GlobalVar.CURRENT_EXECUTION_MODE="API";
			    	System.setProperty("jsse.enableSNIExtension", "false");
			    	oAppComponent=new APIExecuter();
			    	System.out.println( "Test-Script in Execution:" + platFormEnv.getTestCaseName() );
			    	testCase.testCaseExecuter(oAppComponent, platFormEnv);
			    }
			    
			    // Case; when test-script to be executed for Back-End| Web Application
			    if ( platFormEnv.isBackEndWeb() ) 
			    {
					GlobalVar.CURRENT_EXECUTION_MODE = "backEndWeb";
					oAppComponent = new BackEndWebAC();
					System.out.println( "Test-Script in Execution:" + platFormEnv.getTestCaseName() );
					testCase.testCaseExecuter( oAppComponent, platFormEnv );
				}
			}
			
			// To summarize Test-Suite results, to be displayed in HTML results' file footer
			//suitreporting.consolidateResultFooter();

		} 
		// Catch exceptions at global level and print stack-trace
		catch (Exception ee) 
		{
			ee.printStackTrace();
		}
	}

	// 'main' class, which initiates execution of Controller.java
	public static void main(String ar[]) throws Exception 
	{
		try{
			// Object declarations and definitions
			Controller c = new Controller();	
			GlobalVar.FEATURE_TYPE=ar[0];
			GlobalVar.serverName=ar[1];
			GlobalVar.serverName=GlobalVar.serverName.trim();
			System.out.println("GlobalVar.FEATURE_TYPE "+GlobalVar.FEATURE_TYPE);
			System.out.println("GlobalVar.serverName "+GlobalVar.serverName);
			// Object, defined for 'Controller' class
			Utility commonUtility = new Utility();						// Object, defined for 'Utility' class
			
			// To initiate environment settings for 'Utility' instance
			commonUtility.initEnvSettings();			
			// To set platform settings for all iterated test-scripts 
			ArrayList<PlatFormEnvSet> totalTestCase = commonUtility.setPlatformSettingToAllTestCase();
			c.suitExecuter(totalTestCase);
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			suitreporting.consolidateResultFooter();
		}
	
		
	}

}
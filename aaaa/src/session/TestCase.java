package session;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;

import testCaseReporting.TestCaseReporting;
import utilities.ExcelUtility;
import utilities.GlobalVar;
import utilities.Utility;

public class TestCase {
	Object o[] = null;
	ExcelUtility exlUtil = new ExcelUtility();
	DriverFactory df = null;
	ArrayList<String> actioncomponent = null;
	Utility commonUtility = new Utility();
	TestCaseReporting testCaseReporting = null;
	int startPoint = 1;

	public void testCaseExecuter(Object ac, PlatFormEnvSet platFormEnv)
			throws Exception {		
		initializeTestCaseVars(platFormEnv);		
		while (startPoint <= platFormEnv.getEndScriptDataRow()) {
			//int endpoint=platFormEnv.getEndScriptDataRow();
			
			GlobalVar.BrowserName = platFormEnv.getDesktopWebBrowserName();
			setTestCaseSession(platFormEnv.getTestCaseName());
			
			exlUtil.fetchTestCaseData(startPoint);
			testCaseReporting.header();
			Class<?> testCaseComponent = ac.getClass();
			Method[] testCaseMethod = testCaseComponent.getDeclaredMethods();
			
			for (String actionCom : actioncomponent) {
				if(actionCom.isEmpty() )
					break;
				for (Method m : testCaseMethod) {
					try{
						if(GlobalVar.ExitTestCase==false)
						{
					if (m.getName().equalsIgnoreCase(actionCom)){
						m.invoke(ac, o);
						break;
							}
						}
						else if (m.getName().equalsIgnoreCase("closeApplication") ||
								m.getName().equalsIgnoreCase("closeAPI") ||
								m.getName().equalsIgnoreCase("closeApplication"))
						{
							System.out.println("inside close Application"+m.getName());
							m.invoke(ac, o);
							break;
						}
					}
					catch(Exception e)
					{
						System.out.println("Exception throw for Exit from TestCase");
						break;
					}
				}
			}
			GlobalVar.ExitTestCase=false;
			startPoint++;
		}

		
/*		if(GlobalVar.CURRENT_EXECUTION_MODE.equalsIgnoreCase("API"))
		{
			exlUtil.fetchTestCaseData(startPoint);
			testCaseReporting.header();
			Class<?> testCaseComponent = ac.getClass();
			Method[] testCaseMethod = testCaseComponent.getDeclaredMethods();
			for (String actionCom : actioncomponent) {
				for (Method m : testCaseMethod) {
					if (m.getName().equalsIgnoreCase(actionCom))
						m.invoke(ac, o);
				}
			}
		}*/
		
		
	}

	public void setTestCaseSession(String testCaseName) throws SQLException {
		//if(GlobalVar.CURRENT_EXECUTION_MODE.equalsIgnoreCase("api"))
		//{
		DriverFactory df = new DriverFactory(GlobalVar.CURRENT_EXECUTION_MODE);;
		DriverSession.setLastExecutionDriver(df.getDriver());
		//DBConnection con=new DBConnection();
		//DBSession.setDBSession(con);
		if (GlobalVar.CURRENT_EXECUTION_MODE.contains("Web")) {
			GlobalVar.url = df.getUrl(GlobalVar.serverName);
			GlobalVar.vendorUrl=df.getVendorUrl();
			//GlobalVar.NSEUrl = df.getNSEWebUrl();
			//GlobalVar.BSEUrl = df.getBSEWebUrl();

		//}
		}
		if(GlobalVar.CURRENT_EXECUTION_MODE.equalsIgnoreCase("API")){
			GlobalVar.url=df.getUrl(GlobalVar.serverName);	
			GlobalVar.staticKey=df.getStaticKey();
		}
		testCaseReporting = new TestCaseReporting(testCaseName);
		DriverSession.setLastExecutionReportingInstance(testCaseReporting);

	}

	public void initializeTestCaseVars(PlatFormEnvSet platFormEnv) {

		if(GlobalVar.CURRENT_EXECUTION_MODE.equalsIgnoreCase("api"))
		{
			actioncomponent= commonUtility.fetchActionComponentApi(platFormEnv.getTestCaseName());
			GlobalVar.CURRENT_TEST_CASE_NAME = platFormEnv.getTestCaseName();
			startPoint = platFormEnv.getStartScriptDataRow();
		}
		else
		{
		actioncomponent = commonUtility.fetchActionComponent(platFormEnv
				.getTestCaseName());				
		GlobalVar.CURRENT_TEST_CASE_NAME = platFormEnv.getTestCaseName();
		startPoint = platFormEnv.getStartScriptDataRow();
		}

	}

}

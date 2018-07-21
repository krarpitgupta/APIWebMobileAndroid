package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

import session.PlatFormEnvSet;
//import java.util.List;
//import org.jopendocument.dom.spreadsheet.Column;
//import jxl.Cell;
//import jxl.Sheet;
//import jxl.Workbook;

public class Utility {
	Properties prop = null;
	ArrayList<PlatFormEnvSet> totalTestCases = new ArrayList<PlatFormEnvSet>();

	public void initEnvSettings() throws Exception {
		try {

			GlobalVar.CURRENT_PROJECT_PATH = System.getProperty("user.dir");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Properties loadPageProperties(String pathToPageProperties) {
		Properties pageProp = new Properties();
		String fileLoc = pathToPageProperties;
		try {
			File f = new File(fileLoc);
			FileInputStream fis = new FileInputStream(f);
			pageProp.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pageProp;
	}

	public ArrayList<PlatFormEnvSet> setPlatformSettingToAllTestCase()
			throws Exception {
		int totalRows=0;
		try {
			String suitExc = GlobalVar.CURRENT_PROJECT_PATH
					+ "/TestRepository/TestSuite/TestSuite.ods";
			if(GlobalVar.FEATURE_TYPE.equalsIgnoreCase("admin"))
			{
				suitExc = GlobalVar.CURRENT_PROJECT_PATH
						+ "/TestRepository/TestSuite/ShopClues_AdminSuite.ods";
			}
			else if(GlobalVar.FEATURE_TYPE.equalsIgnoreCase("mobile"))
			{
				suitExc = GlobalVar.CURRENT_PROJECT_PATH
						+ "/TestRepository/TestSuite/ShopClues_MobileSuite.ods";
			}
			else if(GlobalVar.FEATURE_TYPE.equalsIgnoreCase("frontend"))
			{
				suitExc = GlobalVar.CURRENT_PROJECT_PATH
						+ "/TestRepository/TestSuite/ShopClues_FrontEndSuite.ods";
			}
			File file = new File(suitExc);
			Sheet sheet=SpreadSheet.createFromFile(file).getSheet(0);
			
			totalRows=OdsFileUtility.getTotalNumberOfRows(suitExc);
			for(int i=1; i < totalRows;i++)
			{
				PlatFormEnvSet plt = new PlatFormEnvSet();
				//System.out.println("plat object is " + plt);
				
				//System.out.println("rowcount " + i);
				
				plt.setTestCaseName(sheet.getCellAt(1, i).getValue().toString());				
				//System.out.println("testCAseName is " + sheet.getCellAt(1, i).getValue().toString());
												
				plt.setDesktopWebBrowserName(sheet.getCellAt(2, i).getValue().toString());				
				//System.out.println("Browser Name is "
				//		+ sheet.getCellAt(2, i).getValue().toString());
				
				plt.setDesktopWeb(Boolean.parseBoolean(sheet.getCellAt(3, i).getValue().toString()));				
				//System.out.println("DeskTop status is " + sheet.getCellAt(3, i).getValue().toString());
				
				plt.setAndroidWeb(Boolean.parseBoolean(sheet.getCellAt(4, i).getValue().toString()));
				//System.out.println("Adroid web status is "
				//				+ sheet.getCellAt(4, i).getValue().toString());

				plt.setAndroidApp(Boolean.parseBoolean(sheet.getCellAt(5, i).getValue().toString()));
				//System.out.println("Adroid app status is "
				//		+ sheet.getCellAt(5, i).getValue().toString());

			    plt.setBackEndWeb(Boolean.parseBoolean(sheet.getCellAt(6, i).getValue().toString()));
				//System.out.println("BackEnd Web status is "
				//				+ sheet.getCellAt(6, i).getValue().toString());
				
				plt.setAPIStaus(Boolean.parseBoolean(sheet.getCellAt(7, i).getValue().toString()));
				//System.out.println(sheet.getCellAt(7, i).getValue().toString());
				
				plt.setStartScriptDataRow(Integer.parseInt(sheet.getCellAt(8, i).getValue().toString()));
				//System.out.println(sheet.getCellAt(8, i).getValue().toString());

				plt.setEndScriptDataRow(Integer.parseInt(sheet.getCellAt(9, i).getValue().toString()));
				//System.out.println(sheet.getCellAt(9, i).getValue().toString());
				
				
						totalTestCases.add(plt);
				
			}		
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		return totalTestCases;
	}

	public ArrayList<String> fetchActionComponent(String testCaseName) {
		ArrayList<String> actionComponent = new ArrayList<String>();

		try {
			String testCaseOds = System.getProperty("user.dir")
			+ "/TestRepository/TestCases/" + testCaseName + ".ods";
			GlobalVar.TestexcelPath = testCaseOds;
			File file = new File(testCaseOds);
			Sheet sheet=SpreadSheet.createFromFile(file).getSheet(0);
						
			for(int i= 1; i < sheet.getRowCount(); i++){
				//sheet.getValueAt(0, i).toString();				
				actionComponent.add(sheet.getValueAt(0, i).toString());
				////System.out.println(sheet.getValueAt(0, i).toString());
			}
			
			//String testCaseExcel = System.getProperty("user.dir")
					//+ "\\TestRepository\\TestCases\\" + testCaseName + ".xls";
			//GlobalVar.TestexcelPath = testCaseExcel;
			//ExcelUtility exlUtil = new ExcelUtility();
			//Workbook workbook = exlUtil.openWorkbook(testCaseExcel);
			//Sheet sheet = exlUtil.getSheetHandel(workbook, 0);

			//for (int i = 1; i < sheet.getRows(); i++) {
				//Cell[] c = sheet.getRow(i);
				//actionComponent.add(c[0].getContents());

			//}

		}

		catch (Exception ee) {
			ee.printStackTrace();
		}
		return actionComponent;

	}
	
	public ArrayList<String> fetchActionComponentApi(String testCaseName) {
		ArrayList<String> actionComponent = new ArrayList<String>();

		try {
			String testCaseOds = System.getProperty("user.dir")
			+ "/TestRepository/TestCases/" +testCaseName + ".ods";
			GlobalVar.TestexcelPath = testCaseOds;
			File file = new File(testCaseOds);
			Sheet sheet=SpreadSheet.createFromFile(file).getSheet(0);
						
			for(int i= 1; i < sheet.getRowCount(); i++){
				//sheet.getValueAt(0, i).toString();				
				actionComponent.add(sheet.getValueAt(0, i).toString());
				////System.out.println(sheet.getValueAt(0, i).toString());
			}
			
			//String testCaseExcel = System.getProperty("user.dir")
					//+ "\\TestRepository\\TestCases\\" + testCaseName + ".xls";
			//GlobalVar.TestexcelPath = testCaseExcel;
			//ExcelUtility exlUtil = new ExcelUtility();
			//Workbook workbook = exlUtil.openWorkbook(testCaseExcel);
			//Sheet sheet = exlUtil.getSheetHandel(workbook, 0);

			//for (int i = 1; i < sheet.getRows(); i++) {
				//Cell[] c = sheet.getRow(i);
				//actionComponent.add(c[0].getContents());

			//}

		}

		catch (Exception ee) {
			ee.printStackTrace();
		}
		return actionComponent;

	}
	
	public static HashMap<String, String> getOdsSheetData(String odsFilePath,String server,int rowNumber)
	{
		Sheet sheet=null;
		try	{
		File file = new File(odsFilePath);
		sheet=SpreadSheet.createFromFile(file).getSheet(server);
		fetchRowDataOds(sheet,rowNumber);
	}
	catch(Exception e)	{
		e.printStackTrace();
	}
	return fetchRowDataOds(sheet,rowNumber);
	}
	
	public static HashMap<String, String> fetchRowDataOds(Sheet sheet, int rowNumber){
		HashMap<String, String> rowData=new HashMap<String, String>();
		for (int i = 0; i < sheet.getColumnCount(); i++) {
			rowData.put(sheet.getValueAt(i,0).toString(), sheet.getValueAt(i,rowNumber).toString());
		}
		return rowData;
	}
	

	private static String getPortFolioCounter() throws FileNotFoundException {

		GlobalVar.CURRENT_PROJECT_PATH = System.getProperty("user.dir");

		//System.out.println(" current project path "
		//		+ GlobalVar.CURRENT_PROJECT_PATH);

		String counterFilePath = GlobalVar.CURRENT_PROJECT_PATH
				+ "/portFolioCounter.txt";

		//System.out.println(" file path " + counterFilePath);

		Scanner sc = new Scanner(new File(counterFilePath));
		return sc.nextLine();
	}

	private static void setPortFolioNewCounter(String str) throws IOException {

		String counterFilePath = GlobalVar.CURRENT_PROJECT_PATH
				+ "/portFolioCounter.txt";
		FileWriter fw = new FileWriter(new File(counterFilePath));
		fw.write(str);
		fw.flush();
		fw.close();
	}

	public static String getPortFolioSuffix() {
		String suf = "";
		try {
			suf = (Integer.parseInt(getPortFolioCounter()) + 1) + "";
			setPortFolioNewCounter(suf);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return suf;
	}

}

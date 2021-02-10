import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class TestUtil {

	static Workbook book;
	static Sheet sh;
	static FileInputStream file;

	static public Object[][] getTestData(String sheetName) {
		try {
			file = new FileInputStream(new File("C:\\Users\\ankumbar\\Desktop\\Login.xlsx"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		sh = book.getSheet(sheetName);

		Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
		for (int i = 0; i < sh.getLastRowNum(); i++) {
			for (int j = 0; j < sh.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sh.getRow(i + 1).getCell(j).toString();
			}
		}

		return data;
	}

//	public static void main(String args[]) {
//
//		Object[][] data = TestUtil.getTestData("login");
//
//		System.out.println(data.length);
//		
//		 for(int i=0;i<data.length;i++)
//		 { 
//			 for(int j=0;j<data[i].length;j++) 
//			 {
//				 System.out.println(data[i][j]); 
//			 } 
//		}
//		
//
//	}
}

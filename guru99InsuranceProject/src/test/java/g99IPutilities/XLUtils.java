package g99IPutilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	public FileInputStream fi;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow row;
	public XSSFCell cell;
	String path=null;
	
	public XLUtils(String path) {
		this.path=path;
		
	}
	public int getRowNum(String SheetName) throws IOException{
		fi= new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		sh=wb.getSheet(SheetName);
		int rownum=sh.getLastRowNum();
		fi.close();
		wb.close();
		return rownum;
		
	}
	public int getcolNum(String SheetName, int rownum) throws IOException {
		fi= new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		
		sh=wb.getSheet(SheetName);
		row=sh.getRow(rownum);
		int colnum=row.getLastCellNum();
		fi.close();
		wb.close();
		return colnum;
	}
	public String readDataFromExcel(String SheetName, int rownum, int colnum) throws IOException {
		fi= new FileInputStream(path);
		wb= new XSSFWorkbook(fi);
		sh=wb.getSheet(SheetName);
		row=sh.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter df= new DataFormatter();
		String data;
		data=df.formatCellValue(cell);
		
		fi.close();
		wb.close();
		return data;
	}

}

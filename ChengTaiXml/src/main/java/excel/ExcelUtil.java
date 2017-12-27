package excel;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    ArrayList<Object> arrayList;

    public ArrayList<Object> readExcel (File file) {

        if (file.getName().endsWith("xlsx"))
            return readExcelXlsx(file);
        
        if (file.getName().endsWith("xls"))
            return readExcelXls(file);

        return null;
    }

    private ArrayList<Object> readExcelXls(File file) {
        return null;
    }

    private ArrayList<Object> readExcelXlsx(File file) {

        arrayList = new ArrayList<Object>();
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (wb != null) {
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row;
            XSSFCell cell;
            Object value;
        }
        return null;
    }
}

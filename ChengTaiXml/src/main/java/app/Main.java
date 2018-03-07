package app;

import excel.ExcelUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import redundant.TestIpm;
import test.aop.AccountAOP;
import web.config.aop.AOPConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {

        ExcelUtil excelUtil = new ExcelUtil();

        excelUtil.loadExcel(new File("/home/cooper/Desktop/test.xlsx"));




    }
}

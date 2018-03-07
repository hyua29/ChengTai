package excel;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import database.data.tables.Carrier;
import database.data.tables.POD;
import database.data.tables.SourceHarbor;
import database.data.tables.TotalInfo;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
    List<TotalInfo> rawToInfo;
    List<TotalInfo> legitToInfo;
    List<TotalInfo> invalidToInfo;

    public ExcelUtil() {
        rawToInfo = new ArrayList<TotalInfo>();
        legitToInfo = new ArrayList<TotalInfo>();
        invalidToInfo = new ArrayList<TotalInfo>();
    }

    public void loadExcel (File file) {

        if (file.getName().endsWith("xlsx"))
            loadExcelXlsx(file);
        
        if (file.getName().endsWith("xls"))
            loadExcelXls(file);

        return;
    }

    private void loadExcelXls(File file) {
        return;
    }

    private void loadExcelXlsx(File file) {
        invalidToInfo = new ArrayList<TotalInfo>();
        legitToInfo = new ArrayList<TotalInfo>();

        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(new FileInputStream(file));

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (wb == null)
            return;

        XSSFSheet sheet = wb.getSheetAt(0);

        int numOfRows = sheet.getLastRowNum();

        int NUM_OF_CLOS = 13;
        for(int i=0;i<numOfRows + 1;i++) {
            TotalInfo totalInfo = new TotalInfo();
            XSSFRow row = sheet.getRow(i);

            if(row == null)
                continue;

            for (int j = 0; j < NUM_OF_CLOS + 1; j++) {
                XSSFCell cell;
                cell = row.getCell(j);

                String sValue = null;
                int nValue = 0;
                if(cell == null)
                    sValue = "";
                else if(cell.getCellType() == 1)
                    sValue = cell.getStringCellValue();
                else if(cell.getCellType() == 0)
                    nValue = (int) cell.getNumericCellValue();
                else if(cell.getCellType() == 3)
                    sValue = "";

                switch (j) {
                    case 0:
                        totalInfo.setSourceHarbor(sValue);
                        break;
                    case 1:
                        totalInfo.setPod(sValue);
                        break;
                    case 2:
                        totalInfo.setCountry(sValue);
                        break;
                    case 3:
                        totalInfo.setImpInfo(sValue);
                        break;
                    case 4:
                        totalInfo.setCarrier(sValue);
                        break;
                    case 5:
                        totalInfo.setGq20(nValue);
                        break;
                    case 6:
                        totalInfo.setGq40(nValue);
                        break;
                    case 7:
                        totalInfo.setHq40(nValue);
                        break;
                    case 8:
                        totalInfo.setRemark(sValue);
                        break;
                    case 9:
                        totalInfo.setFeeder(sValue);
                        break;
                    case 10:
                        totalInfo.setHKCLS(sValue);
                        break;
                    case 11:
                        totalInfo.setETPHK(sValue);
                        break;
                    case 12:
                        totalInfo.setTT(sValue);
                        break;
                    case 13:
                        totalInfo.setExtraInfo(sValue);
                        break;
                }

            }
            rawToInfo.add(totalInfo);
        }

        return;
    }

    public void validateData(List<SourceHarbor> sourceHarbors, List<POD> PODs, List<Carrier> carriers) {

        for(int i=0;i<this.rawToInfo.size();i++) {

            Boolean validHarbor = false;
            for(int j=0;j<sourceHarbors.size();j++) {
                String harbor = sourceHarbors.get(j).getSourceHarborName();
                if (rawToInfo.get(i).getSourceHarbor().equals(harbor)) {
                    validHarbor = true;
                break;
                }
            }
            Boolean validPOD= false;
            for(int j=0;j<PODs.size();j++) {
                String POD = PODs.get(j).getPODName();
                String country = PODs.get(j).getCountry();
                if (rawToInfo.get(i).getPod().equals(POD) && rawToInfo.get(i).getCountry().equals(country)) {
                    validPOD = true;
                    break;
                }
            }
            Boolean validCarrier = false;
            for(int j=0;j<carriers.size();j++) {
                String carrier = carriers.get(j).getCarrierName();
                if(rawToInfo.get(i).getCarrier().equals(carrier)) {
                    validCarrier = true;
                    break;
                }
            }

            if(validCarrier && validHarbor && validPOD)
                legitToInfo.add(rawToInfo.get(i));
            else
                invalidToInfo.add(rawToInfo.get(i));
        }
    }


    public List<TotalInfo> getLegitToInfo() {
        return this.legitToInfo;
    }

    public List<TotalInfo> getInvalidToInfo(){
        return this.invalidToInfo;
    }
}

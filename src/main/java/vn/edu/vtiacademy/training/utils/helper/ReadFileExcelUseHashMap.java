package vn.edu.vtiacademy.training.utils.helper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import vn.edu.vtiacademy.training.utils.keywords.Excel;
public class ReadFileExcelUseHashMap {
//    private static Logger logger =LogHelper.getLogger();
//    public static Map<String,List<Map<String,String>>>readDataTestCase(String filePath,String sheetName,String tableName){
//        File file =new File(filePath);
//        FileInputStream inputStream ;
//        try{
//            inputStream =new FileInputStream(file);
//
//        }catch(FileNotFoundException e){
//            throw new RuntimeException(e);
//        }
//        XSSFWorkbook exampleWorkbook =null;
//        try{
//            exampleWorkbook=new XSSFWorkbook(inputStream);
//        }catch (IOException e){
//            throw new RuntimeException(e);
//        }
//        XSSFSheet newAccountSheet = exampleWorkbook.getSheet(sheetName);
//
//        Map<String,List<Map<String,String>>> superMap=new HashMap<>();
//        List<String> columnHeader=new ArrayList<>();
//        DataFormatter formatter =new DataFormatter();
//        XSSFRow row=newAccountSheet.getRow(0);
//        Iterator<Cell> cellIterator = row.cellIterator();
//        while (cellIterator.hasNext()) {
//            columnHeader.add(cellIterator.next().getStringCellValue());
//            int rowCount= newAccountSheet.getLastRowNum()- newAccountSheet.getFirstRowNum();
//            int cellCount=row.getLastCellNum();
//
//            for(int i=1; i<=rowCount; i++){
//                Map<String,String> singleRowData=new HashMap<String,String>();
//                XSSFRow rowFirst= newAccountSheet.getRow(i);
////                XSSFCell cellTestCaseID=rowFirst.getCell(0);
//                tableName= String.valueOf(newAccountSheet.getRow(i).getCell(0));
//                for (int j=1;j<cellCount;j++){
//                    XSSFCell cell=rowFirst.getCell(j);
//                    singleRowData.put(columnHeader.get(j), formatter.formatCellValue(cell));
//                }
//                superMap.put(formatter.formatCellValue(git),singleRowData);
//            }
//            for(String key: superMap.keySet());
//            logger.info("Super map" +superMap);
//
//            return superMap;
//
//
//
//        }
//
//        }


    }
}

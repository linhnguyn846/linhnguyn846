package vn.edu.vtiacademy.training.utils.keywords;
import java.io.*;
import java.text.MessageFormat;
import java.util.*;

import org.apache.commons.math3.analysis.function.Constant;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import vn.edu.vtiacademy.training.utils.helper.LogHelper;

import javax.xml.transform.Result;

public class Excel {
    private static Logger logger= LogHelper.getLogger();
    private static XSSFSheet sheet;
    private static XSSFWorkbook exampleWorkBook;
    private static XSSFCell cell;
    private static XSSFRow row;
    public  void openFile(String filePath) {
        File file =new File(filePath);
        FileInputStream inputStream ;
        try{
            inputStream =new FileInputStream(file);

        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
    }

    public static void getSheet (String filePath,String sheetName) throws IOException {
        File file = new File(filePath);
        try{
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook exampleWorkBook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = exampleWorkBook.getSheet(sheetName);
    }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    public static String getCellData(int rowNum,int cellNum) throws Exception{
        try{
            XSSFCell cell =sheet.getRow(rowNum).getCell(cellNum);
            String cellData=cell.getStringCellValue();
            return cellData;
        }catch (Exception e){
            return "";
        }

    }
    public static void setCellData(String filePath,String result,int rowNum,int colNum) throws Exception{
        try{
            XSSFRow row =sheet.getRow(rowNum);
            cell=row.getCell(colNum);
            if (cell == null){
                cell=row.createCell(colNum);
                cell.setCellValue(result);
            }
            else{
                cell.setCellValue(result);
            }

            FileOutputStream fileOut =new FileOutputStream(filePath);
            exampleWorkBook.write(fileOut);
            fileOut.flush();
            fileOut.close();

        }catch (Exception e){
            throw e;
        }
    }

}

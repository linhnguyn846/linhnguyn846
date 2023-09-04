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

public class ReadFileExcel {
    private static Logger logger =LogHelper.getLogger();
    private static final Excel excel =new Excel();

//    public static ArrayList<String> readDataFileExcel(String fileExcelPath,String sheetName,String testCaseID){
//        File file =    new File(fileExcelPath);
//
//        //Create an object of FileInputStream class to read excel file
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
//        ArrayList<String>newArray=new ArrayList<>();
//        XSSFSheet newAccountSheet =exampleWorkbook.getSheet(sheetName);
//        String inputValue =null;
//        String errorMessage=null;
//        //Find number of rows in excel file
//        int rowCount=newAccountSheet.getLastRowNum()-newAccountSheet.getFirstRowNum();
//        //Create a loop over all the rows of excel file to read it
//        DataFormatter formatter = new DataFormatter();
//        for(int i =0; i<rowCount+1;i++){
//            XSSFRow row=newAccountSheet.getRow(i);
//            XSSFCell testCaseIDCell=newAccountSheet.getRow(i).getCell(0);
//            if(formatter.formatCellValue(testCaseIDCell).equals(testCaseID)){
//                XSSFCell cellInputValue =newAccountSheet.getRow(i).getCell(1);
//                inputValue=formatter.formatCellValue(cellInputValue);
//                XSSFCell cellErrorMessage=newAccountSheet.getRow(i).getCell(2);
//                errorMessage= formatter.formatCellValue(cellErrorMessage);
//                break;
//            }
//        }
//        newArray.add(inputValue);
//        newArray.add(errorMessage);
//        return newArray;
//
//
//
//    }

public static Map<String,Map<String,String>> readDataFileExcel(String fileExcelPath,String sheetName) {
    File file =    new File(fileExcelPath);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream ;
        try{
            inputStream =new FileInputStream(file);

        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        XSSFWorkbook exampleWorkbook =null;
        try{
            exampleWorkbook=new XSSFWorkbook(inputStream);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        XSSFSheet newAccountSheet = exampleWorkbook.getSheet(sheetName);

    Map<String, Map<String,String> > superMap= new HashMap<String, Map<String,String> >();
    List<String> columnHeader = new ArrayList<String>();
    DataFormatter formatter =new DataFormatter();
    XSSFRow row=newAccountSheet.getRow(0);
    Iterator<Cell> cellIterator = row.cellIterator();
    while (cellIterator.hasNext()) {
        columnHeader.add(cellIterator.next().getStringCellValue());
    }
    int rowCount= newAccountSheet.getLastRowNum()- newAccountSheet.getFirstRowNum();
    int cellCount=row.getLastCellNum();

    for(int i=1; i<=rowCount; i++){
        Map<String,String> singleRowData=new HashMap<String,String>();
        XSSFRow rowFirst= newAccountSheet.getRow(i);
        XSSFCell cellTestCaseID=rowFirst.getCell(0);
        for (int j=1;j<cellCount;j++){
            XSSFCell cell=rowFirst.getCell(j);
            singleRowData.put(columnHeader.get(j), formatter.formatCellValue(cell));
        }
        superMap.put(formatter.formatCellValue(cellTestCaseID),singleRowData);
    }
    for(String key: superMap.keySet());
    logger.info("Super map" +superMap);

    return superMap;



}
    public static String readErrorMessageInExcelSheet(String fileExcelPath,String sheetName,String testCaseID){
        File file =    new File(fileExcelPath);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream ;
        try{
            inputStream =new FileInputStream(file);

        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        XSSFWorkbook exampleWorkbook =null;
        try{
            exampleWorkbook=new XSSFWorkbook(inputStream);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        ArrayList<String>newArray=new ArrayList<>();
        XSSFSheet newAccountSheet =exampleWorkbook.getSheet(sheetName);
        String errorMessage =null;
        int rowCount =newAccountSheet.getLastRowNum()-newAccountSheet.getFirstRowNum();
        DataFormatter formatter=new DataFormatter();
        for (int i=0;i<rowCount+1;i++){
            XSSFRow row=newAccountSheet.getRow(i);
            XSSFCell testCaseIDCell=newAccountSheet.getRow(i).getCell(0);
            if(formatter.formatCellValue(testCaseIDCell).equals(testCaseID)){
                XSSFCell cellErrorMessage=newAccountSheet.getRow(i).getCell(2);
                errorMessage= formatter.formatCellValue(cellErrorMessage);
                break;
            }
        }
        return errorMessage;


    }
    public void readExcelSheet(String fileExcelPath,String sheetName){
        File file =    new File(fileExcelPath);

        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream ;
        try{
            inputStream =new FileInputStream(file);

        }catch(FileNotFoundException e){
            throw new RuntimeException(e);
        }
        XSSFWorkbook exampleWorkbook =null;
        try{
            exampleWorkbook=new XSSFWorkbook(inputStream);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        ArrayList<String>newArray=new ArrayList<>();
        XSSFSheet newAccountSheet =exampleWorkbook.getSheet(sheetName);
        DataFormatter formatter =new DataFormatter();
        int rowCount=newAccountSheet.getLastRowNum()-newAccountSheet.getFirstRowNum();
        for(int i =0;i<rowCount+1;i++){
            XSSFRow row=newAccountSheet.getRow(i);
            for (int j=0;j<row.getLastCellNum();j++){
                XSSFCell cell = newAccountSheet.getRow(i).getCell(j);
                System.out.print(formatter.formatCellValue(cell)+"|| ");
            }
            System.out.println();
            }
        }

    }


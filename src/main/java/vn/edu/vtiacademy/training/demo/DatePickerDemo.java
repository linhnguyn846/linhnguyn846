package vn.edu.vtiacademy.training.demo;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class DatePickerDemo {

    private static final String SITEDEMO_URL = "https://demoqa.com/date-picker";
    private static final String DATETIME_TXT = "//div[@id='dateAndTimePicker']//div[@class='react-datepicker-wrapper']";
    private static final String YEAR_BTN="//div[@class='react-datepicker__year-read-view']";
    private static final String YEAR_DROPDOWN="//div[@class='react-datepicker__year-dropdown']//div[@class='react-datepicker__year-option']";
    private static final String NEXTMONTH_BTN = "//button[normalize-space()='Next Month']";
    private static final String PREVIOUSMONTH_BTN = "//button[normalize-space()='Previous Month']";
//    private static final String MONTH_DROPDOWN = "//div[starts-with(@class,'react-datepicker__month') and contains(@class,'option')]";
    private static final String MONTH_DROPDOWN="//div[@class='react-datepicker__month-dropdown']//div[@class='react-datepicker__month-option']";
    private static final String MONTH_BTN="//div[@class='react-datepicker__month-read-view']";

    private static final String DATE_LST = "//div[starts-with(@class,'react-datepicker__') and contains(@role,'option')]";
//    private static final String YEAR_DROPDOWN = "//div[contains(@class,'react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--scroll')]//div[contains(@class,'react-datepicker__year-dropdown')]";
    private static final String TIME_LST = "//ul[@class='react-datepicker__time-list']/li";

    private static final String DATE_TXT="//div[@class='react-datepicker__month-container']";
    private static final WebUI webUI = new WebUI();
    private static String[] date_dd_MM_yyyy;

    public static void main(String[] args) {
        webUI.openBrowser("Edge", SITEDEMO_URL);
        webUI.maximizeWindow();
        webUI.delayInSecond(5);
        webUI.clickElement(DATETIME_TXT);
        webUI.delayInSecond(5);
      // webUI.clickElement(MONTH_BTN);
       // webUI.selectOptionByValue(MONTH_DROPDOWN,"March");
        selectDate("2021","July","21","12:00");
        webUI.delayInSecond(5);
        webUI.closeBrowser();
    }




    public static void selectDate(String year,String month,String day,String time ) {
        webUI.clickElement(YEAR_BTN);
        List<WebElement> ddlValueYears = webUI.findElements(YEAR_DROPDOWN,180);
        for (WebElement ddlValueYear: ddlValueYears) {
            String actualYear = webUI.getElementText(ddlValueYear).trim();
            if(actualYear.contentEquals(year)) {
                webUI.clickElement(ddlValueYear);
                break;
            }
        }


        webUI.clickElement(MONTH_BTN);
        List<WebElement> ddlValueMonths = webUI.findElements(MONTH_DROPDOWN,180);
        for (WebElement ddlValueMonth: ddlValueMonths) {
            String actualMonth = webUI.getElementText(ddlValueMonth).trim();
            if(actualMonth.contentEquals(month)) {
                webUI.clickElement(ddlValueMonth);
                break;
            }
        }
        webUI.clickElement(DATE_LST);
        List<WebElement> ddlValueDays = webUI.findElements(DATE_LST);
        for (WebElement ddlValueDay: ddlValueDays) {
            String actualDate = webUI.getElementText(ddlValueDay).trim();
            if(actualDate.equals(day)) {
                webUI.clickElement(ddlValueDay);
                break;
            }
        }


        List<WebElement> ddlValueTimes = webUI.findElements(TIME_LST,60);
        for (WebElement ddlValueTime: ddlValueTimes) {
            String actualTime = webUI.getElementText(ddlValueTime).trim();
            if(actualTime.contentEquals(time)) {
                webUI.scrollToElement(TIME_LST);
                webUI.clickElement(ddlValueTime);
                break;
            }
        }





//        List<WebElement> lblDays =webUI.findElements(DATE_LST,60);
//
//        webUI.clickElement(DATE_LST);
//        List<WebElement> lblTimes =webUI.findElements(TIME_LST,60);
//        webUI.clickElement(TIME_LST);



    }



}
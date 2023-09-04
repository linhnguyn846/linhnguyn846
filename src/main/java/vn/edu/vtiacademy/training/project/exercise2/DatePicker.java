package vn.edu.vtiacademy.training.project.exercise2;
import vn.edu.vtiacademy.training.project.exercise2.SelectDateRepo;
import vn.edu.vtiacademy.training.project.exercise2.DateAndTimeRepo;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;
import io.qameta.allure.Step;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
public class DatePicker extends BasePage {
    public DatePicker(WebUI webUI) {
        super(webUI);
    }

    //Select Date
    @Step("01: Scroll to and click element Select Date")
    public void scrollToAndClickElementSelectDate(){
        webUI.scrollToElementTop(SelectDateRepo.INPDATE);
        webUI.delayInSecond(3);
        webUI.clickElement(SelectDateRepo.INPDATE);
        webUI.takeScreenShotAndHighLightElement(SelectDateRepo.INPDATE);
    }

    @Step("02: Select month at Select Date")
    public void selectMonthAtSelectDate(String month){
        webUI.clickElement(SelectDateRepo.SELECTMONTH);
        webUI.takeScreenShotAndHighLightElement(SelectDateRepo.SELECTMONTH);
        webUI.delayInSecond(3);
        webUI.selectByIndexDropdownList(Integer.parseInt(month) - 1, SelectDateRepo.SELECTMONTH);
        webUI.takeScreenShotAndHighLightElement(SelectDateRepo.SELECTMONTH);
    }

    @Step("03: Select year at Select Date")
    public void selectYearAtSelectDate(String year){
        webUI.clickElement(SelectDateRepo.SELECTYEAR);
        webUI.takeScreenShotAndHighLightElement(SelectDateRepo.SELECTYEAR);
        webUI.selectByVisibleTextDropdownList(Integer.parseInt(year), SelectDateRepo.SELECTYEAR);
        webUI.takeScreenShotAndHighLightElement(SelectDateRepo.SELECTYEAR);
    }

    @Step("04: Select day at Select Date")
    public void selectDayAtSelectDate(String day){
        int dayy = Integer.parseInt(day);
        List<WebElement> daysElement = webUI.findElements(By.cssSelector("div.react-datepicker__day"));
        for(WebElement dayElement : daysElement){
            String text = dayElement.getText();
            if(text.equals(String.valueOf(dayy))){
                dayElement.click();
                break;
            }
        }
    }

    @Step("05: Get current Select Date text field")
    public String getCurrentSelectDateText(){
        String text;
        webUI.scrollToElementCenter(SelectDateRepo.INPDATE);
        text = webUI.getElementAttribute(SelectDateRepo.INPDATE, "value");
        return text;
    }

    @Step("Select the given date correctly MMddyyyy")
    public void selectTheGivenDateCorrectlyMMddyyyy(String inputDate){
        String[] splitter = inputDate.split("/");
        String year = splitter[0];
        String month = splitter[1];
        String day = splitter[2];

        scrollToAndClickElementSelectDate();
        webUI.delayInSecond(3);
        selectMonthAtSelectDate(month);
        webUI.delayInSecond(3);
        selectYearAtSelectDate(year);
        webUI.delayInSecond(3);
        selectDayAtSelectDate(day);
        webUI.takeScreenShotAndHighLightElement(SelectDateRepo.INPDATE);
        webUI.delayInSecond(5);
    }

    //Date and Time
    @Step("01: Scroll to and click element Date And Time")
    public void scrollToAndClickElementDateAndTime(){
        webUI.scrollToElementTop(DateAndTimeRepo.TXT_DATE_AND_TIME);
        webUI.delayInSecond(3);
        webUI.clickElement(DateAndTimeRepo.TXT_DATE_AND_TIME);
        webUI.takeScreenShotAndHighLightElement(DateAndTimeRepo.TXT_DATE_AND_TIME);
    }


    @Step("02: Select month at Date And Time")
    public void selectMonthAtDateAndTime(String month){
        int monthhh = Integer.parseInt(month);
        String namem = Month.of(monthhh).name();
        webUI.clickElement(DateAndTimeRepo.LBL_MONTH);
        webUI.takeScreenShotAndHighLightElement(DateAndTimeRepo.LBL_MONTH);
        List<WebElement> monthsElement = webUI.findElements(By.cssSelector("div.react-datepicker__month-option"));
        for(WebElement monthElement : monthsElement){
            String text = monthElement.getText();
            String text2 = text.toUpperCase();
            if(text2.equals(namem)){
                monthElement.click();
                break;
            }
        }
    }

    @Step("03: Select year at Date And Time Textbox")
    public void selectYearAtDateAndTimeTextBox(String year){
        int yearrr = Integer.parseInt(year);
        String yearReadView = webUI.getElementText(DateAndTimeRepo.YEARREADVIEW);
        int actualYear = Integer.parseInt(yearReadView);
        if(yearrr != actualYear){
            webUI.clickElement(DateAndTimeRepo.LBL_YEAR);
            webUI.delayInSecond(3);
            webUI.takeScreenShotAndHighLightElement(DateAndTimeRepo.LBL_YEAR);
            List<WebElement> yearsElement = webUI.findElements(By.cssSelector("div.react-datepicker__year-option"));
            ArrayList<Integer> yearsValue = new ArrayList<>();

            for(WebElement yearElement: yearsElement){
                String text = yearElement.getText();
                if(text.length() == 4){
                    int temp = Integer.parseInt(text);
                    yearsValue.add(temp);
                }
            }

            if(yearrr < yearsValue.get(yearsValue.size()-1)){ //keo xuong
                int tmp = yearsValue.get(yearsValue.size()-1) - yearrr + 1;
                while(tmp>0){
                    webUI.clickElement(DateAndTimeRepo.LNK_DOWN_ARROW);
                    webUI.delayInSecond(1);
                    tmp--;
                }
            }else if(yearrr > yearsValue.get(0)){ //keo len
                int tmp2 = yearrr - yearsValue.get(0) + 1;
                while(tmp2>0){
                    webUI.clickElement(DateAndTimeRepo.LNK_UP_ARROW);
                    webUI.delayInSecond(1);
                    tmp2--;
                }
            }
            //List<WebElement> yearsElement2 = webUI.findElements(By.cssSelector("div.react-datepicker__year-option"));
            yearsElement = webUI.findElements(By.cssSelector("div.react-datepicker__year-option"));
            for (WebElement yearElement : yearsElement) {
                String text = yearElement.getText();
                if (text.equals(year)) {
                    yearElement.click();
                    break;
                }
            }
        }
    }

    @Step("04: Select day at Date And Time")
    public void selectDayAtDateAndTime(String day){
        int dayy = Integer.parseInt(day);
        List<WebElement> daysElement = webUI.findElements(By.cssSelector("div.react-datepicker__day"));
        for(WebElement dayElement : daysElement){
            String text = dayElement.getText();
            if(text.equals(String.valueOf(dayy))){
                dayElement.click();
                break;
            }
        }
    }

    @Step("05: Select time at Date And Time")
    public void selectTimeAtDateAndTime(String time){
        List<WebElement> timesElement = webUI.findElements(By.cssSelector("li.react-datepicker__time-list-item"));
        for(WebElement timeElement : timesElement){
            String text = timeElement.getText();
            if(text.equals(time)){
                timeElement.click();
                break;
            }
        }
    }

    @Step("06: Get current Date and Time text field")
    public String getCurrentDateAndTimeText(){
        String text;
        webUI.scrollToElementCenter(DateAndTimeRepo.TXT_DATE_AND_TIME);
        text = webUI.getElementAttribute(DateAndTimeRepo.TXT_DATE_AND_TIME, "value");
        return text;
    }

    @Step("Select the given date correctly yyyyMMddHHmm")
    public void selectTheGivenDateCorrectlyyyyyMMddHHmm(String inputDate){
        String[] splitter = inputDate.split(" ");
        String date = splitter[0];
        String time = splitter[1];

        String[] splitter2 = date.split("/");
        String year = splitter2[0];
        String month = splitter2[1];
        String day = splitter2[2];

        scrollToAndClickElementDateAndTime();
        webUI.delayInSecond(3);
        selectMonthAtDateAndTime(month);
        webUI.delayInSecond(3);
        selectYearAtDateAndTimeTextBox(year);
        webUI.delayInSecond(3);
        selectDayAtDateAndTime(day);
        webUI.delayInSecond(3);
        selectTimeAtDateAndTime(time);
        webUI.delayInSecond(3);

    }
}

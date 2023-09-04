package vn.edu.vtiacademy.training.project.exercise2;

import vn.edu.vtiacademy.training.project.exercise2.DatePickerTest;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import vn.edu.vtiacademy.training.project.exercise2.DatePicker;
import io.qameta.allure.Description;
import java.lang.reflect.Method;
import java.text.ParseException;
import org.testng.annotations.Test;

public class DatePickerTest extends BaseTest{
    private DatePicker objDatePicker;
    public DatePickerTest(){
        super();
        objDatePicker=new DatePicker(this.webUI);
        setDataFile(DatePickerTest.class.getSimpleName());
    }
    @Test(description = "TC001: Verify select date text equals the given date with format yyyy/MM/dd to MM/dd/yyyy")
    @Description("Verify date value 1 text equals the given date with format yyyy/MM/dd to MM/dd/yyyy")
    public void TC001_verify_date_value_1_text_equals_the_given_date(Method method){
        logger.info("Test case: " + method.getName());
        objDatePicker.selectTheGivenDateCorrectlyMMddyyyy("2002/05/06");
        assertEquals(objDatePicker.getCurrentSelectDateText(), "05/06/2002");
    }

    @Test(description = "TC002: Verify date and time text equals the given date with format yyyy/MM/dd HH:mm")
    @Description("Verify date and time text equals the given date with format yyyy/MM/dd HH:mm")
    public void TC002_verify_date_and_time_text_equals_the_given_date(Method method){
        logger.info("Test case: " + method.getName());
        objDatePicker.selectTheGivenDateCorrectlyyyyyMMddHHmm("1999/07/06 19:00");
        assertEquals(objDatePicker.getCurrentDateAndTimeText(),
                "July 6, 1999 7:00 PM");
    }
}

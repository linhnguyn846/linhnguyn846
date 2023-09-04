package vn.edu.vtiacademy.training.project.exercise2;
import org.slf4j.Logger;
import vn.edu.vtiacademy.training.utils.keywords.WebUI;
import vn.edu.vtiacademy.training.utils.helper.LogHelper;

import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BasePage {
    protected WebUI webUI;
    protected Logger logger = LogHelper.getLogger();


    public BasePage(WebUI webUI) {
        this.webUI = webUI;
    }

    public int getYear(String date) {
        String pattern = "YYYY/MM/DD HH:MM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date newDate = null;
        try {
            newDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            logger.error(MessageFormat.format("Can not parse date.Root cause:{0}", e.getMessage()));

        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        return calendar.get(Calendar.YEAR);
    }

    public int getMonth(String date) {
        String pattern = "YYYY/MM/DD HH:MM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date newDate = null;
        try {
            newDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            logger.error(MessageFormat.format("Can not parse date.Root cause:{0}", e.getMessage()));

        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        return calendar.get(Calendar.MONTH);
    }

    public int getDate(String date) {
        String pattern = "YYYY/MM/DD HH:MM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date newDate = null;
        try {
            newDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            logger.error(MessageFormat.format("Can not parse date.Root cause:{0}", e.getMessage()));

        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        return calendar.get(Calendar.DATE);
    }

    public int getHour(String date) {
        String pattern = "YYYY/MM/DD HH:MM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date newDate = null;
        try {
            newDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            logger.error(MessageFormat.format("Can not parse date.Root cause:{0}", e.getMessage()));

        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        return calendar.get(Calendar.HOUR);
    }
    public int getMinute(String date) {
        String pattern = "YYYY/MM/DD HH:MM";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        Date newDate = null;
        try {
            newDate = simpleDateFormat.parse(date);
        } catch (ParseException e) {
            logger.error(MessageFormat.format("Can not parse date.Root cause:{0}", e.getMessage()));

        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(newDate);
        return calendar.get(Calendar.MINUTE);
    }
}

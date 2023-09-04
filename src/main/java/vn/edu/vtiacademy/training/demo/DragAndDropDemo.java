package vn.edu.vtiacademy.training.demo;

import vn.edu.vtiacademy.training.utils.keywords.WebUI;

public class DragAndDropDemo {
    private static final String SITEDEMO_URL = "https://demoqa.com/droppable/";
    private static final String LBL_DRAGE_ME = "//div[@id='draggable']";
    private static final String LBL_DROP_HERE = "//div[@id='simpleDropContainer']//div[@id='droppable']";
    private static WebUI webUI = new WebUI();

    public static void main(String[] args) {
        webUI.openBrowser("Chrome", SITEDEMO_URL);
        webUI.maximizeWindow();
        webUI.delayInSecond(5);
        webUI.dragAndDropToObject(LBL_DRAGE_ME, LBL_DROP_HERE);
        webUI.delayInSecond(5);
        webUI.closeBrowser();
    }
}
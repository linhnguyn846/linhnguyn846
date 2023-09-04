package vn.edu.vtiacademy.training.demo;

import org.openqa.selenium.By;

public class LocatorDemo {

  public static void main(String[] args) {
    By.id("message23");
    By.name("uid");
    By.className(" mr-sm-2 form-control");
    By.linkText("Home");
    By.partialLinkText("Hom");
    By.partialLinkText("Ho");
    By.xpath("//a[@id='simpleLink']");
    By.cssSelector("#simpleLink");

    String LBL_ABC = "id:message23";
    String LBL_BCD = "name:uid";
    String LBL_ETGE = "xpath://a[@id='simpleLink']";
    String LBL_TUIL = "//a[@id='simpleLink']";

    // empty (có nhà cửa, nhưng không có đồ đạc) != null (vô gia cư)
    // empty != blank (ký tự trắng) ""
  }

}

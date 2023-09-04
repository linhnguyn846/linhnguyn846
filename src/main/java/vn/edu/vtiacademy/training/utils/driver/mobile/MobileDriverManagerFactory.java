package vn.edu.vtiacademy.training.utils.driver.mobile;

public class MobileDriverManagerFactory {

    public static MobileDriverManager getManager(MobileDriverType type) {

      MobileDriverManager mobileDriverManager = null;

      switch (type) {
        case ANDROID:
          mobileDriverManager = new AndroidDriverManager();
          break;
        case IOS:
          mobileDriverManager = new IOSDriverManager();
          break;
      }
      return mobileDriverManager;

    }
  }


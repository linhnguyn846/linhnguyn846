package vn.edu.vtiacademy.training.utils.helper;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;
//import org.codehaus.plexus.util.PropertyUtils;
import org.slf4j.Logger;
import vn.edu.vtiacademy.training.utils.exceptions.UnableToLoadPropertiesException;
public class PropertyHelper {

    private static PropertyHelper INSTANCE = null;
    private static Logger logger = LogHelper.getLogger();
    private final Properties props = new Properties();

    private final String PROPERTIES_EXTENSION = ".properties";

    private static String deviceName;

    public PropertyHelper() {
        this.loadProperties("configuration" + PROPERTIES_EXTENSION);
        this.props.putAll(System.getProperties()); //[{"platformName", "Android"}, {"platformVersion", "12"}, ....]
    }

    public PropertyHelper(String fileName) {
        deviceName = fileName;
        this.loadProperties(fileName + PROPERTIES_EXTENSION);
        this.props.putAll(System.getProperties());
    }

    private static PropertyHelper getInstance() {
        if (PropertyHelper.INSTANCE == null && deviceName == null) {
            PropertyHelper.INSTANCE = new PropertyHelper();
        } else if(deviceName != null) {
            PropertyHelper.INSTANCE = new PropertyHelper(deviceName);
        }
        return PropertyHelper.INSTANCE;
    }

    public static String getProperty(final String key) {
        return PropertyHelper.getInstance().props.getProperty(key);
    }

    public static int getIntegerProperty(final String key, final int defaultValue) {
        int integerValue = 0;
        final String value = PropertyHelper.getInstance().props.getProperty(key);
        if (value == null) {
            return defaultValue;
        }
        integerValue = Integer.parseInt(value);
        return integerValue;
    }

    public static String getProperty(final String key, final String defaultValue) {
        return PropertyHelper.getInstance().props.getProperty(key, defaultValue);
    }

    public void loadProperties(final String fileName) {
        InputStream inputStream = null;
        try {
            inputStream = ClassLoader.getSystemResourceAsStream(fileName);
            logger.info(MessageFormat.format("Configuration property path: {0}", inputStream));
            if (inputStream != null) {
                this.props.load(inputStream);
            } else {
                throw new UnableToLoadPropertiesException(
                        MessageFormat.format("Property file ''{0}'' not found in the classpath", fileName));
            }
        } catch (final Exception e) {
            logger.error(
                    MessageFormat.format("Cannot load properties file. Root cause: {0}", e.getMessage()));
        } finally {
            try {
                inputStream.close();
            } catch (final IOException e) {
                logger.error(MessageFormat.format("Cannot close file. Root cause: {0}", e.getMessage()));
            }
        }
    }

    public static Properties getProps() {
        return PropertyHelper.getInstance().props;
    }
}

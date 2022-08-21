package domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class TokenPropertiesUtil {
  private static Properties properties = new Properties();
  public static TokenPropertiesUtil INSTANCE = new TokenPropertiesUtil();
  private static final Logger LOGGER = LogManager.getLogger(TokenPropertiesUtil.class);

  private TokenPropertiesUtil() {
    try {
      properties.load(new FileReader(new File("src/main/resources/token.properties")));
    } catch (IOException e) {
      LOGGER.error("The properties file was not read properly", e);
    }
  }

  public static TokenPropertiesUtil getInstance() {
    return INSTANCE;
  }

  public String getString(String key) {
    return properties.getProperty(key);
  }

  public int getInt(String key) {
    return Integer.parseInt(properties.getProperty(key));
  }

}

package Utils.Common.Helper;

import java.io.*;
import java.util.Properties;

public class ReadProperties {
   private static Properties properties;
   private static ReadProperties readProperties=new ReadProperties();
    public static ReadProperties init()
    {
        readProperties.getInstance();
        return readProperties;
    }
    public void getInstance()
    {
        if(properties==null)
        {
            properties=new Properties();
        }
        try {
            String dir=System.getProperty("user.dir");
           InputStream fileInputStream= this.getClass().getClassLoader().getResourceAsStream("env.properties");
            properties.load(fileInputStream);
        }
        catch (FileNotFoundException exception)
        {
            exception.printStackTrace();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public String getProperties(String propertyname)
    {
       return properties.getProperty(propertyname);
    }
}

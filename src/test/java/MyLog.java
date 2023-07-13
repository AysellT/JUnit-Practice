import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class MyLog {

    static Logger logger = Logger.getLogger(MyLog.class); //Logger objesi olusturdum butun islemler bu obje uzerinden ilerleyecek

    public MyLog(){
        DOMConfigurator.configure("log4j.xml");
    }

    public void info(String message){
        logger.info(message);
    }

    public void warn(String message){
        logger.warn(message);
    }

    public void error(String message){
        logger.error(message);
    }
}

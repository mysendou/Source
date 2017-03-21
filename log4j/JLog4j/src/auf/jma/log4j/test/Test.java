package auf.jma.log4j.test;

import org.apache.log4j.Logger;

/**
 * test the log4j
 * @author Jeff.Ma
 *
 */
public class Test {
    private static Logger logger = Logger.getLogger(Test.class);
    
    public static void main(String[] args) {
        //debug message
        logger.debug("debug message");
        //info message
        logger.info("info message");
        //error message
        logger.error("error message");
        logger.debug("test" + true);
        
    }
}

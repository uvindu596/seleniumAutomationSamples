package demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggingDemo {

	private static final Logger log = LogManager.getLogger(LoggingDemo.class.getName());
	
	
	public static void main(String[] args) {
		log.debug("Debud message Logged");
		log.error("error message Logged");
		log.fatal("fatal message Logged");
	}
}

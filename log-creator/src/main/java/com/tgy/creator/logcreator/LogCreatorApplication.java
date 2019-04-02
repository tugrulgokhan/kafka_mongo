package com.tgy.creator.logcreator;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;

@SpringBootApplication
public class LogCreatorApplication {

	private static Logger logger = Logger.getLogger(LogCreatorApplication.class);
	private static Random random = new Random();

	private static final int INFO = 0;
	private static final int ERROR = 1;
	private static final int WARN = 2;

	private static final int ISTANBUL = 0;
	private static final int TOKYO = 1;
	private static final int MOSCOW = 2;
	private static final int BEIJING = 3;
	private static final int LONDON = 4;

	public static void oneLineLog(){
		int type = random.nextInt(3);
		int city = random.nextInt(5);
		String message = "fajldljsgrlkjwrg";
		switch(city){
			case ISTANBUL:
				message = "ISTANBUL " + message;
				break;
			case TOKYO:
				message = "TOKYO " + message;
				break;
			case MOSCOW:
				message = "MOSKOW " + message;
				break;
			case BEIJING:
				message = "BEIJING " + message;
				break;
			case LONDON:
				message = "LONDON " + message;
				break;
			default:
				break;
		}
		switch(type){
			case INFO:
				logger.info(message);
				break;
			case ERROR:
				logger.error(message);
				break;
			case WARN:
				logger.warn(message);
				break;
			default:
				break;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

		SpringApplication.run(LogCreatorApplication.class, args);

		while(true){
			oneLineLog();
			Thread.sleep(100);
		}
	}

}

package com.telek.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class LogTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Log logger = LogFactory.getLog(LogTest.class);
		logger.info("hello log\r\t");
		logger.info(add(1,1));
	
		
	}
    
	 private static  int add(int a,int b){
	        int c=a+b;
	    	return c;
	}
}

package com.cs.main.test;
import org.junit.Test;
import org.mockito.Mock;

import com.cs.main.LogHandler;

public class LogHandlerTest {

	@Mock 
	private LogHandler logFileHandler;
	
    @Test
    public void testParseLogFile() {
    	String file = "logfile.txt";
    	logFileHandler.parseLogFile(file);
    }
}

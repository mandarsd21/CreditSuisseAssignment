package com.cs.main;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.cs.util.DAO;
import com.cs.util.Parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

public class LogHandler {
	private final static Log logger = LogFactory.getLog(Parser.class);

	public static void main(String[] args) {
        if (args == null || args.length != 1) {
            logger.error("Arguments should be in the format --args='<File>'.");
            throw new IllegalArgumentException("Please check the arguments and run again.");
        }

        String file = args[0];

       LogHandler logh = new LogHandler();
       logh.parseLogFile(file);
    }

	public void parseLogFile(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));

			DAO dao = new DAO();
			dao.createEventsTable();

			logger.debug("Parsing file <" + filename + "> for events.");
			Parser parser = new Parser();
			parser.parseLogs(reader, dao);

			dao.selectAll();
			dao.deleteAll();
			dao.closeDatabase();
		} catch (IOException e) {
			logger.error("Error parsing file < " + filename + " >");
			e.printStackTrace();
		} catch (SQLException e) {
			logger.error("Error encountered with DB");
			e.printStackTrace();
		}
	}
}

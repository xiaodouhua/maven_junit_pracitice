package edu.zju.sc.doulongchao;

import java.io.IOException;
import java.util.Date;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.apache.log4j.SimpleLayout;
import org.junit.Assert;
import org.junit.Test;

public class TestLog4jUtility {

	@Test
	public void logEntrance() {
		Logger logger = Logger.getLogger(this.getClass());

		String signature = "testLogEntrance";
		String[] paramNames = new String[] {"Date", "Double", "Float", "Long", "Integer", "String", "Boolean"};
		Date date = new Date();
		Double double1 = new Double(1.23);
		Float float1 = new Float(4.56);
		Long long1 = new Long(123);
		Integer integer = new Integer(456);
		String string = new String("789");
		Boolean boolean1 = new Boolean(true);
		Object[] paramValues = new Object[] {
				date,
				double1,
				float1,
				long1,
				integer,
				string,
				boolean1
		};
		Log4jUtility.logEntrance(logger, signature, paramNames, paramValues);
	}

	@Test
	public void logEntrance2() {
		Logger logger = Logger.getLogger(this.getClass());
		String signature = "testLogEntrance";
		String[] paramNames = new String[] {"Date", "Double", "Float", "Long", "Integer", "String", "Boolean"};
		Date date = new Date();
		Double double1 = new Double(1.23);
		Float float1 = new Float(4.56);
		Long long1 = new Long(123);
		Integer integer = new Integer(456);
		String string = new String("789");
		Boolean boolean1 = new Boolean(true);
		Object[] paramValues = new Object[] {
				date,
				double1,
				float1,
				long1,
				integer,
				string,
				boolean1
		};
		Log4jUtility.logEntrance(logger, signature, paramNames, paramValues, Priority.WARN);
	}

	@Test
	public void logExit() {
		Logger logger = Logger.getLogger(this.getClass());
		String signature = "testLogEntrance";
		String[] paramNames = new String[] {"Date", "Double", "Float", "Long", "Integer", "String", "Boolean"};
		Date date = new Date();
		Double double1 = new Double(1.23);
		Float float1 = new Float(4.56);
		Long long1 = new Long(123);
		Integer integer = new Integer(456);
		String string = new String("789");
		Boolean boolean1 = new Boolean(true);
		Object[] paramValues = new Object[] {
				date,
				double1,
				float1,
				long1,
				integer,
				string,
				boolean1
		};
		Log4jUtility.logExit(logger, signature, paramValues);
	}

	@Test
	public void logExit2() {
		Logger logger = Logger.getLogger(this.getClass());
		String signature = "testLogEntrance";
		String[] paramNames = new String[] {"Date", "Double", "Float", "Long", "Integer", "String", "Boolean"};
		Date date = new Date();
		Double double1 = new Double(1.23);
		Float float1 = new Float(4.56);
		Long long1 = new Long(123);
		Integer integer = new Integer(456);
		String string = new String("789");
		Boolean boolean1 = new Boolean(true);
		Object[] paramValues = new Object[] {
				date,
				double1,
				float1,
				long1,
				integer,
				string,
				boolean1
		};
		Date entranceTimestamp = new Date();
		Log4jUtility.logExit(logger, signature, paramValues, entranceTimestamp);
	}

	@Test
	public void logExit3() {
		Logger logger = Logger.getLogger(this.getClass());
		String signature = "testLogEntrance";
		String[] paramNames = new String[] {"Date", "Double", "Float", "Long", "Integer", "String", "Boolean"};
		Date date = new Date();
		Double double1 = new Double(1.23);
		Float float1 = new Float(4.56);
		Long long1 = new Long(123);
		Integer integer = new Integer(456);
		String string = new String("789");
		Boolean boolean1 = new Boolean(true);
		Object[] paramValues = new Object[] {
				date,
				double1,
				float1,
				long1,
				integer,
				string,
				boolean1
		};
		Date entranceTimestamp = new Date();
		Priority priority = Priority.WARN;
		Log4jUtility.logExit(logger, signature, paramValues, entranceTimestamp, priority);
	}

	@Test
	public void logException() {
		Logger logger = Logger.getLogger(this.getClass());
		String signature = "testLogEntrance";
		String[] paramNames = new String[] {"Date", "Double", "Float", "Long", "Integer", "String", "Boolean"};
		Date date = new Date();
		Double double1 = new Double(1.23);
		Float float1 = new Float(4.56);
		Long long1 = new Long(123);
		Integer integer = new Integer(456);
		String string = new String("789");
		Boolean boolean1 = new Boolean(true);
		Object[] paramValues = new Object[] {
				date,
				double1,
				float1,
				long1,
				integer,
				string,
				boolean1
		};
		Date entranceTimestamp = new Date();
		Priority priority = Priority.WARN;
		IOException ex = new IOException("鎴戞槸寮傚父鍟�");
		IOException ex2 = Log4jUtility.logException(logger, signature, ex);
		Assert.assertEquals(ex, ex2);
	}

	@Test
	public void logException2() {
		Logger logger = Logger.getLogger(this.getClass());
		String signature = "testLogEntrance";
		String[] paramNames = new String[] {"Date", "Double", "Float", "Long", "Integer", "String", "Boolean"};
		Date date = new Date();
		Double double1 = new Double(1.23);
		Float float1 = new Float(4.56);
		Long long1 = new Long(123);
		Integer integer = new Integer(456);
		String string = new String("789");
		Boolean boolean1 = new Boolean(true);
		Object[] paramValues = new Object[] {
				date,
				double1,
				float1,
				long1,
				integer,
				string,
				boolean1
		};
		Date entranceTimestamp = new Date();
		Priority priority = Priority.WARN;
		IOException ex = new IOException("鎴戞槸寮傚父鍟�");
		IOException ex2 = Log4jUtility.logException(logger, signature, ex, priority);
		Assert.assertEquals(ex, ex2);
	}
}

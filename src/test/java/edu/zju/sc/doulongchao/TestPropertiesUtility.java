package edu.zju.sc.doulongchao;

import java.util.Date;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestPropertiesUtility {

	private Properties properties = new Properties();

	@Before
	public void before() {
		properties.setProperty("String", "String");
		properties.setProperty("Integer", "1024");
		properties.setProperty("Double", "12.345");
		properties.setProperty("Long", "10241024");
		properties.setProperty("Float", "9.9");
		properties.setProperty("Date", "20161023");
		properties.setProperty("Class", "java.lang.String");
	}

	@Test
	public void getStringProperty() {
		String key1 = "String";
		String key2 = "hello";
		Class<Exception> exceptionClass = Exception.class;

		try {
			PropertiesUtility.getStringProperty(properties, key1, true, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			PropertiesUtility.getStringProperty(properties, key2, true, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void getStringsProperty() {
		String key1 = "String";
		String key2 = "hello";
		Class<Exception> exceptionClass = Exception.class;

		try {
			PropertiesUtility.getStringsProperty(properties, key1, "i", true, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			PropertiesUtility.getStringsProperty(properties, key2, "i", true, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void getIntegerProperty() {
		String key1 = "Integer";
		String key2 = "hello";
		String key3 = "String";
		Class<Exception> exceptionClass = Exception.class;

		try {
			PropertiesUtility.getIntegerProperty(properties, key1, true, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			PropertiesUtility.getIntegerProperty(properties, key2, true, exceptionClass);
		} catch (Exception e) {
			try {
				PropertiesUtility.getIntegerProperty(properties, key3, true, exceptionClass);
			} catch (Exception e1) {
				return;
			}
		}
		Assert.fail();
	}

	@Test
	public void getLongProperty() {
		String key1 = "Long";
		String key2 = "hello";
		String key3 = "String";
		Class<Exception> exceptionClass = Exception.class;

		try {
			PropertiesUtility.getLongProperty(properties, key1, true, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			PropertiesUtility.getLongProperty(properties, key2, true, exceptionClass);
		} catch (Exception e) {
			try {
				PropertiesUtility.getLongProperty(properties, key3, true, exceptionClass);
			} catch (Exception e1) {
				return;
			}
		}
		Assert.fail();
	}

	@Test
	public void getDoubleProperty() {
		String key1 = "Double";
		String key2 = "hello";
		String key3 = "String";
		Class<Exception> exceptionClass = Exception.class;

		try {
			PropertiesUtility.getDoubleProperty(properties, key1, true, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			PropertiesUtility.getDoubleProperty(properties, key2, true, exceptionClass);
		} catch (Exception e) {
			try {
				PropertiesUtility.getDoubleProperty(properties, key3, true, exceptionClass);
			} catch (Exception e1) {
				return;
			}
		}
		Assert.fail();
	}

	@Test
	public void getDateProperty() {
		String key1 = "Date";
		String key2 = "hello";
		String key3 = "String";
		Class<Exception> exceptionClass = Exception.class;

		try {
			PropertiesUtility.getDateProperty(properties, key1, "yyyyMMdd", true, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			PropertiesUtility.getDateProperty(properties, key2, "yyyyMMdd", true, exceptionClass);
		} catch (Exception e) {
			try {
				PropertiesUtility.getDateProperty(properties, key3, "yyyyMMdd", true, exceptionClass);
			} catch (Exception e1) {
				return;
			}
		}
		Assert.fail();
	}

	@Test
	public void getClassProperty() {
		String key1 = "Class";
		String key2 = "hello";
		String key3 = "Integer";
		Class<Exception> exceptionClass = Exception.class;

		try {
			PropertiesUtility.getClassProperty(properties, key1, true, exceptionClass);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail();
		}

		try {
			PropertiesUtility.getClassProperty(properties, key2, true, exceptionClass);
		} catch (Exception e) {
			try {
				PropertiesUtility.getDoubleProperty(properties, key3, true, exceptionClass);
			} catch (Exception e1) {
				return;
			}
		}
		Assert.fail();
	}
}

package edu.zju.sc.doulongchao;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class TestValidationUtility {

	@Test
	public void checkNotNull() {
		String name = "Integer";
		Object obj = new Integer(1024);
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotNull(obj, name, exceptionClass);
		} catch (Exception ex) {
			Assert.fail();
		}
	}

	@Test
	public void checkNotNull2() {
		String name = "Integer";
		Object obj = null;
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotNull(obj, name, exceptionClass);
		} catch (Exception ex) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotEmpty() {
		String name = "String";
		String value = "1024";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotEmpty(value, name, exceptionClass);
		} catch (Exception ex) {
			Assert.fail();
		}
	}

	@Test
	public void checkNotEmpty2() {
		String name = "String";
		String value = "";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotEmpty(value, name, exceptionClass);
		} catch (Exception ex) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotEmptyAfterTrimming() {
		String name = "String";
		String value = "hello";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotEmptyAfterTrimming(value, name, exceptionClass);
		} catch (Exception ex) {
			Assert.fail();
		}
	}

	@Test
	public void checkNotEmptyAfterTrimming2() {
		String name = "String";
		String value = "     ";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotEmptyAfterTrimming(value, name, exceptionClass);
		} catch (Exception ex) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotNullNorEmpty() {
		String name = "String";
		String value = "hello";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotNullNorEmpty(value, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkNotNullNorEmpty2() {
		String name = "String";
		String value = null;
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotNullNorEmpty(value, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotNullNorEmpty3() {
		String name = "String";
		String value = "";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotNullNorEmpty(value, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotNullNorEmptyAfterTrimming() {
		String name = "String";
		String value = "hello";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotNullNorEmpty(value, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkNotNullNorEmptyAfterTrimming2() {
		String name = "String";
		String value = null;
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotNullNorEmpty(value, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkInstance() {
		String value = "hello";
		Class<String> expectedType = String.class;
		String name = "value";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkInstance(value, expectedType, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkInstance2() {
		Integer value = new Integer(1024);
		Class<String> expectedType = String.class;
		String name = "value";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkInstance(value, expectedType, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNullOrInstance() {
		String value = "hello";
		Class<String> expectedType = String.class;
		String name = "value";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNullOrInstance(value, expectedType, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkNullOrInstance2() {
		String value = null;
		Class<String> expectedType = String.class;
		String name = "value";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNullOrInstance(value, expectedType, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkNullOrInstance3() {
		Integer value = new Integer(1024);
		Class<String> expectedType = String.class;
		String name = "value";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNullOrInstance(value, expectedType, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkExists() {
		File file = new File(getClass().getClassLoader().getResource("log4j.properties").getPath());
		String name = "log4j.properties";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkExists(file, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkExists2() {
		File file = new File("jivcox");
		String name = "log4j.properties";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkExists(file, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkIsFile() {
		File file = new File(getClass().getClassLoader().getResource("log4j.properties").getPath());
		String name = "log4j.properties";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkIsFile(file, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkIsFile2() {
		File file = new File("jivcox");
		String name = "log4j.properties";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkIsFile(file, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkIsDirectory() {
		File file = new File(getClass().getClassLoader().getResource(".").getPath());
		String name = ".";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkIsDirectory(file, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkIsDirectory2() {
		File file = new File("jivcox");
		String name = "log4j.properties";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkIsDirectory(file, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotEmptyCollection() {
		Collection<String> collection = new ArrayList<String>();
		String name = ".";
		Class<Exception> exceptionClass = Exception.class;
		collection.add("1");
		collection.add("2");
		collection.add("3");
		try {
			ValidationUtility.checkNotEmpty(collection, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkNotEmptyCollection2() {
		Collection<String> collection = new ArrayList<String>();
		String name = "log4j.properties";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotEmpty(collection, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotNullNorEmptyCollection() {
		Collection<String> collection = new ArrayList<String>();
		String name = ".";
		Class<Exception> exceptionClass = Exception.class;
		collection.add("1");
		collection.add("2");
		collection.add("3");
		try {
			ValidationUtility.checkNotNullNorEmpty(collection, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkNotNullNorEmptyCollection2() {
		Collection<String> collection = new ArrayList<String>();
		String name = ".";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotNullNorEmpty(collection, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotEmptyMap() {
		Map<String, String> map = new HashMap<String, String>();
		String name = ".";
		Class<Exception> exceptionClass = Exception.class;
		map.put("1", "11");
		map.put("2", "22");
		try {
			ValidationUtility.checkNotEmpty(map, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkNotEmptyMap2() {
		Map<String, String> map = new HashMap<String, String>();
		String name = ".";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotEmpty(map, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotNullNorEmptyMap() {
		Map<String, String> map = new HashMap<String, String>();
		String name = ".";
		Class<Exception> exceptionClass = Exception.class;
		map.put("1", "11");
		map.put("2", "22");
		try {
			ValidationUtility.checkNotNullNorEmpty(map, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkNotNullNorEmptyMap2() {
		Map<String, String> map = new HashMap<String, String>();
		String name = ".";
		Class<Exception> exceptionClass = Exception.class;
		try {
			ValidationUtility.checkNotNullNorEmpty(map, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotNullElements() {
		Collection<String> collection = new ArrayList<String>();
		String name = ".";
		Class<Exception> exceptionClass = Exception.class;
		collection.add("1");
		collection.add("2");
		collection.add("3");
		try {
			ValidationUtility.checkNotNullElements(collection, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkNotNullElements2() {
		Collection<String> collection = new ArrayList<String>();
		String name = ".";
		Class<Exception> exceptionClass = Exception.class;
		collection.add("1");
		collection.add(null);
		collection.add("3");
		try {
			ValidationUtility.checkNotNullElements(collection, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotEmptyElements() {
		Collection<String> collection = new ArrayList<String>();
		String name = ".";
		Class<Exception> exceptionClass = Exception.class;
		collection.add("1");
		collection.add("2");
		collection.add("3");
		try {
			ValidationUtility.checkNotNullElements(collection, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void checkNotEmptyElements2() {
		Collection<String> collection = new ArrayList<String>();
		String name = ".";
		Class<Exception> exceptionClass = Exception.class;
		collection.add("1");
		collection.add(null);
		collection.add("3");
		try {
			ValidationUtility.checkNotNullElements(collection, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotNullKeys() {
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("1", "123");
		map1.put("2", "456");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("1", "123");
		map2.put(null, "456");

		String name = "鎴戞槸鍚嶅瓧鍟婏紝浣犱笉璁板緱浜嗗悧锛�";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkNotNullKeys(map1, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkNotNullKeys(map2, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotNullValues() {
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("1", "123");
		map1.put("2", "456");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("1", "123");
		map2.put("2", null);

		String name = "鎴戞槸鍚嶅瓧鍟婏紝浣犱笉璁板緱浜嗗悧锛�";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkNotNullValues(map1, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkNotNullValues(map2, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotEmptyKeys() {
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("1", "123");
		map1.put("2", "456");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("1", "123");
		map2.put("", "456");

		String name = "鎴戞槸鍚嶅瓧鍟婏紝浣犱笉璁板緱浜嗗悧锛�";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkNotEmptyKeys(map1, true, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkNotEmptyKeys(map2, true, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotEmptyValues() {

		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("1", "123");
		map1.put("2", "456");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("1", "123");
		map2.put("2", "");

		String name = "鎴戞槸鍚嶅瓧鍟婏紝浣犱笉璁板緱浜嗗悧锛�";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkNotEmptyValues(map1, true, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkNotEmptyValues(map2, true, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNegative() {
		double value1 = -1;
		double value2 = 1;
		String name = "鎴戜笉鏄悕瀛楋紝浣犵瀰鎴戝共浠�涔堬紵";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkNegative(value1, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkNegative(value2, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkPositive() {
		double value1 = 1;
		double value2 = -1;
		String name = "鎴戜笉鏄悕瀛楋紝浣犵瀰鎴戝共浠�涔堬紵";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkPositive(value1, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkPositive(value2, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotNegative() {
		double value1 = 0;
		double value2 = -1;
		String name = "鎴戜笉鏄悕瀛楋紝浣犵瀰鎴戝共浠�涔堬紵";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkNotNegative(value1, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkNotNegative(value2, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotPositive() {
		double value1 = 0;
		double value2 = 1;
		String name = "鎴戜笉鏄悕瀛楋紝浣犵瀰鎴戝共浠�涔堬紵";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkNotPositive(value1, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkNotPositive(value2, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotZero() {
		double value1 = 1;
		double value2 = 0;
		String name = "鎴戜笉鏄悕瀛楋紝浣犵瀰鎴戝共浠�涔堬紵";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkNotZero(value1, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkNotZero(value2, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkGreaterThan() {
		double value1 = 1;
		double value2 = 0;
		double value3 = -1;
		double number = 0;
		String name = "鎴戜笉鏄悕瀛楋紝浣犵瀰鎴戝共浠�涔堬紵";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkGreaterThan(value3, number, true, name, exceptionClass);
		} catch (Exception e) {
			try {
				ValidationUtility.checkGreaterThan(value2, number, false, name, exceptionClass);
			} catch (Exception e2) {
				return;
			}
		}

		Assert.fail();
	}

	@Test
	public void checkLessThan() {
		double value1 = 1;
		double value2 = 0;
		double value3 = -1;
		double number = 0;
		String name = "鎴戜笉鏄悕瀛楋紝浣犵瀰鎴戝共浠�涔堬紵";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkLessThan(value1, number, true, name, exceptionClass);
		} catch (Exception e) {
			try {
				ValidationUtility.checkLessThan(value2, number, false, name, exceptionClass);
			} catch (Exception e2) {
				return;
			}
		}

		Assert.fail();
	}

	@Test
	public void checkInRange() {
		double value1 = 2;
		double value2 = 1;
		double value3 = 0;
		double value4 = -1;
		double value5 = -2;
		double from = -1;
		double to = 1;
		String name = "鍚嶅瓧鐪熸槸瓒婃潵瓒婂鏉備簡锛岃�佸笀鐪熷彲pia";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkInRange(value3, from, to, true, true, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			ValidationUtility.checkInRange(value3, from, to, false, true, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			ValidationUtility.checkInRange(value3, from, to, true, false, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			ValidationUtility.checkInRange(value3, from, to, false, false, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			ValidationUtility.checkInRange(value1, from, to, false, false, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNegativeLong() {
		long value1 = -1;
		long value2 = 0;
		String name = "鎴戜笉鎯冲啓浜嗗晩鍟婂晩鍟婂晩鍟婂晩";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkNegative(value1, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkNegative(value2, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkPositiveLong() {
		long value1 = 1;
		long value2 = 0;
		String name = "鎴戜笉鎯冲啓浜嗗晩鍟婂晩鍟婂晩鍟婂晩";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkPositive(value1, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkPositive(value2, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotNegativeLong() {
		long value1 = 0;
		long value2 = -1;
		String name = "鎴戜笉鎯冲啓浜嗗晩鍟婂晩鍟婂晩鍟婂晩";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkNotNegative(value1, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkNotNegative(value2, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotPositiveLong() {
		long value1 = 0;
		long value2 = 1;
		String name = "鎴戜笉鎯冲啓浜嗗晩鍟婂晩鍟婂晩鍟婂晩";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkNotPositive(value1, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkNotPositive(value2, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkNotZeroLong() {
		long value1 = 1;
		long value2 = 0;
		String name = "鎴戜笉鎯冲啓浜嗗晩鍟婂晩鍟婂晩鍟婂晩";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkNotZero(value1, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}

		try {
			ValidationUtility.checkNotZero(value2, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}

	@Test
	public void checkGreaterThanLong() {
		long value = 0;
		long number = 1;
		String name = "鎴戜笉鎯冲啓浜嗗晩鍟婂晩鍟婂晩鍟婂晩";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkGreaterThan(value, number, true, name, exceptionClass);
		} catch (Exception e) {

			try {
				ValidationUtility.checkGreaterThan(value, number, false, name, exceptionClass);
			} catch (Exception e1) {
				return;
			}
		}

		Assert.fail();
	}

	@Test
	public void checkLessThanLong() {
		long value = 1;
		long number = 0;
		String name = "鎴戜笉鎯冲啓浜嗗晩鍟婂晩鍟婂晩鍟婂晩";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkLessThan(value, number, true, name, exceptionClass);
		} catch (Exception e) {

			try {
				ValidationUtility.checkLessThan(value, number, false, name, exceptionClass);
			} catch (Exception e1) {
				return;
			}
		}

		Assert.fail();
	}

	@Test
	public void checkInRangeLong() {
		long value1 = 2;
		long value2 = 1;
		long value3 = 0;
		long value4 = -1;
		long value5 = -2;
		long from = -1;
		long to = 1;
		String name = "鍚嶅瓧鐪熸槸瓒婃潵瓒婂鏉備簡锛岃�佸笀鐪熷彲pia";
		Class<Exception> exceptionClass = Exception.class;

		try {
			ValidationUtility.checkInRange(value3, from, to, true, true, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			ValidationUtility.checkInRange(value3, from, to, false, true, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			ValidationUtility.checkInRange(value3, from, to, true, false, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			ValidationUtility.checkInRange(value3, from, to, false, false, name, exceptionClass);
		} catch (Exception e) {
			Assert.fail();
		}
		try {
			ValidationUtility.checkInRange(value1, from, to, false, false, name, exceptionClass);
		} catch (Exception e) {
			return;
		}
		Assert.fail();
	}
}

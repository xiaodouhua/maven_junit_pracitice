package edu.zju.sc.doulongchao;

import java.text.NumberFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Map.Entry;

/**
 * This is a utility class that provides static methods for retrieving
 * properties of different types (String, Integer, Long, Double, Date, Class)
 * from Properties instance. This utility throws en exception specified by the
 * caller if required property is missing or cannot be parsed properly.
 * getSubConfiguration() method allows to extract inner configuration from
 * Properties instance (when "childConfigName.childPropertyName" format is used
 * for property keys).
 *
 * Thread Safety: This class is immutable and thread safe when properties
 * parameters passed to it are used by the caller in thread safe manner.
 */
public class PropertiesUtility {
	/**
	 * Empty private constructor.
	 */
	private PropertiesUtility() {
	}

	/**
	 * Retrieves the string property from the given Properties instance.
	 *
	 * @throws T
	 *             if the property is required, but missing
	 * @param exceptionClass
	 *            the type of the exception to be thrown if some error occurs
	 * @param properties
	 *            the properties container
	 * @param key
	 *            the key of the property to be retrieved
	 * @param required
	 *            true if property is required, false otherwise (if property is
	 *            required, but missing, an exception is thrown)
	 * @return the retrieved string property value (null if property is optional
	 *         and missing)
	 */
	public static <T extends Throwable> String getStringProperty(Properties properties, String key, boolean required,
			Class<T> exceptionClass) throws T {
		String value = properties.getProperty(key);
		if (value == null) {
			if (required) {
				throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
			}
			return null;
		}
		return value;
	}

	/**
	 * Retrieves the delimited strings property from the given Properties
	 * instance.
	 *
	 * @throws T
	 *             if the property is required, but missing
	 * @param delimiter
	 *            the delimiter regular expression pattern
	 * @param exceptionClass
	 *            the type of the exception to be thrown if some error occurs
	 * @param properties
	 *            the properties container
	 * @param key
	 *            the key of the property to be retrieved
	 * @param required
	 *            true if property is required, false otherwise (if property is
	 *            required, but missing, an exception is thrown)
	 * @return the retrieved strings values (null if property is optional and
	 *         missing)
	 */
	public static <T extends Throwable> String[] getStringsProperty(Properties properties, String key, String delimiter,
			boolean required, Class<T> exceptionClass) throws T {
		String value = properties.getProperty(key);
		if (value == null) {
			if (required) {
				throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
			}
			return null;
		}
		return value.split(delimiter, -1);
	}

	/**
	 * Retrieves the integer property from the given Properties instance.
	 *
	 * @throws T
	 *             if the property value has invalid format or is required, but
	 *             missing
	 * @param exceptionClass
	 *            the type of the exception to be thrown if some error occurs
	 * @param properties
	 *            the properties container
	 * @param key
	 *            the key of the property to be retrieved
	 * @param required
	 *            true if property is required, false otherwise (if property is
	 *            required, but missing, an exception is thrown)
	 * @return the retrieved integer property value (null if property is
	 *         optional and missing)
	 */
	public static <T extends Throwable> Integer getIntegerProperty(Properties properties, String key, boolean required,
			Class<T> exceptionClass) throws T {

		Integer result = null;

		String value = properties.getProperty(key);
		if (value == null) {
			if (required) {
				throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
			}
			return null;
		}
		try {
			result = Integer.valueOf(value);
		} catch (NumberFormatException ex) {
			throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " should be a valid integer", ex);
		}

		return result;
	}

	/**
	 * Retrieves the long integer property from the given Properties instance.
	 *
	 * @throws T
	 *             if the property value has invalid format or is required, but
	 *             missing
	 * @param exceptionClass
	 *            the type of the exception to be thrown if some error occurs
	 * @param properties
	 *            the properties container
	 * @param key
	 *            the key of the property to be retrieved
	 * @param required
	 *            true if property is required, false otherwise (if property is
	 *            required, but missing, an exception is thrown)
	 * @return the retrieved long integer property value (null if property is
	 *         optional and missing)
	 */
	public static <T extends Throwable> Long getLongProperty(Properties properties, String key, boolean required,
			Class<T> exceptionClass) throws T {
		Long result = null;

		String value = properties.getProperty(key);
		if (value == null) {
			if (required) {
				throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
			}
			return null;
		}
		try {
			result = Long.valueOf(value);
		} catch (NumberFormatException ex) {
			throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " should be a valid long integer", ex);
		}
		return result;
	}

	/**
	 * Retrieves the double property from the given Properties instance.
	 *
	 * @throws T
	 *             if the property value has invalid format or is required, but
	 *             missing
	 * @param exceptionClass
	 *            the type of the exception to be thrown if some error occurs
	 * @param properties
	 *            the properties container
	 * @param key
	 *            the key of the property to be retrieved
	 * @param required
	 *            true if property is required, false otherwise (if property is
	 *            required, but missing, an exception is thrown)
	 * @return the retrieved double property value (null if property is optional
	 *         and missing)
	 */
	public static <T extends Throwable> Double getDoubleProperty(Properties properties, String key, boolean required,
			Class<T> exceptionClass) throws T {
		Double result;

		String value = properties.getProperty(key);
		if (value == null) {
			if (required) {
				throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
			}
			return null;
		}
		ParsePosition parsePosition = new ParsePosition(0);
		result = (Double) (NumberFormat.getInstance(Locale.US).parse(value, parsePosition));
		if (parsePosition.getIndex() != value.length()) {
			throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " should be a valid double");
		}
		return result;
	}

	/**
	 * Retrieves the date/time property from the given Properties instance.
	 *
	 * @throws T
	 *             if the property value has invalid format or is required, but
	 *             missing
	 * @param format
	 *            the expected date/time format string
	 * @param exceptionClass
	 *            the type of the exception to be thrown if some error occurs
	 * @param properties
	 *            the properties container
	 * @param key
	 *            the key of the property to be retrieved
	 * @param required
	 *            true if property is required, false otherwise (if property is
	 *            required, but missing, an exception is thrown)
	 * @return the retrieved date/time property value (null if property is
	 *         optional and missing)
	 */
	public static <T extends Throwable> Date getDateProperty(Properties properties, String key, String format,
			boolean required, Class<T> exceptionClass) throws T {
		String value = properties.getProperty(key);
		if (value == null) {
			if (required) {
				throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
			}
			return null;
		}
		ParsePosition parsePosition = new ParsePosition(0);
		Date result = new SimpleDateFormat(format, Locale.US).parse(value, parsePosition);
		if (result == null || parsePosition.getIndex() != value.length()) {
			throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " should be in format [" + format + "]");
		}
		return result;
	}

	/**
	 * Retrieves the class property from the given Properties instance. Property
	 * value is expected to contain a full class name.
	 *
	 * @throws T
	 *             if the property value has invalid format or is required, but
	 *             missing
	 * @param exceptionClass
	 *            the type of the exception to be thrown if some error occurs
	 * @param properties
	 *            the properties container
	 * @param key
	 *            the key of the property to be retrieved
	 * @param required
	 *            true if property is required, false otherwise (if property is
	 *            required, but missing, an exception is thrown)
	 * @return the retrieved class property value (null if property is optional
	 *         and missing)
	 */
	public static <T extends Throwable> Class<?> getClassProperty(Properties properties, String key, boolean required,
			Class<T> exceptionClass) throws T {
		String value = properties.getProperty(key);
		if (value == null) {
			if (required) {
				throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " is required");
			}
			return null;
		}
		Class<?> result = null;
		try {
			result = Class.forName(value);
		} catch (Exception ex) {
			throw ExceptionHelper.constructException(exceptionClass, getPropertyTitle(key) + " contains invalid full class name (" + value + ")", ex);
		}
		return result;
	}

	/**
	 * Retrieves the inner configuration from the configuration stored in
	 * Properties container.
	 *
	 * @param configName
	 *            the name of the inner configuration
	 * @param properties
	 *            the properties with the main configuration
	 * @return the Properties container with the extracted inner configuration
	 *         (not null)
	 */
	public static Properties getSubConfiguration(Properties properties, String configName) {
		Properties result = null;

		String prefix = configName + ".";
		result = new Properties();
		Iterator<Entry<Object, Object>> it = properties.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Object, Object> entry = it.next();
			String key = (String) entry.getKey();
			String value = (String) entry.getValue();
			if (key.startsWith(prefix)) {
				String newKey = key.substring(prefix.length());
				result.put(newKey, value);
			}
		}
		return result;
	}
	/**
	 * Retrieves the property title to be used in exception message.
	 *
	 * @param key
	 *            the property key
	 * @return the constructed property title
	 */
	private static String getPropertyTitle(String key) {
		return "The property '" + key + "'";
	}
}
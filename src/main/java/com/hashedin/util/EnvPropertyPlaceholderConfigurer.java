package com.hashedin.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 
 * Replaces ${} variables in Spring Framework's ApplicationContext.xml and <servlet-name>-servlet.xml 
 * with environment specific (i.e. Machine specific) properties
 * 
 * 
 * This allows you to have a different configuration on a per-machine basis. 
 * 
 * The substitution variables are picked up from EnvironmentInfo class. By default, EnvironmentInfo looks for a file /environment/<machinename>.properties
 * in the classpath.
 * 
 * @see http://forum.springframework.org/showthread.php?t=29472
 * @see http://static.springframework.org/spring/docs/2.0.x/api/org/springframework/beans/factory/config/PropertyPlaceholderConfigurer.html
 *
 */
public class EnvPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer
{

	private static final String ENVNAME = "envname";

	/**
	 * Replaces the values in the origProperties with environment specific values
	 * 
	 * How it works -
	 * a) Parent class creates a Properties object by reading fdngp.properties
	 * b) EnvironmentInfo object determines the most suitable environment
	 * 		- Tries to find a system property "ENVNAME" - and picks up the file classpath:/environment/<ENVNAME>.properties
	 * 		- Tries to find the file classpath:/environment/<machine-name>.properties
	 * 		- Finally, it picks up fdngp.properties (which by convention is just root.properties)
	 * c) Environments follow an inheritance hierarchy - so fcxas313a inherits from fordqa, 
	 * 		which inherits from FordDataCenterEnvironments, which finally inherits from root.properties
	 * d) convertProperties replaces each property with the most appropriate value
	 */
	@Override
	protected void convertProperties(Properties origProperties)
	{
		Set<Map.Entry<Object, Object>> entrySet = origProperties.entrySet();
		Iterator<Map.Entry<Object, Object>> iterator = entrySet.iterator();
		
		Properties overriddenProps = getEnvironmentSpecificProperties(determineEnvironment());
		
		/*
		 * Iterate over each property, find the environment specific value for the property, 
		 * and replace it in the original Properties object  
		 */
		while(iterator.hasNext())
		{
			Map.Entry<Object, Object> entry = iterator.next();
			String key = (String)entry.getKey();
			
			if(overriddenProps.containsKey(key)) {
				String newValue = overriddenProps.getProperty(key);
				entry.setValue(newValue);	
			}			
		}
	}
	
	private Properties getEnvironmentSpecificProperties(String envName) {
		Properties props = new Properties();
		try {
			InputStream in = this.getClass().getClassLoader().getResourceAsStream(envName + ".properties");
			props.load(in);
		}
		catch(IOException ioe) {
			//swallow
		}
		return props;
	}
	
	/**
	 * Figure out the environment we are running
	 * 
	 * TODO - move environment determination to a separate class that can be injected
	 * @return the environment name. A property file with this name must exist in the class path
	 */
	private String determineEnvironment() {
		if(System.getProperty(ENVNAME) != null) {
			return System.getProperty(ENVNAME);
		}
		return "root";
	}
}

package com.aescis.lib.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader
{
	private static final PropertiesLoader INSTANCE = createInstance();

	private static PropertiesLoader createInstance()
	{
		return new PropertiesLoader(new ClassLoaderResourceLocator());
	}

	public static PropertiesLoader getInstance()
	{
		return INSTANCE;
	}

	private final ResourceLocator itsResourceLocator;

	private PropertiesLoader(final ResourceLocator resourceLocator)
	{
		itsResourceLocator = resourceLocator;
	}

	public Properties load(final String propertyFile)
	{
		final InputStream s = itsResourceLocator.getAsStream(propertyFile);
		final Properties p = new Properties();
		try
		{
			p.load(s);
		}
		catch (final IOException e)
		{
			try
			{
				throw new ScumberException("Failed to load property file : " + propertyFile, e);
			}
			catch (final ScumberException e1)
			{
				e1.printStackTrace();
			}
		}
		return p;
	}

}

package com.aescis.lib.helper;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public abstract class AbstractResourceLocator implements ResourceLocator
{
	private final String itsPrefix;

	public AbstractResourceLocator(final String prefix)
	{
		if (prefix == null)
		{
			throw new IllegalArgumentException("Prefix is null");
		}
		itsPrefix = prefix;
	}

	public AbstractResourceLocator()
	{
		this("");
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.aurea.test.scumber.common.utils.ResourceLocator#getResourceName(java
	 * .lang.String)
	 */
	@Override
	public String getResourceName(final String name)
	{
		final String value;
		if ("".equals(itsPrefix))
		{
			value = name;
		}
		else
		{
			value = String.format("%s/%s", itsPrefix, name);
		}
		return value;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.aurea.test.scumber.common.utils.ResourceLocator#getAsFile(java.lang
	 * .String)
	 */
	@Override
	public File getAsFile(final String resource)
		throws ScumberException
	{
		final URL u = getAsUrl(resource);

		if (u == null)
		{
			throw new IllegalArgumentException(String.format("The resource %s does not exist", resource));
		}

		final URI uri;
		try
		{
			uri = u.toURI();
		}
		catch (final URISyntaxException e)
		{
			throw new ScumberException("Invalid URI : " + resource, e);
		}

		final File file = new File(uri);

		if (!file.exists())
		{
			throw new IllegalStateException(String.format("The resource %s does not exist", uri));
		}

		return file;
	}

	/*
	 * (non-Javadoc)
	 * @see com.aurea.test.scumber.common.utils.ResourceLocator#getFullPathResourceName(java.lang.String)
	 */
	@Override
	public String getFullPathResourceName(final String resource)
		throws ScumberException
	{
		try
		{
			final File file = getAsFile(resource);
			return file.getAbsolutePath();
		}
		catch (final Exception e)
		{
			throw new ScumberException("Failed to load resource : " + resource, e);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.aurea.test.scumber.common.utils.ResourceLocator#getBaseFolder()
	 */
	@Override
	public String getBaseFolder()
		throws ScumberException
	{
		return getFullPathResourceName(".");
	}
}

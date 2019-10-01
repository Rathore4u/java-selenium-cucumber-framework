package com.aescis.lib;

public enum OperatingSystem
{
	WINDOWS, LINUX, MAC, OTHER;

	public static OperatingSystem getCurrentOperatingSystem()
	{
		final String name = System.getProperty("os.name");

		if (name == null)
		{
			throw new IllegalStateException(
					"It is not possible retrieve Operating System from current virtual machine!");
		}

		final String lname = name.toLowerCase();
		final OperatingSystem type;

		if (lname.contains("mac"))
		{
			type = OperatingSystem.MAC;
		}
		else if (lname.contains("windows"))
		{
			type = OperatingSystem.WINDOWS;
		}
		else if (lname.contains("linux"))
		{
			type = OperatingSystem.LINUX;
		}
		else
		{
			type = OperatingSystem.OTHER;
		}

		return type;
	}
}

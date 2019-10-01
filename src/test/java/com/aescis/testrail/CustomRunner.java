//=====================================================================================================================
// Copyright (c) 2017. Aurea Software, Inc. All Rights Reserved.
//
// You are hereby placed on notice that the software, its related technology and services may be covered by one or
// more United States ("US") and non-US patents. A listing that associates patented and patent-pending products
// included in the software, software updates, their related technology and services with one or more patent numbers
// is available for you and the general public's access at www.aurea.com/legal/ (the "Patent Notice") without charge.
// The association of products-to-patent numbers at the Patent Notice may not be an exclusive listing of associations,
// and other unlisted patents or pending patents may also be associated with the products. Likewise, the patents or
// pending patents may also be associated with unlisted products. You agree to regularly review the products-to-patent
// number(s) association at the Patent Notice to check for updates.
//=====================================================================================================================

package com.aescis.testrail;

import java.io.IOException;

import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import cucumber.api.junit.Cucumber;

/** <!-- ========================================================================================================== -->
 * This is a simple Runner class overriding Cucumber runner
 * It enables one to associate own custom listener to be added in RunNotifier
 *
 * @author Rathore Mahipal
 *
 * @lastrev fixXXXXX - new class
 * @since 27-07-2017
 * <!-- -------------------------------------------------------------------------------------------------------- --> */

public class CustomRunner extends Cucumber
{

	public CustomRunner(final Class clazz) throws InitializationError, IOException
	{
		super(clazz);

	}

	@Override
	public void run(final RunNotifier runNotifier)
	{
		runNotifier.addListener(new CustomListener());
		super.run(runNotifier);
	}
}
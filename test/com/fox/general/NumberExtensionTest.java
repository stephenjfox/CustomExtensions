package com.fox.general;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * NumberExtension Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jul 29, 2015</pre>
 */
public class NumberExtensionTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: isNumber(String string)
     */
    @Test
    public void testIsNumber() throws Exception {
        boolean number = NumberExtension.isNumber("1000");

        Assert.assertTrue("This shouldn't fit in a short", number);

    }


} 

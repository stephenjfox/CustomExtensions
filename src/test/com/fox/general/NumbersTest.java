package test.com.fox.general;

import com.fox.general.Numbers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Numbers Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jul 29, 2015</pre>
 */
public class NumbersTest {

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
        boolean number = Numbers.isNumber("1000");

        Assert.assertTrue("This shouldn't fit in a short", number);

    }


} 

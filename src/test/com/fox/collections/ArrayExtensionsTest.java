package test.com.fox.collections;

import com.fox.collections.ArrayExtensions;
import com.fox.io.log.ConsoleLogger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

/**
 * ArrayExtensions Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jul 30, 2015</pre>
 */
public class ArrayExtensionsTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: myToString(Iterable<T> objArray)
     */
    @Test
    public void testMyToString() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: reverse(T[] array, int currInd)
     */
    @Test
    public void testReverse() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: linearSearch(T[] arr, T seek)
     */
    @Test
    public void testLinearSearch() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: concat(T[] left, T[] right)
     */
    @Test
    public void testConcat() throws Exception {
//TODO: Test goes here...

        Integer[] ints = new Integer[] { 1, 2, 3, 4},
            integers = new Integer[] { 5, 6, 7, 8};

        Integer[] concat = ArrayExtensions.concat(ints, integers);

        for ( int i = 0; i < concat.length; i++ ) {

            if (i < 4) {
                ConsoleLogger.debug(String.format("Comparing %d == %d", concat[i], ints[i]));
                Assert.assertTrue("All elements should be found",
                        concat[i].intValue() == ints[i].intValue());
            }
            else {
                ConsoleLogger.debug(String.format("Comparing %d == %d", concat[i], integers[i - 4]));
                Assert.assertTrue("All elements should be found",
                        concat[i].intValue() == integers[i - 4].intValue());
            }

        }

    }


} 
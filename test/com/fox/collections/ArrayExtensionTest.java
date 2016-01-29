package com.fox.collections;

import com.fox.io.log.ConsoleLogger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * ArrayExtension Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jul 30, 2015</pre>
 */
public class ArrayExtensionTest {

    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: stringify(Iterable<T> objArray)
     */
    @Test
    public void testStringify() throws Exception {

        ArrayList<Integer> integers = new ArrayList<>();
        for ( int i = 0; i < 10; i++ ) {
            integers.add(i);
        }

        String stringify = ArrayExtension.stringify(integers);
        ConsoleLogger.debug(stringify);
        Assert.assertTrue(stringify.length() > 20);
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

        Integer[] ints = new Integer[] { 1, 2, 3, 4},
            integers = new Integer[] { 5, 6, 7, 8};

        Integer[] concat = ArrayExtension.concat(ints, integers);

        for ( int i = 0; i < concat.length; i++ ) {

            if (i < 4) {
                ConsoleLogger.debugFormatted("Comparing %d == %d", concat[i], ints[i]);
                Assert.assertTrue("All elements should be found",
                        concat[i].intValue() == ints[i].intValue());
            }
            else {
                ConsoleLogger.debugFormatted("Comparing %d == %d", concat[i], integers[i - 4]);
                Assert.assertTrue("All elements should be found",
                        concat[i].intValue() == integers[i - 4].intValue());
            }

        }

    }


} 

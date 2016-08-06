package com.fox.general;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by stephen on 12/3/15.
 */
public class PredicationTest {

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {

  }

  @Test
  public void testIsTrue() throws Exception {
  }

  @Test
  public void testIsTrueVersion2() throws Exception {
  }

  @Test
  public void testExistenceCheck() throws Exception {
  }

  @Test
  public void testIsFalse() throws Exception {

    Predication.isFalse(false); // this should NOT throw exception

    Assert.assertTrue("We should get here.", true);
  }

  @Test
  public void testIsFalse2() throws Exception {

    Predication.isFalse(true); // this should throw exception

    Assert.fail("We shouldn't make it this far");

  }
}

package com.fox;

import com.fox.collection.CollectionExtension;
import com.fox.collection.ListExtension;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Stephen on 8/6/2016.
 */
public class IterableExtensionTest {
  @Test
  public void map() throws Exception {

  }

  @Test
  public void concat() throws Exception {

  }

  @Test
  public void findAll() throws Exception {

  }

  @Test
  public void range() throws Exception {

  }

  @Test
  public void take() throws Exception {

  }

  @Test
  public void skip() throws Exception {
    List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    List<Integer> test = CollectionExtension
        .castBetter((List<Integer>) IterableExtension.skip(source, 3));

    assertEquals("Should only be 7 elements", 7L, test.size());
    final Integer[] toArray = test.toArray(new Integer[] {});
    assertArrayEquals("Should match elements", new Integer[] {4, 5, 6, 7, 8, 9, 10}, toArray);
  }

  @Test
  public void flattenCollections() throws Exception {

  }

}
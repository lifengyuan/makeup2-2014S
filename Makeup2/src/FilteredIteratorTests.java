import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

/**
 * Tests for FilteredIterators.  Intended to be overriden.  (See 
 * GoodFilteredIteratorTests.java for an example.)
 *
 * Portions are based closely on code by Samuel A. Rebelsky for problem 3 
 * of exam 3 of CSC 317 3124S.
 *
 * @author Samuel A. Rebelsky
 */
public class FilteredIteratorTests
{
  // +------------+------------------------------------------------------
  // | Predicates |
  // +------------+

  /**
   * Check for even numbers.
   */
  static final Predicate<Integer> EVEN = new Predicate<Integer>()
    {
      public boolean test(Integer i)
      {
        return (i % 2) == 0;
      } // test(Integer)
    }; // new Predicate<Integer>()

  /**
   * Accept all values.
   */
  static final Predicate<Integer> I_ACCEPT = new Predicate<Integer>()
    {
      public boolean test(Integer i)
      {
        return true;
      } // test(Integer)
    }; // new Predicate<Integer>

  // +--------+----------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The factory we use to build new FilteredIterators.  Should get
   * filled in by the 
   */
  FilteredIteratorFactory<Integer> factory;

  // +--------------+----------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Prepare to run tests using a particular factory.
   */
  public FilteredIteratorTests(FilteredIteratorFactory<Integer> factory)
  {
    this.factory = factory;
  } // FilteredIteratorTests(FilteredIteratorFactory)

  // +-----------+-------------------------------------------------------
  // | Utilities |
  // +-----------+

  /**
   * Create an iterator for an array.
   */
  public static <T> Iterator<T> arrayIterator(T[] array)
  {
    return Arrays.asList(array).iterator();
  } // arrayIterator(T[])

  // +-------+-----------------------------------------------------------
  // | Tests |
  // +-------+

  /**
   * A sample test so that students can think about how to write the
   * other tests.
   */
  @Test
  public void sampleTest1()
  {
    // Create an iterator for array of known values
    Iterator<Integer> it = arrayIterator(new Integer[] { 0, 1, 2 });

    // Create a filtered iterator from that array.  The iterator
    // should give the equivalent of [1,3].
    Iterator<Integer> fit = this.factory.filter(it, EVEN);

    // Some "by hand" tests.
    assertTrue(fit.hasNext());
    assertEquals(fit.next(), Integer.valueOf(0));
    assertTrue(fit.hasNext());
    assertEquals(fit.next(), Integer.valueOf(2));
    assertFalse(fit.hasNext());
  } // sampleTest1()

  /**
   * Another sample test, one that shows that remove works correctly
   * in some cases.
   */
  @Test
  public void sampleTest2()
  {
    Integer[] arr = new Integer[] { 1, 2, 3 };
    ArrayList<Integer> vals = new ArrayList<Integer>(Arrays.asList(arr));
    Iterator fit = this.factory.filter(vals.iterator(), I_ACCEPT);

    // Go through the list and remove elements.
    assertTrue(fit.hasNext());
    assertEquals(fit.next(), Integer.valueOf(1));
    assertTrue(fit.hasNext());
    assertEquals(fit.next(), Integer.valueOf(2));
    fit.remove();
    assertTrue(fit.hasNext());
    assertEquals(fit.next(), Integer.valueOf(3));
    assertFalse(fit.hasNext());

    // Look at the resulting list, which should be [1,3]
    fit = this.factory.filter(vals.iterator(), I_ACCEPT);
    assertTrue(fit.hasNext());
    assertEquals(fit.next(), Integer.valueOf(1));
    assertTrue(fit.hasNext());
    assertEquals(fit.next(), Integer.valueOf(3));
    assertFalse(fit.hasNext());
  } // sampleTest2()

  /**
   * A test in which the `next` method of some poorly implemented filtered 
   * iterators returns null, rather than the appropriate element of the 
   * underlying iterator.
   */
  public void testNext1()
  {
    fail("not yet implemented");
  } // testInappropriateNull()

  /**
   * A test in which the `next` method of some poorly implemented filtered
   * iterators returns the wrong value, and the problem is likely to be 
   * the implementation of `next`.
   */
  public void testNext2()
  {
    fail("not yet implemented");
  } // testNext2()

  /**
   * A test in which the `next` method of some poorly implemented filtered
   * iterators returns the wrong value, and the problem is likely to be 
   * the implementation of `hasNext`.
   */
  public void testNext3()
  {
    fail("not yet implemented");
  } // testNext3()

  /**
   * A test in which the `remove` method of some poorly implemented filtered
   * iterators deletes the wrong values.
   */
  public void testRemove1()
  {
    fail("not yet implemented");
  } // testRemove1()

  /**
   * A test in which the `hasNext` method of some poorly implemented filtered
   * iterators returns the wrong value (true instead of false, or vice versa).
   */
  public void testHasNext1()
  {
    fail("not yet implemented");
  } // testHasNext1()

} // class FilteredIteratorTests
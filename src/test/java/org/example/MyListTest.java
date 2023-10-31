package org.example;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import java.util.List;


public class MyListTest {
  @Test
  public void testAddAndGet_ShouldAddElements_ReturnCorrectly() {
    MyList<Integer> list = new MyList<>();
    list.add(7);
    list.add(13);
    list.add(19);

    Assertions.assertEquals(Integer.valueOf(7), list.get(0));
    Assertions.assertEquals(Integer.valueOf(13), list.get(1));
    Assertions.assertEquals(Integer.valueOf(19), list.get(2));
  }
  @Test
  public void testAddAndGetPart2_ShouldAddElements_ReturnCorrectly() {
    MyList<Double> list = new MyList<>();
    list.add(1.1);
    list.add(3.7);
    list.add(10.0);

    Assertions.assertEquals(Double.valueOf(1.1), list.get(0).doubleValue());
    Assertions.assertEquals(Double.valueOf(3.7), list.get(1).doubleValue());
    Assertions.assertEquals(Double.valueOf(10.0), list.get(2).doubleValue());
  }

  @Test
  public void testAddAndGetPart_ShouldAddElements_ReturnIncorrectly() {
    MyList<Double> list = new MyList<>();
    list.add(1.1);
    list.add(3.7);
    list.add(10.0);

    Assertions.assertNotEquals(Double.valueOf(1.2), list.get(0).doubleValue());
    Assertions.assertNotEquals(Double.valueOf(3.6), list.get(1).doubleValue());
    Assertions.assertNotEquals(Double.valueOf(10.1), list.get(2).doubleValue());
  }
  @Test
  public void testRemove_ShouldRemoveElementAtGivenIndex_RemoveCorrectly() {
    MyList<Integer> list = new MyList<>();
    list.add(11);
    list.add(57);
    list.add(59);
    list.add(77);
    System.out.println(list);
    Assertions.assertEquals(Integer.valueOf(59), list.remove(2));
    Assertions.assertEquals(3, list.size());
    Assertions.assertEquals(Integer.valueOf(77), list.get(2));

  }

  @Test
  public void testMap_ShouldApplyFunctionToEachElementAndReturnNewList() {
    MyList<Integer> list = new MyList<>();
    list.add(33);
    list.add(31);
    list.add(999);
    MyList<Integer> newList = list.map(x -> x * 1000);
    Assertions.assertEquals(3, newList.size());
    Assertions.assertEquals(Integer.valueOf(33000), newList.get(0));
    Assertions.assertEquals(Integer.valueOf(31000), newList.get(1));
    Assertions.assertEquals(Integer.valueOf(999000), newList.get(2));
  }



  @Test
  public void   testIterator_ShouldAddAllTheElementsCorrectly_ShouldReturnTrue() {
    MyList<Integer> list = new MyList<>();
    list.add(1);
    list.add(9);
    list.add(3);
    list.add(7);
    list.add(11);
    list.add(37);
    list.add(59);
    int sum = 0;
    int expected=1+9+3+7+11+37+59;
    for (Object i : list) {
      sum += (Integer) i;

    }
    Assertions.assertEquals(expected, sum);
  }
  @Test
  public void testEquals_Step1_testReflexivity_ShouldReturnTrue() {
    MyList<Integer> list1 = new MyList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(7);
    list1.add(59);

    Assertions.assertTrue(list1.equals(list1));

  }

  @Test
  public void testEquals_Step2_testSymmetry_ShouldReturnTrue() {
    MyList<Integer> list1 = new MyList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(7);
    list1.add(59);

    MyList<Integer> list2 = new MyList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);
    list2.add(7);
    list2.add(59);

    if (list1.equals(list2))
    Assertions.assertTrue(list2.equals(list1));

  }
  @Test
  public void testEquals_Step3_testTransitivity_ShouldReturnTrue() {
    MyList<Integer> list1 = new MyList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(7);
    list1.add(59);

    MyList<Integer> list2 = new MyList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);
    list2.add(7);
    list2.add(59);

    MyList<Integer> list3 = new MyList<>();
    list3.add(1);
    list3.add(2);
    list3.add(3);
    list3.add(7);
    list3.add(59);

    if (list1.equals(list2)&&list2.equals(list3))
    Assertions.assertTrue(list1.equals(list3));

  }
  @Test
  public void testEquals_Step4_testConsistency_ShouldReturnFalse() {
    MyList<Integer> list1 = new MyList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(7);
    list1.add(59);

    MyList<Integer> list2 = new MyList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);
    list2.add(7);
    list2.add(59);


    if (list1.equals(list2))
    { list2.add(9);
    Assertions.assertFalse(list1.equals(list2));}
  }

  @Test
  public void testEquals_Step5_testCompare_ShouldReturnFalse() {
    MyList<Integer> list1 = new MyList<>();

Assertions.assertFalse(list1.equals(null));


  }

  @Test
  public void testHashCode_Step1_ShouldReturnTrue() {
  /*  Whenever it is invoked on the same object more than once during an execution of a Java application,
    the hashCode method must consistently return the same integer, provided no information used in equals
    comparisons on the object is modified. This integer need not remain consistent from one execution of an
    application to another execution of the same application.*/
    MyList<Integer> list1 = new MyList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(7);
    list1.add(59);

    Assertions.assertEquals(list1.hashCode(), list1.hashCode());
    Assertions.assertEquals(list1.hashCode(), list1.hashCode());
    Assertions.assertEquals(list1.hashCode(), list1.hashCode());
  }

  @Test
  public void testHashCode_Step2_ShouldReturnTrue() {
   /* If two objects are equal according to the equals method, then calling the hashCode method on each of
    the two objects must produce the same integer result.*/
    MyList<Integer> list1 = new MyList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(7);
    list1.add(59);

    MyList<Integer> list2 = new MyList<>();
    list2.add(1);
    list2.add(2);
    list2.add(3);
    list2.add(7);
    list2.add(59);
    if (list1.equals(list2))
      Assertions.assertEquals(list1.hashCode(), list2.hashCode());
  }

  @Test
  public void testHashCode_Step3_ShouldReturnTrue() {
   /* It is not required that if two objects are unequal according to the equals method,
    then calling the hashCode method on each of the two objects must produce distinct integer results.
    However, the programmer should be aware that producing
    distinct integer results for unequal objects may improve the performance of hash tables.*/
    MyList<Integer> list1 = new MyList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(7);
    list1.add(59);

    MyList<Integer> list2 = new MyList<>();
    list2.add(59);
    list2.add(0);
    list2.add(77);
    list2.add(3);
    list2.add(19);
   if (!list1.equals(list2))
    Assertions.assertNotEquals(list1.hashCode(),list2.hashCode());



  }


  }





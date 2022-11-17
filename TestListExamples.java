import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class TestListExamples {
  // Write your grading tests here!
  
  @Test
    public void largeList() {
        ArrayList<String> input = new ArrayList<>(Arrays.asList("swag", "weather and stuff", "and", "andy", "sweet"));
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("weather and stuff", "and", "andy"));

        List<String> test = ListExamples.filter(input, new HasAnAnd());

        assertArrayEquals(expected.toArray(), test.toArray());
    }


  @Test (timeout = 6000)
  public void testMerge() {
    ArrayList<String> input1 = new ArrayList<>(Arrays.asList("a", "b", "d", "e"));
    ArrayList<String> input2 = new ArrayList<>(Arrays.asList("c", "f", "g", "p"));
    ArrayList<String> expected = new ArrayList<>(Arrays.asList("a", "b" , "c", "d", "e", "f", "g", "p"));

    List<String> test = ListExamples.merge(input1, input2);

    assertArrayEquals(expected.toArray(), test.toArray());
}

@Test (timeout = 6000) 
public void emptyInput1Merge() {
  ArrayList<String> input1 = new ArrayList<>();
  ArrayList<String> input2 = new ArrayList<>(Arrays.asList("a","b","c","d"));

  List<String> test = ListExamples.merge(input1, input2);

  assertArrayEquals(input2.toArray(), test.toArray());
}

@Test (timeout = 6000)
public void emptyInput2Merge() {
  ArrayList<String> input2 = new ArrayList<>();
  ArrayList<String> input1 = new ArrayList<>(Arrays.asList("a","b","c","d"));

  List<String> test = ListExamples.merge(input1, input2);

  assertArrayEquals(input1.toArray(), test.toArray());
}

@Test (timeout = 6000)
public void bothEmptyMerge() {
  ArrayList<String> input1 = new ArrayList<>();
  ArrayList<String> input2 = new ArrayList<>();
  ArrayList<String> expected = new ArrayList<>();

  List<String> test = ListExamples.merge(input1, input2);

  assertArrayEquals(expected.toArray(), test.toArray());
}

}

class HasAnAnd implements StringChecker {
  public boolean checkString(String s) {
      if (s.contains("and")) {
          return true;
      }
      return false;
  }
}

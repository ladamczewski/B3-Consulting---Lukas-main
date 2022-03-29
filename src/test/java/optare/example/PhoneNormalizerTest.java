package optare.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class PhoneNormalizerTest {

  PhoneNormalizer normalizer = new PhoneNormalizerBean();
  
 
  @Test
  public void test1() {
    assertEquals("+34 636010203",normalizer.normalize("636010203"));
  }
  
  @Test
  public void test2() {
    assertEquals("+34 636010203",normalizer.normalize("636 01 02 03"));
  }
  
  @Test
  public void test3() {
    assertEquals("+34 636010203",normalizer.normalize("636 010 203"));
  }
  
  @Test
  public void test4() {
    assertEquals("+34 636010203",normalizer.normalize("636-01-02-03"));
  }

  @Test
  public void test5() {
    assertEquals("+34 636010203",normalizer.normalize("+34636010203"));
  }
  
  @Test
  public void test6() {
    assertEquals("+34 636010203",normalizer.normalize("34 636010203"));
  }
  
  @Test
  public void test7() {
    assertEquals("+20 636010203",normalizer.normalize("20 636010203"));
  }

  
}

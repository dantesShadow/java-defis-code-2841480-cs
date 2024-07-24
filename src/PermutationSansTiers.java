import static org.junit.Assert.*;
import org.junit.Test;

public class PermutationSansTiers {

  @Test
  public void test() {
    byte a = 99;
    byte b = 101;

    // Votre essai ici
    a = (byte) (a ^ b);
    b = (byte) (a ^ b);
    a = (byte) (a ^ b);

    assertEquals(101, a);
    assertEquals(99, b);
  }
}

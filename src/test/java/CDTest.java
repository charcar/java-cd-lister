import org.junit.*;
import static org.junit.Assert.*;
import java.time.LocalDateTime;

public class CDTest {

  @Test
  public void CD_intantiatesCorrectly_true() {
    CD myCD = new CD ("Pelican City");
    assertEquals(true, myCD instanceof CD);
  }

  @Test
  public void CD_intantiatesWithDescription_true() {
    CD myCD = new CD ("Pelican City");
    assertEquals("Pelican City", myCD.getTitle());
  }

  @Test
  public void all_returnsAllInstancesOfCD_true() {
    CD firstCD = new CD("Pelican City");
    CD secondCD = new CD("Gnarls Barkley");
    assertTrue(CD.all().contains(firstCD));
    assertTrue(CD.all().contains(secondCD));
  }

  @Test
  public void newId_tasksInstantiateWithAnID_true() {
    CD myCD = new CD ("Pelican City");
    assertEquals(CD.all().size(), myCD.getId());
  }

  @Test
  public void find_returnsNullWhenoCDFound_null() {
    assertTrue(CD.find(999) == null);
  }
}

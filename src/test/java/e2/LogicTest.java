package e2;
import org.junit.jupiter.api.*;

import java.util.function.BiPredicate;

import static org.junit.jupiter.api.Assertions.*;

public class LogicTest {

  private Logics logic;
  private static final int SIZE = 5;
  private static final Pair<Integer, Integer> VALID_PAWN_POSITION = new Pair<>(0, 0);
  private static final Pair<Integer, Integer> VALID_KNIGHT_POSITION = new Pair<>(1, 1);

  @BeforeEach
  public void beforeEach() {
    logic = new LogicsImpl(SIZE, VALID_PAWN_POSITION, VALID_KNIGHT_POSITION);
  }

  @Test
  public void testKnightAndPawnInitialPosition() {
    boolean cellContainsPawn = logic.hasPawn(VALID_PAWN_POSITION.getX(), VALID_PAWN_POSITION.getY());
    boolean cellContainsKnight = logic.hasKnight(VALID_KNIGHT_POSITION.getX(), VALID_KNIGHT_POSITION.getY());
    assertTrue(cellContainsPawn);
    assertTrue(cellContainsKnight);
  }

  @Test
  public void testInvalidHitPositions() {
    assertAll(
      () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(-1, 0)),
      () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(0, -1)),
      () -> assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(SIZE, SIZE))
    );
  }

}

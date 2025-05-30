import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import boardgame.Board;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(8, 8); // Inicializa un tablero de 8x8
    }

    @Test
    void testBoardCreationWithValidDimensions() {
        assertEquals(8, board.getRows());
        assertEquals(8, board.getColumns());
    }


 
}
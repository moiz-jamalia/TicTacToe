package TicTacToe;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.Test;


class TicTacToeTest {

	@Test
	void testXCoordinate() {
		Board board = new Board();
		int actual = board.getX();
		int expected = 3;
		assertEquals(expected, actual, "testing X-Coordinate failed");
	}

	@Test
	void testYCoordinate() {
		Board board = new Board();
		int actual = board.getY();
		int expected = 3;
		assertEquals(expected, actual, "testing Y-Coordinate failed");
	}

	 @Test
	    void testStopwatch() {
	    	long expected = new Date().getTime();
	    	StopWatch stopwatch = new StopWatch();
	        stopwatch.startRoundTime();
	        long actual = stopwatch.getRoundStartTime();
	        assertEquals(expected, actual, "testStopwatch failed");
	    }
	 
	  @Test
	    void testLinePrinter() {
	        Board board = new Board();
	        String actual = board.getPrintedLine(8);
	        String expected = "--------";
	        assertEquals(expected, actual, "testGetColumnsMedium failed");
	    }
	  
	  @Test
	    void testLinePrinter1() {
	        Board board = new Board();
	        String actual = board.getPrintedLine(10);
	        String expected = "----------";
	        assertEquals(expected, actual, "testGetColumnsMedium failed");
	    }
	  
	  @Test
	    void testLinePrinter2() {
	        Board board = new Board();
	        String actual = board.getPrintedLine(20);
	        String expected = "--------------------";
	        assertEquals(expected, actual, "testGetColumnsMedium failed");
	    }
	  
	  @Test
	  void testGetField() {
		  int x = 1;
		  int y = 1;
		  Board board = new Board();
		  Field field = board.getField(x, y);
		  assertEquals(x, field.getX());
		  assertEquals(y, field.getY());
	  }
	  
	  @Test
	  void testGetField1() {
		  int x = 2;
		  int y = 0;
		  Board board = new Board();
		  Field field = board.getField(x, y);
		  assertEquals(x, field.getX());
		  assertEquals(y, field.getY());
	  }
	  
	  @Test
	  void testGetField2() {
		  int x = 1;
		  int y = 2;
		  Board board = new Board();
		  Field field = board.getField(x, y);
		  assertEquals(x, field.getX());
		  assertEquals(y, field.getY());
	  }
	  
	  @Test
	  void testGetField3() {
		  int x = 2;
		  int y = 2;
		  Board board = new Board();
		  Field field = board.getField(x, y);
		  assertEquals(x, field.getX());
		  assertEquals(y, field.getY());
	  }
	  
	  @Test
	  void testHistorySize() {
		  Board board = new Board();
		  int actual = board.getHistory().getBoards().size();
		  int expected = 0;
		  assertEquals(expected, actual);
	  }
	  
	  @Test
	  void testIsFirstPrinted() {
		  Board board = new Board();
		  board.printboard();
		  boolean actual = board.isFirstPrinted();
		  assertFalse(actual);
	  }
}
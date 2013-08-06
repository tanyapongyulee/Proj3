import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;


public class BoardTest extends TestCase {

  public void testBoard(){
		Board b= new Board("easy.txt");
		Block[][] board = b.newBoard();	
		int [] c = b.getSize();
		assertTrue(4 == c[1]);
		assertTrue(4==c[0]);
		
		Board g = new Board("140x140.txt");
		Block [][] cord = g.newBoard();
		int [] n = g.getSize();
		assertTrue(140 == n[1]);
		assertTrue(140 == n[0]);
		
	}
	
	public void testFilledBoard(){
		Board b=new Board("easy.txt");
		Block[][] board= b.newBoard();
		b.placeBlocks();
		System.out.println(b.getBoard());
		
		Board c = new Board("140x140.txt");
		Block [][] cord = c.newBoard();
		c.placeBlocks();
		System.out.println(c.getBoard());
	}

}

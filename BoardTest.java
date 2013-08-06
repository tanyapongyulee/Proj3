import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;


public class BoardTest extends TestCase {

	public void testBoard(){
		Board b= new Board("easy.txt");
		b.buildBoard();	
		int [] c = b.getSize();
		assertTrue(4 == c[1]);
		assertTrue(4==c[0]);
		
		Board g = new Board("140x140.txt");
		g.buildBoard();
		int [] n = g.getSize();
		assertTrue(140 == n[1]);
		assertTrue(140 == n[0]);
		
	}
	
	public void testFilledBoard(){
		Board b1=new Board("easy.txt");
		b1.buildBoard();
		b1.placeBlocks();
		System.out.println(b1.printBoard());
		
		Board b2 = new Board("easy2.txt");
		b2.buildBoard();
		b2.placeBlocks();
		System.out.println(b2.printBoard());
	}

}

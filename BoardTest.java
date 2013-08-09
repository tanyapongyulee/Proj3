import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

// test avail block to move
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
		b1.printBoard();
		
		Board b2 = new Board("easy2.txt");
		b2.buildBoard();
		b2.placeBlocks();
		b2.printBoard();
	}
	
	public void testMoveUp(){
		Board b1=new Board("easy.txt");
		b1.buildBoard();
		b1.placeBlocks();
		b1.printBoard();
		Block block1ToMove=b1.board[1][0];
		assertFalse(b1.moveOk(b1.board[1][0]));
		b1.moveUp(block1ToMove);
		b1.printBoard();
		
		Block block2ToMove=b1.board[2][3];
		b1.moveUp(block2ToMove);
		b1.printBoard();
		
		System.out.println("End of testMoveUp.");
		System.out.println("-------------------");
		
	}
	
	public void testMoveDown(){
		Board b1=new Board("easy.txt");
		b1.buildBoard();
		b1.placeBlocks();
		b1.printBoard();
		
		Block block1ToMove=b1.board[0][0];
		b1.moveDown(block1ToMove);
		b1.printBoard();
		
		System.out.println("End of testMoveDown.");
		System.out.println("-------------------");
	}
	
	public void testMoveRight(){
		Board b1=new Board("easy.txt");
		b1.buildBoard();
		b1.placeBlocks();
		b1.printBoard();
		
		Block block1ToMove=b1.board[0][0];
		b1.moveRight(block1ToMove);
		b1.printBoard();
		
		System.out.println("End of testMoveRight.");
		System.out.println("-------------------");
	}
	
	public void testMoveLeft(){
		Board b1=new Board("easy.txt");
		b1.buildBoard();
		b1.placeBlocks();
		b1.printBoard();
		
		Block block1ToMove=b1.board[2][2];
		b1.moveLeft(block1ToMove);
		b1.printBoard();
		
		System.out.println("End of testMoveLeft.");
		System.out.println("-------------------");
	}
	public void testMatchGoal(){
		Board b1=new Board("easy.txt");
		b1.buildBoard();
		b1.placeBlocks();
		Board bSame=new Board("easy.txt");
		bSame.buildBoard();
		bSame.placeBlocks();	
		assertTrue(b1.matchGoal(b1,bSame));
				
	}

}

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;

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
		
		
		Board bG= new Board("easyGoal.txt",b.getLength(), b.getWidth());
		int [] cG = bG.getSize();
		assertTrue(4 == cG[1]);
		assertTrue(4==cG[0]);
		//bG.printBoard();


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
		//b1.printBoard();

		Board b2 = new Board("easy2.txt");
		b2.buildBoard();
		b2.placeBlocks();
		//b2.printBoard();
	}

	public void testMoveUp(){
		Board b1=new Board("easy.txt");
		b1.buildBoard();
		b1.placeBlocks();
		b1.printBoard();
		Block block1ToMove=b1.board[1][0];
	
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
	
	
	
	public void testMovesOkay(){
		Board b1=new Board("dads");
		b1.buildBoard();
		b1.placeBlocks();
		b1.printBoard();
		ArrayList list1,list2,list3, list4, list5, list6, list7;
		list1= b1.okayMoves(b1.board[0][0]); //corner top-left
		assertTrue(list1.size()==0);
		list2= b1.okayMoves(b1.board[0][2]); //corner top-right
		assertTrue(list2.size()==0);
		list3= b1.okayMoves(b1.board[3][0]); //corner bottom-left
		assertTrue(list3.size()==0);
		list4= b1.okayMoves(b1.board[4][2]); //corner bottom-right
		assertTrue(list4.size()==0);
		list5= b1.okayMoves(b1.board[3][2]); //random middle
		assertTrue(list5.size()==0);
		list6= b1.okayMoves(b1.board[3][1]); //random middle, checking Up
		assertTrue(list6.size()==1);
		assertTrue(list6.get(0)=="Up");
		list7= b1.okayMoves(b1.board[2][3]); //random middle, checking Left
		assertTrue(list7.size()==1);
		assertTrue(list7.get(0)=="Left");
		
		
		Board b2=new Board("medium.txt");
		b2.buildBoard();
		b2.placeBlocks();
		b2.printBoard();
		ArrayList list11,list22,list33, list44;
		list11= b2.okayMoves(b2.board[0][0]); //corner top-left
		assertTrue(list11.size()==0);
		list22= b2.okayMoves(b2.board[0][3]); //corner top-right
		assertTrue(list22.size()==0);
		list33= b2.okayMoves(b2.board[4][1]); //checking Right
		assertTrue(list33.size()==1);
		assertTrue(list33.get(0)=="Right");
		list44= b2.okayMoves(b2.board[3][3]); // checking Down
		assertTrue(list44.size()==1);
		assertTrue(list44.get(0)=="Down");
		
		Board b3=new Board("middle.txt");
		b3.buildBoard();
		b3.placeBlocks();
		b3.printBoard();
		ArrayList l1,l2;
		l1= b3.okayMoves(b3.board[2][2]);  // checking multiple moves
		System.out.print(l1.size());
		assertTrue(l1.size()==3);
		assertTrue(l1.get(0)=="Up");
		assertTrue(l1.get(1)=="Down");
		assertTrue(l1.get(2)=="Left");
		l2= b3.okayMoves(b3.board[1][3]); // checking multiple moves
		assertTrue(l2.size()==3);
		assertTrue(l2.get(0)=="Up");
		assertTrue(l2.get(1)=="Down");
		assertTrue(l2.get(2)=="Right");
	
	}
	
	
	public void testCopyBoard(){
		System.out.println("Testing CopyBoard.");   
		Board b1=new Board("1x1.txt");   // checking one-block-board copy
		b1.buildBoard();
		b1.placeBlocks();
		Board b1copy=b1.copyBoard();
		for(int k=0;k<b1.getLength();k++){
			for(int j=0;j<b1.getWidth();j++){
				Point p1=b1.board[k][j].getTop();
				Point copyp1=b1copy.board[k][j].getTop();
				assertEquals(p1,copyp1);    
			}
		}
		
		Board b2=new Board("dads");
		b2.buildBoard();
		b2.placeBlocks();
		Board b2copy=b2.copyBoard();
		b2.printBoard();
		b2copy.printBoard();
		//System.out.println(b2.getLength());
		//System.out.println(b2.getWidth()); 
		assertEquals(b2.getLength(),b2copy.getLength());  //testing length
		assertEquals(b2.getLength(),b2copy.getLength());  // testing width
		//assertEquals(b2.avail.get(0),b2copy.avail.get(0)); // testing saved avail blocks
		for(int k=0;k<b2.getLength();k++){
			for(int j=0;j<b2.getWidth();j++){
				if(b2.board[k][j]!=null){
					Point p2=b2.board[k][j].getTop();
					Point copyp2=b2copy.board[k][j].getTop();
					assertEquals(p2,copyp2);    //checking each block
				}
			}
		}
		b2.moveUp(b2.board[3][1]);
		assertTrue(b2copy.board[2][1]==null);         // checking moving a block in the original board doesn't affect the copy board
		
		b2copy.moveUp(b2copy.board[3][1]);		      // checking moving a block in the copy board doesn't affect the original board
		for(int k=0;k<b2.getLength();k++){
			for(int j=0;j<b2.getWidth();j++){
				if(b2.board[k][j]!=null){
				Point p2=b2.board[k][j].getTop();
				Point copyp2=b2copy.board[k][j].getTop();
				assertEquals(p2,copyp2);    //checking each block
				}else{
					assertEquals(b2copy.board[k][j], null);
				}
			}
		}
		
		Board b3=new Board("empty.txt");   // checking one-block-board copy
		b3.buildBoard();
		b3.placeBlocks();
		Board b3copy=b3.copyBoard();
		for(int k=0;k<b1.getLength();k++){
			for(int j=0;j<b1.getWidth();j++){
				if(b3.board[k][j]!=null){
				Point p=b1.board[k][j].getTop();
				Point copyp=b1copy.board[k][j].getTop();
				assertEquals(p,copyp); 
				}else{
					assertEquals(b3copy.board[k][j], null);    
				}
			}
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}

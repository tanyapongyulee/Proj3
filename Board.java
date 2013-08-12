import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Board {
	public Block[][] board;
	private InputSource file;
	private int BoardLength;
	private int BoardWidth;
	protected ArrayList<Block> Goal;
	private HashSet<Point> availMove;
	public Board(String fileName){
		 file=new InputSource(fileName);	//initializes the file name.	
	}
	public void buildBoard(){   //returns a 2d array of block objects all initialized to empty. 
		String s =file.readLine();
		String[] v = (String[]) s.split(" ");
		int  L1= Integer.parseInt(v[0]);
		int  W1= Integer.parseInt(v[1]);
		BoardLength=L1;
		BoardWidth=W1;
		board=new Block[BoardLength][BoardWidth];
	}
	public int getWidth(){
		return BoardWidth;
	}
	public int getLength(){
		return BoardLength;
	}
	public void placeBlocks(){
		String input = file.readLine();
		while(input!=null){
			String[] v= (String[]) input.split(" ");
			int value1=Integer.parseInt(v[0]);
			int value2=Integer.parseInt(v[1]);
			int value3=Integer.parseInt(v[2]);
			int value4=Integer.parseInt(v[3]);
			int w1 =value4-value2;
			int l1 =value3-value1;
			Block b= new Block(w1,l1);
			b.setTop(value1,value2);
			b.setBottom(value3,value4);
			for(int k=value1; k<value3+1;k++){
				for(int j=value2; j<value4+1; j++){
					board[k][j]=b;
				}
			}
			input=file.readLine();

		}
		for(int k=0; k<BoardLength;k++){
			for(int j=0; j<BoardWidth; j++){
				if(board[k][j]==null){
					Block b= new Block();
					b.setTop(k, j);
					board[k][j]=b;
				}
			}
		}
	}
	public void placeGoalBlocks(){
		String input = file.readLine();
		while(input!=null){
			String[] v= (String[]) input.split(" ");
			int value1=Integer.parseInt(v[0]);
			int value2=Integer.parseInt(v[1]);
			int value3=Integer.parseInt(v[2]);
			int value4=Integer.parseInt(v[3]);
			int w1 =value4-value2;
			int l1 =value3-value1;
			Block b= new Block(w1,l1);
			Goal.add(b);
			b.setTop(value1,value2);
			b.setBottom(value3,value4);
			for(int k=value1; k<value3+1;k++){
				for(int j=value2; j<value4+1; j++){
					board[k][j]=b;
				}
			}
			input=file.readLine();

		}
		for(int k=0; k<BoardLength;k++){
			for(int j=0; j<BoardWidth; j++){
				if(board[k][j]==null){
					Block b= new Block();
					b.setTop(k, j);
					board[k][j]=b;
				}
			}
		}
	}
	public void printBoard(){
		String s="";
		for (int k = 0; k<BoardLength; k++ ){
			for(int j =0; j<BoardWidth; j++){
				s= s+"["+ board[k][j]+"]"+" ";
			}
			s=s+"\n";
		}
		System.out.println(s);

	}

	public int getEmptyBlocks(){ 

		//return the null blocks onBoard
		return 0;
	}

	public void emptyBlocks(){  // update a set of available blocks to move;
		availMove= new HashSet <Point>();
		for (Block[] bRow:board ){
			for(Block block:bRow){
				if(block.toString()==("empty")){
					availMove.add(block.Top);
				}
				}
			}
		}
	public boolean moveOk(Block b){ // check if a block is available to move
		emptyBlocks();
		return availMove.contains(b.Top);
	}


	public void moveUp(Block b){

		Point newTop=new Point(b.Top.x-1,b.Top.y);
		Point newBottom=new Point(b.Bottom.x-1,b.Bottom.y);
		for(int k=newTop.x; k<newBottom.x+1;k++){
					for(int j=newTop.y; j<newBottom.y+1; j++){
						board[k][j]=b;
					}
				}
		for(int k=newTop.y; k<newBottom.y+1; k++){
			Block empty=new Block();
			empty.setTop(b.Bottom.x, k);
			board[b.Bottom.x][k]=empty;
			}
		b.setTop(newTop.x, newTop.y);
		b.setBottom(newBottom.x, newBottom.y);		
	}

	public void moveDown(Block b){

		Point newTop=new Point(b.Top.x+1,b.Top.y);
		Point newBottom=new Point(b.Bottom.x+1,b.Bottom.y);
		for(int k=newTop.x; k<newBottom.x+1;k++){
			for(int j=newTop.y; j<newBottom.y+1; j++){
				board[k][j]=b;
			}
		}

		for(int k=newTop.y; k<newBottom.y+1; k++){
			Block empty=new Block();
			empty.setTop(b.Top.x, k);
			board[b.Top.x][k]=empty;
		}

		b.setTop(newTop.x, newTop.y);
		b.setBottom(newBottom.x, newBottom.y);		
	}

	public void moveLeft(Block b){

		Point newTop=new Point(b.Top.x,b.Top.y-1);
		Point newBottom=new Point(b.Bottom.x,b.Bottom.y-1);
		for(int k=newTop.x; k<newBottom.x+1;k++){
					for(int j=newTop.y; j<newBottom.y+1; j++){
						board[k][j]=b;
					}
				}
		for(int k=newTop.x; k<newBottom.x+1; k++){
			Block empty=new Block();
			empty.setTop(k,b.Bottom.y);
			board[k][b.Bottom.y]=empty;
			}
		b.setTop(newTop.x, newTop.y);
		b.setBottom(newBottom.x, newBottom.y);		
	}

	public void moveRight(Block b){

		Point newTop=new Point(b.Top.x,b.Top.y+1);
		Point newBottom=new Point(b.Bottom.x,b.Bottom.y+1);
		for(int k=newTop.x; k<newBottom.x+1;k++){
					for(int j=newTop.y; j<newBottom.y+1; j++){
						board[k][j]=b;
					}
				}
		for(int k=newTop.x; k<newBottom.x+1; k++){
			Block empty=new Block();
			empty.setTop(k,b.Top.y);
			board[k][b.Top.y]=empty;
			}
		b.setTop(newTop.x, newTop.y);
		b.setBottom(newBottom.x, newBottom.y);		
	}



	public boolean isOkay(){
		return false;
	}

	public boolean possible(Board b2){
		//using A*algorithm to compute
		return false;
	}
	private int distance(Block b, Block[][] Goal){
		int max=-1;
		for (Block[] bRow:Goal){
			for(Block block:bRow){
				if(block.getWidth()==b.getWidth()){
					int valueX=block.Top.x-b.Top.x;
					int valueY=block.Top.x-b.Top.x;
					int dist= Math.abs(valueX)+Math.abs(valueY);
					if(dist>max){
						max=dist;
					}
				}
			}
		} return max;

	}
	public int h_value(Block b){
		return 0;
	}
	public int g_value(Block b){
		return 0;
	}
	public int f_value(Block b){
		return h_value(b)+g_value(b);
	}
	/*
	public Board createGoalBoard(String FileName){
		Board goal=new Board(FileName);
		goal.board=new Block[BoardLength][BoardWidth];
		goal.placeBlocks();
		return goal;
	}
	*/


	public boolean matchGoal(Board init, Board goal){
		HashMap<Integer, String> compare = new HashMap<Integer,String>();
		int count = 0;
		for (int k = 0; k<init.BoardLength; k++){
			for (int j = 0; j<init.BoardWidth; j++){
				Block block = init.board[k][j];
				System.out.println(block.toString());
				if(!block.toString().equals("null")){
					compare.put((Integer)(10*k+j), block.toString());
					System.out.println(compare.get(10*k+j));
				}
			}
		}

		for (int i = 0; i<goal.BoardLength; i++){
			for (int r = 0; r<goal.BoardWidth; r++){
				Block blocktwo = goal.board[i][r];
				if(!blocktwo.toString().equals("null")){
					count ++;
					if (compare.get(10*i+r).equals(blocktwo.toString())){
						count--;
					}
				}
			}
		}

		if (count==0){
			return true;
		} else{
			return false;
		}

	}
	/*
	public static void main(String[] args){
		Board b= new Board("easy.txt");
		
		b.buildBoard();	
		b.placeBlocks();
		;
		
		System.out.println(b.moveOk(b.board[0][2]));
		System.out.println(b.moveOk(b.board[1][3]));
		System.out.print(b.moveOk(b.board[0][0]));
		
	}
	*/
}

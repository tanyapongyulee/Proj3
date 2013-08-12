import java.awt.List;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Board {
	public Block[][] board;
	public InputSource file;
	private int BoardLength;
	private int BoardWidth;	
	private HashMap compare;
	private HashSet<Point> availMove;
	private HashMap<String, ArrayList> Track;
	
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
		Track= new HashMap<String, ArrayList>();
	}
	public int[] getSize(){ //returns the parameters of the board, length in index 0, width in index 1.
		int[] size = new int [2];
		size[0] = BoardLength;
		size[1] = BoardWidth;
		return size;
	}
	public void placeBlocks(){
		String input = file.readLine();
		while(input!=null){
			String[] v= (String[]) input.split(" ");
			String name=v[0]+v[1]+v[2]+v[3];
			int value1=Integer.parseInt(v[0]);
			int value2=Integer.parseInt(v[1]);
			int value3=Integer.parseInt(v[2]);
			int value4=Integer.parseInt(v[3]);
			int w1 =value4-value2;
			int l1 =value3-value1;
			Block b= new Block(w1,l1, name);
			b.setTop(value1,value2);
			b.setBottom(value3,value4);
			ArrayList<Point> track= new ArrayList<Point>();  // creating a track of path for each block
			track.add(b.Top);
			Track.put(name, track);
			for(int k=value1; k<value3+1;k++){
				for(int j=value2; j<value4+1; j++){
					board[k][j]=b;
				}
			}
			input=file.readLine();
			
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
	
	
	
	public void emptyBlocks(){  // update a set of available blocks to move; // not necessary
		availMove= new HashSet <Point>();
		for (Block[] bRow:board ){
			for(Block block:bRow){
				if(block.toString()==("empty")){
					availMove.add(block.Top);
				}
				}
			}
		}
	
	public ArrayList<Point> okayMoves(Block b){ // update the avail coordinates for a specific block to move.	
		boolean checkUp=true, checkDown=true, checkLeft=true, checkRight=true;
		ArrayList <Point> availblock= new ArrayList<Point>();
		for (int t=0;t<b.getWidth();t++){ // up		
			if(board[b.getTop().x-1][b.getTop().y+t]!=null){
				checkUp=false;
			}
			if(board[b.getTop().x+b.getLength()][b.getTop().y+t]!=null){
				checkDown=false;
			}
			
		}
		for(int t=0;t<b.getLength();t++){		
			if(board[b.getTop().x+t][b.getTop().y-1]!=null){
				checkLeft=false;
			}
			if(board[b.getTop().x+t][b.getTop().y+b.getWidth()]!=null){
				checkRight=false;
			}
		}
		if(checkUp==true){
			availblock.add(new Point(b.getTop().x-1,b.getTop().y));
		}
		if(checkDown=true){
			availblock.add(new Point(b.getTop().x+1,b.getTop().y));
		}
		if(checkLeft=true){
			availblock.add(new Point(b.getTop().x,b.getTop().y-1));
		}
		if(checkRight=true){
			availblock.add(new Point(b.getTop().x,b.getTop().y+1));
		}
		return availblock; 
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
			board[b.Bottom.x][k]=null;
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
			board[b.Top.x][k]=null;
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
			board[k][b.Bottom.y]=null;
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
			
			board[k][b.Top.y]=null;
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
	
	public Board createGoalBoard(String FileName){     // this method is not working. cant find the bug.
		Board goal=new Board(FileName);
		goal.board=new Block[this.BoardLength][this.BoardWidth];
		goal.placeBlocks();
		String s="";                                       // can ignore this part, just trying to see if it works
		for (int k = 0; k<goal.BoardLength; k++ ){
			for(int j =0; j<goal.BoardWidth; j++){
				s= s+"["+ goal.board[k][j]+"]"+" ";
				System.out.println("hi");
			}
			s=s+"\n";
		}
		System.out.println(s);
		return goal;
	}
	

	public boolean matchGoal(Board init, Board goal){
		int count = 0;
		for (int k = 0; k<init.BoardLength; k++){
			for (int j = 0; j<init.BoardWidth; j++){
				Block block = init.board[k][j];
				if(!block.toString().equals("null")){
					compare.put(10*k+j, block.toString());
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
	
}


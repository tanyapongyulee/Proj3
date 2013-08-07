import java.util.HashSet;


public class Board {
	private InputSource file;
	private int BoardLength;
	private int BoardWidth;
	private Block[][] board;
	private HashSet availMove;
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
			int w1 =Integer.parseInt(v[3])- Integer.parseInt(v[1]);
			int l1 =Integer.parseInt(v[2]) - Integer.parseInt(v[0]);
			Block b= new Block(w1,l1, name);
			for(int k=Integer.parseInt(v[0]); k<Integer.parseInt(v[2])+1;k++){
				for(int j=Integer.parseInt(v[1]); j<Integer.parseInt(v[3])+1; j++){
					board[k][j]=b;
				}
			}
			input=file.readLine();
			
		}
	}
	public String printBoard(){
		String s="";
		for (int k = 0; k<BoardLength; k++ ){
			for(int j =0; j<BoardWidth; j++){
				s= s+"["+ board[k][j]+"]"+" ";
			}
			s=s+"\n";
		}
		return s;
	}
	
	public int getEmptyBlocks(){ 
		//return the null blocks onBoard
		return 0;
	}
	public HashSet moveOk(){
		// return a set of available blocks to move;
		
		return availMove;
	}
	public void move(Block b, int a ){
		for(Block[] BColumn:board){
			for(Block B:BColumn){
				if(B.equals(b) && availMove.contains(B)){
				//MOVE
				}
			}
		}
			System.out.println("a"+" "+"b"+" "+"c"+" "+"d");
		
	}
	public boolean compare(String FileName){
		Board goal= new Board(FileName);
		goal.board= new Block[BoardLength][BoardWidth];
		goal.placeBlocks();
		for(int k=0;k<BoardLength;k++){
			for(int j=0; j<BoardWidth; j++){
				if(goal.board[k][j]!=null){
					if(goal.board[k][j].getSize()!=(this.board[k][j].getSize()))
						return false;
				}
			}
			
		}
		return true;
	}
	
	public boolean isOkay(){
		return false;
	}
	
	public boolean possible(Board b2){
		//using A*algorithm to compute
		return false;
	}
}


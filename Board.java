
public class Board {
  private InputSource file;
	private int length;
	private int width;
	private Block[][] board;
	public Board(String fileName){
		 file=new InputSource(fileName);	//initializes the file name.	
	}
	public Block[][] newBoard(){   //returns a 2d array of block objects all initialized to empty. 
		String s =file.readLine();
		String[] v = (String[]) s.split(" ");
		int length2 = Integer.parseInt(v[0]);
		int width2 = Integer.parseInt(v[1]);
		board=new Block[length2][width2];
		length = length2;
		width = width2;
		return board;
	}
	public int[] getSize(){ //returns the parameters of the board, length in index 0, width in index 1.
		int[] size = new int [2];
		size[0] = length;
		size[1] = width;
		return size;
	}
	public void placeBlocks(){
		String input = file.readLine();
		while(input!=null){
			String[] v= (String[]) input.split(" ");
			int w1 =Integer.parseInt(v[3])- Integer.parseInt(v[1]);
			int l1 =Integer.parseInt(v[2]) - Integer.parseInt(v[0]);
			Block b= new Block(w1,l1);
			for(int k=Integer.parseInt(v[0]); k<Integer.parseInt(v[2])+1;k++){
				for(int j=Integer.parseInt(v[1]); j<Integer.parseInt(v[3])+1; j++){
					board[k][j]=b;
				}
			}
			input=file.readLine();
			
		}
	}
	public String getBoard(){
		String s="";
		for (int k = 0; k<length; k++ ){
			for(int j =0; j<width; j++){
				s= s+"["+ board[k][j]+","+k+"]"+" ";
			}
			s=s+"\n";
		}
		return s;
	}
	
	public boolean possible(Board b2){
		return false;
	}
}



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
    private HashSet<Point> availMove;
    protected ArrayList<Block> Goal = new ArrayList<Block>();;
    protected ArrayList<Block> avail = new ArrayList<Block>();

    public Board(String fileName){
         file=new InputSource(fileName);    //initializes the file name.    
    }
    public Board(int length, int width){
        BoardLength=length;
        BoardWidth=width;
        board = new Block[BoardLength][BoardWidth];
    }
    public Board(String fileName, int BLength, int BWidth){ // construct goal-board, skipping other construct board methods
        BoardLength=BLength;
        BoardWidth=BWidth;
        board= new Block[BoardLength][BoardWidth];
        file= new InputSource(fileName);
        placeBlocks();    
    }
    public void buildBoard(){   //returns a 2d array of block objects all initialized to empty. 
        String s =file.readLine();
        String[] v = (String[]) s.split(" ");
        int  L1= Integer.parseInt(v[0]);
        int  W1= Integer.parseInt(v[1]);
        BoardLength=L1;
        BoardWidth=W1;
        board=new Block[BoardLength][BoardWidth];
        Goal = new ArrayList<Block>();
    }
    protected int getLength(){
        return BoardLength;
    }
    protected int getWidth(){
        return BoardWidth;
    }
    protected Board copyBoard(){
        Board newBoard = new Board(BoardLength,BoardWidth);
        System.out.println(avail.size());
        for(int k =0; k<avail.size();k++){
            Block c = new Block(avail.get(k).getLength(),avail.get(k).getWidth());
            c.setTop(avail.get(k).getTop().x, avail.get(k).getTop().y);
            c.setBottom(avail.get(k).getBottom().x, avail.get(k).getBottom().y);
            for(int g =avail.get(k).getTop().x; g<avail.get(k).getTop().x+avail.get(k).getLength();g++){
                for(int h = avail.get(k).getTop().y; h<avail.get(k).getWidth()+avail.get(k).getTop().y;h++){
                        newBoard.board[g][h]=c;
                }
            }
        }
        newBoard.Goal = Goal;
        return newBoard;
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
            avail.add(b);
            b.setTop(value1,value2);
            b.setBottom(value3,value4);
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
            for(int k=value1; k<value3;k++){
                for(int j=value2; j<value4; j++){
                    System.out.println(k+" "+j);
                    board[k][j]=b;
                }
            }
            input=file.readLine();

        }
        
        
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
    public int[] getSize(){ //returns the parameters of the board, length in index 0, width in index 1.
        int[] size = new int [2];
        size[0] = BoardLength;
        size[1] = BoardWidth;
        return size;
    }

    public ArrayList<String> okayMoves(Block b){ // it's working. 
		boolean checkUp=true, checkDown=true, checkLeft=true, checkRight=true;
		ArrayList <String> availblock= new ArrayList<String>();
		for (int t=b.getTop().y;t<b.getWidth()+b.getTop().y;t++){ // up	
			if(b.getTop().x==0){
				checkUp=false;
			}
			else if(board[b.getTop().x-1][t]!=null){
				checkUp=false;
				break;
				
			}
		}
		for (int t=b.getTop().y;t<b.getWidth()+b.getTop().y;t++){//down
			 if(this.getWidth()<1){
				checkDown = false;
				checkUp = false;
				break;
			}
			 else if(b.getTop().x+b.getLength()==this.BoardLength){
				 checkDown = false;
				 break;
			 }
			else if (board[b.getTop().x+b.getLength()][t]!=null){
				checkDown = false;
				
			}
		}
		for(int t=b.getTop().x;t<b.getLength()+b.getTop().x;t++){	//left
			if(b.getTop().y==0){
				checkLeft = false;
			}
			
			else if(board[t][b.getTop().y-1]!=null){
				checkLeft=false;
			}
			
		}
		for(int t=b.getTop().x;t<b.getLength()+b.getTop().x;t++){//right
			 if (this.getLength()<1){
				checkLeft= false;
				checkRight= false;
				break;
			 }
				 else if(b.getTop().y+b.getWidth()==this.BoardWidth){
					 checkRight= false;
					 break;
				 }
			
			 else if(board[t][b.getTop().y+b.getWidth()]!=null){
					checkRight=false;
				}
			
		}
		if(checkUp==true){
			availblock.add("Up");
		}
		if(checkDown==true){
			availblock.add("Down");
		}
		if(checkLeft==true){
			availblock.add("Left");
		}
		if(checkRight==true){
			availblock.add("Right");
		}
		//System.out.println(checkUp+" "+checkDown+" "+checkLeft+" "+checkRight);
		return availblock; 
	}




    public void moveUp(Block b){        
        Point newTop=new Point(b.Top.x-1,b.Top.y);//x's are y's we NEED TO CHANGE THAT. IT IS UNINTUITIVE. 
        Point newBottom=new Point(b.Bottom.x-1,b.Bottom.y);
        for(int k=newTop.x; k<newBottom.x+1;k++){
                    for(int j=newTop.y; j<newBottom.y+1; j++){
                        System.out.println(k+" "+j);
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
    
}

    


    


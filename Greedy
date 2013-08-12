import java.awt.Point;
import java.util.ArrayList;


public class aStar {
	//private ArrayList<Block> evaluated;
	//private ArrayList<Block> open;
	//private ArrayList<String> move;
	private ArrayList<Block> Need;
	public aStar(){
		
	}
	protected Board match(Board goal,Board board){
		int p = goal.Goal.size();
		int size = goal.Goal.get(p-1).getSize();//for later use when multiple blocks come into play.
		boolean d = true;
		boolean c = true;
		Board finished=null;
		while(d){
			int t =0;
			while(t<board.getLength()){
				int k =0 ;
				while(k<board.getWidth()){
					if(board.board[t][k].getSize()==size){
						finished = greedySearch(board.board[t][k],goal.Goal.get(0),board);//sends a block, and a goal block
						d=false;
						t=board.getLength();
						k=board.getWidth();
				}
					k++;
			}
				
			}
			t++;
		}
		return finished;
	}
	protected static Board greedySearch(Block Start,Block goal,Board board){
		int current;
		int h = heuristic(Start.getTop(),goal.getTop());
		while(!done(Start,goal)){ //keeps moving block until finished
			ArrayList<Point> avail = Start.availBlock();
			int temp = h;
			int i = 0;
			while(temp==h){ //finds a block with low heuristics
				if(h>heuristic(avail.get(i),goal.getTop())){
					temp = heuristic(avail.get(i),goal.getTop());
				}
				i++;
			}
			h= temp;
			int relativeY= Start.getTop().y-avail.get(i).y;//distinguished the position of goal relative to thye goal block
			int relativeX= Start.getTop().x-avail.get(i).x;
			if(relativeY<0){
				board.moveUp(Start);	//bnch of if statements that moves the block closer to goal.
				if(relativeX<0){
					board.moveLeft(Start);
				}
				else if (relativeX>0){
					board.moveRight(Start);
				}
			}
			else if(relativeY>0){
				board.moveDown(Start);
				if(relativeX>0){
					board.moveRight(Start);
				}
				else if (relativeX<0){
					board.moveLeft(Start);
				}
			}
			else if(relativeX>0){
				board.moveRight(Start);
			}
			else{
				board.moveLeft(Start);
			}
		}
		return board;
	}
	private static boolean done(Block Start, Block goal){ //checks if done
		if(Start.getTop().x==goal.getTop().x&&Start.getTop().y==goal.getTop().y){
			return true;
		}
		return false;
	}
	protected static int heuristic(Point Start, Point goal){ //the heuristic
		int h = (int)Math.sqrt(Math.pow(goal.x-Start.x, 2)+Math.pow(goal.y-Start.y, 2));
		return h;
	}
	

}

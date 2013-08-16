
import java.awt.Point;
import java.util.*;
public class Block{
	private int width; //horizontal
	private int length; //vertical
	private int size;
	protected Point Top; // x vertical, y horizontal
	protected Point Bottom; // x vertical, y horizontal
	protected Block(int w, int l){
		width=w;
		length=l;
		size=w*l;
	}
	public Block(){
		width=0;
		length=0;
		size=0;
	}
	public Block(int w , int l , int x, int y){
		width =w;
		length =l;
		size=w*l;
		Top= new Point(x,y);
		Bottom = new Point(x+w,y+l);
		//System.out.println(Top+" "+Bottom);
	}
	public int getWidth(){
		return width+1;
	}
	public int getLength(){
		return length+1;
	}
	public int getSize(){
		return size;
	}
	public void setTop(int x, int y){
		Top= new Point(x,y);
	}
	
	public Point getTop(){
		return Top;
	}
	
	public void setBottom(int x, int y){
		Bottom= new Point(x,y);
	}
	public Point getBottom(){
		return Bottom;
	}
	public boolean equals(Block block2){
		System.out.println(block2.getTop()+" "+Top);
		if(Top.x!=block2.getTop().x){
			return false;
		}
		if(Top.y!=block2.getTop().y){
			return false;
		}
		if(getSize()!=block2.getSize()){
			return false;
		}
		return true;
	}
	
}



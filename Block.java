
import java.awt.Point;
import java.util.*;
public class Block{
	private int width; //horizontal
	private int length; //vertical
	private int size;
	public Point Top; // x vertical, y horizontal
	public Point Bottom; // x vertical, y horizontal
	
	
	public Block(int w, int l){
		width=w;
		length=l;
		size=w*l;
		
		
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
	public String toString(){
		String s="";
		s=Integer.toString(Top.x)+Integer.toString(Top.y);
		return s;
	}
}

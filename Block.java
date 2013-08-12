
import java.awt.Point;
import java.util.*;
public class Block{
	private int width; //horizontal
	private int length; //vertical
	private int size;
	private String name;
	public Point Top; // x vertical, y horizontal
	public Point Bottom; // x vertical, y horizontal
	
	
	public Block(int w, int l){
		width=w;
		length=l;
		size=w*l;
		
		
	}
	
	public int getWidth(){
		return width;
	}
	public int getLength(){
		return length;
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
		return name;
	}
}

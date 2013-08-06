
public class Block{
  private int width;
	private int length;
	private int size;
	
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
		return size+1;
	}
	public String toString(){
		return (length+","+width);
	}
}

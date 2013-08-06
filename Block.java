
public class Block{
	private int width;
	private int length;
	private int size;
	private String name;
	
	public Block(int w, int l, String s){
		width=w;
		length=l;
		size=w*l;
		name=s;
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
		return name;
	}
}

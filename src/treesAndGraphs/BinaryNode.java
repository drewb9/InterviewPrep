package treesAndGraphs;

public class BinaryNode {

	private int value;
	private BinaryNode lchild;
	private BinaryNode rchild;
	
	public BinaryNode(int value, BinaryNode lchild, BinaryNode rchild)
	//Overloaded constructors
	{
		this.value = value;
		this.lchild = lchild;
		this.rchild = rchild;
	}
	
	public BinaryNode(int value)
	{
		this.value = value;
		this.lchild = null;
		this.rchild = null;
	}
	
	//GETTERS AND SETTERS
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public BinaryNode getLchild() {
		return lchild;
	}
	public void setLchild(BinaryNode lchild) {
		this.lchild = lchild;
	}
	public BinaryNode getRchild() {
		return rchild;
	}
	public void setRchild(BinaryNode rchild) {
		this.rchild = rchild;
	}
}

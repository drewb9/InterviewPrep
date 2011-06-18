package linkedListStuff;

public class IntNode {
	
	private int value;
	private IntNode next;
	
	public IntNode(int value, IntNode next)
	{
		this.value = value;
		this.next = next;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setValue(int value)
	{
		this.value = value;
	}
	
	public IntNode getNext()
	{
		return next;
	}
	
	public void setNext(IntNode next)
	{
		this.next = next;
	}
}

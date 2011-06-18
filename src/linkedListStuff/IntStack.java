package linkedListStuff;

import java.util.EmptyStackException;

public class IntStack {
	
	private IntNode top;
	
	public IntStack() {
		top = null;
	}
	
	public void push(int i)
	{
		if (top == null)
		{
			top = new IntNode(i, null);
		}
		else
		{
			IntNode newTop = new IntNode(i, top);
			top = newTop;
		}
	}
	
	public int pop()
	{
		if (top == null)
		{
			throw new EmptyStackException();
		}
		int result = top.getValue();
		top = top.getNext();
		return result;
	}
	
	public int peek()
	{
		if (top == null)
		{
			throw new EmptyStackException();
		}
		int result = top.getValue();
		return result;
	}
	
	public void printStack()
	{
		IntLinkedListUtilities.printLL(top);
	}
}

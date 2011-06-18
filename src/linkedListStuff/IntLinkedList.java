package linkedListStuff;

public class IntLinkedList {
	
	private IntNode head;
	private IntNode tail;
	
	// Constructor
	public IntLinkedList()
	{
		head = null;
		tail = null;
	}
	
	// Adds element to front of linked list
	public void addToFront(int i)
	{
		IntNode n = new IntNode(i, head);
		head = n;
		if (tail == null)
		{
			tail = n;
		}
	}
	
	// Adds element to end of linked list
	public void addToBack(int i)
	{
		IntNode n = new IntNode(i, null);
		tail.setNext(n);
		tail = n;
	}
	
	// Inserts "toInsert" after the first appearance of "insertAfter"
	public void insertAfter(int insertAfter, int toInsert)
	{
		IntNode current = head;
		IntNode next;
		while (current != null)
		{
			next = current.getNext();
			if (current.getValue() == insertAfter)
			{
				if (current.equals(tail))
				{
					IntNode n = new IntNode(toInsert, null);
					tail.setNext(n);
					tail = n;
				}
				else
				{
					current.setNext(new IntNode(toInsert, next));
				}
			}
			current = next;
		}
		
	}
	
	// Removes the first appearance of "val"
	public void remove(int val)
	{
		IntNode current = head;
		IntNode previous = null;
		while(current != null)
		{
			if (current.getValue() == val)
			{
				if (current == head)
				{
					head = head.getNext();
					break;
				}
				else if (current == tail)
				{
					tail = previous;
					previous.setNext(null);
					break;
				}
				else
				{
					previous.setNext(current.getNext());
					break;
				}
			}
			previous = current;
			current = current.getNext();
		}
	}
	

	// Returns the mth to last element (0th to last element is the last element)
	public int getMthLastElem(int m)
	{
		IntNode mth = head;
		for (int i = 0; i < m; i++)
		{
			mth = mth.getNext();
		}
		
		IntNode current = head;
		while(mth.getNext() != null)
		{
			current = current.getNext();
			mth = mth.getNext();
		}
		
		return current.getValue();	
	}
	
	// Prints the contents of the linked list and prints the head and tail nodes
	public void print()
	{
		IntLinkedListUtilities.printLL(head);
		if (head != null && tail != null)
		{
			System.out.println("HEAD: " + head.getValue()  + " TAIL: " + tail.getValue());
		}
		else
		{
			System.out.println("HEAD: " + "no head"  + " TAIL: " + "no tail");
		}
	}
	
	// GETTERS AND SETTERS

	public IntNode getHead() {
		return head;
	}

	public void setHead(IntNode head) {
		this.head = head;
	}

	public IntNode getTail() {
		return tail;
	}

	public void setTail(IntNode tail) {
		this.tail = tail;
	}
}

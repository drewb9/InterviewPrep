package linkedListStuff;

import java.util.Random;

public class IntLinkedListUtilities {

	public static IntNode genList(int size, boolean sorted)
	{
		IntNode head;
		IntNode copy;
		if (sorted)
		{
			head = new IntNode(0, null);
			copy = head;
			for (int i = 1; i < size; i++)
			{
				copy.setNext(new IntNode(i,null));
				copy = copy.getNext();
			}
			return head;
		}
		else
		{
			Random r = new Random();
			int randInt = r.nextInt(size*10);
			head = new IntNode(randInt, null);
			copy = head;
			for (int i = 1; i < size; i++)
			{
				randInt = r.nextInt(size*10);
				copy.setNext(new IntNode(randInt,null));
				copy = copy.getNext();
			}
			return head;
		}
	}
	
	public static void printLL(IntNode head)
	{
		while(head != null)
		{
			System.out.println(head.getValue());
			head = head.getNext();
		}
	}
	
	public static IntNode reverse(IntNode head)
	{
		if (head == null || head.getNext() == null)
		{
			return head;
		}
		else
		{
			IntNode previous = null;
			IntNode current = head;
			IntNode next = head;
			
			while(next != null)
			{
				next = next.getNext();
				current.setNext(previous);
				previous = current;
				current = next;
			}
			return previous;
		}
	}
	
	public static IntNode reverseRecursive(IntNode head)
	{
		if (head == null || head.getNext() == null)
		{
			return head;
		}
		else
		{
			IntNode secondElem = head.getNext();
			head.setNext(null);
			IntNode reverseRest = reverseRecursive(secondElem);
			secondElem.setNext(head);
			return reverseRest;
		}
	}
	
	public static IntNode sort(IntNode head) //merge sort
	{
		if (length(head) == 1)
		{
			return head;
		}
		else if (length(head) == 2)
		{
			IntNode next = head.getNext();
			if (head.getValue() <= next.getValue())
			{
				return head;
			}
			else
			{
				head.setNext(null);
				next.setNext(head);
				return next;
			}
		}
		else
		{
			//determine mid-point
			int mid = length(head)/2;
			
			//get your two lists
			IntNode lastFirstList = getNthElem(mid-1, head);
			IntNode firstSecList = getNthElem(mid, head);
			
			//make first list null terminated
			lastFirstList.setNext(null);
			
			//sort both of the lists
			head = sort(head);
			firstSecList = sort(firstSecList);
			
			//merge them and return newHead
			IntNode newHead = merge(head, firstSecList);
			return newHead;
		}
	}
	
	public static int length(IntNode head)
	{
		if (head == null)
		{
			return 0;
		}
		else
		{
			int count = 1;
			while(head.getNext() != null)
			{
				count += 1;
				head = head.getNext();
			}
			return count;
		}	
	}
	
	public static IntNode getNthElem(int n, IntNode head) //first element is 0th element
	{
		while(n > 0)
		{
			head = head.getNext();
			n--;
		}
		return head;
	}
	
	public static IntNode merge(IntNode l1, IntNode l2)
	{
		if (l1 != null && l2 != null)
		{
			if (l1.getValue() <= l2.getValue())
			{
				IntNode nextL1 = l1.getNext();
				l1.setNext(merge(nextL1, l2));
				return l1;
			}
			else
			{
				IntNode nextL2 = l2.getNext();
				l2.setNext(merge(l1, nextL2));
				return l2;
			}
		}
		else if (l1 != null)
		{
			return l1;
		}
		else if (l2 != null)
		{
			return l2;
		}
		else
		{
			return null;
		}		
	}
	
	
	// Determines whether or not the linked list has a cycle.
	// Buggy: stack overflow error
	public static boolean hasCycle(IntNode head)
	{
		if (head == null) {
			return false;
		}
		IntNode slow = head;
		IntNode fast = head.getNext();
		
		while (true)
		{
			if (fast == null || fast.getNext() == null)
			{
				return false;
			}
			else if (fast.equals(slow) || fast.getNext().equals(slow))
			{
				return true;
			}
			else
			{
				fast = fast.getNext().getNext();
				slow = slow.getNext();
			}
		}
	}
}
